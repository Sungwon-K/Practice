package practice08;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainMethod {

	public static void main(String[] args) {
		
		//1.Exception�� �߻��ϸ�, �����޽����� �α�(����ú���.log)���Ͽ� ���
		CalendarInfo cal = new CalendarInfo();
		Scanner scan = new Scanner(System.in);
		
		
		FileWriter errorMassage = null;
	
		
		try {
			System.out.println("�Է��Ͻÿ�.");
			int c = scan.nextInt();
			System.out.println("������� "+ c);
		} 
		catch(Exception e){ 
			
			try {
				
			
				errorMassage = new FileWriter("c:\\log\\"+cal.s +".log");
				errorMassage.write(e.toString());
				errorMassage.close();
				
			} 
			catch (Exception e1) {
				e1.printStackTrace();
			}
		
		}
		
		//2.����9-5 ȭ���� FlowLayout�� ��E�Ͽ� �ۼ�
		
		new GridLayoutEx();
		
		
		
		//scan.close();
	}


}
