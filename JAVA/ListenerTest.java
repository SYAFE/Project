package ch05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ListenerTest extends JFrame implements ActionListener {
	private JButton btnUp, btnDown, btnLeft, btnRight;
	private JLabel lblMan;
	private JPanel panCenter, panDown;
	
	ListenerTest () {
		setTitle("Action 이벤트 리스너 작성");
		//setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		// 여기에 코드를 작성하세요.
		panCenter = new JPanel();
		panCenter.setLayout(null);
		
		lblMan = new JLabel("Man");
		lblMan.setBounds(130,80,50,25);
		panCenter.add(lblMan);
		
		panCenter.setBackground(Color.yellow);
		add(panCenter, BorderLayout.CENTER);
		
		panDown = new JPanel();
		panDown.setLayout(new BorderLayout());
		
		btnUp = new JButton("UP");
		btnUp.addActionListener(this);
		panDown.add(btnUp, BorderLayout.NORTH);
		btnDown = new JButton("Down");
		panDown.add(btnDown, BorderLayout.SOUTH);
		btnLeft = new JButton("Left");
		panDown.add(btnLeft, BorderLayout.WEST);
		btnRight = new JButton("Right");
		btnRight.addActionListener(this);
		panDown.add(btnRight, BorderLayout.EAST);
		
		panDown.setBackground(Color.green);
		add(panDown, BorderLayout.SOUTH);
		
		setSize(300,300);
		setVisible(true);
	}
	public static void main(String [] args) {
		new ListenerTest ();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btnUp)
		{
			int x = lblMan.getX();
			int y = lblMan.getY();
			lblMan.setLocation(x, y-5);
		}
		else if(obj == btnRight)
		{
			int x = lblMan.getX();
			int y = lblMan.getY();
			lblMan.setLocation(x+5, y);
		}
	}
	
} 
