package practice06;
import java.util.Scanner;
import practice06.Bc;


public class mainmethod {
	public static void main(String[] args)
	{
		//마우스 클래스 interface로 변경
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
		
		
		//1.전화번호(010-1234-5678)에서 국번 (010)을 추출하시오.
		
		String phoneNum = "010-1234-5678";
		
		System.out.println(phoneNum.substring(0,3));
		
		//2.전화번호(010-1234-5678)에서 '-'을 제거하시오
		System.out.println(phoneNum.replace("-", ""));
		
		//3.상품코드(E20160001)에서 상품카테고리('E')를 추출하시오.
		String productNum = "E20160001";
		
		System.out.println(productNum.charAt(0));
		
		//4.상품코드(E20160001)에서 년도(2016)을 추출하시오.
		System.out.println(productNum.substring(1, 5));
		
		//5.주소록 csv데이터에서 데이터를 분리하시오.
		String data = "Hong,010-1111-2222,hkd@hkd.com";
		
		String[] dataArray = data.split(",");
		
		for(int i =0;i<dataArray.length;i++)
			System.out.println(dataArray[i]);
		
		//6.csv데이터에 다음과 같은 학번이 저장되어 있을때. 각 학과명 출력
		//EL-전자공학과
		//CH-화학공학과
		//EN영어영문학과
		Bc[] cd = new Bc[3];
		
		cd[0] = new Bc("EL20180001");
		cd[1] = new Bc("CH201800021");
		cd[2] = new Bc("EN12231");
		
		for(int i= 0;i<cd.length;i++)
			cd[i].showinfo();
		*/
		
		//7.아이디에 !,@,#,$,%,^가 포함된 경우
		//'아이디에 !,@,#,$,%,^가 포함되면 안됩니다.'
		//메시지 출력하기.charAt()참고.
		
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디를 입력하세요. : ");
		
		String ck = sc.next();
		
		for(int i=0;i<ck.length();i++)
		{
			if('!'== ck.charAt(i) || '@'== ck.charAt(i) || '#'== ck.charAt(i) || '$'== ck.charAt(i) || '%'== ck.charAt(i) || '^'== ck.charAt(i))
			{
				System.out.println("아이디에 !,@,#,$,%,^가 포함되면 안됩니다.");
				break;
			}
				
		}
		System.out.println("입력받은 아이디는 "+ck+"입니다.");
		sc.close();		
	}
}
