package ch05;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MouseListenerEx extends JFrame implements MouseListener {
	private JPanel pan;
	private JLabel text;
	
	MouseListenerEx() {
		setTitle("Mouse 이벤트 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		pan = new JPanel();
		pan.setLayout(null);
		pan.addMouseListener(this);
		
		text = new JLabel("홍길동");
		text.setBounds(10, 10, 50, 25);
		pan.add(text);
		
		add(pan);

		setSize(200,200);
		setVisible(true);
	}

	public static void main(String [] args) {
		new MouseListenerEx();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		text.setLocation(x-15, y-15);
		text.setText("(" + x + "," + y + ")");
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
} 

