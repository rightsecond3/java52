<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	int x = 1;
	public String newsList(String news[]) {
		StringBuilder sb = new StringBuilder();
		sb.append("<table width='500px' border='1'>");
		sb.append("<tr><td>"+news[0]+" >"+news[1]+"</td></tr>");
		sb.append("</table>");
		return sb.toString();
	}
%>

<%
	String news1[] = {"연합뉴스","전세금 떼일 위험 없앤다…만기 6개월 전 ‘반환 보증’ 가입해야"};
	String news2[] = {"서울신문","소년에서 영웅으로…’스파이더맨’ 주역 내한"};
	String news3[] = {"머니투데이","북미, 실무협상서 핵동결 집중할듯…비건 “제재해제는 없어”"};
	String news4[] = {"bbc","[해외축구] 이강인 “이적설 할 말 없어…지금 각오는 ‘열심히 놀기’”"};
	String news5[] = {"기상청","[7/3 날씨] 어제보다 더워, 대구 33도…내륙 곳곳 폭염특보"};
	String datas = "";
	switch(x){
	case 1:
		datas = newsList(news1);
		x++;
		break;
	case 2:
		datas = newsList(news2);
		x++;
		break;
	case 3:
		datas = newsList(news3);
		x++;
		break;
	case 4:
		//메소드 호출시 파라미터로 뉴스 정보 넘김
		datas = newsList(news4);
		//기사 내보낸 후 다음 기사 정보를 가져오기 위해서 1씩 증가시킴
		x++;
		//case문을 탈출함. 다음 case로 넘어가면 안되니까
		break;
	case 5:
		datas = newsList(news5);
		x=1;
		break;
	}
	//이전요청에서 가지고 있던 정보 지우기
	//아래코드를 생략하면 이전 정보를 계속 유지하므로 새로운 기사 처리가 되지않음.
	out.clear();
	//새로 읽어들인 정보 출력하기
	out.print(datas);
%>