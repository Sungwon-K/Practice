import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class KeyCodeEx extends JFrame {
	
	private JLabel la = new JLabel();
	
	public KeyCodeEx() {
		this.setTitle("Key Code ���� : F1Ű:�ʷϻ�, %Ű �����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		
		c.addKeyListener(new MyKeyListener());
		
		c.add(la);
		
		this.setSize(300,150);
		this.setVisible(true);
		
		//contentpane�� Ű �Է��� ���� �� �ֵ��� ��Ŀ�� ���� ����
		c.setFocusable(true);
		c.requestFocus();
	}
	
	
	//Key������ ����
	class MyKeyListener extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			
			Container contentPane = (Container)e.getSource();
			
			//la�� �Էµ� Ű�� Ű �̸� ���ڿ��� ����Ͽ� ����ڿ��� ������
			la.setText(e.getKeyText(e.getKeyCode()));
			
			if(e.getKeyChar() == '%') {	//�Էµ� Ű�� %�� ���
				contentPane.setBackground(Color.YELLOW);
			}
			else if(e.getKeyCode() == KeyEvent.VK_F1) {
				contentPane.setBackground(Color.GREEN);
			}
				
		}
	}
	
	public static void main(String[] args) {
		new KeyCodeEx();
	}

}
