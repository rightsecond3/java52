package com.ch14;

public class Exception_2 {
	void methodA() throws Exception {//throws:예외처리를 넘긴다.
		System.out.println("methodA 호출");
		int x=5/0;
	}
	/*
	 * try~catch블록은 예외상황이 발생했을 경우에만 효과가 있다.
	 * 예외상황이 없다면 있으나 마나한 코드
	 */
	public static void main(String[] args) {
		Exception_2 exc1 = new Exception_2();
		/*
		 * 멀티블럭으로 처리할 경우 하위 클래스에서 상위클래스 순으로 작성함
		 * 만일 같은 이름의 exception이 존재하지 않으면 더 넓은 범위(상위클래스)가 잡는다.
		 */
		try {
			exc1.methodA();
		} catch (ArithmeticException ae) {
			System.out.println("Exception ae:"+ae.toString());
		} catch (NumberFormatException ne) {
			System.out.println("Exception ne:"+ne.toString());
		} catch (Exception e) {
			System.out.println("Exception e:"+e.toString());
		}
		System.out.println("후행 코드들도 실행 기회를 갖는다");
	}

}
