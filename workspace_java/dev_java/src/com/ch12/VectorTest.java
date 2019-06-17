package com.ch12;

import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
class ChatVO {
	private String nickName = null;
	private int age = 0;
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}

public class VectorTest extends JFrame {
	String cols[] = {"닉네임", "나이"};
	String data[][] = new String[0][2];
	DefaultTableModel dtm = new DefaultTableModel(data,cols);
	JTable jt = new JTable(dtm);
	JScrollPane jsp = new JScrollPane(jt);
	///*** 생성자 ***///
	public VectorTest() {
		List<ChatVO> list = new Vector<>();
		ChatVO cVO = new ChatVO();
		cVO.setNickName("데프트");
		cVO.setAge(23);
		list.add(cVO);
		cVO = new ChatVO();
		cVO.setNickName("페이커");
		cVO.setAge(23);
		list.add(cVO);
		cVO = new ChatVO();
		cVO.setNickName("박상범");
		cVO.setAge(26);
		list.add(cVO);
		Vector<ChatVO> vec = new Vector<>();
		ChatVO cVO1 = new ChatVO();
		cVO1.setNickName("이순신");
		cVO1.setAge(21);
		vec.add(cVO1);
		//이 밑의 문장이 없을 경우 결국 하나의 주소번지에 접근하는 것이기 때문에 마지막 set 값만 나온다
		cVO1 = new ChatVO();
		cVO1.setNickName("김유신");
		cVO1.setAge(22);
		//new ChatVO가 없을 경우 여기서는 김유신 22로 다 바뀌는 것이다.
		//위 의 cVO1과 같은 주소번지이기 때문에 같이 바뀐다.
		vec.add(cVO1);
		cVO1 = new ChatVO();
		cVO1.setNickName("세종대왕");
		cVO1.setAge(24);
		vec.add(cVO1);
		//Vector안에 제네릭 타입 ChatVO를 세건 넣었기 때문에 반복문으로 하나씩 꺼낸다.
		for(int i=0;i<vec.size();i++) {
			//제네릭 타입안에 들은 정보를 가진 주소번지를 대입
			ChatVO rcVO = vec.get(i);
			///실제 데이터를 갖는 DefaultTableModel 객체 로우 값들을 하나씩
			//담기 위해서 벡터를 추가로 인스턴스화 했음
			//반복문이 돌때마다 새로 값을 초기화 해야하므로 반복문안에서 인스턴스화를 함
			Vector<String> rowData = new Vector<>();
			//실제 데이터를 가진건 제네릭 타입은 ChatVO이므로 멤버변수에
			//담긴 값을 하나씩 저장
			rowData.add(rcVO.getNickName());
			//나이를 담음 - 컬렌션은 모두 객체(참조)타입만 담을수 있으므로 String타입으로 변경
			rowData.add(String.valueOf(rcVO.getAge()));
			dtm.addRow(rowData);
		}
		//vec.copyInto(anArray);
		//copyInto가 자식에는 있지만 부모에는 없기 때문에
		//list.copyInto 메소드는 사용 불가하다.
		this.add("Center",jsp);
		this.setSize(500, 300);
		this.setVisible(true);
	}
	///// 메인 /////
	public static void main(String[] args) {
		new VectorTest();
	}
}