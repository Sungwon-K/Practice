package practice08;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GridLayoutEx extends JFrame{
	public GridLayoutEx() {
		this.setTitle("GridLayout Sample");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//4*2������ GridLayout ��ġ ������ ����
			
		
		Container a = getContentPane();
		
			
		a.setLayout(new FlowLayout(FlowLayout.LEFT,75,5));
					
		a.add(new JLabel("�̸�"));
		a.add(new JTextField("                                    "));
		a.add(new JLabel("�̸�"));
		a.add(new JTextField("                                    "));
		a.add(new JLabel("�̸�"));
		a.add(new JTextField("                                    "));
		a.add(new JLabel("�̸�"));
		a.add(new JTextField("                                    "));
		
		
		
		this.setSize(300,200);
		this.setResizable(false);
		this.setVisible(true);
	}

}
