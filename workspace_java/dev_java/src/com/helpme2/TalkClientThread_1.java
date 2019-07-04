package com.helpme2;

import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;


public class TalkClientThread_1 extends Thread {
	//TalkClientThread에서 TalkClient 원본을 참조하기 위해서 선언
	TalkClient_1 tc = null;
	///*** 생성자 ***/// - 생성자에서 초기화.
	public TalkClientThread_1(TalkClient_1 tc) {
		this.tc = tc;
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
				msg = (String) tc.ois.readObject(); //msg-110|nickName
				StringTokenizer st = null;
				int protocol = 0;
				if(msg!=null) {
					st = new StringTokenizer(msg, Protocol_1.seperator);
					protocol = Integer.parseInt(st.nextToken());
				}
				switch(protocol) {
				/*
				 * 닉네임을 읽어서 Vector 담기 -> dtm_name 추가 addRow(v)
				 * 화면(jta_display) XXX님이 입장하였습니다.
				 */
					case Protocol_1.ROOM_IN:{
						String nickName = st.nextToken();
						//입장한 사람의 이름을 Vector에 담기 위해
						Vector<String> v_name = new Vector<>();
						//실제 벡터에 추가하는 부분
						v_name.add(nickName);
						//마지막으로 dtm클래스에 이름 추가하기
						tc.dtm_name.addRow(v_name);
						SimpleAttributeSet sas = makeAttribute();
						try {
							//화면에 메시지 출력하는 부분
							tc.sd_display.insertString(tc.sd_display.getLength(),
									nickName+"님이 입장하였습니다. \n"
									,sas);
						} catch (Exception e) {
							// TODO: handle exception
						}
					}break;
					case Protocol_1.MESSAGE: {
						String nickName = st.nextToken();
						String message = st.nextToken();
						String imgChoice = st.nextToken();
						MutableAttributeSet attr1 =
								new SimpleAttributeSet();
						if (!imgChoice.equals("default")) {//이모티콘
							int i = 0;
							//이모티콘 배열 객체에서 같은 이미지를 찾아서 출력해야함.
							for(i=0;i<tc.imo.imgFiles.length;i++) {
								if(tc.imo.imgFiles[i].equals(imgChoice)) {
									StyleConstants.setIcon
									(attr1, new ImageIcon(tc.imo.imgPath+tc.imo.imgFiles[i]));
									try {
										//1-시작위치 2-메세지 3- 속성
										tc.sd_display.insertString(tc.sd_display.getLength()
												, "\n"
												, attr1);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							}
						} else if(imgChoice.equals("default")) {//메세지일때
							try {
								tc.sd_display.insertString(tc.sd_display.getLength()
										,"["+nickName+"] : "+message+"\n"
										,null);
							} catch (Exception e) {
								// TODO: handle exception
							}
						}
						//스크롤바 자동이동 메소드
						tc.jtp_display.setCaretPosition(tc.sd_display.getLength());
					}break;
					case Protocol_1.WHISPER: {
						String nickName = st.nextToken();
						String message = st.nextToken();
						int index = Integer.parseInt(st.nextToken());
						String you = (String) tc.dtm_name.getValueAt(index, 0);
						try {
							tc.sd_display.insertString(tc.sd_display.getLength()
									,"["+nickName+"]가 ["+you+"]에게 "+message+"\n"
									,null);
						} catch (Exception e) {
							// TODO: handle exception
						}
						tc.jtp_display.setCaretPosition(tc.sd_display.getLength());
					}break;
					case Protocol_1.ROOM_OUT: {
						String nickName = st.nextToken();
						int index = Integer.parseInt(st.nextToken());
						tc.sd_display.insertString(tc.sd_display.getLength()
								,nickName+"님이 나갔습니다. \n"
								,null);
						tc.dtm_name.removeRow(index);
					}
				}////////end of switch
			} catch (Exception e) {
				// TODO: handle exception
			}///////////end of try
		}//////////////end of while
	}//////////////////end of run
}
