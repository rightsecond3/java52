package com.helpme4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.google.gson.Gson;

public class LogicServer {
	DaoServer sDao = new DaoServer();
	
	// ********************* 박상범 수정
	public List<VOChatList> getList() {
		List<VOChatList> nList = null;
		nList = sDao.getList();
		return nList;
	}
	// ********************* 박상범 수정
}
