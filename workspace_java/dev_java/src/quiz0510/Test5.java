package quiz0510;

public class Test5 {

	public static void main(String[] args) {
		Integer a = new Integer(10); // int타입에 대한 Wrapper클래스이다.
		//int타입에 메소드를 주고 싶기 때문에 만듬
		Integer b = new Integer(10);
		//6행과 8행은 값은 같지만 주소번지는 다르다.
		Integer c = a;
		int d = 10;
		double e =10.0;
		if(a==d) { // 클래스와 원시형 타입을 비교하면 주소번지가 아니라 값을 비교한다.
			System.out.println("참");
		}
		System.out.println(a); //결과값 10
		int i;
		i=a;
		i=a.intValue();
	}

}
