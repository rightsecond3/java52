package com.mvc1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.util.MyBatisCommonFactory;
import com.vo.DeptVO;

public class MyProcSimulation {
	// 스태틱 영역은 메인메소드보다 먼저 시작됨.
	static SqlSessionFactory sqlSessionFactory = null;
	static {
		sqlSessionFactory =
				MyBatisCommonFactory.getSqlSessionFactory();
	}
	public MyProcSimulation() {
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			Map<String, Object> pMap = new HashMap<>();
			sqlSession.selectOne("my_proc", pMap);
			
			if(pMap instanceof HashMap) { //해당하는 변수가 HashMap이냐
				Object keys[] = pMap.keySet().toArray(); //키값을 배열로 담음
				System.out.println("키의 길이 : "+keys.length);
				//sys_refcursor가 어떤 자료형으로 담아주는지를 반드시 체크
				//파라미터 타입을 Map으로 하였으나 그 안에 자료구조가 List형인지 반드시 점검
				for(int i=0;i<keys.length;i++) {
					List<DeptVO> dList = (List<DeptVO>) pMap.get(keys[i]);
					Iterator it = dList.iterator();
					while(it.hasNext()) {
						DeptVO dVO = (DeptVO) it.next();
						int deptno = dVO.getDeptno();
						String dname = dVO.getDname();
						String loc = dVO.getLoc();
						System.out.println("deptno : "+deptno+" dname : "+dname
								+" loc : "+loc);
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new MyProcSimulation();
	}

}
