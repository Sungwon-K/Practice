import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BookRent extends JPanel {
   DefaultTableModel model = null;
   JTable table = null;
   Connection conn = null;
   
   String query;
   
   public BookRent() {

      query = "select student.id, student.name, books.title, bookRent.rDate" + " from  bookRent, student,books"
            + " where bookRent.id=student.id" + " and bookRent.bookNo=books.no" + " order by bookRent.no";      

      setLayout(null);// ���̾ƿ�����. ���̾ƿ� ��� ����.

      JLabel l_dept = new JLabel("�а�");
      l_dept.setBounds(10, 10, 30, 20);
      add(l_dept);

      String[] dept = { "��ü", "��ǻ�ͽý���", "��Ƽ�̵��", "��ǻ�Ͱ���" };
      JComboBox cb_dept = new JComboBox(dept);
      cb_dept.setBounds(45, 10, 100, 20);
      add(cb_dept);

      cb_dept.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            query = "select s.id, s.name, b.title, br.rDate" + " from student s, books b, bookRent br"
                  + " where br.id=s.id and br.bookNo=b.no";
            JComboBox cb = (JComboBox) e.getSource();
            int selectedIndex = cb.getSelectedIndex(); // ���õ� �������� index

            if (selectedIndex == 0) {
               query += " order by s.id";
            } else if (selectedIndex == 1) {
               query += " and s.dept = '��ǻ�ͽý���' order by b.no";
            } else if (selectedIndex == 2) {
               query += " and s.dept = '��Ƽ�̵��' order by b.no";
            } else if (selectedIndex == 3) {
               query += " and s.dept = '��ǻ�Ͱ���' order by b.no";
            }

            list(); // ������

         }
      });

      String colName[] = { "�й�", "�̸�", "������", "������" };
      model = new DefaultTableModel(colName, 0);
      table = new JTable(model);
      table.setPreferredScrollableViewportSize(new Dimension(470, 200));
      add(table);
      JScrollPane sp = new JScrollPane(table);
      sp.setBounds(10, 40, 460, 250);
      add(sp);

      setSize(490, 400);// ȭ��ũ��
      setVisible(true);

      // ��ü���
      list();
   }

   public void list() {
      try {
         System.out.println("����Ǿ����ϴ�.....");
         System.out.println(query);
         // Select�� ����
         Haksa.rs = Haksa.stmt.executeQuery(query);

         // JTable �ʱ�ȭ
         model.setNumRows(0);

         while (Haksa.rs.next()) {
            String[] row = new String[4];// �÷��� ������ 4
            row[0] = Haksa.rs.getString("id");
            row[1] = Haksa.rs.getString("name");
            row[2] = Haksa.rs.getString("title");
            row[3] = Haksa.rs.getString("rdate");
            model.addRow(row);
         }
         Haksa.rs.close();

      } catch (Exception e1) {
         // e.getStackTrace();
         System.out.println(e1.getMessage());
      }
   }

}