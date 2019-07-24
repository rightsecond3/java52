package com.ch05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberDao {
	public List<Map<String, Object>> memberList() {
		List<Map<String, Object>> memList = new ArrayList<>();
		Map<String, Object> rMap = new HashMap<String, Object>();
		rMap.put("mem_id", "test");
		rMap.put("mem_pw", "123");
		rMap.put("mem_name", "김유신");
		memList.add(rMap);
		
		rMap = new HashMap<String, Object>();
		rMap.put("mem_id", "apple");
		rMap.put("mem_pw", "123");
		rMap.put("mem_name", "이성계");
		memList.add(rMap);
		
		rMap = new HashMap<String, Object>();
		rMap.put("mem_id", "haha");
		rMap.put("mem_pw", "123");
		rMap.put("mem_name", "김춘추");
		memList.add(rMap);
		
		return memList;
	}
}
