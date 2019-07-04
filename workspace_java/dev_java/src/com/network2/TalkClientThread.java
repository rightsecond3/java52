package com.network2;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;


public class TalkClientThread extends Thread {
	//TalkClientThread에서 TalkClient 원본을 참조하기 위해서 선언
	TalkClientVer2 tc2 = null;
	///*** 생성자 ***/// - 생성자에서 초기화.
	public TalkClientThread(TalkClientVer2 tc2) {
		this.tc2 = tc2;
	}
	//** 이모티콘 **//
	public SimpleAttributeSet makeAttribute() {
		SimpleAttributeSet sas = new SimpleAttributeSet();
		return sas;
	}
	//-!듣기!
	public void run() {
		String msg = null;
		boolean isStop = false;
		while(!isStop) {
			try {
				msg = (String) tc2.ois.readObject(); //msg-110|nickName
				StringTokenizer st = null;
				int protocol = 0;
				if(msg!=null) {
					st = new StringTokenizer(msg, Protocol.seperator);
					protocol = Integer.parseInt(st.nextToken());
				}
				switch(protocol) {
				/*
				 * 닉네임을 읽어서 Vector 담기 -> dtm_name 추가 addRow(v)
				 * 화면(jta_display) XXX님이 입장하였습니다.
				 */
					case Protocol.WAIT:{
						String nickname = st.nextToken();
						String state = st.nextToken();
						Vector<String> v_nick = new Vector<>();
						v_nick.add(nickname);
						v_nick.add(state);
						tc2.wr.dtm_wait.addRow(v_nick);
						//테이블 스크롤바를 자동위치 변경
						tc2.wr.jsp_wait.getVerticalScrollBar()
						.addAdjustmentListener(new AdjustmentListener() {
							@Override
							public void adjustmentValueChanged(AdjustmentEvent e) {
								JScrollBar jsb = (JScrollBar) e.getSource();
								jsb.setValue(jsb.getMaximum());
							}
						});
					}break;
					case Protocol.ROOM_CREATE: {
						String roomTitle = st.nextToken();
						String currentNum = st.nextToken();
						Vector<String> v_room = new Vector<String>();
						v_room.add(roomTitle);
						v_room.add(currentNum);
						tc2.wr.dtm_room.addRow(v_room);
						//테이블 스크롤바를 자동위치 변경
						tc2.wr.jsp_room.getVerticalScrollBar()
						.addAdjustmentListener(new AdjustmentListener() {
							@Override
							public void adjustmentValueChanged(AdjustmentEvent e) {
								JScrollBar jsb = (JScrollBar) e.getSource();
								jsb.setValue(jsb.getMaximum());
							}
						});
					}break;
					case Protocol.ROOM_LIST: {
						String roomTitle = st.nextToken();
						String currentNum = st.nextToken();
						Vector<String> v_room = new Vector<String>();
						v_room.add(roomTitle);
						v_room.add(currentNum);
						tc2.wr.dtm_room.addRow(v_room);
						//테이블 스크롤바를 자동위치 변경
						tc2.wr.jsp_room.getVerticalScrollBar()
						.addAdjustmentListener(new AdjustmentListener() {
							@Override
							public void adjustmentValueChanged(AdjustmentEvent e) {
								JScrollBar jsb = (JScrollBar) e.getSource();
								jsb.setValue(jsb.getMaximum());
							}
						});
						
					}break;
					case Protocol.ROOM_IN:{
						//* 정보 가져오기
						String roomTitle = st.nextToken();
						String current = st.nextToken();
						String nickName = st.nextToken();
						//* 단톡 인원 정보 갱신 처리
						JOptionPane.showMessageDialog(tc2, "인원수 갱신");
						for(int i=0;i<tc2.wr.jtb_room.getRowCount();i++) {
							if (roomTitle.equals(tc2.wr.dtm_room.getValueAt(i, 0))) {
								//1)인원수, 2)로우의 값, 3)인원수
								//DefaultTableModel이 실제 값을 가질 수 있는 클래스
								//JTable은 화면만 제공할 뿐
								//JScrollPane은 속지이고 스크롤바만 제공
								tc2.wr.dtm_room.setValueAt(current, i, 1);
								break;
							}
						}
						//* 대기실 위치 명 갱신
						JOptionPane.showMessageDialog(tc2, "대기실 위치 갱신");
						//테이블의 로우 수만큼 카운트 - 3명이면 3번 반복
						for(int i=0;i<tc2.wr.jtb_wait.getRowCount();i++) {
							//내 대화명과 dtm_wait(왼쪽)에 있는 데이터 중에서 첫번째(대화명)과 같은지 비교함
							//변수 i는 로우 값이고 0은 컬럼정보니까 대화명
							//무사.equals("무사")
							if (nickName.equals(tc2.wr.dtm_wait.getValueAt(i, 0))) {
								//i번째 로우의 두번 째 컬럼(위치)
								tc2.wr.dtm_wait.setValueAt(roomTitle, i, 1);
							}
						}
						//* MessageRoom의 nickName 추가
						//단톡명을 누른 사람만 화면 이동 처리 - MessageRoom
						//tc2.nickName - 내 대화명 | nickName - 서버에서 전송된 대화명
						//이 둘을 비교 - 같다 : 내 대화명
						JOptionPane.showMessageDialog(tc2, "단톡 닉네임 리스트 갱신");
						if (tc2.nickName.equals(nickName)) {
							//두번 째 탭으로 화면 이동
							tc2.tp.setSelectedIndex(1);
							for(int x=0;x<tc2.wr.jtb_wait.getRowCount();x++) {
								if (roomTitle.equals(tc2.wr.dtm_wait.getValueAt(x, 1))) {
									String imsi[] = {(String) tc2.wr.dtm_wait.getValueAt(x, 0)};
									tc2.mr.dtm_name.addRow(imsi);
								}
							}
						}
					}break;
					case Protocol.ROOM_INLIST: {
						String roomTitle = st.nextToken();
						String currentNum = st.nextToken();
						String nickname = st.nextToken();
						Vector<String> v_room = new Vector<String>();
						v_room.add(nickname);
						tc2.mr.dtm_name.addRow(v_room);
					}break;
					case Protocol.MESSAGE: {
						String nickName = st.nextToken();
						String message = st.nextToken();
						String imgChoice = st.nextToken();
						MutableAttributeSet attr1 =
								new SimpleAttributeSet();
						if (!imgChoice.equals("default")) {//이모티콘
							int i = 0;
							//이모티콘 배열 객체에서 같은 이미지를 찾아서 출력해야함.
							for(i=0;i<tc2.mr.imo.imgFiles.length;i++) {
								if(tc2.mr.imo.imgFiles[i].equals(imgChoice)) {
									StyleConstants.setIcon
									(attr1, new ImageIcon(tc2.mr.imo.imgPath+tc2.mr.imo.imgFiles[i]));
									try {
										//1-시작위치 2-메세지 3- 속성
										tc2.mr.sd_display.insertString(tc2.mr.sd_display.getLength()
												, "\n"
												, attr1);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							}
						} else if(imgChoice.equals("default")){//메세지일때
							try {
								tc2.mr.sd_display.insertString(tc2.mr.sd_display.getLength()
										,"["+nickName+"] : "+message+"\n"
										,null);
							} catch (Exception e) {
								// TODO: handle exception
							}
						}
						//스크롤바 자동이동 메소드
						tc2.mr.jtp_display.setCaretPosition(tc2.mr.sd_display.getLength());
					}break;
					case Protocol.ROOM_OUT: {
						String nickName = st.nextToken();
						int index = Integer.parseInt(st.nextToken());
						tc2.mr.sd_display.insertString(tc2.mr.sd_display.getLength()
								,nickName+"님이 나갔습니다. \n"
								,null);
						tc2.mr.dtm_name.removeRow(index);
					}
				}////////end of switch
			} catch (Exception e) {
				// TODO: handle exception
			}///////////end of try
		}//////////////end of while
	}//////////////////end of run
}
