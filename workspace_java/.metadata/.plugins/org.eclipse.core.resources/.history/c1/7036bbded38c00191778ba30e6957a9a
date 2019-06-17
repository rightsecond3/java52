package com.address;
/*
 * NullPointerException - 인스턴스화 하지 않고 선언만 되어 있는 경우
 * 그 주소번지를 사용하여 메소드를 호출하면 바로 그 때 NullPointerException발생함.
 */
public class RegisterLogic {
	AddressBookInterface aBookInterface = new AddressBookDao();
	public AddressVO addressInsert(AddressVO paVO) {
		AddressVO raVO = null;
		System.out.println("RegisterLogic addressInsert() 호출 성공");
		//insert here
		raVO = new AddressVO();
		raVO.setStatus(1);
		return raVO;
	}

}
