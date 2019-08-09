package com.mvc2;

public class ControllerMapping {
	static String crud = null;
	/**********************
	 * 1차에서는 xxx.kos?work=onLineTest로 받았었다.
	 * @param command : onLineTest/getSubjectList.mo?crud=select
	 * @param crud : select
	 * @return
	 **********************/
	public static Controller getController(String command, String crud) {
		ControllerMapping.crud = crud;
		Controller controller = null;
		String commands[] = command.split("/"); // "/"안의 문자열을 기준으로 썰어서 배열에 담아줌
		String work = commands[0]; // onLineTest
		String requestName = commands[1];// getSubjectList.mo?crud=select
		if("onLineTestVer2".equals(work)) {
			controller = new Test2Controller(requestName, ControllerMapping.crud);
		}
		else if("member".equals(work)) {
			controller = new Member2Controller(requestName, ControllerMapping.crud);
		}
		else if("board".equals(work)) {
			controller = new BoardController(requestName, ControllerMapping.crud);
		}
		return controller;
	}
}
