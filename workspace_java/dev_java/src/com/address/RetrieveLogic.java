package com.address;

import java.util.List;
import java.util.Map;
/*
 * 로직 클래스에서는 직접 오라클 서버와 연동하지 않음.
 * 로직 클래스에서는 업무에 대한 판단, 선택, 결정을 하는 클래스임.
 * 지금 현재는 입력,수정,삭제,조회등 모두가 한개의 테이블에서 일어나므로
 * 있으나 마나한 클래스로 생각할 수 있음.
 * 그러나 꼭 필요한 클래스 이므로 반드시 구현할 것.
 */
public class RetrieveLogic {
	//다형성을 기대할 수 있는 인스턴스화 구문임.
	AddressBookInterface aDao = new AddressBookDao();
	//상세주소 정보를 보기 위한 메소드 선언임
	//파라미터에는 아이디만 담겨 있음. 나머지는 다 default값임.
	//select * from mkaddrtb where id=? 에서 ?자리에 들어갈 정보를
	//담기 위해 paVO를 사용하였음.
	public AddressVO addressDetail(AddressVO paVO) {
		System.out.println("RetrieveLogic addressDetail");
		AddressVO raVO = null;
		//DB연동을 담당하는  메소드 호출시 paVO의 주소번지를 넘김
		//paVO를 주고 raVO를 받아옴
		//raVO에는 조회된 한 개 로우만 담겨 있음.
		raVO = aDao.getAddressDetail(paVO);
		return raVO;
	}

	public List<AddressVO> getAddressList() {
		System.out.println("RetrieveLogic getAddressList호출 성공");
		List<AddressVO> list = null;
		list = aDao.getAddress();
		return list;
	}
	public List<Map<String,Object>> getAddressMap() {
		System.out.println("RetrieveLogic getAddressList호출 성공");
		List<Map<String,Object>> list = null;
		list = aDao.getAddressMap();
		return list;
	}

}
