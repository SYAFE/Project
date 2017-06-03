package menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileNameExtensionFilter;

public class BasicMenu extends JFrame implements ActionListener {
	
	private JMenuBar mb;
	private JMenu fileMenu, testMenu, helpMenu;
	private JMenuItem openItem,exitItem;
	private JMenuItem colorItem, fontItem, progItem;
	private JMenuItem infoItem;
	
	private JToolBar tb;
	private JButton btnOpen, btnExit, btnProg;
	
	private JPanel pane;
	private JLabel imgLabel;
	
	private JFileChooser dialog = new JFileChooser();
	
	public BasicMenu() {
		setTitle("메뉴 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 1. 메뉴
		setMenu();
		setJMenuBar(mb);
		
		// 2. 툴바
		setToolBar();
		add(tb, BorderLayout.NORTH);
		
		// 3. 화면 구성
		setPane();
		add(pane);
		
		setLocation(300, 200);
		setSize(600, 500);
		setVisible(true);
		
	}
	
	private void setPane() {
		pane = new JPanel();
		pane.setLayout(new BorderLayout());
		
		imgLabel = new JLabel();
		imgLabel.setOpaque(true);  // 라벨 투명도를 불투명으로 바꿈
		imgLabel.setBackground(Color.YELLOW);
		
		pane.add(imgLabel);
	}

	private void setToolBar() {
		tb = new JToolBar("내 툴바");
		tb.setBackground(Color.LIGHT_GRAY);
		
		btnOpen = new JButton(new ImageIcon("src/Images/open.jpg"));
		btnOpen.addActionListener(this);
		btnExit = new JButton(new ImageIcon("src/Images/save.jpg"));
		btnExit.addActionListener(this);
		btnProg = new JButton("실행");
		btnProg.addActionListener(this);
		
		tb.add(btnOpen);
		tb.addSeparator();
		tb.add(btnExit);
		tb.add(btnProg);
	}

	private void setMenu() {
		mb = new JMenuBar();
		
		fileMenu = new JMenu("파일");
		openItem = new JMenuItem("열기");
		openItem.addActionListener(this);
		exitItem = new JMenuItem("종료");
		exitItem.addActionListener(this);
		
		fileMenu.add(openItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);
		
		mb.add(fileMenu);
		
		testMenu = new JMenu("테스트");
		colorItem = new JMenuItem("색상");
		fontItem = new JMenuItem("폰트");
		progItem = new JMenuItem("프로그램");
		progItem.addActionListener(this);
		
		testMenu.add(colorItem);
		testMenu.addSeparator();
		testMenu.add(fontItem);
		testMenu.addSeparator();
		testMenu.add(progItem);
		
		mb.add(testMenu);
		
		helpMenu = new JMenu("도움말");
		infoItem = new JMenuItem("정보");
		helpMenu.add(infoItem);
		
		mb.add(helpMenu);
		
	}

	public static void main(String[] args) {
		new BasicMenu();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if (obj == exitItem || obj == btnExit) {
			if(JOptionPane.showConfirmDialog(null, "종료할까요?", "종료", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
		
		else if ( obj == openItem || obj == btnOpen) {
			FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif", "png");
			dialog.setFileFilter(filter);
			
			if (dialog.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) { // 파일 선택을 하지 않았다면
				JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.");
				return;
			}
			String path = dialog.getSelectedFile().getPath();  // 파일에 대한 경로
			imgLabel.setIcon(new ImageIcon(path));
			pack();  // 이미지 크기에 맞게 변경
		}
		
		else if (obj == progItem || obj == btnProg) {
			new BasicDialog(this);  // this로 닫는창의 정보 넘김
			this.setVisible(false);
		}
	}

}
