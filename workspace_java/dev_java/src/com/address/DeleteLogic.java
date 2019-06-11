package com.address;

public class DeleteLogic {
	AddressBookInterface aBookInterface = new AddressBookDao();
	public AddressVO addressDelete(AddressVO paVO) {
		AddressVO raVO = null;
		System.out.println("DeleteLogic addressDelete() 호출 성공");
		raVO = aBookInterface.addressDelete(paVO);
		return raVO;
	}

}
