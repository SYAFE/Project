package ch06;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ComboActionEx extends JFrame implements ActionListener {
	JComboBox strCombo;
	Container contentPane;
	JLabel lbl;
	String [] fruits = {"apple", "banana", "kiwi", "mango"};
	ImageIcon [] images = {
		new ImageIcon("src/images/apple.jpg"),
		new ImageIcon("src/images/banana.jpg"),
		new ImageIcon("src/images/kiwi.jpg"),
		new ImageIcon("src/images/mango.jpg") };
	JLabel imgLabel = new JLabel(images[0]);

	ComboActionEx() {
		setTitle("리스트 만들기  예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());

		strCombo = new JComboBox(fruits);
		strCombo.addActionListener(this);
		
		contentPane.add(strCombo);
		contentPane.add(imgLabel);
		
		lbl = new JLabel(fruits[0]);
		contentPane.add(lbl);
		setSize(300,300);
		setVisible(true);
	}
	public static void main(String [] args) {
		new ComboActionEx();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int index = strCombo.getSelectedIndex();
		//String item = (String)strCombo.getSelectedItem();
		//System.out.println(index + "," + item);
		imgLabel.setIcon(images[index]);
		lbl.setText(fruits[index]);
		
	}	
	
}
