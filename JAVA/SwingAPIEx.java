package ch06;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SwingAPIEx extends JFrame implements ActionListener {
	Container contentPane;
	JLabel la;
	JButton b1, b2, b3, b4;

	SwingAPIEx() {
		setTitle("Swing 공통 메소드 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());

		b1 = new JButton("위치와 크기 정보");		
		// 버튼에 대한 리스너 등록하기(각 버튼 별로 처리하기) 
		b1.addActionListener(this);
		contentPane.add(b1);

		b2 = new JButton("모양 정보");
		b2.setOpaque(true);
		b2.setForeground(Color.MAGENTA);
		b2.setBackground(Color.YELLOW);
		b2.setFont(new Font("고딕체", Font.ITALIC, 20));
		
		b2.addActionListener(this);
		contentPane.add(b2);

		b3 = new JButton("작동하지 않는 버튼");
		b3.setEnabled(false);
		
		contentPane.add(b3);

		b4 = new JButton("숨기기/보이기");
		
		b4.addActionListener(this);
		contentPane.add(b4);

		setSize(250,200);
		setVisible(true);
	}
	
	public static void main(String [] args) {
		new SwingAPIEx();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == b1) {
			System.out.println("위치 및 크기");
			System.out.println("위치 = (" + b1.getX() + "," + b1.getY() + ")");
			System.out.println("크기 = (" + b1.getWidth() + "," + b1.getHeight() + ")");
		}
		else if(obj == b2) {
			Font f = b2.getFont();
			System.out.println(f.getName());
			System.out.println(b2.getForeground());
			System.out.println(b2.getBackground());
		}
		else if(obj == b4) {
			if(b1.isVisible()) {
				b1.setVisible(false);
				b2.setVisible(false);
				b3.setVisible(false);
			}
			else {
				b1.setVisible(true);
				b2.setVisible(true);
				b3.setVisible(true);
			}
			
		}
	}
} 
