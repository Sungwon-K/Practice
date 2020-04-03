import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatServer extends JFrame implements ActionListener {
	private BufferedReader in = null;
	private BufferedWriter out = null;
	private ServerSocket listener = null;
	private Socket socket = null;
	private Receiver receiver; // JTextArea�� ��ӹް� Runnable �������̽��� ������ Ŭ�����μ� ���� ������ ��� ��ü
	private JTextField sender; // JTextField ��ü�μ� ������ ������ ��� ��ü
	private String nickMsg = new String();
	private ImageIcon[] image = {
			new ImageIcon("images/angry.jpg"),
			new ImageIcon("images/sad.jpg"),
			new ImageIcon("images/smile.jpg")
	};
	private int iconIndex = 3;
	private JButton[] btn = new JButton[iconIndex];
	private JPanel panel = new JPanel();
	private JPanel buttonGroup = new JPanel();
	public static String[] im = {"ang","sad","smi"};

	
	private static int iconFlag = 0;
	
	
	public ChatServer() {
		nickMsg = JOptionPane.showInputDialog("�г����� �Է��ϼ���.");
		
		if(nickMsg.equals("") == true)
			nickMsg = "����";
		
		setTitle("���� ä�� â - " + nickMsg); // ������ Ÿ��Ʋ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������ ���� ��ư(X)�� Ŭ���ϸ� ���α׷� ����
		Container c = getContentPane();
		
		for(int i = 0;i<iconIndex;i++) {
			btn[i]= new JButton(im[i]);
		}
		
		c.setLayout(new BorderLayout()); //BorderLayout ��ġ�������� ���
		panel.setLayout(new GridLayout(1,2));
		buttonGroup.setLayout(new GridLayout(1,3));
		
		receiver = new Receiver(); // Ŭ���̾�Ʈ���� ���� �޽����� ����� ���۳�Ʈ
		receiver.setEditable(false); // ���� �Ұ�

		sender = new JTextField();
		sender.addActionListener(this);

		add(new JScrollPane(receiver),BorderLayout.CENTER); // ��ũ�ѹٸ� ����  ScrollPane �̿�
		
		
		
		
		for(int i = 0 ; i<iconIndex;i++) {
			btn[i].addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					JButton b = (JButton)e.getSource();
					
					for(int i = 0; i<iconIndex;i++) {
						if(b.getText().equals(im[i])) {
							iconFlag = i+1;
						}
					}					
				}
				
			});
			buttonGroup.add(btn[i]);
		}	
		
		panel.add(buttonGroup);
		panel.add(sender);
		
		
		add(panel,BorderLayout.SOUTH);
		
		setSize(400, 200); // �� 400 �ȼ�, ���� 200 �ȼ��� ũ��� ������ ũ�� ����
		setVisible(true); // �������� ȭ�鿡 ��Ÿ������ ����
		
		try {
			setupConnection();
		} catch (IOException e) {
			handleError(e.getMessage());
		}
		
		Thread th = new Thread(receiver); // ���κ��� �޽��� ������ ���� ������ ����
		th.start();
	}
	private void setupConnection() throws IOException {
		listener = new ServerSocket(9999); // ���� ���� ����
		socket = listener.accept(); // Ŭ���̾�Ʈ�κ��� ���� ��û ���
		//System.out.println("�����");
		receiver.append("Ŭ���̾�Ʈ�κ��� ���� �Ϸ�");
		int pos = receiver.getText().length();
		receiver.setCaretPosition(pos); // caret �������� ���� ���������� �̵�
		
		in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Ŭ���̾�Ʈ�κ����� �Է� ��Ʈ��
		out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // Ŭ���̾�Ʈ���� ��� ��Ʈ��
	}

	private static void handleError(String string) {
		System.out.println(string);
		System.exit(1);
	}
	
	private class Receiver extends JTextArea implements Runnable {
		@Override
		public void run() {
			
			String msg = null;
			String icon = "";
			StringBuffer msgCopy = null;
			
			
			while (true) {
				try {
					msg = in.readLine(); // ���κ��� �� ���� ���ڿ� �ޱ�
					msgCopy = new StringBuffer(msg);
				} 
				catch (IOException e) {
					handleError(e.getMessage());
				} 
				
				System.out.println(msg.charAt(msg.length()-1));			
				
				for(int i =0; i<iconIndex;i++) {					
					if(msg.charAt(msg.length()-1) == (char)(i+49) ) {
						icon = im[i];
					}
				}				
			
				msgCopy.setLength(msg.length()-4);
											
				
				this.append("\n"+msgCopy + "    " +icon); // ���� ���ڿ��� JTextArea�� ���
				icon = "";
				int pos = this.getText().length();
				this.setCaretPosition(pos); // caret �������� ���� ���������� �̵�
				
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) { // JTextField�� <Enter> Ű ó��
		if (e.getSource() == sender) {
			String msg = sender.getText(); // �ؽ�Ʈ �ʵ忡�� ���ڿ� ����
			try {
												
				out.write(nickMsg + " > " +msg+ "00"+String.valueOf(iconFlag)+"\n"); // ���ڿ� ����
				out.flush();
				
				if(iconFlag == 0)
					receiver.append("\nMe)" + nickMsg + " > " + msg);// JTextArea�� ���
				else
					receiver.append("\nMe)" + nickMsg + " > " + msg + "    " +im[iconFlag-1]);// JTextArea�� ���
				iconFlag = 0;
				
				int pos = receiver.getText().length();
				receiver.setCaretPosition(pos); // caret �������� ���� ���������� �̵�
				sender.setText(null); // �Է�â�� ���ڿ� ����
			} catch (IOException e1) {
				handleError(e1.getMessage());
			} 
		}
	}
	
	public static void main(String[] args) {
		new ChatServer();
	}

}
