import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LabelSample0327 extends JFrame {
	public LabelSample0327() {
		this.setTitle("���̺� ����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c  = getContentPane();
		
		c.setLayout(new FlowLayout());
		
		JLabel textLabel = new JLabel("�����Դϴ�.");
		
		
		ImageIcon baeuty = new ImageIcon("images/icon.png");
		JLabel imagelabel = new JLabel(baeuty);
		
		ImageIcon normalIcon = new ImageIcon("images/icon.png");
		JLabel label = new JLabel("�����ϼ���",
				normalIcon,SwingConstants.CENTER);
		
		c.add(textLabel);
		c.add(imagelabel);
		c.add(label);
		
		this.setSize(200, 300);
		this.setVisible(true);
		
	}

	public static void main(String[] args) {
		new LabelSample0327();

	}

}
