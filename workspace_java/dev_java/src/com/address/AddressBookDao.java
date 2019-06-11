package com.address;

import java.util.List;

public class AddressBookDao implements AddressBookInterface {

	@Override
	public AddressVO getAddressDetail(AddressVO paVO) {
		System.out.println("DAO getAddressDetail 호출성공");
		return null;
	}

	@Override
	public AddressVO addressInsert(AddressVO paVO) {
		System.out.println("DAO addressInsert 호출성공");
		return null;
	}

	@Override
	public AddressVO addressUpdate(AddressVO paVO) {
		System.out.println("DAO addressUpdate 호출성공");
		return null;
	}

	@Override
	public AddressVO addressDelete(AddressVO paVO) {
		System.out.println("DAO addressDelete 호출성공");
		return null;
	}

	@Override
	public List<AddressVO> getAddress(AddressVO paVO) {
		System.out.println("DAO getAddress 호출성공");
		return null;
	}

}
