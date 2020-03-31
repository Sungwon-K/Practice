import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Haksa extends JFrame{
	
	JTextField tfId = null;
	JTextField tfName = null;
	JTextField tfDepartment = null;
	JTextField tfAddress = null;
	JTextArea taList = null;
	
	JButton btnList = null;
	JButton btnInsert = null;
	JButton btnUpdate = null;
	JButton btnDelete = null;
	
	
	public Haksa() {
		this.setTitle("�л����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("�й�"));
		this.tfId= new JTextField(20);
		c.add(tfId);
	
		c.add(new JLabel("�̸�"));
		this.tfName= new JTextField(20);
		c.add(tfName);

		c.add(new JLabel("�а�"));
		this.tfDepartment= new JTextField(20);
		c.add(tfDepartment);
		
		c.add(new JLabel("�ּ�"));
		this.tfAddress= new JTextField(20);
		c.add(tfAddress);
		
		this.taList = new JTextArea(10,23);
		c.add(new JScrollPane(this.taList));
		
		
		btnList = new JButton("���");
		btnInsert = new JButton("�Է�");
		btnUpdate = new JButton("����");
		btnDelete = new JButton("����");
		
		c.add(this.btnList);
		c.add(this.btnInsert);
		c.add(this.btnUpdate);
		c.add(this.btnDelete);
		
		this.setSize(300, 500);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Haksa();

	}

}
