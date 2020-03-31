package practice09;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;




	
public class MainMethod extends JFrame implements ActionListener{
	JLabel timeinfo;
	public JLabel ti = new JLabel();
	public int index =1;
	
	public MainMethod() {
		timeinfo = new JLabel();
		MyActionListener1 lis = new MyActionListener1(this);
		
		this.setTitle("�ð� ���");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//1.ȭ�鿡 ���� �ð��� ����ϴ� Label ����
		//�� ��ư Ŭ���ϸ� �߾� Label�� �ð� ���
		
		Container selBox = getContentPane();
		Container c  = getContentPane();
		
		JPanel selPanel = new JPanel();
				 
		JButton btn1 = new JButton("��ư1");
		btn1.addActionListener(lis);
		selBox.add(btn1);
	
		
		JButton btn2 = new JButton("��ư2");
		btn2.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton c= (JButton)e.getSource();
				if(c.getText().equals("��ư2")) {
					timeinfo.setText(new TimeInfo().s);
					index = 1;
				}
				
			}

		});
		selBox.add(btn2);
		
		
		JButton btn3 = new JButton("��ư3");
		btn3.addActionListener(new MyActionListener3());
		selBox.add(btn3);
		
		JButton btn4 = new JButton("��ư4");
		btn4.addActionListener(this);
		selBox.add(btn4);
		
		
		
		
		
		
		selPanel.add(btn1);
		selPanel.add(btn2);
		selPanel.add(btn3);
		selPanel.add(btn4);
				
		
		//2.���� �ð� ���ؼ� �λ� Label�� ǥ���ϱ�
		TimeInfo time = new TimeInfo();		
		
		c.setLayout(new BorderLayout());
		
		if(time.t < 12)
			ti = new JLabel("Good Morning");
		else if(time.t >= 12 && time.t <18)
			ti = new JLabel("Good Afternoon");
		else if(time.t >= 18)
			ti = new JLabel("Good Evening");
		else
			ti = new JLabel("Error");
		

		
		
		timeinfo.setText("���� ����");	
		
		
		c.add(timeinfo, BorderLayout.NORTH);
		c.add(ti,BorderLayout.CENTER);
		c.add(selPanel,BorderLayout.SOUTH);
		ti.setHorizontalAlignment(SwingConstants.CENTER);
		timeinfo.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		
		this.setSize(350,200);
		this.setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
		
	}
	
	class MyActionListener3 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
						
				timeinfo.setText(new TimeInfo().s);
				index =1;
					
		}
		
	}
		
	
	public static void main(String[] args) {
		new MainMethod();
		//�߸� �����ؼ� ���� �ڵ�-Ű���� ����Ű�� �̹��� ��ȯ(�̿ϼ�)
		new Gallery();
		new Gallery2();
		
		

	}
	
	public void actionPerformed(ActionEvent e) {
		TimeInfo time4 = new TimeInfo();
		JButton c= (JButton)e.getSource();
		if(c.getText().equals("��ư4")) {
			timeinfo.setText(time4.s);
			index =1;
		}
		
	}

}
