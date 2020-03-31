package main0331;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsDrawLineMouseEx extends JFrame{
	
	private MyPanel panel = new MyPanel();
	private int flag = 0;
	
	public GraphicsDrawLineMouseEx() {
		this.setTitle("drawing Line by Mouse");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(panel);
		this.setSize(300, 300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new GraphicsDrawLineMouseEx();
	}
	
	class MyPanel extends JPanel{
		private ArrayList<Point> aPoint = new ArrayList<>();
		private ArrayList<Boolean> aPointFlag = new ArrayList<>();
		

		Point startP;
		Point endP;
		
		public MyPanel() {
			addMouseMotionListener(new MouseMotionListener(){

				@Override
				public void mouseDragged(MouseEvent e) {
					aPoint.add(e.getPoint());
					aPointFlag.add(false);
					repaint();
					
				}

				@Override
				public void mouseMoved(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				
			});
			
			addMouseListener(new MouseListener() {
				@Override
				public void mousePressed(MouseEvent e) {
					aPoint.add(e.getPoint());
					aPointFlag.add(false);
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					aPointFlag.remove(aPointFlag.size()-1);	
					
					//���콺�� ���� ���Ⱑ �ߴ����̶�� ���� ǥ��
					aPointFlag.add(true);
					repaint();//������ �ٷ� �� ��츦 ����
					
				}
				@Override
				public void mouseClicked(MouseEvent arg0) {}
				@Override
				public void mouseEntered(MouseEvent e) {}
				@Override
				public void mouseExited(MouseEvent e) {
					aPoint.clear();
					aPointFlag.clear();
					repaint();
				}
				
			});
		}
		
	
	
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(new Color(122,122,79));
			for(int i = 0; i<aPoint.size();i++) {
				//ù��° ���̰ų� ���� ���� ������ ���̸�
				if(i == 0 || aPointFlag.get(i-1)==true) {
					startP = aPoint.get(i);
				}
				
				endP=aPoint.get(i);
				g.drawLine((int)startP.getX(), (int)startP.getY(), (int)endP.getX(), (int)endP.getY());
				startP = endP;
			}
		}
	}

}
