package com.helpme3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * 친구 그룹레이아웃 패널 붙히는거
 * 이벤트처리
 */
public class FriendGroup extends JPanel {

	FriendStatus t = null;
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	JPanel jp2_1 = new JPanel();
	JPanel jp3 = new JPanel();
	JPanel jp4 = null;

	JLabel jl1 = new JLabel();// 사진
	JLabel jl2 = new JLabel();// 이름
	JLabel jl3 = new JLabel();// 상태표시

	String imgPath = "C:\\workspace_java\\dev_java\\src\\images\\";
	
	ChatView chatview = null;
	
	String mem_id = null; // 내 로그인 아이디
	String your_id = null; //그 해당 패널에 대한 상대방아이디 -> 맵에는 mem_id
	public FriendGroup(String mem_id) {
		this.mem_id = mem_id;
	}

	public void initDisplay(Map<String, Object> map) {
		jl1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource().equals(jl1)) {
					FirendDialog fd = new FirendDialog();
					fd.initDisplay(map);
				}
			}
		});
		jl2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if(e.getClickCount()>1) {
					your_id = (String) map.get("mem_id"); // your_id ?
					ChatDao cDao = new ChatDao();
					VOChatList rVO = cDao.getNewRoom(mem_id, your_id);
					if("새창".equals(rVO.getClist_gubun())){
						chatview = new ChatView(map);
					}
				}
			}
		});
		// 이미지 자르기 경로에 VO.getimg 넣기
		ImageIcon img = new ImageIcon(imgPath + map.get("mem_img").toString() + ".png");
		Image originImg = img.getImage();
		Image changedImg = originImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		// 이미지 자르기 끝
		jl1.setIcon(new ImageIcon(changedImg));
		jl2.setText(map.get("mem_nick").toString());
		jl3.setText(map.get("mem_status").toString());
		int di = jl3.getMaximumSize().width;
		FriendStatus t = new FriendStatus(di);
		jp4 = new FriendStatus(di);

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

}
