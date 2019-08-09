package com.helpme4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

/*
 * 친구 그룹레이아웃 패널 붙히는거
 * 이벤트처리
 */
public class FriendGroup extends JPanel implements ActionListener {
	//////////////////////선언부
	FriendStatus t = null;
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	JPanel jp2_1 = new JPanel();
	JPanel jp3 = new JPanel();
	JPanel jp4 = null;
	JPopupMenu jpm = new JPopupMenu();
	JLabel jl1 = new JLabel();// 사진
	JLabel jl2 = new JLabel();// 이름
	JLabel jl3 = new JLabel();// 상태표시
	JMenuItem jmi_change = new JMenuItem("닉네임 변경");
	JMenuItem jmi_delete = new JMenuItem("친구삭제");
	String imgPath = "C:\\workspace_java\\dev_java\\src\\images\\";
	
	ChatView chatview = null;
	
	Login login = null;
	
	Map<String, Object> map = null;
	String mem_id = null; // 내 로그인 아이디
	String your_id = null; //그 해당 패널에 대한 상대방아이디 -> 맵에는 mem_id
	public FriendGroup(String mem_id, Login login) {
		this.mem_id = mem_id;
		this.login = login;
	}

	public void initDisplay(Map<String, Object> map) {
		this.map = map;
		//////////////////////사진 클릭시 프로필창 켜기
		jl1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource().equals(jl1)) {
					FirendDialog fd = new FirendDialog();
					fd.initDisplay(map);
				}
			}
		});
		//////////////////////닉네임 클릭시 방 만들기 oos 보내기
		jl2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2) {
					your_id = (String) map.get("mem_id"); // your_id ?
					System.out.println(mem_id);
					System.out.println(your_id);
					String status = "갠톡";
					///////////////////////내 아이디랑 상대방 아이디 보내기
					try {
						login.oos.writeObject(Protocol.ROOM_CREATE_PERSONAL
								+Protocol.seperator+mem_id+Protocol.seperator+your_id+ Protocol.seperator + status);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
			/////////////////////오른쪽 클릭시 팝업창 띄우기 (친구 삭제/ 닉네임 변경)
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				if (e.isMetaDown()) {
					// 팝업창을 열어줌
					jpm.show(jp2, e.getX(), e.getY());
					// Dao로 보내줘야할 pk 값
				}
			}
		});
		jmi_change.addActionListener(this);
		jmi_delete.addActionListener(this);
		// 이미지 자르기 경로에 VO.getimg 넣기
		ImageIcon img = new ImageIcon(imgPath + map.get("mem_img").toString() + ".png");
		Image originImg = img.getImage();
		Image changedImg = originImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		// 이미지 자르기 끝
		jl1.setIcon(new ImageIcon(changedImg));
		jl2.setText(map.get("fri_fnick").toString());
		jl3.setText(map.get("mem_status").toString());
		int di = jl3.getMaximumSize().width;
		FriendStatus t = new FriendStatus(di);
		jp4 = new FriendStatus(di);
		jpm.add(jmi_change);
		jpm.add(jmi_delete);
		jp2.setLayout(new BorderLayout());
		jp3.setLayout(new FlowLayout(FlowLayout.RIGHT));

		jl2.setVerticalAlignment(JLabel.CENTER);
		jp1.add(jl1);
		jp2.add(jl2);
		jp3.add(jp4);
		jp4.add(jl3);

		GroupLayout gl = new GroupLayout(this);
		this.setLayout(gl);

		// 수직
		gl.setHorizontalGroup(gl.createSequentialGroup()
				.addComponent(jp1, 50, 50, GroupLayout.PREFERRED_SIZE)
				.addComponent(jp2, 158, 158, GroupLayout.PREFERRED_SIZE).addComponent(jp3));
		// 수평
		gl.setVerticalGroup(gl.createSequentialGroup()
				.addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jp1, 50, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(jp2, 50, 50, GroupLayout.PREFERRED_SIZE).addComponent(jp3)));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(jmi_change)) {//////////////친구 닉네임변경(자기 화면에서만 바껴서 보임)
			your_id = (String) map.get("mem_id");
			ChangeFriNick cfn = new ChangeFriNick(your_id,login);
		}
		else if(obj.equals(jmi_delete)){//////////친구 삭제
			your_id = (String) map.get("mem_id");///////내가 클릭한 사람의 아이디를 map에서 뽑아 온다
			try {
				login.oos.writeObject(Protocol.FRIEND_DELETE
						+Protocol.seperator+mem_id
						+Protocol.seperator+your_id		            
						);
				login.oos.writeObject(Protocol.FRIEND_CHANGE_NICK
						+Protocol.seperator+login.mem_id
						);				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
