package com.helpme2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

public class TalkServerThread_1 extends Thread {
	TalkServer_1 ts = null;
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	String nickName = null;//사용자의 닉네임
	
	///*** 생성자 ***///
	public TalkServerThread_1(TalkServer_1 ts) {
		this.ts = ts;
		try {
			oos = new ObjectOutputStream(ts.client.getOutputStream());//말하기
			ois = new ObjectInputStream(ts.client.getInputStream());//듣기
			String msg = (String) ois.readObject(); //oos.writeObject 메세지 넣기
			ts.jta_log.append(msg+"\n");
			//자동으로 스크롤바 이동시켜주기
			ts.jta_log.setCaretPosition(ts.jta_log.getDocument().getLength());
			StringTokenizer st = null;
			if(msg!=null) {
				st = new StringTokenizer(msg, Protocol_1.seperator);
			}
			st.nextToken();//100
			nickName = st.nextToken();//닉네임 담기
			for(TalkServerThread_1 tst : ts.chatList) {// 그전 이용자들의 정보를 가져오기 위한 for
				String currentName = tst.nickName;
				//이전 사용자의 정보를 받음
				this.send(Protocol_1.ROOM_IN+Protocol_1.seperator+currentName);//2번
			}
			//입장한 내 스레드 추가하기
			ts.chatList.add(this);
			//현재 서버에 접속해 있는 모든 사람들에게 메세지 전송
			this.broadCasting(msg); //3번
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//** 서버에 접속한 모든 사용자들에게 메세지를 전송 처리 **//
	public void broadCasting(String msg) {//200|누가|누구에게|오늘 스터디할까?
		for(TalkServerThread_1 tst:ts.chatList) { //전 이용자들에게 접근하기 위해 for
			//this.send(msg), tst.send(msg) 차이
			tst.send(msg); // 내정보를줌
		}
	}
	//** 메세지 전송부 **//
	public void send(String msg) {//반복문은 필요없다.
		try {
			oos.writeObject(msg);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//run 메소드 안에서는 무엇을 구현해야 되는가?-!듣기!
	@Override
	public void run() {
		boolean isStop = false;
		try {
			run_start://break run_start - 라벨이 붙어있는 구역 전체를 빠져나감
			while(!isStop) {
				String msg = (String) ois.readObject();
				ts.jta_log.append(msg+"\n");
				ts.jta_log.setCaretPosition(ts.jta_log.getDocument().getLength());
				int protocol = 0;
				StringTokenizer st = null;
				if(msg!=null) {
					st = new StringTokenizer(msg,"|");
					protocol = Integer.parseInt(st.nextToken());
				}
				switch(protocol) {
				case Protocol_1.MESSAGE: {
					String nickName = st.nextToken();
					String message = st.nextToken();
					String imgChoice = "";
					while(st.hasMoreTokens()) { //남아있는 것이 있냐?
						imgChoice = st.nextToken();//받아온 이모티콘이있을 때 짤라줌
					}
					this.broadCasting(Protocol_1.MESSAGE
							+Protocol_1.seperator+nickName
							+Protocol_1.seperator+message
							+Protocol_1.seperator+imgChoice
							);
					
				}break;
				case Protocol_1.WHISPER: {
					String nickName = st.nextToken();
					String message = st.nextToken();
				    int index = Integer.parseInt(st.nextToken());
				    ts.chatList.get(index).send(Protocol_1.WHISPER
							+Protocol_1.seperator+nickName
							+Protocol_1.seperator+message
							+Protocol_1.seperator+index);
				    this.send(Protocol_1.WHISPER
							+Protocol_1.seperator+nickName
							+Protocol_1.seperator+message
							+Protocol_1.seperator+index);
					
				}break;
				case Protocol_1.ROOM_OUT: {
					String nickName = st.nextToken();
					int index = ts.chatList.indexOf(this);
					ts.chatList.remove(this);
					this.broadCasting(Protocol_1.ROOM_OUT
							+Protocol_1.seperator+nickName
							+Protocol_1.seperator+index);
				}break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
