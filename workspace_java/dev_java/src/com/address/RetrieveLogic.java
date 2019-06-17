package com.address;

import java.util.List;

public class RetrieveLogic {
	//AddressBookDao와 연결
	AddressBookInterface aDao = new AddressBookDao();
	
	// 상세조회를 처리할 메소드 구현
	public AddressVO addressDetail(AddressVO paVO) {
		AddressVO raVO = null;
		raVO = aDao.getAddressDetail(paVO);
		return raVO;
	}
	// 전체조회를 처리할 메소드 구현
	public List<AddressVO> getAddressList() {
		System.out.println("RetrieveLogic getAddressList()호출 성공");
		List<AddressVO> list = null;
		// Dao에서 받은 것을 넘겨줌
		list = aDao.getAddress();
		return list;
	}

}
