package com.util;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/*
 * 사용자가 입력한 값을 읽을 때마다 반복되는
 * request.getParameter()를 대신하여 사용할 수 있는 bind 메소드 추가
 * 리턴타입은 void로 하지만 파라미터를 Map타입으로 하여
 * 필요한 개발자가 Map을 생성하고 그 주소번지를 받아 값을 담는다.
 */
public class HashMapBinder {
	HttpServletRequest req = null;

	public HashMapBinder(HttpServletRequest req) {
		this.req = req;
	}

	// * getParameter의 name의 이름을 가져옴
	public void bind(Map<String, Object> target) {
		// 파라미터로 넘어온 target안에 다른 정보가 담겨 있다면 제거
		target.clear();
		Enumeration er = req.getParameterNames();
		while (er.hasMoreElements()) {
			String name = (String) er.nextElement();// name,address,pet
			// key : name, address, pet
			// value : 값
			// Tomcat의 server.xml에서 한글 처리를 해줬었음.
			target.put(name, req.getParameter(name));
		}
	}
	// * getParameter의 name의 이름을 가져옴
	public void bindPost(Map<String, Object> target) {
		// 파라미터로 넘어온 target안에 다른 정보가 담겨 있다면 제거
		target.clear();
		Enumeration er = req.getParameterNames();
		while (er.hasMoreElements()) {
			String name = (String) er.nextElement();// name,address,pet
			// key : name, address, pet
			// value : 값
			// HangulConversion.toUTF() : POST일경우
			target.put(name, HangulConversion.toUTF(req.getParameter(name)));
		}
	}
}
