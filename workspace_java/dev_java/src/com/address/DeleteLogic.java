package com.address;

public class DeleteLogic {
	AddressBookInterface aDao = new AddressBookDao();
	public AddressVO addressDelete(AddressVO paVO) {
		System.out.println("DeleteLogic addressDelete() 호출 성공");
		AddressVO raVO = null;
		raVO = aDao.addressDelete(paVO);
		return raVO;
	}

}
