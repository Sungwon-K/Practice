package practice06;

public class Bc {
	String cd = new String();
	
	public Bc(String cd)
	{
		this.cd=cd.substring(0, 2);
	}
	
	public void showinfo()
	{
		if(cd.equals("EL"))
			System.out.println("���ڰ��а�");
		else if(cd.equals("CH"))
			System.out.println("ȭ�а��а�");
		else if(cd.equals("EN"))
			System.out.println("������а�");
	}
}
