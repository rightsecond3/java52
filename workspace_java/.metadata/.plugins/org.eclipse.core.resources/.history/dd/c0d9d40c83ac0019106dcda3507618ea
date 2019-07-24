package com.helpme3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

/*
 * 친구목록 전체 뷰
 */
public class FriendView extends JPanel {
	/////////////// 생성부
	/////////////////// 위쪽 검색창///////////////////////////
	JPanel jp_search = new JPanel();
	JButton jbtn_search = new JButton() {
		@Override
		public void setBorder(Border border) {
		}
	};
	JTextField jtf_search = new JTextField(40) {
		@Override
		public void setBorder(Border border) {
		}
	};
	Shape s = null;
	FriendGroup frl = null;
	///////////////////// 검색창 이미지 경로 파일이름 크기조절
	String imgPath = "C:\\workspace_java\\dev_java\\src\\images\\";
	ImageIcon img = new ImageIcon(imgPath + "search.png");
	Image originImg = img.getImage();
	Image changedImg = originImg.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	/////////////// 중간 친구 목록/////////////////////////////////
	JPanel jp_center = new JPanel();
	JScrollPane jsp = new JScrollPane(jp_center) {
		@Override
		public void setBorder(Border border) {
		}
	};

	//////////////////////////////////////////////////////
	public FriendView(String mem_id) {
		////////////// 검색창 색조절///////////////////////
		jp_search.setLayout(new FlowLayout(FlowLayout.RIGHT));
		jtf_search.setBackground(new Color(220, 220, 220));
		jbtn_search.setIcon(new ImageIcon(changedImg));
		jbtn_search.setBorderPainted(false);
		jbtn_search.setFocusPainted(false);
		jbtn_search.setContentAreaFilled(false);
		jp_search.add(jtf_search);
		jp_search.add(jbtn_search);
		///////////// groupLayout 넣기///////////////////
		this.setLayout(new BorderLayout());
		GridLayout gr = new GridLayout();
		gr.setRows(10);
		jp_center.setLayout(gr);
		ChatDao dao = new ChatDao();
		List<Map<String, Object>> tList = new Vector<>();
		tList = dao.friend(mem_id);
		for (int i = 0; i < tList.size(); i++) {
			frl = new FriendGroup(mem_id);
			frl.initDisplay(tList.get(i));
			jp_center.add(frl);
		}
		;
		this.add("North", jp_search);
		this.add("Center", jsp);
	}

}
