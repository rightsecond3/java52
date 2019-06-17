package com.ch12;

import java.util.List;
import java.util.Vector;

import com.google.gson.Gson;

public class JsonFormatPrint {

	public static void main(String[] args) {
		List<ChatVO> list = new Vector<>();
		ChatVO cVO = new ChatVO();
		cVO.setNickName("최종현");
		cVO.setAge(88);
		list.add(cVO);
		cVO = new ChatVO();
		cVO.setNickName("정원형");
		cVO.setAge(93);
		list.add(cVO);
		cVO = new ChatVO();
		cVO.setNickName("박상범");
		cVO.setAge(94);
		list.add(cVO);
		Gson g = new Gson();
		String jsonChat = g.toJson(list);
		System.out.println(jsonChat);
	}

}
