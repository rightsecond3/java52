package com.ch12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
/*
 * deptMap은 지변이다.
 * 지역변수를 다른 메소드에서 사용하려면 어떡하지?
 * 1)파라미터
 * 2)리턴타입
 */
public class MapTest {
	public void setMap() {
		List<Map<String,Object>> deptList = new ArrayList<>();
		Map<String,Object> deptMap = new HashMap<>();
		deptMap.put("deptno", 10);
		deptMap.put("dname", "ACCOUNTING");
		deptMap.put("loc", "New York");
		deptList.add(deptMap);
		deptMap = new HashMap<String, Object>();
		deptMap.put("deptno", 20);
		deptMap.put("dname", "RESEARCH");
		deptMap.put("loc", "DALLAS");
		deptList.add(deptMap);
		deptMap = new HashMap<String, Object>();
		deptMap.put("deptno", 30);
		deptMap.put("dname", "SALES");
		deptMap.put("loc", "CHICAGO");
		deptList.add(deptMap);
		deptMap = new HashMap<String, Object>();
		deptMap.put("deptno", 40);
		deptMap.put("dname", "OPERATION");
		deptMap.put("loc", "BOSTON");
		deptList.add(deptMap);
		mapPrint(deptList);

	}

	private void mapPrint(List<Map<String, Object>> deptList) {
		Vector v = new Vector();
		for(int i=0; i<deptList.size(); i++) {
			//List->Map->map.get(key)
			//Object는 기본적으로 toString을 메소드로 지정해준다.
			//sys에 deptList나 deptList.toString이나 같다.
			//Map의 재정의된 toString메소드(override)가 호출되었다.
			//System.out.println(deptList.get(i)); -> Map의 주소번지를 가져옴
			Map<String, Object> rMap = deptList.get(i);
			//keySet(리턴타입:Set)은 Map의 메소드 toArray는 Set의 메소드
			Object keys[] = rMap.keySet().toArray();
			for(int j=0;j<keys.length;j++) {
				System.out.print(rMap.get(keys[j]));
				if(j==keys.length) {
					break;
				}
				System.out.print(" ");
			}
			System.out.println();//줄바꿈처리
		}
	}

	public void mapPrint(Map<String,Object> deptMap) {
		//Set은 집합을 담을 수 있는 클래스이다.
		//Map에 담긴 key를 하나의 집합으로 생각하여 Set안에 keySet메소드를 제공함.
		Set<String> set = deptMap.keySet();//키 값들을 가져오는 메소드
		//Set안에서 키 값을 꺼내야 하는데 n개이므로
		//toArrayy메소드를 호출하면 Object배열에 담아줌.
		Object keys[] =set.toArray();
		for(int i=0;i<keys.length;i++) {
			System.out.println(keys[i]);//키를 출력하는 코드
			System.out.println(deptMap.get(keys[i]));//값을 출력하는 코드
		}
		/*
		 * 정리하기
		 * list에 담을 때는 add, map에 담을 때는 put
		 * list에서 꺼낼때는 get(int index). map에서 꺼낼때는 get(Object key)
		 */
	}
	public static void main(String[] args) {
		MapTest mt = new MapTest();
		mt.setMap();
		//도전 - 만일 키 종류가 100가지라면 어떡하지?
		//keySet()
		
		//도전2 - 여러개의 행을 담으려면 어떡하지?
	}
}
