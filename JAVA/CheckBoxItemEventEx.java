package ch06;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CheckBoxItemEventEx extends JFrame implements ItemListener {
	Container contentPane;
	JCheckBox [] fruits = new JCheckBox [3];
	String [] names = {"사과", "배", "체리"};
	JLabel sumLabel;
	int sum = 0;

	CheckBoxItemEventEx() {
		setTitle("체크박스와 ItemEvent  예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());						
		contentPane.add(new JLabel("사과  100원, 배 500원, 체리 20000원"));
		for(int i=0; i<fruits.length; i++) {
			fruits[i] = new JCheckBox(names[i]);
			fruits[i].setBorderPainted(true);
			contentPane.add(fruits[i]);
			fruits[i].addItemListener(this);

		}
		sumLabel = new JLabel("현재 0 원 입니다.");
		contentPane.add(sumLabel);
		setSize(250,200);
		setVisible(true);
	}


	public static void main(String [] args) {
		new CheckBoxItemEventEx();
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		int selected = 1;

		if(e.getStateChange() == ItemEvent.SELECTED)
			selected = 1;
		else
			selected = -1;

		if(e.getItem() == fruits[0]) {
			System.out.println("사과");
			sum = sum + 100 * selected;
		}
		else if(e.getItem() == fruits[1]) {
			System.out.println("배");
			sum += 500 * selected;
		}
		else if(e.getItem() == fruits[2]) {
			System.out.println("체리");
			sum += 20000 * selected;
		}

		sumLabel.setText("현재 " + sum + "원 입니다.");
	}



} 
