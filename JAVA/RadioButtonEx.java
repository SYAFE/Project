package ch06;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class RadioButtonEx extends JFrame {
	Container contentPane;
	RadioButtonEx() {
		setTitle("라디오버튼 만들기  예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());

		ImageIcon cherryIcon = new ImageIcon("src/Images/cherry.jpg");
		ImageIcon selectedCherryIcon = new ImageIcon("src/Images/selectedCherry.jpg");

		ButtonGroup g = new ButtonGroup();
		JRadioButton b1 = new JRadioButton("사과");
		JRadioButton b2 = new JRadioButton("배", true);
		JRadioButton b3 = new JRadioButton("체리", cherryIcon);
		b3.setBorderPainted(true);
		b3.setSelectedIcon(selectedCherryIcon);
		
		g.add(b1);
		g.add(b2);
		g.add(b3);
		
		contentPane.add(b1);
		contentPane.add(b2);
		contentPane.add(b3);
		
 		setSize(350,250);
		setVisible(true);
	}
	public static void main(String [] args) {
		new RadioButtonEx();
	}
}
