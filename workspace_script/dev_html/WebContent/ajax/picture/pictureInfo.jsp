<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.google.gson.Gson" %>
<%
	/*
	* pictureMain.html 문서에서 ajax 처리 메소드에서 호출하는
	* url 뒤에 query string 문자열 값을 읽어오는 메소드.
	*/
	String p_no = request.getParameter("p_no");
    List<Map<String,Object>> picList = new ArrayList<>();
	Map<String,Object> picInfo = new HashMap<>();
	picInfo.put("p_no",1);
	picInfo.put("p_img","picture1.jpg");
	picInfo.put("p_info","다람쥐");
	picList.add(picInfo);
	
	picInfo = new HashMap<>();
	picInfo.put("p_no",2);
	picInfo.put("p_img","picture2.jpg");
	picInfo.put("p_info","고양이");
	picList.add(picInfo);
	
	picInfo = new HashMap<>();
	picInfo.put("p_no",3);
	picInfo.put("p_img","picture3.jpg");
	picInfo.put("p_info","몽몽이");
	picList.add(picInfo);
	
	picInfo = new HashMap<>();
	picInfo.put("p_no",4);
	picInfo.put("p_img","picture4.jpg");
	picInfo.put("p_info","판다너구리");
	picList.add(picInfo);
	//선택하는 그림의 아이디에 대응하는 값만 가져오기
	//json 포맷으로 넘겨야 하고 그 후 스크립트로 다시 파싱해야 하므로 동일한 구조로 만들어야함
	//그러면 파싱하는 부분의 코드는 수정을 안해도 되니깐
	/*
	위에서는 모든 건을 다 조회하였다
	그러나 그림 제목에 오버했을 때 td태그의 id속성의 값을 읽어서 그 값을 쿼리 스트링으로 넘겼다.
	pictureInfo.jsp?p_no=? -> ?뒤에 문장 : 쿼리 스트링
	*/
    List<Map<String,Object>> picDetail = new ArrayList<>();
	Map<String,Object> picDetailMap = null;
	for(int i=0;i<picList.size();i++) { //4번 반복
		Map<String,Object> rmap = picList.get(i); //한건 식 꺼냄
		if(p_no.equals(rmap.get("p_no").toString())) { //비교 - p_no로
			//한건 씩 꺼낸 맵의 주소번지를 새로운 주소번지 대입하고
			picDetailMap = rmap; //4건을 가진 map 중에서 p_no가 같은 한개 맵만 주소번지를 저장
			picDetail.add(picDetailMap); //리스트에 담아줌
		}
	}
	//구글에서 제공하는 오픈 API를 사용하여 JSON포맷으로 꺼내기
	Gson g = new Gson();
	String result = g.toJson(picDetail);
	//picList가 아닌 Json포맷으로 변형된 result를 넘겨야 된다.
	out.print(result);
%>