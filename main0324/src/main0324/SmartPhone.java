package main0324;

//smartPhone class <-  PDA ���
//MobilePhoneinterface,MP3Interface�� ����� �߻� �޼ҵ带 ��� ����
public class SmartPhone extends PDA implements MobilePhoneInterface, MP3Interface{

	@Override
	public void sendCall() {
		System.out.println("��������");
		
	}

	@Override
	public void receiveCall() {
		System.out.println("��ȭ�Ծ��");
		
	}

	@Override
	public void play() {
		System.out.println("���� �����մϴ�.");
		
	}

	@Override
	public void stop() {
		System.out.println("���� �ߴ��մϴ�.");
		
	}

	@Override
	public void sendSMS() {
		System.out.println("���ڰ��ϴ�.");
		
	}

	@Override
	public void receiveSMS() {
		System.out.println("���ڿԾ��.");
		
	}
	
	public void schedule() {
		System.out.println("���� �����մϴ�.");
	}
	

}
