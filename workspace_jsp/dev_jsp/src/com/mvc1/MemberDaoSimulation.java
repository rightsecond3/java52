package com.mvc1;

import java.util.List;

import com.vo.ZipCodeVO;

public class MemberDaoSimulation {

	public static void main(String[] args) {
		MemberDao mDao = new MemberDao();
		String time = mDao.currentTime();
		ZipCodeDao zDao = new ZipCodeDao();
		ZipCodeVO zVO = new ZipCodeVO();
		zVO.setDong("본오");
		List<ZipCodeVO> zipList = zDao.zipcodeList(zVO);
	}

}