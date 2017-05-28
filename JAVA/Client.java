package network;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client extends JFrame implements ActionListener {
	String nickName = "";
	JPanel p;
	JTextArea ta;
	JTextField tf;
	DataInputStream in;
	DataOutputStream out;
	
	public Client(String nickName) {
		setTitle(nickName);
		this.nickName = nickName;
		setLocation(600,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDesign();
		
		add(p);
		
		setSize(300,300);
		setVisible(true);
		tf.requestFocus();
		startClient();
	}
	
	private void startClient() {
		try {
			Socket socket = new Socket("localhost", 7777);
			ta.setText("서버에 연결되었습니다.");
			
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			
			while(in != null) {
				String Msg = in.readUTF();
				ta.append("\n" + Msg);
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void setDesign() {
		p = new JPanel();
		p.setLayout(new BorderLayout());
		
		ta = new JTextArea();
		ta.setEditable(false);  // 편집불가로 만듦
		p.add(ta, BorderLayout.CENTER);
		
		tf = new JTextField();
		tf.addActionListener(this);
		tf.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tf.requestFocus();
			}
		});
		p.add(tf, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		new Client("클라이언트");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = tf.getText();
		if(msg.equals("")) {
			return;
		}
		
		if(out != null) {
			try {
				out.writeUTF(nickName + " > " + msg);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		ta.append("\n" + nickName + " > " + msg);
		tf.setText("");  // 입력란에 엔터를 누르면 입력란 초기화
	}

}
