package menu;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

public class BasicDialog extends JDialog implements ActionListener {
	
	private JButton btn;
	private BasicMenu menu;
	
	public BasicDialog(BasicMenu basicMenu) {
		setTitle("다이얼로그");
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		
		menu = basicMenu;
		
		btn = new JButton("OK");
		btn.addActionListener(this);
		add(btn);
		
		setSize(200, 200);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		//new BasicDialog();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		menu.setVisible(true);  // 넘겨받은 닫힌 창을 다시 염
		this.dispose();  // 창을 사라지게 함
		
	}

}
