package ch06;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InputText extends JFrame implements ActionListener, KeyListener {
	private JPanel pan;
	private JTextField tf;
	private JTextArea ta;
	private JButton btn;
	
	public InputText() {
		setTitle("메모장");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		pan = new JPanel();
		creatPan();
		add(pan);
		
		setSize(300,300);
		setVisible(true);
	}
	
	private void creatPan() {
		pan.setLayout(new FlowLayout());
		JLabel lbl = new JLabel("입력");
		pan.add(lbl);
		tf = new JTextField(20);
		tf.addKeyListener(this);
		pan.add(tf);
		btn = new JButton("입력");
		btn.addActionListener(this);
		pan.add(btn);
		ta = new JTextArea(12, 24);
		pan.add(new JScrollPane(ta));
		
	}

	public static void main(String[] args) {
		new InputText();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ta.append(tf.getText() + "\n");
		tf.setText("");
		tf.requestFocus();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			ta.append(tf.getText() + "\n");
			tf.setText("");
			tf.requestFocus();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
