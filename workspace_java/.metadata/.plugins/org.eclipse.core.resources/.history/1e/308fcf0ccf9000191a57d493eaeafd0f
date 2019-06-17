package com.ch12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionTest1 {
/*
 * 둘 다 동일한 메소드를 호출하 였고 파라미터 타입도 똑같이 0을 주었다.
 * 그러나 위에서는 파라미터가 Object인 것이 호출된 것이고
 * 이 자료구조 안에는 그 값이 없으므로 처리된 것이 없다.
 * 그러나 아래에서는 파라미터가 int인 것이 호출된 것이고 그 자리에
 * 값이 있어 값이 삭제되었다.
 * 
 * 다행인 것은 remove(Object)이어서 20번 라인이 컴파일 에러가 안난 경우
 * 메소드 오버로딩으로 해석
 */
	public static void main(String[] args) {
		Collection<String> coll = new ArrayList<>();
		coll.add("파인애플");
		coll.remove(0);//Object타입 메소드만 지원
		//자식인터페이스 List에만 있는 remove(int index) 사용불가
		for(String fru:coll) {
			System.out.println(fru);
		}//삭제X
		List<String> li = new ArrayList<>();
		li.add("딸기");
		li.remove(0); //List에서 지원하는 메소드
		for(String fru:li) {
			System.out.println(fru);//0번쨰 삭제
		}
	}
}
