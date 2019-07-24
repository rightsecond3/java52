package com.helpme3;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class JsonFormatter {
	Gson gson = new Gson();
	public String toJson(List<Map<String, Object>> jList) {
		String temp = null;
		temp = gson.toJson(jList);
		return temp;
	}
	public String toJson(Map<String, Object> pMap) {
		String temp = null;
		temp = gson.toJson(pMap);
		return temp;
	}
	public String VOtoJson(List<VOMem> mVO) {
		String temp = null;
		temp = gson.toJson(mVO);
		return temp;
	}
}
