package main0325;

import java.io.FileReader;
import java.io.IOException;

public class Main0325 {

	public static void main(String[] args) {
		/*
		StringTokenizer st = new StringTokenizer("ȫ�浿/��ȭ/ȫ��/����/����","/");
		
		while(st.hasMoreTokens())
			System.out.println(st.nextToken());
		
		Calendar now = Calendar.getInstance();
		System.out.println(now);
		System.out.println(now.get(Calendar.YEAR));
		System.out.println(now.get(Calendar.MONTH)+1);
		System.out.println(Calendar.DAY_OF_MONTH);
		System.out.println(Calendar.HOUR);
		System.out.println(Calendar.MINUTE);
		System.out.println(Calendar.SECOND);
		System.out.println(Calendar.MILLISECOND);
		System.out.println(Calendar.DAY_OF_WEEK);
		int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);
		
		if(dayOfWeek==1)
			System.out.println("�Ͽ���");
		else if(dayOfWeek==2)
			System.out.println("������");
		else if(dayOfWeek==3)
			System.out.println("ȭ����");
		else if(dayOfWeek==4)
			System.out.println("������");
		else if(dayOfWeek==5)
			System.out.println("�����");
		else if(dayOfWeek==6)
			System.out.println("�ݿ���");
		else if(dayOfWeek==7)
			System.out.println("�����");
		
		
		//���ڿ��� ���� ������ ArrayList ����
		ArrayList<String> a = new ArrayList<String>();
		
		//Ű����κ��� 4�� �̸� �Է¹޾� ArrayList�� ����
		Scanner scanner = new Scanner(System.in);
		
		for(int i = 0; i<4;i++) {
			System.out.print("�̸��� �Է��Ͻÿ� : ");
			String s = scanner.next();
			a.add(s);
		}
		
		//ArrayList�� �ִ� ��� �̸� ���
		for(int i =0;i<a.size();i++) {
			String name = a.get(i);
			System.out.println(name + " ");
		}
		
		//���� �� �̸� ���
		int longestIndex = 0;
		
		for(int i =0;i<a.size();i++) {
			if(a.get(longestIndex).length() < a.get(i).length())
				longestIndex = i;
		}
		System.out.println("\n���� �� �̸��� : " + a.get(longestIndex));
		scanner.close();
		
		
		//HashMapȰ��
		//�̸��� ���� ������ HashMap�÷��� ����
		HashMap<String, Integer> scoreMap = new HashMap<>();
		
		//5���� ���� ����
		scoreMap.put("KimS",97);
		scoreMap.put("HangK",88);
		scoreMap.put("KimN",98);
		scoreMap.put("LeeJ",70);
		scoreMap.put("HanW",99);
		
		System.out.println("HashMap�� ��� ���� : "+ scoreMap.size());
		
		//��� ����� ���� ���
		
		Set<String> keys = scoreMap.keySet();
		Iterator<String> it = keys.iterator();
		
		
		Iterator<String> it = scoreMap.keySet().iterator(); //chaining
		
		while(it.hasNext()) {
			String name = it.next();
			int score = scoreMap.get(name);
			System.out.println(name + " " + score);
			
		}
		
				
		FileReader fin = null;
		try {
			fin = new FileReader("c:\\windows\\system.ini");
			int c;
			while((c=fin.read()) != -1){
				System.out.print((char)c);
			}
			fin.close();
		}
		catch(IOException e) {
			System.out.println("����� ����");
		}
		*/

	}
}
