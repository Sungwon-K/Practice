package main0331;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;

public class paintComponentEx extends JFrame{
	
	public paintComponentEx() {
		this.setTitle("���ο� ��ư �����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		Container c = getContentPane();
		
		c.setLayout(new FlowLayout());
		
		MyButton b = new MyButton("New Button");
		
		b.setOpaque(true); b.setBackground(Color.BLUE);
		
		c.add(b);
		
		this.setSize(250, 200);
		this.setVisible(true);
	}
	
	class MyButton extends JButton{
		public MyButton(String s) {
			super(s);
		}
	
		protected void paintComponent(Graphics g) {
			super.paintComponents(g);
			g.drawOval(0, 0, this.getWidth()-1, this.getHeight()-1);
			//g.drawRect(2, 2, this.getWidth()-5, this.getHeight()-5);
		}
	}

	public static void main(String[] args) {
		new paintComponentEx();

	}

}
