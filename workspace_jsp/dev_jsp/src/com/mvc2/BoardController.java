package com.mvc2;
/*
 * 현재 게시판 목록을 조회할 때 boardList.jsp를 호출하였다.
 * 이렇게 호출하면 ActionServlet을 경유 하지 않으므로 세션값이 없다.
 * 경유하도록 한다. test.mo -> boardList.jsp 호출
 * 위와 같이 할 경우 객체 주입이 일어난다. (생성자 호출이 일어남.)
 * 생성자 안에서 전체 레코드를 가져 오자. -> 세션 미리 담기
 * 생성자 안에는 request가 없다. -> execute의 if문 밖에서 담아준다.
 * 페이지 요청을 표준 서블릿으로 처리 받아서는 세션 값에 사용이 불가.
 * ㄴ> ActionServlet을 경유 하라.
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.HashMapBinder;
import com.vo.BoardMasterVO;

public class BoardController implements Controller {
	//* 선언부
	Logger logger = Logger.getLogger(Member2Controller.class);
	String path = null;
	String requestName = null;
	String crud = null;
	BoardLogic bLogic = null;
	BoardMasterVO bmVO = new BoardMasterVO();
	int tot = 0;
	//* 생성자
	public BoardController(String requestName, String crud) {
		this.requestName = requestName;
		this.crud = crud;
		bLogic = new BoardLogic();
	}

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("execute 호출 성공");
		/*
		 * HttpSession session = req.getSession(); session.setAttribute("s_tot", tot);
		 * logger.info("총 레코드 수 : "+session.getAttribute("s_tot"));
		 */
		if("total".equals(crud)) {
			bmVO = null;
			bmVO = new BoardMasterVO();
			bmVO.setKeyword(req.getParameter("keyword"));
			bmVO.setCb_value(req.getParameter("cb_value"));
			tot = bLogic.getTotal(bmVO);
			req.setAttribute("tot", tot);
			path = "forward:getTotal.jsp";
			//path = "redirect:boardList.jsp";
		} else if("boardList".equals(crud)) {
			logger.info("목록조회 호출 성공");
			bmVO = null;
			bmVO = new BoardMasterVO();
			List<Map<String, Object>> rList = null;
			bmVO.setKeyword(req.getParameter("keyword"));
			bmVO.setCb_value(req.getParameter("cb_value"));
			bmVO.setBm_date(req.getParameter("bm_date"));
//			bmVO.setPageNumber(Integer.parseInt(req.getParameter("pageNumber")));
//			bmVO.setPageSize(Integer.parseInt(req.getParameter("pageSize")));
			rList = bLogic.boardList(bmVO);
			req.setAttribute("rList", rList);
			// 아래는 JSON 포맷으로 값을 넘겨서 목록처리하는 코드
			//path = "forward:jsonBoardList.jsp";
			// 아래는 JSON을 사용하지 않고 스크립트 요소로 처리하는 코드
			// 댓글처리에 대한 차수 정렬과 끼어드는 글에 대한 상수값들의 변화를 관찰하여
			// 기존에 설계한 값들의 유효성 체크를 하기 위함.
			path = "forward:boardListVer2.jsp";
		} else if("boardDetail".equals(crud)) {
			logger.info("상세조회 호출 성공");
			bmVO = null;
			bmVO = new BoardMasterVO();
			List<Map<String, Object>> boardDetail = null;
			bmVO.setBm_no(Integer.parseInt(req.getParameter("bm_no")));
			boardDetail = bLogic.boardList(bmVO);
			req.setAttribute("boardDetail", boardDetail);
			path = "forward:read.jsp";
			
		} else if ("boardAdd".equals(crud)){
			logger.info("입력 호출 성공");
			Map<String, Object> pMap = new HashMap<>();
			HashMapBinder hmb = new HashMapBinder(req);
			hmb.multiBind(pMap);
			//hmb.bindPost(pMap);
			logger.info("제목 : "+pMap.get("bm_title"));
			logger.info("내용 : "+pMap.get("bm_content"));
			int result = bLogic.boardAdd(pMap);
			if(result==1) {
				path = "redirect:test.mo?crud=boardList";
			} else if(result==0) {
				path = "redirect:boardAddFail.jsp"; // 실패 페이지-구현안됨
			}
			
		} else if("boardUpd".equals(crud)) {
			logger.info("수정 호출 성공");
			Map<String, Object> pMap = new HashMap<>();
			HashMapBinder hmb = new HashMapBinder(req);
			hmb.bind(pMap);
			int result = bLogic.boardUpd(pMap);
			path = "forward:boardList.jsp";
			
		} else if("boardDel".equals(crud)) {
			logger.info("삭제 호출 성공");
			Map<String, Object> pMap = new HashMap<>();
			HashMapBinder hmb = new HashMapBinder(req);
			hmb.bind(pMap);
			int result = bLogic.boardDel(pMap);
			path = "forward:boardList.jsp";
		}
		return path;
	}

}
