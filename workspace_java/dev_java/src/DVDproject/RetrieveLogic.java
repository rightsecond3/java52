package DVDproject;

import java.util.List;

public class RetrieveLogic {
	DVDDao dDao = new DVDDao();
	
	//조건검색을 처리할 메소드 구현
	public List<DVDVO> getRentList(DVDVO paVO) {
		System.out.println("RetriveLogic getRentList메소드 호출성공");
		List<DVDVO> list = null;
		list = dDao.getRent(paVO);
		return list;
	}
}
