package com.address;

import com.project.MemVO;

/*
 * NullPointerException - 인스턴스화 하지 않고 선언만 되어 있는 경우
 * 그 주소번지를 사용하여 메소드를 호출하면 바로 그때 NullPointerException발생함.
 * A a = new A();//다형성 기대할 수 없다.
 * A a = new B();//다형성 기대 가능
 * A a = B.getXXX();//기대
 * 1),2)번과의 차이점은 싱글톤기대가능
 * if(a=null){
 * 	a = new A();
 * }
 */
public class RegisterLogic {
	AddressBookInterface aDao = new AddressBookDao();
	
	public AddressVO addressInsert(AddressVO paVO) {
		System.out.println("RegisterLogic addressInsert 호출 성공");
		AddressVO raVO = new AddressVO();
		raVO=aDao.addresssInsert(paVO);
		//raVO.setStatus(1);
		return raVO;
	}

}
