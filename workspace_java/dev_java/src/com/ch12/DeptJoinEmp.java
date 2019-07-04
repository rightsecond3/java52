package com.ch12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.vo.DeptVO;
import com.vo.EmpVO;
/*
 * 리턴타입이 참조형인 경우를 연습을 많이해라
 */
public class DeptJoinEmp {
	List<Map<String,Object>> list = null; //전역변수
	Map<String,Object> rMap = null;
	//** unitTest 개선하기 **//
	/**************************************************************
	 * 아래 코드 개선해보기
	 * 문제제기
	 * List를 사용하더라도 제네릭 타입을 두 개 선정할 수가 없다
	 * 그래서 DeptVO에 EmpVO를 추가 선언한 것
	 * 그러나 조인 갯수가 5개라면...ㄷㄷ;;
	 * 닷트 연산자가 너무 열거되어서 가독성도 떨어지고  코드는 길어지고
	 * 관리하기가 어려워진다
	 * 해결방법
	 * 제네릭 타입으로 Map을 생각해보자
	 * Map은 키와 값으로 정보를 관리하니깐... 테이블과 상관없이 여러개의 컬럼정보를
	 * 키로 사용할 수 있다
	 * 단 VO처럼 테이블은 구분되지 않는다
	 * 득과 실을 따져 볼 때 그래도 득이 많은 편이다
	 * List<Map> 패턴으로 사용하는 것이 효과적이다
	 * 또 하나 불편할 수 있는 점은 VO는 타입이 정해져 있어서
	 * ClassCastingException은 예방되는 효과가 있는데
	 * Map의 경우 타입이 정해지지 않아서 캐스팅 익셉션에 노출되어 있다
	 * 그러나 본인이 예방하고 코딩할 수 있다면 문제가 되지 않는다
	 **************************************************************/

	public void unitTestVer2() {
		//Map에는 여러개 행을 담을 수 가 없다.
		//List에 제네릭 형태로 담아서 써야 한다.
		//여러 테이블을 조인할 경우 그 반환 결과값을 이렇게 넣어준다.
		list = new ArrayList<>();
		rMap = new HashMap<String, Object>();	
		rMap.put("empno", 7934);
		rMap.put("ename", "MILLER");
		rMap.put("dname", "ACCOUNTING");
		list.add(rMap);
		
		rMap = new HashMap<String, Object>();
		rMap.put("empno", 7782);
		rMap.put("ename", "CLERK");
		rMap.put("dname", "ACCOUNTING");
		list.add(rMap);

		rMap = new HashMap<String, Object>();
		rMap.put("empno", 7839);
		rMap.put("ename", "KING");
		rMap.put("dname", "ACCOUNTING");
		list.add(rMap);
	}
	public void listPrint() {
		unitTestVer2();
		//Iterator는 자료구조(Collection Framework) 안에 있는
		//정보의 유무를 체크해주는 메소드를 지원함.
		Iterator<Map<String,Object>> it = list.iterator();//리스트를 이터레이터화 시켰다
		while(it.hasNext()) { //반복 처리로 한층 더 요소가 있는 경우에true를 돌려줍니다.
			Map<String,Object> pMap = it.next(); //반복 처리로 다음의 요소를 돌려줍니다.
			System.out.println(pMap.get("empno"));
			System.out.println(pMap.get("ename"));
			System.out.println(pMap.get("dname"));
		}
	}
	
	public void unitTest() {
		List<DeptVO> deptList = null;
		List<EmpVO> empList = null;
		DeptVO dVO = new DeptVO();
		EmpVO eVO = new EmpVO();
		dVO.setDname("ACCOUNTING");
		eVO.setEname("CLERK");
		eVO.setEmpno(7782);
		dVO.setEmpVO(eVO);
		//insert here 사원번호
		System.out.println(dVO.getEmpVO().getEmpno());
		//insert here 사원이름
		System.out.println(dVO.getEmpVO().getEname());
		//insert here 부서명
		System.out.println(dVO.getDname());
		
		dVO = new DeptVO();
		eVO = new EmpVO();
		dVO.setDname("ACCOUNTING");
		eVO.setEname("CLERK");
		eVO.setEmpno(7782);
		dVO.setEmpVO(eVO);
		
		dVO = new DeptVO();
		eVO = new EmpVO();
		dVO.setDname("ACCOUNTING");
		eVO.setEname("MILLER");
		eVO.setEmpno(7934);
		dVO.setEmpVO(eVO);

	}
	public static void main(String[] args) {
		DeptJoinEmp dje = new DeptJoinEmp();
		dje.listPrint();
	}
}
