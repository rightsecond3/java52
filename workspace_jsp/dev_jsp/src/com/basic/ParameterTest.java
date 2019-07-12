package com.basic;

import java.util.HashMap;
import java.util.Map;
class Param {
	int ival;
}
public class ParameterTest {
	/*
	 * 리턴타입이 void이다. - 내가 설계한 메소드가 아닐 때
	 * public void doGet(req, res); //override
	 * 1)해결방법 1: 전역변수 사용
	 * - 전제조건 ==> 반드시 인스턴스화를 해야 함.
	 * 그런데 서블릿은 내가 인스턴스화를 직접하는가 ? login.nhn
	 * 그럼 누가 인스턴스화를 한거지? - Tomcat -> 객체주입 -> 인스턴스화
	 * 서블릿은 개발자가 직접 인스턴스화 하지 않는다. ==> 불가
	 * 2)해결방법 2 : 파라미터를 이용함.
	 */
	public void methodA(Map<String, Object> target) {
		target.put("account", 5000);
	}
	public void methodC(Param p) {
		int i = p.ival;
	}
	public static void main(String[] args) {
		ParameterTest pt = new ParameterTest();
		Param p = new Param();
		p.ival=500;
		Map<String, Object> target = null;
		target = new HashMap<String, Object>();
		pt.methodA(target);
		System.out.println(target.get("account"));
		
	}

}
