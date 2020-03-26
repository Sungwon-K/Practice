import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class NoLayout0326 extends JFrame {

	public NoLayout0326() {
		this.setTitle("���̾ƿ����� ������Ʈ ��ġ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = this.getContentPane();
		
		c.setLayout(null);
		
		int hGap = 10;
		int vGap = 10;
		
		JButton btn1 = new JButton("��ư1");
		btn1.setBounds(0, 0, 100, 100);
		c.add(btn1);
		
		JButton btn2 = new JButton("��ư2");
		btn2.setBounds(100+hGap,0,100,100);
		c.add(btn2);
		
		JButton btn3 = new JButton("��ư3");
		btn3.setBounds(0,100+vGap,100,100);
		c.add(btn3);
		
		
		this.setSize(500,500);
		this.setVisible(true);

	}
	public static void main(String[] args) {
		new NoLayout0326();
	}
	
}
