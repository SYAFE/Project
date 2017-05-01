package ch06;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Project3 extends JFrame implements MouseListener, MouseMotionListener, KeyListener {

	private JPanel pan;
	private JButton btn;
	
	int x = 10;
	int y = 10;
	int width = 100;
	int height = 100;
	
	public Project3() {
		setTitle("버튼 이동하기 과제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		pan = new JPanel();
		pan.setLayout(null);
		pan.addMouseListener(this);
		pan.addKeyListener(this);
		
		ImageIcon img = new ImageIcon("src/Images/inha.jpg");
		
		btn = new JButton(img);
		btn.addMouseMotionListener(this);
		btn.setBounds(x, y, width, height);
		pan.add(btn);
		
		add(pan);
		
		setSize(600,500);
		setVisible(true);
		pan.requestFocus();
		pan.setFocusable(true);
	}
	
	public static void main(String[] args) {
		new Project3();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		int x = e.getX();
		int y = e.getY();
		
		btn.setLocation(x-(width/2),y-(height/2));
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int tx = e.getX() - (width/2);
		int ty = e.getY() - (height/2);
		
		x = x + tx;
		y = y + ty;
		
		btn.setBounds(x, y, width, height);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key) {
			case KeyEvent.VK_UP :
				btn.setLocation(btn.getX(), btn.getY()-10);
				break;
			case KeyEvent.VK_DOWN :
				btn.setLocation(btn.getX(), btn.getY()+10);
				break;
			case KeyEvent.VK_LEFT :
				btn.setLocation(btn.getX()-10, btn.getY());
				break;
			case KeyEvent.VK_RIGHT :
				btn.setLocation(btn.getX()+10, btn.getY());
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}
