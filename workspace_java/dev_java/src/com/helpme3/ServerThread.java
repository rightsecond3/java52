package com.helpme3;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;

import org.w3c.dom.NameList;

import com.google.gson.Gson;

public class ServerThread extends Thread {
	Server server = null;
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	String mem_nick = null;
	String mem_id = null;
	String mem_pw = null;
	String clist_code = null;// 클라에서 넘겨주는 톡방 코드
	CtrlServer sCtrl = new CtrlServer();
	Gson g = new Gson();

	public ServerThread(Server server) {
		this.server = server;
		try {
			oos = new ObjectOutputStream(server.cSocket.getOutputStream());
			ois = new ObjectInputStream(server.cSocket.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// * 해당 채팅방으로 보냄
	public void roomCasting(String msg) {
		// 전체방개수
		for (int i = 0; i < server.chatList.size(); i++) { //2개
			System.out.println("server.chatList.size() : " + server.chatList.size());
			// 여기에 서버가 관리하는 모든 리스트가 담기고 ex) 4개
			VOChatList clVO = server.chatList.get(i);// 서버의 모든 방 리스트
			// 우리가 가지고있는 gclVO에서도 다 빼서 clist코드 비교
			// 내가 들어간 코드랑 같은지 비교하고
			System.out.println(i + "번째의 clist_code : " + clVO.getClist_code());
			System.out.println("roomCating clist_code : " + clVO.getClist_code());
			System.out.println("roomCasting 전역변수 clist_code : " + this.clist_code);
			if (this.clist_code.equals(clVO.getClist_code())) { // 해당 톡방이 선정
				System.out.println("clVO.userList.size() : " + clVO.userList.size());
				for (int j = 0; j < clVO.userList.size(); j++) {
					try {
						ServerThread st = clVO.userList.get(j);
						System.out.println("스레드의 주소번지 : " + st);
						System.out.println("룸캐스팅 메세지 : " + j + ", " + msg);
						st.send(msg);
					} catch (Exception e) {
						e.printStackTrace();
						clVO.userList.remove(j--);
					}
				} ////////////// end of inner for
				break;
			}
		}
	}

	// * 나와의 채팅
	public void send(String msg) {
		try {
			oos.writeObject(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		boolean isStop = false;
		try {
			run_start: while (!isStop) {
				String msg = (String) ois.readObject();
				server.jta_log.append(msg + "\n");
				server.jta_log.setCaretPosition(server.jta_log.getDocument().getLength());
				int protocol = 0;
				StringTokenizer stz = null;
				if (msg != null) {
					stz = new StringTokenizer(msg, "|");
					protocol = Integer.parseInt(stz.nextToken());
				}
				switch (protocol) {
				case Protocol.JOIN: {
					VOChatList pVO = new VOChatList();
					String json = stz.nextToken();
					Map<String, Object> pMap = new HashMap<String, Object>();
					// json으로 온 포맷을 map으로 바꿔준다.
					pMap = (Map<String, Object>) g.fromJson(json, pMap.getClass());
					String mem_id = sCtrl.join(pMap);
					this.send(Protocol.JOIN + Protocol.seperator + mem_id);
				}
					break;
				case Protocol.OVERLAP: { // 아이디 중복검사
					String mem_id = stz.nextToken();
					String temp = sCtrl.overLap(mem_id);
					this.send(Protocol.OVERLAP + Protocol.seperator + temp);
				}
					break;
				case Protocol.ADDFRIEND: { // 친구 추가
					String mem_id = stz.nextToken();
					String friend_id = stz.nextToken();
					VOFriend pVO = new VOFriend();
					pVO.setMem_id(mem_id);
					pVO.setFri_fid(friend_id);
					String result = sCtrl.addFriend(pVO);
					this.send(Protocol.ADDFRIEND + Protocol.seperator + result);
				}
					break;
				case Protocol.FRIENDLIST: { // 친구 리스트
					String mem_id = stz.nextToken();
					List<Map<String, Object>> rList = null;
					rList = sCtrl.friendList(mem_id);
					String fList = g.toJson(rList);
					this.send(Protocol.FRIENDLIST + Protocol.seperator + fList);
				}
					break;
				case Protocol.CHANGEFRINICK: { // 친구닉네임 바꾸기
					String mem_id = stz.nextToken();
					String friend_id = stz.nextToken();
					String change_nick = stz.nextToken();
					VOFriend pVO = new VOFriend();
					pVO.setMem_id(mem_id);
					pVO.setFri_fid(friend_id);
					pVO.setFri_fnick(change_nick);
					sCtrl.changeFriNick(pVO);
				}
					break;
				case Protocol.DELETEFRIEND: { // 친구삭제
					String mem_id = stz.nextToken();
					String friend_id = stz.nextToken();
					VOFriend pVO = new VOFriend();
					pVO.setMem_id(mem_id);
					pVO.setFri_fid(friend_id);
					sCtrl.deleteFriend(pVO);
				}
					break;
				case Protocol.SEARCHFRIEND: {
					String mem_id = stz.nextToken();
					VOFriend pVO = new VOFriend();
					pVO.setMem_id(mem_id);
					List<Map<String, Object>> rList = null;
					rList = sCtrl.searchFriend(pVO);
					String fList = g.toJson(rList);
					this.send(Protocol.SEARCHFRIEND + Protocol.seperator + fList);
				}
					break;
				case Protocol.GROUPLIST: { // 단톡방 생성시 뿌려줄 친구 목록
					String mem_id = stz.nextToken();
					List<Map<String, Object>> rList = null;
					rList = sCtrl.friendList(mem_id);
					String fList = g.toJson(rList);
					this.send(Protocol.GROUPLIST + Protocol.seperator + fList);
				}
					break;
				case Protocol.ADDGROUP: {
					String mem_id = stz.nextToken();
					String clist_yourid = stz.nextToken();
					String gubun = stz.nextToken();
					VOChatList pVO = new VOChatList();
					pVO.setMem_id(mem_id);
					pVO.setClist_yourid(clist_yourid);
					pVO.setClist_gubun(gubun);
					pVO = sCtrl.createGroup(pVO);
					// 전역변수 clist_code 초기화
					clist_code = pVO.getClist_code();
					List fList = new Vector<>(); // , ,로 오는 친구 목록 따로따로 넣어주기
					if (clist_yourid != null) {
						StringTokenizer stz2 = new StringTokenizer(clist_yourid, ",");
						while (stz2.hasMoreTokens()) {
							String friend_id = stz2.nextToken();
							fList.add(friend_id);
							pVO.setClist_yourid(friend_id);
						}
					}
					clist_yourid = g.toJson(fList);
					this.send(Protocol.ADDGROUP + Protocol.seperator + pVO.getClist_code() + Protocol.seperator
							+ pVO.getClist_name() + Protocol.seperator + clist_yourid);
					// **** 서버의 chatList에 넣어주기 위해 단톡방의 사람들의 이름(pk)과 해당 스레드를 넣어준 VOchatList를 만듬
					// 서버의 글로벌 리스트의 사이즈만큼 돌리고
					for (int i = 0; i < server.globalList.size(); i++) {
						// 서버의 글로벌리스트의 i번째 스레드의 전역변수 mem_id와 비교
						String id = server.globalList.get(i).mem_id;
						if (mem_id.equals(id)) {
							pVO.nameList.add(id);
							pVO.userList.add(server.globalList.get(i));
						}
						// 상대방 이름이랑 같은 VO가 있을경우
						for (int j = 0; j < fList.size(); j++) {
							if (fList.get(j).equals(id)) {
								// ChatVO의 nameList에 add해주고
								pVO.nameList.add(id);
								// ChatVO의 스레드List에도 add해줌
								pVO.userList.add(server.globalList.get(i));
							}
						}
					}
					// **** 만들어 놓은 VOchatList를 서버의 chatList<VOChatList>에 넣어줌.
					server.chatList.add(pVO);
				}
					break;
				case Protocol.LOGIN: {
					// * 로그인 처리
					mem_id = stz.nextToken();
					mem_pw = stz.nextToken();
					VOMem pVO = new VOMem();
					pVO.setMem_id(mem_id);
					pVO.setMem_pw(mem_pw);
					VOMem rVO = null;
					rVO = sCtrl.send(pVO);
					mem_id = rVO.getMem_id();// 성공 or 실패
					String str = Protocol.LOGIN + Protocol.seperator + mem_id;
					server.globalList.add(this);
					this.send(str);
					// 재접속했을 경우 원래 있던 방의 스레드 리스트에 내 스레드를 add해줌
					System.out.println("[로그인] chatList.size() : " + server.chatList.size());
					for (int i = 0; i < server.chatList.size(); i++) {
						VOChatList clVO = server.chatList.get(i);
						System.out.println("[로그인] " + i + " 번째 방코드 : " + clVO.getClist_code());
						// System.out.println("내 아이디 : "+mem_id);
						for (int j = 0; j < clVO.nameList.size(); j++) {
							System.out.println("i는 현재 : " + i + "[로그인] " + j + "번지의 pk : " + clVO.nameList.get(j));
							if (mem_id.equals(clVO.nameList.get(j))) {
								clVO.userList.add(this);
								System.out.println("i는 현재 : " + i + "[로그인] " + j + "번 째 스레드 add 성공");
							}
						}
					}
				}
					break;
				case Protocol.ROOM_IN : { // 더블클릭해서 방 들어가기
					String mem_id = stz.nextToken();
					String clist_code = stz.nextToken();
					this.clist_code = clist_code; //룸캐스팅을 위해서 초기화해줌
					List<Map<String, Object>> rList = null;
					rList = sCtrl.roomIn(mem_id, clist_code);
					String jsonRoomIn = g.toJson(rList);
					// 클라에서 ROOM_CREATE로 처리하기 때문에 프로토콜을 바꿔 보내줌
					this.send(Protocol.ROOM_CREATE+Protocol.seperator+jsonRoomIn);
				}
					break;
				case Protocol.ROOM_CREATE: { // 개인톡 생성
					// 내 아이디
					String mem_id = stz.nextToken();
					// 상대방아이디
					String your_id = stz.nextToken();
					// 구분
					String gubun = stz.nextToken();
					VOChatList pVO = new VOChatList();
					List<VOChatList> rList = null;
					pVO.setMem_id(mem_id);
					pVO.setClist_yourid(your_id);
					pVO.setClist_gubun(gubun);
					rList = sCtrl.send(pVO);
					//////////////
					Map<String, Object> sMap = null;
					List<Map<String, Object>> sList = new ArrayList<Map<String, Object>>();
					for (int i = 0; i < rList.size(); i++) {
						sMap = new HashMap<String, Object>();
						VOChatList sVO = rList.get(i);
						sMap.put("clist_code", sVO.getClist_code());
						sMap.put("clist_count", sVO.getClist_count());
						sMap.put("chat_nick", sVO.getClist_name());
						sMap.put("clist_gubun", sVO.getClist_gubun());
						sMap.put("clist_img", sVO.getClist_img());
						sMap.put("chat_id", sVO.getMem_id());
						sList.add(sMap);
					}
					//////////////
					String jsonChatNick = g.toJson(sList);
					// 클라에 보낼 clist_yourid
					// 전역변수 초기화 해주기
					VOChatList aVO = rList.get(0); // 공통 컬럼을 꺼내오기 위한 VO
					this.clist_code = aVO.getClist_code(); //초기화
					System.out.println("[ROOMCREATE clist_code] : "+this.clist_code);
					String result = aVO.getResult();
					System.out.println("새창 아니면 회식 : " + result);
					if ("새창".equals(result)) {
						// 현재 그 사람이 들어와 있을 경우 add
						for (int i = 0; i < rList.size(); i++) { //2번
							VOChatList cVO = rList.get(i); // nameList들에 넣어주기 위한 VO
							String chat_id = cVO.getMem_id(); // kkk 와 melon
							for (int j = 0; j < server.globalList.size(); j++) { //5번
								// 서버의 글로벌리스트의 j번째 스레드의 전역변수 mem_id와 비교
								String id = server.globalList.get(j).mem_id;
								// 상대방 이름이랑 같은 VO가 있을경우
								if (chat_id.equals(id)) {
									// ChatVO의 스레드List에도 add해줌
									aVO.nameList.add(id);
									if (server.globalList.get(j) != null) {
										aVO.userList.add(server.globalList.get(j));
									}
								}
							}
						}
						server.chatList.add(aVO);
					}
					// 방을 팔때는 방을 판 사람에게만 보냄
					this.send(Protocol.ROOM_CREATE + Protocol.seperator + jsonChatNick);
				}
					break;
				case Protocol.ROOM_INLIST : {
					String clist_code = stz.nextToken();
					String login_id = stz.nextToken();
					List<Map<String, Object>> rList = null;
					rList = sCtrl.roomInList(clist_code, login_id);
					String jsonRoomInList = g.toJson(rList);
					this.send(Protocol.ROOM_INLIST+Protocol.seperator+jsonRoomInList);
				}
					break;
				case Protocol.ROOM_ADDLIST : {
					String clist_code = stz.nextToken();
					String login_id = stz.nextToken();
					List<Map<String, Object>> rList = null;
					rList = sCtrl.roomAddList(clist_code, login_id);
					String jsonRoomAddList = g.toJson(rList);
					this.send(Protocol.ROOM_ADDLIST
							+Protocol.seperator+jsonRoomAddList
							+Protocol.seperator+clist_code);
				}
					break;
				case Protocol.ROOM_ADD : {
					String clist_code = stz.nextToken();
					String addPerson = stz.nextToken();
					String login_id = stz.nextToken();
					Map<String,Object> rMap = null;
					// gubun, r_clistcode, msg_title 가져오는 Map
					rMap = sCtrl.roomAddPerson(clist_code, addPerson, login_id);
					String gubun = (String) rMap.get("gubun");
					String r_clistcode = (String) rMap.get("r_clistcode");
					String msg_title = (String) rMap.get("msg_title");
					// 나를 제외한 상대방 아이디들 가져오기
					List<Map<String, Object>> rList = null;
					rList = sCtrl.selyourid(r_clistcode, login_id);
					String jsonSelYourid = g.toJson(rList);
					this.send(Protocol.ROOM_ADD
							+Protocol.seperator+r_clistcode
							+Protocol.seperator+gubun
							+Protocol.seperator+msg_title
							+Protocol.seperator+jsonSelYourid);

					VOChatList aVO = new VOChatList();
					//nameList에 담고
					if("새창".equals(gubun)) {
						//pk 넣어주기
						String allId = (String) rMap.get(msg_title); // kkk,jvm,apple
						String allIds[] = allId.split(",");
						aVO.setClist_code(r_clistcode);
						aVO.setClist_count(String.valueOf(allIds.length));
						for(int i=0;i<allIds.length;i++) {
							aVO.nameList.add(allIds[i]);
							for(int j=0;j<server.globalList.size();j++) {
								String globalId = server.globalList.get(j).mem_id;
								if(allIds[i].equals(globalId)) {
									aVO.userList.add(server.globalList.get(j));
								}
							}
							server.chatList.add(aVO);
						}
						//return;
					} 
					else if("단톡".equals(gubun)) {
						String people[] = addPerson.split(",");
						for(int i=0;i<people.length;i++) { 
							aVO.nameList.add(people[i]); // nameList에 넣는거 끝
							for(int j=0;j<server.globalList.size();j++) {
								String id = server.globalList.get(j).mem_id;
								if(people[i].equals(id)) {
									aVO.userList.add(server.globalList.get(j));
								}
							}
							server.chatList.add(aVO);
						}
						//return;
					}
				}
					break;
				case Protocol.MESSAGE: {
					// 클라이언트에서 보내준 코드
					String clist_code = stz.nextToken();
					String writer = stz.nextToken();
					String your_id = stz.nextToken();
					String date = stz.nextToken();
					String time = stz.nextToken();
					String content = stz.nextToken();
					String imogi = stz.nextToken();
					this.clist_code = clist_code; // 초기화
					Map<String, Object> pMap = new HashMap<>();
					// json 포멧으로 온 your_id를 리스트로 변환 [0] jvm [1] apple
					List<String> fList = new ArrayList<>();
					fList = (List<String>) g.fromJson(your_id, fList.getClass());
					System.out.println("[MESSAGE] fList의 사이즈 : " + fList.size());
					for (int i = 0; i < fList.size(); i++) {
						System.out.println("[MESSAGE] your_id의 메시지 : " + fList.get(i));
					}
					// clog 테이블에 인서트 해주기 위한 Map
					pMap.put("clist_code", clist_code);
					pMap.put("writer", writer);
					pMap.put("date", date);
					pMap.put("time", time);
					pMap.put("content", content);
					pMap.put("imogi", imogi);
					// 여기서 fList 사용
					pMap.put("your_id", fList);
					// rMap 클라이언트에서 필요한 정보를 json 포멧으로 바꿔줌
					List<Map<String, Object>> rList = null;
					rList = sCtrl.send(pMap);
					String json = g.toJson(rList);
					System.out.println("메세지 프로토콜 : " + json);
					this.roomCasting(Protocol.MESSAGE + Protocol.seperator + json);
				}
					break;
				case Protocol.CHATLOG: {
					String mem_id = stz.nextToken();
					String clist_code = stz.nextToken();
					List<Map<String, Object>> logList = sCtrl.chatLog(mem_id, clist_code);
					String jsonChatLog = g.toJson(logList);
					this.send(Protocol.CHATLOG + Protocol.seperator + jsonChatLog);
				}
					break;
				case Protocol.CHATLIST: {
					String mem_id = stz.nextToken();
					List<Map<String, Object>> chatList = sCtrl.chatList(mem_id);
					String temp = g.toJson(chatList);
					System.out.println("[CHATLIST] : " + temp);
					this.send(Protocol.CHATLIST + Protocol.seperator + temp);
				}
					break;
				case Protocol.EXIT: {
					String clist_code = stz.nextToken();
					String login_id = stz.nextToken();
					sCtrl.exitRoom(clist_code, login_id);
					for(int i=0;i<server.chatList.size();i++) {
						VOChatList aVO = server.chatList.get(i);
						String byeCode = aVO.getClist_count();
						if(clist_code.equals(byeCode)) {
							aVO.nameList.remove(login_id); //nameList에서 삭제
							aVO.userList.remove(this);
						}
					}
					this.send(Protocol.EXIT
							+Protocol.seperator+clist_code);
				}
					break;
				}/////// end of switch
			} /////////// end of while
		} catch (Exception e) {
			e.printStackTrace();
		} ////////////// end of try~catch
	}////////////////// end of run
}
