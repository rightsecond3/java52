package com.address;
/*
 * NullPointerException - 인스턴스화 하지 않고 선언만 되어 있는 경우
 * 그 주소번지를 사용하여 메소드를 호출하면 바로 그 때 NullPointerException발생함.
 * 1) A a = new A(); // 다형성 기대할 수 없다.
 * 2) A a = new B(); // 다형성 기대 가능
 * 3) A a = B.getXXX(); // 기대
 * 3번은 1,2번과의 차이점은 싱글톤 기대 가능
 * if(a==null) {
 * 	a = new A();
 * }
 * 
 */
public class RegisterLogic {
	// 선언부에 인터페이스 생성부에 구현체 클래스 사용 - 인스턴스화
	// 스프링 프레임 워크를 이용해서 MVC패턴을 적용할 때 -> 추상클래스, 인터페이스중심의 코딩전개
	AddressBookInterface aDao = new AddressBookDao();
	public AddressVO addressInsert(AddressVO paVO) {
		AddressVO raVO = null;
		System.out.println("RegisterLogic addressInsert() 호출 성공");
		//insert here
		raVO = new AddressVO();
		raVO = aDao.addressInsert(paVO);
		// 테스트용 raVO.setStatus(1);
		return raVO;
	}

}