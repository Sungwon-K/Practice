package practice06;
import java.util.Scanner;
import practice06.Bc;


public class mainmethod {
	public static void main(String[] args)
	{
		//���콺 Ŭ���� interface�� ����
		/*
		Mouse m = new Mouse();
		
		m.Mouse();
		m.leftClick();
		m.rightClick();
		m.mouseMove();
		System.out.println();
		
		WheelMouse wm = new WheelMouse() ;
		
		wm.Mouse();
		wm.leftClick();
		wm.rightClick();
		wm.mouseMove();
		wm.scrollWheel();
		wm.wheelclick();
		wm.optical();
		
		System.out.println();
		
		LaserMouse lm = new LaserMouse();
		
		lm.Mouse();
		lm.leftClick();
		lm.rightClick();
		lm.mouseMove();
		lm.scrollWheel();
		lm.wheelclick();
		lm.optical();
		
		
		//1.��ȭ��ȣ(010-1234-5678)���� ���� (010)�� �����Ͻÿ�.
		
		String phoneNum = "010-1234-5678";
		
		System.out.println(phoneNum.substring(0,3));
		
		//2.��ȭ��ȣ(010-1234-5678)���� '-'�� �����Ͻÿ�
		System.out.println(phoneNum.replace("-", ""));
		
		//3.��ǰ�ڵ�(E20160001)���� ��ǰī�װ�('E')�� �����Ͻÿ�.
		String productNum = "E20160001";
		
		System.out.println(productNum.charAt(0));
		
		//4.��ǰ�ڵ�(E20160001)���� �⵵(2016)�� �����Ͻÿ�.
		System.out.println(productNum.substring(1, 5));
		
		//5.�ּҷ� csv�����Ϳ��� �����͸� �и��Ͻÿ�.
		String data = "Hong,010-1111-2222,hkd@hkd.com";
		
		String[] dataArray = data.split(",");
		
		for(int i =0;i<dataArray.length;i++)
			System.out.println(dataArray[i]);
		
		//6.csv�����Ϳ� ������ ���� �й��� ����Ǿ� ������. �� �а��� ���
		//EL-���ڰ��а�
		//CH-ȭ�а��а�
		//EN������а�
		Bc[] cd = new Bc[3];
		
		cd[0] = new Bc("EL20180001");
		cd[1] = new Bc("CH201800021");
		cd[2] = new Bc("EN12231");
		
		for(int i= 0;i<cd.length;i++)
			cd[i].showinfo();
		*/
		
		//7.���̵� !,@,#,$,%,^�� ���Ե� ���
		//'���̵� !,@,#,$,%,^�� ���ԵǸ� �ȵ˴ϴ�.'
		//�޽��� ����ϱ�.charAt()����.
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���̵� �Է��ϼ���. : ");
		
		String ck = sc.next();
		
		for(int i=0;i<ck.length();i++)
		{
			if('!'== ck.charAt(i) || '@'== ck.charAt(i) || '#'== ck.charAt(i) || '$'== ck.charAt(i) || '%'== ck.charAt(i) || '^'== ck.charAt(i))
			{
				System.out.println("���̵� !,@,#,$,%,^�� ���ԵǸ� �ȵ˴ϴ�.");
				break;
			}
				
		}
		System.out.println("�Է¹��� ���̵�� "+ck+"�Դϴ�.");
		sc.close();		
	}
}
