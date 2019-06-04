package quiz0510;

public class Test8 {
	static int j = 0;
	public static boolean methodB(int k) {
		j=j+k;
		return true;
	}
	public static void methodA(int i) {//파라미터 자리에 i=지역변수
		boolean b; //변수 선언 - 지변:초기화
		b=false;
		System.out.println(i);
		System.out.println(b);
	}
	public static void main(String[] args) {
		//자바는 같은 이름의 메소드를 여러개 선언할 수 있다.
		methodA(5);
	}

}
