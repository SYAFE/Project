package ch05;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class KeyListenerEx extends JFrame implements KeyListener {
	JPanel contentPane = new JPanel();
	JLabel [] keyMessage;

	KeyListenerEx() {
		setTitle("KeyListener 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setContentPane(contentPane);
		contentPane.addKeyListener(this);
		// 여기에 코드 추가 

		keyMessage = new JLabel [3];
		keyMessage[0] = new JLabel("  getKeyCode()  ");
		keyMessage[1] = new JLabel("  getKeyChar()  ");
		keyMessage[2] = new JLabel("  getKeyText()  ");
		
		for(int i=0; i<keyMessage.length; i++) {
			contentPane.add(keyMessage[i]);
			keyMessage[i].setOpaque(true);
			keyMessage[i].setBackground(Color.yellow);
		}
		
		setSize(300,150);
		setVisible(true);
		contentPane.requestFocus();
		contentPane.setFocusable(true);
	}

	// 여기에 코드 추가 
	
	public static void main(String [] args) {
		new KeyListenerEx();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("1111");
		int keyCode = e.getKeyCode();
		char keyChar = e.getKeyChar();
		String msg = e.getKeyText(keyCode);
		
		keyMessage[0].setText(keyCode + "");
		keyMessage[1].setText(keyChar + "");
		keyMessage[2].setText(msg);
		
		if(keyChar == KeyEvent.VK_F1)
		{
			contentPane.setBackground(Color.GREEN);
		}
		else if(keyChar == '%')
		{
			contentPane.setBackground(Color.RED);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("111");
		int keyCode = e.getKeyCode();
		char keyChar = e.getKeyChar();
		String msg = e.getKeyText(keyCode);
		
		keyMessage[0].setText(keyCode + "");
		keyMessage[1].setText(keyChar + "");
		keyMessage[2].setText(msg);
		
		if(keyChar == KeyEvent.VK_F1)
		{
			contentPane.setBackground(Color.GREEN);
		}
		else if(keyChar == '%')
		{
			contentPane.setBackground(Color.RED);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("11");
		int keyCode = e.getKeyCode();
		char keyChar = e.getKeyChar();
		String msg = e.getKeyText(keyCode);
		
		keyMessage[0].setText(keyCode + "");
		keyMessage[1].setText(keyChar + "");
		keyMessage[2].setText(msg);
		
		if(keyChar == KeyEvent.VK_F1)
		{
			contentPane.setBackground(Color.GREEN);
		}
		else if(keyChar == '%')
		{
			contentPane.setBackground(Color.RED);
		}
		
	}
} 
