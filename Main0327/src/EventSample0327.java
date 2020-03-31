import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


//�ܺ� Ŭ����
class MyAction implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		//Action�̺�Ʈ �߻� �ɶ� ó���� �۾�
		//System.out.println("btn1�� Ŭ����");
		JButton btn = (JButton) e.getSource();
		if(btn.getText().equals("��ư1"))
			System.out.println("btn1�� Ŭ����");
		else if(btn.getText().equals("��ư2"))
			System.out.println("btn2�� Ŭ����");
		else if(btn.getText().equals("��ư3"))
			System.out.println("btn3�� Ŭ����");
		
	}
	
}

public class EventSample0327 extends JFrame implements ActionListener{
	public EventSample0327() {
		this.setTitle("Event");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		Container c= this.getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton btn1 = new JButton("��ư1");
		MyAction ma = new MyAction();
		c.add(btn1);
		btn1.addActionListener(ma);
		
		
		JButton btn2 = new JButton("��ư2");
		c.add(btn2);
		//btn2.addActionListener(new MyAction2());
		btn2.addActionListener(ma);
		
		
		
		 /*JButton btn3 = new JButton("��ư3"); c.add(btn3); 
		  * btn3.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) {
		 * System.out.println("btn3�� Ŭ����");
		 * 
		 * } });
		 */		
		
		JButton btn3 = new JButton("��ư3");
		c.add(btn3);
		btn3.addActionListener(ma);
		
		
		JButton btn4 = new JButton("��ư4");
		c.add(btn4);
		btn4.addActionListener(this);
		
		this.setSize(500,500);
		this.setVisible(true);
	
	}
	
	//����(inner)Ŭ����
			class MyAction2 implements ActionListener{

				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("btn2�� Ŭ����");
					
				}
				
			}
	

	public static void main(String[] args) {
		new EventSample0327();
		
		
	}
	
	//Ŭ���� �ڽ��� ���� �̺�Ʈ ó��
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("btn4�� Ŭ����");
		
	}

}
