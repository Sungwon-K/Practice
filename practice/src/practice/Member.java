package practice;

public class Member {
	String name,address,job;
	int age;
	
	//�⺻ ������ ����
	public Member() {
	};
	
	//�з����� ��θ� ����ϴ� ������ ����
	public Member(String name, String address, String job, int age )
	{
		this.name = name;
		this.address = address;
		this.job = job;
		this.age = age;
	}
	
	//�Է°� ���
	public void showInfo()
	{
		System.out.println(this.name + "�� " + this.address +" " + this.job +" " + this.age+"�� ");
	}

}
