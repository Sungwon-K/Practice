package practice07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class MainMethod {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//1.å����, ����, ���ǻ�, ������ Ű���带 ���� 1���� �����͸� ArrayList�� �����Ͻÿ�.
		ArrayList<String> book = new ArrayList<>();
		
		System.out.println("ArrayList - å����,����,���ǻ�,������ �Է��ϼ���");
		for(int i=0;i<4;i++)
		{
			String s = scan.next();
			book.add(s);
		}
		
		for(int i=0;i<book.size();i++)
		{
			String s = book.get(i);
			System.out.print(s + " ");
		}
		System.out.println();
		
		
		//2.1���� HashMap�� �̿��ؼ� �����ϰ� ����Ͻ̵�.
		HashMap<String, String> hashBook = new HashMap<>();
		 
		System.out.println("HashMap - å����,����,���ǻ�,������ �Է��ϼ���");
		
		String key[] = {"å����","����","���ǻ�","����"};
		
		for(int i=0;i<4;i++) {
			String s = scan.next();
			hashBook.put(key[i],s);
		}
		
		
		Iterator<String> it = hashBook.keySet().iterator();
		for(int i =0; i<hashBook.size();i++)
		{
			String keys = it.next();
			String value = hashBook.get(keys);
			System.out.println(keys+"\t-" + value);
		}
		System.out.println();
		
		
		//3.1���� Book Class�� ���� ���� Array List�� Book ��ü�� �־ ó���ϱ�.
		System.out.println("Class in the ArrayList - å����,����,���ǻ�,������ �Է��ϼ���");
		
		Book2 book2 = new Book2();
		ArrayList<Book2> data = new ArrayList<Book2>();
		String k[] = new String[4];
		
		
		for(int i=0;i<4;i++)
		{
			k[i] = scan.next();
			
		}		
		data.add(new Book2(k[0], k[1], k[2], k[3]));
		
	
				
		for(int i=0;i<data.size();i++)
		{
			book2 = data.get(i);
			System.out.print(book2.getName() + " "+book2.getWrite() + " "+book2.getCompany() + " " + book2.getPrice());
		}
		System.out.println();
		
		
		//3-2.Book Class�� Array List�� �־ ó��
		System.out.println("ArrayList in the Class - å����,����,���ǻ�,������ �Է��ϼ���");
		
		for(int i=0;i<4;i++)
		{
			String s = scan.next();
			Book arrayBook = new Book(s);
			arrayBook.ShowInfo();				
		}
		
			
		
		scan.close();
		

	}

}
