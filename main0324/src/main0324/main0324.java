package main0324;



interface PhoneInterface{
	final int TIMEOUT = 10000;
	void sendCall();
	void receiveCall();
	default void printLogo()
	{
		System.out.println("*Phone*");
	}
}
interface MobilePhoneInterface extends PhoneInterface{
	void sendSMS();
	void receiveSMS();
}

interface MP3Interface{
	public void play();
	public void stop();
}

class PDA{
	public int calculate(int x,int y) {
		return x+ y;
	}
}



public class main0324 {

	public static void main(String[] args) {
		
		/*
		SamsungPhone phone = new SamsungPhone();
		phone.printLogo();
		phone.sendCall();
		phone.receiveCall();
		phone.flash();
		*/
		
		/*
		SmartPhone phone = new SmartPhone();
		phone.printLogo();
		phone.sendCall();
		phone.play();
		System.out.println("3�� 5�� ���ϸ� "+phone.calculate(3, 5));
		phone.schedule();
		*/
		
		//equals()Ȱ��
		/*
		Point a = new Point(2,3);
		Point b = new Point(2,3);
		Point c = new Point(3,4);
		
		if(a==b)
			System.out.println("a==b");
		if(a.equals(b))
			System.out.println("a is equal to b");
		if(a.equals(c))
			System.out.println("a is equal to c");
		*/
		
		//boxing,��boxingȰ��
		/*
		int n =10;
		System.out.println("n = "+n);
		Integer intObject = n;
		System.out.println("intObject = "+intObject);
		int m = intObject + 10;
		System.out.println("m = "+m);
		*/
		
		//StringŬ���� �޼ҵ� Ȱ��
		/*
		String s1 = "Hello World";
		
		
		System.out.println(s1 + "�� ���̴� " +s1.length());
		
		String s2 = "010-1111-2222";
		System.out.println(s2.replace("-","."));
		System.out.println(s2);
		s2 = s2.replace("-",".");
		System.out.println(s2);
		
		// CSV(Comma Seperated Value) �޸��� �̷���� ǥ��
		String data = "�̼���,010-1111-2222,��ǻ�Ͱ��а�";
		String[] dataArray = data.split(",");
		for(int i =0;i<dataArray.length;i++)
			System.out.println(dataArray[i]);
		
		String fileName = "HelloWorld.java";
		System.out.println(fileName.substring(5));
		System.out.println(fileName.substring(5, 6));
		System.out.println(fileName.substring(11));
		System.out.println(fileName.indexOf("."));
		System.out.println(fileName.substring(fileName.indexOf(".")+1));
		
		String fileName2="login.html";
		System.out.println(fileName2.substring(fileName2.indexOf(".")+1));
		
		String fileName3="a.b.c.mp3";
		System.out.println(fileName3.substring(fileName3.indexOf(".")+1));
		System.out.println(fileName3.substring(fileName3.lastIndexOf(".")+1));
		*/
		
		
		
		
		
	}

}
