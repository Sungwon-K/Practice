import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class MainMethod {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//FileWriter ���
		
		/*
		FileWriter fout = null;
		int c;
		
		try {
			fout = new FileWriter("c:\\Java_Workspace\\test.txt");
			while(true) {
				String line = scanner.nextLine();
				if(line.length() == 0)
					break;
				fout.write(line, 0 , line.length());
				fout.write("\r\n",0,2);
			}
			fout.close();
		} catch(IOException e) {
			System.out.println("����¿���");
		}
		*/
		
		/*
		//BufferedIOex ���
		FileReader fin =null;			//���� �бⰪ �ʱ�ȭ
		int c;
		try{
			fin = new FileReader("c:\\Java_Workspace\\test2.txt");
			BufferedOutputStream out = new BufferedOutputStream(System.out,5);

			while ((c = fin.read()) !=-1 ){		//���� �����͸� ��� ��ũ���� ���
				out.write(c);
			}
		

			//���� �����Ͱ� ��� ��µ� ����
			new Scanner(System.in).nextLine();	//����Ű �Է�
			out.flush();			//���ۿ� ���� �ִ� ���� ��� ���
			fin.close();
			out.close();

			} 
		catch(IOException e) {
				e.printStackTrace();
		}
		*/
		
		/*
		//FileInputStream,FileOutputStream�� �̿��� ���� ����
		File src = new File("C:\\Windows\\Web\\Wallpaper\\Theme1\\photo-of-trees-in-forest-3801030.jpg");
		
		File dest = new File("c:\\Java_Workspace\\coping.jpg");
		
		int c;
		
		try {
			FileInputStream fi = new FileInputStream(src);
			FileOutputStream fo = new FileOutputStream(dest);
			
			while((c=fi.read())!= -1) {
				fo.write((byte)c);
			}
			fi.close();
			fo.close();
			System.out.println(src.getPath() + "��" +dest.getPath()+"�� �����Ͽ����ϴ�.");
		}
		catch(IOException e) {
			System.out.println("���� ���� ����");
		}
		
		
		File dest2 = new File("c:\\Java_Workspace\\desert.jpg");
		try {
			FileInputStream fi = new FileInputStream(src);
			FileOutputStream fo = new FileOutputStream(dest2);
			
			byte[] buf = new byte[1024*10];	//10KB ����
			
			while(true) {
				int n = fi.read(buf);
				fo.write(buf, 0 , n);
				if(n < buf.length)
					break;
			}
			fi.close();
			fo.close();
			System.out.println(src.getPath() + "��" + dest2.getPath() + "�� �����Ͽ����ϴ�.");
		}
		catch(IOException e) {
			System.out.println("���� ���� ����");
		}
		*/
		
		
		
		scanner.close();
	}
}
