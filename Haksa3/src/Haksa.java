import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Haksa extends JFrame {
	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	
	
	
	JPanel panel;

	public Haksa() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:myOracle", "ora_user", "hong");
			stmt = conn.createStatement();
		} catch (Exception e2) {
			e2.printStackTrace();
		}

		// ������ ����� connection close
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
			}
		});

		this.setTitle("�л����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar bar = new JMenuBar();

		JMenu m_student = new JMenu("�л�����");// File�޴�
		bar.add(m_student);
		JMenu m_book = new JMenu("��������");// Edit�޴�
		bar.add(m_book);

		JMenuItem mi_list = new JMenuItem("�л�����");
		m_student.add(mi_list);

		JMenuItem mi_bookRent = new JMenuItem("������");
		m_book.add(mi_bookRent);
		
		JMenuItem mi_bookPi = new JMenuItem("��������Ƚ��");
		m_book.add(mi_bookPi);

		mi_list.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll(); // ���������Ʈ ����
				panel.revalidate(); // �ٽ� Ȱ��ȭ
				panel.repaint(); // �ٽ� �׸���
				panel.add(new Student()); //ȭ�� ����.
				panel.setLayout(null);// ���̾ƿ��������

			}
		});
		mi_bookRent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll(); // ���������Ʈ ����
				panel.revalidate(); // �ٽ� Ȱ��ȭ
				panel.repaint(); // �ٽ� �׸���
				panel.add(new BookRent()); //ȭ�� ����.
				panel.setLayout(null);// ���̾ƿ��������

			}
		});
		mi_bookPi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll(); // ���������Ʈ ����
				panel.revalidate(); // �ٽ� Ȱ��ȭ
				panel.repaint(); // �ٽ� �׸���
				panel.add(new BookPi()); //ȭ�� ����.
				panel.setLayout(null);// ���̾ƿ��������
				
			}
		});

		panel = new JPanel();
		this.add(panel);

		this.setJMenuBar(bar);
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		new Haksa();
	}

}
