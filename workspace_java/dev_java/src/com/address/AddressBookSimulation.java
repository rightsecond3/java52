package com.address;

public class AddressBookSimulation {

	public static void main(String[] args) {
		AddressBookCtrl bookCtrl = new AddressBookCtrl();
		AddressVO paVO = new AddressVO();
		AddressVO raVO = null;
		paVO.setCommand("update");
		paVO.setId("test");
		paVO.setName("김유신");
		paVO.setHp("010-1234-5678");
		try {
			//raVO : 1 또는 0
			//paVO : id, name, hp가 들어가 있다.
			raVO = bookCtrl.send(paVO);
			if (raVO.getStatus()==1) {
				System.out.println("입력성공");
			} else {
				System.out.println("입력실패");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
