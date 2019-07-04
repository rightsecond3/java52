package com.address;

import java.util.List;
import java.util.Map;

/* view계층과 model계층 사이에서 인터페이스 역할
 * : 삼성서비스센터, 은행방문
 * 고려사항
 * :반복되는 코드는 줄인다.(메소드 한개로 설계할 수 있지 않을까?-)
 * 공통분모 - 입력-r:int, 수정-r:int, 삭제-r:int, 상세조회-AddressVO
 * 공통의 리턴타입을 AddressVO로 하겠다.
 * 공통의 파라미터 타입을 
 * 조회 - 상세조회(1row-AddressVO
 *       SELECT id, name, ... FROM mkaddrtb WHERE id=?
 *       SELECT id, name, ... FROM mkaddrtb
 *           , 전체 조회-n:row ArrayList<AddressVO>)
 *       상세조회시 - 파라미터는 String 혹은 AddressVO
 *       전체조회시 - 파라미터는 필요없고 리턴타입은 ArrayList    
 * 입력 - 추가
 *       INSERT INTO mkaddrtb(,,,,) VALUES(?,?,?.....)
 *      리턴타입 :int
 *      파라미터타입 : AddressVO
 * 수정 - 수정처리
 *       UPDATE mkaddrtb SET name=?, hp=?, address=?, comments=?
 *        WHERE id=?
 *      리턴타입 : int
 *      파라미터타입: AddressVO  
 * 삭제 - 삭제처리
 *       DELETE FROM mkaddrtb WHERE id =?
 *      리턴타입 : int
 *      파라미터타입: String, AddressVO
 *  ----------------------------------------------------    
 * 전체 조회
 *      리턴타입 : ArrayList<AddressVO>
 *      파라미터타입 :필요없다. 
 *      만일 조건검색 기능이 추가된다면?      
 * 필요한 메소드 설계하기 - 리턴타입결정, 파라미터타입 결정
 * 
 */
public class AddressBookCtrl {
	//AddressBook에서 사용자가 선택한 버튼이나 메뉴에 따라 그 값을 AddressBookCtrl에서
	//분기하는데 필요한 정보임
	//분기 해야 하는 경우의 수가 전체 5가지 이므로 변수 5개 선언하였음.
	private static final String _SEL = "select";//전체조회를 구분하기 위한 값
	private static final String _DET = "detail";//상세조회를 구분하기 위한 값
	private static final String _INS = "insert";//입력을 구분하기 위한 값
	private static final String _UPD = "update";//수정을 구분하기 위한 값
	private static final String _DEL = "delete";//삭제를 구분하기 위한 값
	/*
	 * throws하면 예외가 발생했을 때 나를 호출한 곳에서 try..catch하라는 의미
	 * throw 강제로 예외를 발생시킬 때
	 */
	/**************************************************************
	 * send하나의 메소드 안에서 4가지 경우[상세조회|입력|수정|삭제]를 분기하여 처리하려고 함.
	 * @param paVO - 사용자가 입력한 값
	 * @return raVO - 오라클 서버에서 반환값을 담은 변수
	 * @throws Exception - 이 메소드를 호출하는 메소드에서는 반드시 try..catch
	 *************************************************************/
	public AddressVO send(AddressVO paVO) throws Exception{
		//입력하고 난 후, 수정하고 난 후 삭제하고 난 후 상세조회하고 난 후에 오라클 서버에서
		//반환한 값을 담을 변수가 필요함.
		AddressVO raVO = null;
		//사용자가 AddressBook에서 선택한 정보를 받아서 command변수에 저장함.
		String command = paVO.getCommand();//insert
		if(_INS.equals(command)) {//입력-> ("insert".equasl("insert"))
			System.out.println("입력 호출 성공");
			//로직클래스를 보면 업무 프로세스 알수 있다.
			RegisterLogic regLogic = new RegisterLogic();
			raVO = regLogic.addressInsert(paVO);
		}
		//수정 -> ("update".equasl("update"))
		else if(_UPD.equals(command)) {//수정버튼을 누른거야?
			ModifyLogic modLogic = new ModifyLogic();
			raVO = modLogic.addressUpdate(paVO);
		}
		//삭제 -> ("delete".equasl("delete"))
		else if(_DEL.equals(command)) {//삭제하니?
			DeleteLogic modLogic = new DeleteLogic();
			raVO = modLogic.addressDelete(paVO);			
		}
		//상세조회 -> ("detail".equasl("detail"))
		else if(_DET.equals(command)) {//상세조회
			RetrieveLogic modLogic = new RetrieveLogic();
			raVO = modLogic.addressDetail(paVO);				
		}else {
			//command에 insert, update, detail, select, delete를 제외한
			//값이 넘어올 경우 강제로 예외를 발생시키는 문자임 -더이상 어플이 진행되지 않음.
			throw new Exception("잘못된 command명 입니다.");
		}
		//각 4가지 경우에서 처리된 결과를 raVO에 담아서 반환해줌. 
		return raVO;
	}
	/****************************************************************
	 * 전체 조회 구현
	 * @param command select
	 * @return ArrayList<AddressVO>
	 ***************************************************************/
	//파라미터를  command로 하여 send메소드의 오버로딩을 구현해 보았음.
	//여기서는 전체 로우를 반환해야 하니까 raVO로는 안되는 것임.
	//
//	public List<AddressVO> send(String command){
	public List<Map<String,Object>> send(String command){
		List<Map<String,Object>> addrList = null;
		if(_SEL.equals(command)) {
			RetrieveLogic retLogic = new RetrieveLogic();
			addrList = retLogic.getAddressMap();
		}
		return addrList;
	}
}










