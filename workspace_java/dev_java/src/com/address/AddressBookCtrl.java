package com.address;

import java.util.List;

import javax.swing.JOptionPane;

/* View계층과 Model계층 사이에서 인터페이스 역할
 *  : 삼성서비스센터, 은행방문
 * 고려사항
 * :반복되는 코드는 줄인다.(메소드 한개로 설계할 수 있지 않을까?-)
 * 공통분모 - 입력-return:int, 수정-return:int, 삭제-return:int
 *         ,상세조회-return:AddressVO
 * -> 공통의 리턴타입을 AddressVO로 하겠다.
 * -> 공통의 파라미터 타입 
 * 조회 - 상세조회(1_row-AddressVO
 *       SELECT id, name, .. FROM mkaddrtb WHERE id=?)
 *      ,전체조회(n_row-ArrayList<AddressVO> 
 *       SELECT id, name, .. FROM mkaddrtb
 *       SELECT 부분 : 리턴타입, 조건절 부분 : 파라미터                  )
 *       상세조회시 - 파라미터는 String 혹은 AddressVO
 *       전체조회시 - 파라미터는 필요없고 리턴타입은 ArrayList
 * 입력 - 추가
 *       INSERT INTO mkaddrtb(,,,) VALUES(?,?,?....)
 *       리턴타입 : int : 0 OR 1
 *       파라미터 타입 : AddressVO
 * 수정 - 수정처리
 *       UPDATE mkaddrtb SET name=?, hp=?, address=?, comments=?
 *        WHERE id=?;
 *       리턴타입 : int
 *       파라미터타입 : AddressVO
 * 삭제 - 삭제처리
 *       DELETE FROM mkaddrtb WHERE id=?;
 *       리턴타입 : int
 *       파라미터타입 : String 혹은 AddressVO;
 * -----------------------------------------------------------------
 * 전체조회
 *      리턴타입 : ArrayList<AddressVO>
 *      파라미터 : 필요없다.
 *      만일 조건검색 기능이 추가된다면? -> 필요하다
 * 필요한 메소드 설계하기 - 리턴타입결정, 파라미터타입 결정
 * 
 */
public class AddressBookCtrl {
	private static final String _SEL = "select";
	private static final String _DET = "detail";
	private static final String _INS = "insert";
	private static final String _UPD = "update";
	private static final String _DEL = "delete";
	
	/*
	 * throws하면 예외가 발생했을 때 나를 호출한 곳에서 try..catch하라는 의미
	 * throw 강제로 예외를 발생시킬 때
	 */
	/********************************************************************
	 * 
	 * @param paVO - 사용자가 입력한 값
	 * @return raVO - 오라클 서버에서 반환값을 담은 변수
	 * @throws Exception - 이 메소드를 호출하는 메소드에서는 반드시 try..catch를 구현
	 *********************************************************************/
	public AddressVO send(AddressVO paVO) throws Exception{
		AddressVO raVO = null;
		String command = paVO.getCommand();
		//equals 메소드는 String 문자열에 대해 주소번지가 아닌 문자열의
		//값이 같은지에 대해 비교한다. 따라서 객체간의 값비교도 가능하다.
		if(_INS.equals(command)) { //입력
			System.out.println("입력 호출 성공");
			//로직클래스를 보면 업무 프로세스를 알 수 있다.
			RegisterLogic regLogic = new RegisterLogic();
			raVO = regLogic.addressInsert(paVO);
		}
		else if (_UPD.equals(command)) { //수정버튼을 누른거야?
			ModifyLogic modLogic = new ModifyLogic();
			raVO = modLogic.addressUpdate(paVO);
		}
		else if (_DEL.equals(command)) { //삭제하니?
			DeleteLogic delLogic = new DeleteLogic();
			raVO = delLogic.addressDelete(paVO);
		}
		else if (_DET.equals(command)) { //상세조회
			RetrieveLogic retLogic = new RetrieveLogic();
			raVO = retLogic.addressDetail(paVO);
		}else {
			throw new Exception("잘못된 command명 입니다.");
			
		}
		return raVO;
	}
	/***********************************************************
	 * 전체 조회 구현
	 * @param command select
	 * @return ArrayList<AddressVO>
	 ***********************************************************/
	public List<AddressVO> send(String command) {
		List<AddressVO> addrList = null;
		if (_SEL.equals(command)) {
			RetrieveLogic retLogic = new RetrieveLogic();
			addrList = retLogic.getAddressList();
		}
		return addrList;
	}
}









