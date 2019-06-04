package quiz0510;

public class Test3 {
	static int i;
	int j; // non-static타입은 static영역에서 사용이 불가함.
	public static void main(String[] args) {
		Test3 t3 = new Test3(); // 인스턴스화를 통해 사용 가능
		System.out.println(t3.j);
		System.out.println(Test3.i); //식별하기 위해 i로 쓸수도 있지만 앞에 Test3.를 써서 직관성을 높힌다
		boolean b1 =(5>=4);
		System.out.println(b1);
		
	}

}
