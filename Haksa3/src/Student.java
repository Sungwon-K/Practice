import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Student extends JPanel {
	JTextField tfId = null;
	JTextField tfName = null;
	JTextField tfDepartment = null;
	JTextField tfAddress = null;
	JTextArea taList = null;

	JButton btnList = null;
	JButton btnInsert = null;
	JButton btnUpdate = null;
	JButton btnDelete = null;
	JButton btnSearch = null;

	DefaultTableModel model;
	JTable table;

	public static String comStringbox = new String();

	public Student() {

		this.setLayout(new FlowLayout());

		this.add(new JLabel("�й�"));
		this.tfId = new JTextField(14);
		this.add(tfId);

		this.btnSearch = new JButton("�˻�");
		this.add(this.btnSearch);

		this.add(new JLabel("�̸�"));
		this.tfName = new JTextField(20);
		this.add(tfName);

		this.add(new JLabel("�а�"));
		this.tfDepartment = new JTextField(20);
		this.add(tfDepartment);

		this.add(new JLabel("�ּ�"));
		this.tfAddress = new JTextField(20);
		this.add(tfAddress);

		String colName[] = { "�й�", "�̸�", "�а�", "�ּ�" };
		model = new DefaultTableModel(colName, 0);
		table = new JTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(275, 200));
		add(table);
		add(new JScrollPane(table));

		// table���� ������ �����ϸ� ������ �� �ֵ��� TextField�� ���
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				table = (JTable) e.getComponent();// Ŭ���� ���̺� ���ϱ�
				model = (DefaultTableModel) table.getModel();// ���̺��� �� ���ϱ�
				String id = (String) model.getValueAt(table.getSelectedRow(), 0);
				tfId.setText(id);
				String name = (String) model.getValueAt(table.getSelectedRow(), 1);
				tfName.setText(name);
				String dept = (String) model.getValueAt(table.getSelectedRow(), 2);
				tfDepartment.setText(dept);
				String address = (String) model.getValueAt(table.getSelectedRow(), 3);
				tfAddress.setText(address);

				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		btnList = new JButton("���");
		btnInsert = new JButton("���");
		btnUpdate = new JButton("����");
		btnDelete = new JButton("����");

		this.btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg) {

				try {

					Haksa.rs = Haksa.stmt.executeQuery("select * from student where id = '" + tfId.getText() + "'");

					model.setNumRows(0);

					if (Haksa.rs.next()) {
						tfName.setText(Haksa.rs.getString("name"));
						tfDepartment.setText(Haksa.rs.getString("dept"));
						tfAddress.setText(Haksa.rs.getString("address"));

						String[] row = new String[4];// �÷��� ������ 3
						row[0] = Haksa.rs.getString("id");
						row[1] = Haksa.rs.getString("name");
						row[2] = Haksa.rs.getString("dept");
						row[3] = Haksa.rs.getString("address");
						model.addRow(row);

					}

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {

						if (Haksa.rs != null)
							Haksa.rs.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}
		});

		this.btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg) {
				try {

					if ((tfId.getText()).equals("")) {
						JOptionPane.showMessageDialog(null, "�й��� �Է��ϼ���!", "�˸�", JOptionPane.INFORMATION_MESSAGE);
						return; // �Լ�����
					}

					Haksa.stmt.executeUpdate(
							"update student set name='" + tfName.getText() + "', dept ='" + tfDepartment.getText()
									+ "', address ='" + tfAddress.getText() + "' where id = '" + tfId.getText() + "'");

					Haksa.rs = Haksa.stmt.executeQuery("select * from student where id = '" + tfId.getText() + "'");

					model.setNumRows(0);

					while (Haksa.rs.next()) {
						String[] row = new String[4];// �÷��� ������ 3
						row[0] = Haksa.rs.getString("id");
						row[1] = Haksa.rs.getString("name");
						row[2] = Haksa.rs.getString("dept");
						row[3] = Haksa.rs.getString("address");
						model.addRow(row);

					}

					Haksa.rs.close();

				} catch (Exception e) {
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "�����Ǿ����ϴ�.");

			}
		});

		this.btnInsert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg) {

				if ((tfId.getText()).equals("")) {
					JOptionPane.showMessageDialog(null, "�й��� �Է��ϼ���!", "�˸�", JOptionPane.INFORMATION_MESSAGE);
					return; // �Լ�����
				}

				if (tfName.getText().equals("")) {
					tfName.setText(JOptionPane.showInputDialog("�̸��� �Է¹��� ���߽��ϴ�. �̸��� �Է��ϼ���"));

					if (tfName.getText().length() == 0)
						tfName.setText("����");
				}

				if (tfDepartment.getText().equals("")) {
					tfDepartment.setText(JOptionPane.showInputDialog("�а��� �Է¹��� ���߽��ϴ�. �а��� �Է��ϼ���"));

					if (tfDepartment.getText().length() == 0)
						tfDepartment.setText("����");
				}

				if (tfAddress.getText().equals("")) {
					tfAddress.setText(JOptionPane.showInputDialog("�ּҸ� �Է¹��� ���߽��ϴ�. �ּҸ� �Է��ϼ���"));

					if (tfAddress.getText().length() == 0)
						tfAddress.setText("����");
				}

				try {

					Haksa.stmt.executeUpdate("insert into student values('" + tfId.getText() + "','" + tfName.getText()
							+ "','" + tfDepartment.getText() + "','" + tfAddress.getText() + "')");

					list();

					JOptionPane.showMessageDialog(null, "�Է¹��� ���� ID :" + tfId.getText() + " �̸� : " + tfName.getText()
							+ " �а� : " + tfDepartment.getText() + " �ּ� : " + tfAddress.getText() + "�� ��� �Ǿ����ϴ�.");

				} catch (Exception e) {
					e.printStackTrace();
				}

				// taList.append(tfId.getText()+"\t"+tfName.getText()+"\t"+tfDepartment.getText()
				// + "\t" +tfAddress.getText());
				//
				// text�ڽ� Ŭ���
				tfId.setText("");
				tfName.setText("");
				tfDepartment.setText("");
				tfAddress.setText("");
			}
		});

		this.btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg) {
				int result = JOptionPane.showConfirmDialog(null, "�����Ͻðڽ��ϱ�?", "����", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					// ����ó��. DB�����ؼ� ����

					try {
						Haksa.stmt.executeUpdate("delete from student where id = '" + tfId.getText() + "'");

						list();

					} catch (Exception e) {
						e.printStackTrace();
					}

					tfId.setText("");
					tfName.setText("");
					tfDepartment.setText("");
					tfAddress.setText("");

					JOptionPane.showMessageDialog(null, "�����Ǿ����ϴ�");
				}

			}
		});

		this.btnList.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg) {

				list();

			}
		});

		this.add(this.btnList);
		this.add(this.btnInsert);
		this.add(this.btnUpdate);
		this.add(this.btnDelete);
		this.setSize(280, 500);
		this.setVisible(true);
	}

	public void list() {
		try {

			// Select�� ����
			ResultSet rs = Haksa.stmt.executeQuery("select * from student order by Id");

			// JTable �ʱ�ȭ
			model.setNumRows(0);

			while (rs.next()) {
				String[] row = new String[4];// �÷��� ������ 3
				row[0] = rs.getString("id");
				row[1] = rs.getString("name");
				row[2] = rs.getString("dept");
				row[3] = rs.getString("address");
				model.addRow(row);
			}
			rs.close();

		} catch (Exception e1) {
			// e.getStackTrace();
			System.out.println(e1.getMessage());
		}
	}

}
