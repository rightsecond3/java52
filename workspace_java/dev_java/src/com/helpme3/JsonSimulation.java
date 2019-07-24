package com.helpme3;

import java.util.ArrayList;
import java.util.List;

public class JsonSimulation {
	
	public static void main(String[] args) {
		JsonSimulation js = new JsonSimulation();
		VOMem mVO = new VOMem();
		List<VOMem> list = new ArrayList<>();
		mVO.setMem_id("20130573");
		mVO.setMem_name("박상범");
		mVO.setMem_hp("01094181307");
		list.add(mVO);
		mVO = new VOMem();
		mVO.setMem_id("20140001");
		mVO.setMem_name("이경애");
		mVO.setMem_hp("01026806592");
		list.add(mVO);
		JsonFormatter json = new JsonFormatter();
		String temp = json.VOtoJson(list);
		System.out.println(temp);
	}

}
