package com.ch7;

import java.util.ArrayList;

/*
 * 사원집합에서 사원번호가 7566인 사원에 대한 정보를 조회하여 ArrayList에 담고자 한다.
 * 제네릭 타입은 무엇을 해야할까요?
 * 힌트 : 타입이 서로 다르다
 * ->래퍼클래스를 사용해야한다.
 * ArrayList에 원시형 타입은 들어갈 수 없다.
 */
public class ArrayListTest2 {

	public static void main(String[] args) {
		//이름은 String으로 해야 한다.
		//급여는 double로 해야 한다.
		//부서번호는 int로 해야 한다.
		String name = new String("JONES");
		Double sal = new Double(3000.56);
		Integer deptno = new Integer(20);
		ArrayList<Object> aList = new ArrayList<Object>();
		ArrayList<String> aList2 = new ArrayList<String>();
		aList2.add(name);
//		aList2.add(sal); -> String으로만 선언했기 때문에 들어갈 수 없다
		aList.add(name);
		aList.add(sal);
		aList.add(deptno);
		aList.add(1, "우리해어져");
		if(aList.isEmpty()) {
			System.out.println("내 안에 아무도 없네...");
		}else {
			System.out.println("내 안에 너 있다....");			
		}
		for(Object obj:aList) {
		//화면 솔류션과 연계할 때 instanceof 활용되니까.. 꼭 기억해 두자.
			if(obj instanceof String) { //instanceof 타입 -> 해당 타입만 출력
				System.out.println(obj.toString());
			}else if(obj instanceof Double) {
				System.out.println(((Double) obj).doubleValue()+10);
			}
			else if(obj instanceof Integer) {
				System.out.println(obj.toString());
			}
		}
		String msg = aList.remove(1).toString();
		System.out.println("msg : "+msg);
		System.out.println("========[[after]]===========");
		for(Object obj:aList) {
		System.out.println(obj);
		}
	}

}
