import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabbedPaneEx extends JFrame {
	public TabbedPaneEx() {
		this.setTitle("탭팬 만들기 예저");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		
		JTabbedPane pane = createTabbedPane();
		
		c.add(pane, BorderLayout.CENTER	);
		
		this.setSize(250, 250);
		this.setVisible(true);
	}
	
	private JTabbedPane createTabbedPane() {
		JTabbedPane pane = new JTabbedPane(JTabbedPane.LEFT);
		pane.addTab("tab1", new JLabel(new ImageIcon("images/img1.jpg")));
		pane.addTab("tab2", new JLabel(new ImageIcon("images/img2.jpg")));
		pane.addTab("tab3", new MyPanel());
		return pane;		
	}
	
	class MyPanel extends JPanel{
		public MyPanel() {
			this.setBackground(Color.YELLOW);
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.fillRect(10, 10, 50, 50);
			
			g.setColor(Color.BLUE);
			g.fillRect(10, 70, 50, 50);
			
			g.setColor(Color.BLACK);
			g.drawString("tab 3에 들어가는 JPanel입니다.",30,50);
		}
	}

	public static void main(String[] args) {
		new TabbedPaneEx();

	}

}
