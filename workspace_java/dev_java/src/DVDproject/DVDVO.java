package DVDproject;

public class DVDVO {
	/////***** DVD 테이블 VO 추가 *****//////
	private String serialnum     = null;// 시리얼넘버
	private String genre         = null;// 장르
	private String mov_class     = null;// 영화등급
	private String mov_title     = null;// 영화제목
	private String maker         = null;// 배급사
	private String nation        = null;// 국가
	private String leadingactor  = null;// 주연배우
	private String director      = null;// 감독
	private String mov_date      = null;// 개봉일
	private String v_date        = null;// 비디오 개봉일
	private String damage        = null;// 파손여부
	private String r_check       = null;// 대여여부
	private int    r_fee         = 0;   // 대여료
	/////***** MEM 테이블 VO 추가 *****//////
	private String memid         = null;// 회원아이디
	private String memname       = null;// 회원이름
	private String tel           = null;// 회원집번호
	private String phonenum      = null;// 회원핸드폰번호
	private String zipcode       = null;// 회원도시명코드
	private String address       = null;// 회원주소
	private String resistdate    = null;// 회원등록일
	private String mempw         = null;// 회원비밀번호
	/////***** RENTAL 테이블 VO 추가 *****//////
	private String r_num       = null;// 렌탈번호
	private String r_date      = null;// 렌탈한날짜
	private String returndate  = null;// 반납일
	private int    latefee     = 0;   // 연체료
	private String duedate     = null;// 반납예정일
//	private String memid       = null; -> MEM테이블의 memid를 외래키로 받아옴.
	/////***** RENDTAIL 테이블 VO 추가 *****//////
	private String r_detailnum = null;// 랜탈디테일번호
//	private String serialnum   = null; -> DVD테이블의 왜래키
//	private String r_num       = null; -> RENTAL테이블의 왜래키
	
	/////***** 업무에 대한 구분을 위한 변수 선언 *****//////
	private String command     = null;// select|insert|update|delete
	/////***** 오라클서버에서 반환되는 값을 담을 변수 *****//////
	private int    status      = -1;
	/////***** 사용자가 입력한 키워드 값을 담을 변수 *****/////
	private String keyword     = null;
	/////***** 사용자가 선택한 콤보박스 값을 담을 변수 *****/////
	private String combobox     = null;

	
	public String getSerialnum() {
		return serialnum;
	}
	public void setSerialnum(String serialnum) {
		this.serialnum = serialnum;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getMov_class() {
		return mov_class;
	}
	public void setMov_class(String mov_class) {
		this.mov_class = mov_class;
	}
	public String getMov_title() {
		return mov_title;
	}
	public void setMov_title(String mov_title) {
		this.mov_title = mov_title;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getLeadingactor() {
		return leadingactor;
	}
	public void setLeadingactor(String leadingactor) {
		this.leadingactor = leadingactor;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getMov_date() {
		return mov_date;
	}
	public void setMov_date(String mov_date) {
		this.mov_date = mov_date;
	}
	public String getV_date() {
		return v_date;
	}
	public void setV_date(String v_date) {
		this.v_date = v_date;
	}
	public String getDamage() {
		return damage;
	}
	public void setDamage(String damage) {
		this.damage = damage;
	}
	public String getR_check() {
		return r_check;
	}
	public void setR_check(String r_check) {
		this.r_check = r_check;
	}
	public int getR_fee() {
		return r_fee;
	}
	public void setR_fee(int r_fee) {
		this.r_fee = r_fee;
	}
	public String getMemid() {
		return memid;
	}
	public void setMemid(String memid) {
		this.memid = memid;
	}
	public String getMemname() {
		return memname;
	}
	public void setMemname(String memname) {
		this.memname = memname;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getResistdate() {
		return resistdate;
	}
	public void setResistdate(String resistdate) {
		this.resistdate = resistdate;
	}
	public String getMempw() {
		return mempw;
	}
	public void setMempw(String mempw) {
		this.mempw = mempw;
	}
	public String getR_num() {
		return r_num;
	}
	public void setR_num(String r_num) {
		this.r_num = r_num;
	}
	public String getR_date() {
		return r_date;
	}
	public void setR_date(String r_date) {
		this.r_date = r_date;
	}
	public String getReturndate() {
		return returndate;
	}
	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}
	public int getLatefee() {
		return latefee;
	}
	public void setLatefee(int latefee) {
		this.latefee = latefee;
	}
	public String getDuedate() {
		return duedate;
	}
	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}
	public String getR_detailnum() {
		return r_detailnum;
	}
	public void setR_detailnum(String r_detailnum) {
		this.r_detailnum = r_detailnum;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getCombobox() {
		return combobox;
	}
	public void setCombobox(String combobox) {
		this.combobox = combobox;
	}

	
	
}