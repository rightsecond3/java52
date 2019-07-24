package com.helpme3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.net.MalformedURLException;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;

/*
 * 왼쪽(상대방) 메시지 붙히는 클래스
 */
public class ChatLeft extends JPanel {
	///////////////////// ===========선언부=================///////////////////
	// 채팅 보낸 시간 분 표시 라벨 붙일 패널
	JPanel jp_time;
	// 채팅창에 프로필 사진
	JLabel jlb_left;
	// 채팅 보낸 시간 분 표시 하는 라벨
	JLabel jlb_time;
	// 메세지를 붙일 라벨
	public JLabel jlb_leftimg;
	// 말풍선을 넣을 페널
	JPanel chat_left;
	String imgPath = "C:\\workspace_java\\dev_java\\src\\images\\";

	////////////////////// ========생성자===========///////////////////////
	public ChatLeft(String id) throws MalformedURLException {
		// 시간 분 처리부
		jp_time = new JPanel(new BorderLayout());
		jlb_time = new JLabel();
		jlb_time.setHorizontalAlignment(JLabel.LEFT);
		jlb_time.setText("13:00");
		jp_time.add("South", jlb_time);
		jp_time.setOpaque(false);

		jlb_left = new JLabel();
		jlb_left.setIcon(new ImageIcon(imgPath + "user-3.png")); // --> 프로필 사진 붙이는거

		// 메세지 붙이는 부분의 처리
		jlb_leftimg = new JLabel();
		jlb_leftimg.setText("어디까지 늘어나냐");

		// 말풍선 처리
		chat_left = new ChatLeftBubble();

		// 이 패널의 투명도를 투명하게 만드는것.
		this.setOpaque(false);

		///////////////// Left BUBBLE///////////////////////////// 의 그룹레이아웃 설정
		jlb_time.setText("13:00");

		GroupLayout chat_leftLayout = new GroupLayout(chat_left);
		chat_left.setLayout(chat_leftLayout);
		chat_leftLayout.setHorizontalGroup(chat_leftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(chat_leftLayout.createSequentialGroup().addGap(31, 31, 31)// 말풍선 안에서 말풍선과 문장 시작부분 gap
						.addComponent(jlb_leftimg).addGap(25, 25, 25))// 말풍선 안에서 말풍선끝부분 gap

		);
		chat_leftLayout
				.setVerticalGroup(
						chat_leftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(chat_leftLayout.createSequentialGroup().addGap(6, 6, 6) // 말풍선 안에서 말풍선위쪽라인과
																									// 텍스트사이 gap
										.addComponent(jlb_leftimg)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
												GroupLayout.DEFAULT_SIZE + 10, GroupLayout.DEFAULT_SIZE + 10)
										.addGap(6, 6, 6)) // 말풍선 안에서 말풍선위쪽라인과 텍스트사이 gap )

				);
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addComponent(jlb_left).addGap(10, 10, 10)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(chat_left,
								GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap().addGap(10, 10, 10).addComponent(jp_time).addContainerGap().addGap(6, 6, 6)));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addContainerGap()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jlb_left)
								.addComponent(chat_left, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jp_time))
						.addContainerGap().addGap(18, 18, 18)));
	}
}
