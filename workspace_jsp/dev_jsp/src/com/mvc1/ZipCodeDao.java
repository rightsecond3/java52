package com.mvc1;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;
import com.vo.ZipCodeVO;

public class ZipCodeDao {
	Logger logger = Logger.getLogger(ZipCodeDao.class);
	SqlSessionFactory ssf = null;
	
	public ZipCodeDao() {
		ssf = MyBatisCommonFactory.getSqlSessionFactory();
	}
	/************************
	 * 
	 * @param dong 사용자로부터 동 정보는 입력 받아서 처리함.
	 * @return 조회 결과가 n건인 경우도 있으니 List의 VO로 처리함.
	 *************************/
	public List<ZipCodeVO> zipcodeList(ZipCodeVO dong) {
		//테스트 시 Exception 발생 -> 화면을 볼 수 없으므로 초기화 처리함.
		List<ZipCodeVO> zipcodeList = new ArrayList<ZipCodeVO>();
		try {
			SqlSession ss = ssf.openSession();
			zipcodeList = ss.selectList("zipcodeList", dong);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return zipcodeList;
	}
}
