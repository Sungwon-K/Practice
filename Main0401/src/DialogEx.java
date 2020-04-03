import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class MyDialog extends JDialog{
	private JTextField tf = new JTextField();
	private JPasswordField pw = new JPasswordField();
	private JButton loginButton = new JButton("login");
	
	public MyDialog(JFrame frame, String title) {
		super(frame,title,true );
		this.setLayout(new FlowLayout());
		this.add(tf);
		this.add(pw);
		this.add(loginButton);
		this.setSize(120, 100);
		
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// �α��� ó��.DB����.ID, PW��ġ ���� Ȯ��
				System.out.println("�α���ó��...");
			}
		});
		
		
		
	}
}

public class DialogEx extends JFrame {
	
	private MyDialog dialog;
	
	public DialogEx() {
		super("�л����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btn = new JButton("�α���");
		
		dialog = new MyDialog(this,"");
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
				
			}});
		
		this.getContentPane().add(btn);
		
		this.setSize(250, 200);
		this.setVisible(true);
		
		
	}

	public static void main(String[] args) {
		new DialogEx();

	}

}
