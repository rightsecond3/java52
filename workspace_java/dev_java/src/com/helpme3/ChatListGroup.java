package com.helpme3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

/*
 * 채팅목록 뷰에서 가져오는 그룹레이아웃
 */
public class ChatListGroup extends JPanel {
	JPanel jp_img = new JPanel();
	JPanel jp_second = new JPanel();
	JPanel jp_time = new JPanel();
	JLabel jl_img = new JLabel("프사", JLabel.CENTER);
	JLabel jl_name = new JLabel("이름", JLabel.LEFT);
	JLabel jl_msg = new JLabel("마지막메세지", JLabel.LEFT);
	JLabel jl_time = new JLabel("시간", JLabel.RIGHT);
	JPopupMenu jpm = new JPopupMenu();
	JMenuItem jmi_change = new JMenuItem("채팅방명 변경");
	JMenuItem jmi_exit = new JMenuItem("나가기");
	Map<String, Object> map = null;

	public ChatListGroup() {

	}

	public void initDisplay(Map<String, Object> map) {
		// * 라벨에 select한 결과를 박아주는 코드
		this.map = map;
		jl_img.setText(map.get("clist_img").toString());
		jl_msg.setText(map.get("clog_contents").toString());
		jl_name.setText(map.get("clist_name").toString());
		jl_time.setText(map.get("clog_time").toString());

		jpm.add(jmi_change);
		jpm.add(jmi_exit);

		// * 오른쪽 버튼 클릭시 이벤트
		jp_second.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				if (e.isMetaDown()) {
					// 팝업창을 열어줌
					jpm.show(jp_second, e.getX(), e.getY());
					// Dao로 보내줘야할 pk 값
					System.out.println(map.get("clist_code"));
				}
			}
		});

		jp_img.setLayout(new BorderLayout());
		jp_second.setLayout(new BorderLayout());
		jp_time.setLayout(new BorderLayout());

		jl_name.setVerticalAlignment(JLabel.BOTTOM);
		jl_msg.setVerticalAlignment(JLabel.TOP);

		// 세컨드 패널에 이름과 마지막 메시지가 들어가는 것임
		jp_second.setLayout(new GridLayout(2, 1));
		jp_img.add(jl_img);
		jp_second.add(jl_name);
		jp_second.add(jl_msg);
		jp_time.add(jl_time);

		// 마지막 메세지부분 회색 처리
		jl_msg.setForeground(Color.GRAY);

		GroupLayout gl = new GroupLayout(this);
		this.setLayout(gl);
		// 수평 그룹
		gl.setHorizontalGroup(
				// 순차적으로 그룹을 붙히겠다
				gl.createSequentialGroup().addComponent(jp_img, 70, 70, 70)
						// DEFAULT_SIZE : 늘리면 늘리는 만큼 늘어남
						.addComponent(jp_second, 300, 300, GroupLayout.DEFAULT_SIZE)
						.addComponent(jp_time, 70, 70, 70));
		// 수직 그룹
		gl.setVerticalGroup(
				// 순차적으로 그룹을 붙히겠다
				gl.createSequentialGroup()
						.addGroup(gl.createParallelGroup(Alignment.BASELINE)
								.addComponent(jp_img, 80, 80, GroupLayout.PREFERRED_SIZE)
								.addComponent(jp_second, 80, 80, GroupLayout.PREFERRED_SIZE)
								.addComponent(jp_time, 80, 80, GroupLayout.PREFERRED_SIZE)));
	}
}
