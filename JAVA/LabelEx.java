package ch06;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LabelEx extends JFrame{
	public LabelEx() {
		setTitle("이미지 라벨");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		
		ImageIcon img = new ImageIcon("src/Images/normalIcon.gif");
		ImageIcon img2 = new ImageIcon("src/Images/rolloverIcon.gif");
		ImageIcon img3 = new ImageIcon("src/Images/pressedIcon.gif");
		JLabel lbl = new JLabel("보고싶으면 전화하세요.", img, JLabel.CENTER);
		add(lbl);
		
		JButton btn = new JButton(img);
		btn.setRolloverIcon(img2);
		btn.setPressedIcon(img3);
		add(btn);
		
		setSize(400,200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new LabelEx();
	}

}
