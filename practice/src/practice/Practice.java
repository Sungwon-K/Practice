package practice;

import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Member[] person = new Member[2];
		
			
		person[0]= new Member("ȫ�浿","��� ���","����",18); 
		person[1]= new Member("�̼���","�ٴ� ���","�屺",35);
		
		
		for(int i = 0; i<person.length;i++)
			person[i].showInfo();
		
		System.out.println("�Է��� �ο� ���� �Է��ϼ���. :");
		
		int num = scan.nextInt();
		Member[] persons = new Member[num];
		System.out.println(num +"���� �Է��մϴ�.");
		
		for(int i=0;i<num;i++)
			persons[i] = new Member();
		
		for(int i=0;i<num;i++)
		{
			System.out.println((i+1)+"��° ���� ����,�ּ�,����,���̸� �Է����ֽʽÿ�.");
			persons[i].name = scan.next();
			persons[i].address = scan.next();
			persons[i].job = scan.next();
			persons[i].age = scan.nextInt();
		}
		
		for(int i = 0;i<num;i++)
			persons[i].showInfo();
			
			
		scan.close();
		

	}

}
