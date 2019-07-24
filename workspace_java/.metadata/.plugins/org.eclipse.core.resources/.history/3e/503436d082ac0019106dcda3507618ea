package com.helpme3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
/*
 * 채팅창 뷰
 */
public class ChatView extends JFrame implements ActionListener {
	//// 선언부
	JPanel jp_north = new JPanel();
	JButton jbtn_friend = new JButton();
	JButton jbtn_change = new JButton();
	JButton jbtn_exit = new JButton();
	JButton jbtn_imo = new JButton();
	JButton jbtn_file = new JButton();
	JButton jbtn_img = new JButton();
	String imgPath = "C:\\workspace_java\\dev_java\\src\\images\\";
	String img[] = { "users.png", "more.png", "exit-1.png", "star.png", "attachment.png", "picture.png" };
	JButton imgFiles[] = { jbtn_friend, jbtn_change, jbtn_exit, jbtn_imo, jbtn_file, jbtn_img };

	StyledDocument sd_center = new DefaultStyledDocument(new StyleContext());
	JTextPane jtp_center = new JTextPane(sd_center);
	JScrollPane jsp_center = new JScrollPane(jtp_center, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	JPanel jp_south = new JPanel();

	JPanel jp_south_first = new JPanel();
	StyledDocument sd_south = new DefaultStyledDocument(new StyleContext());
	JTextPane jtp_south = new JTextPane(sd_south);

	JScrollPane jsp_south = new JScrollPane(jtp_south, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JButton jbtn_send = new JButton("보내기");

	JPanel jp_south_second = new JPanel();

	ChatLeft cl = null;
	ChatRight cr = null;

	String nickName = null;
	Map<String, Object> map = null;
	//// 생성자
	public ChatView(Map<String, Object> map) {
		this.map = map;
		initDisplay();
	}

	//// 화면처리부
	public void initDisplay() {

		// 이벤트 처리
		jbtn_send.addActionListener(this);
		jtp_south.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.isShiftDown()) {
					if (e.getKeyCode() == 10) {
						try {
							sd_south.insertString(sd_south.getLength(), "\n", null);
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					}
				} else if (e.getKeyCode() == 10) {
					try {
						String msg = wrapLine();
						if (msg.length() != 0) {
							cr = new ChatRight("test");
							cr.jlb_rightimg.setText(msg);
							jtp_center.insertComponent(cr);
							sd_center.insertString(sd_center.getLength(), "\n", null);
						} else {
							return;
						}
					} catch (Exception ae) {
						ae.printStackTrace();
					}
				}
			}

			public void keyReleased(KeyEvent e) {

				if (e.isShiftDown()) {
					return;
				} else if (e.getKeyCode() == 10) {
					jtp_south.setText("");
				}
			}
		});

		// 화면 붙히기
		for (int i = 0; i < img.length; i++) {
			imgFiles[i].setIcon(new ImageIcon(imgPath + img[i]));
			imgFiles[i].setBorderPainted(false);
			imgFiles[i].setFocusPainted(false);
			imgFiles[i].setContentAreaFilled(true);
			imgFiles[i].setBackground(Color.white);
		}
		jp_north.setBackground(Color.white);
		jp_south_first.setBackground(Color.white);
		jp_south_second.setBackground(Color.white);

		jtp_south.setBorder(BorderFactory.createEmptyBorder());

		// 위쪽패널
		jp_north.setLayout(new GridLayout(1, 3));
		jp_north.add(jbtn_friend);
		jp_north.add(jbtn_change);
		jp_north.add(jbtn_exit);
		jp_north.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// 센터패널
		jtp_center.setDragEnabled(false);
		jtp_center.setEditable(false);
		jtp_center.setBackground(new Color(255, 180, 130));

		// 아래패널
		jp_south.setLayout(new BorderLayout());
		jp_south_first.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_south_second.setLayout(new FlowLayout(FlowLayout.LEFT));
		jtp_south.setPreferredSize(new Dimension(260, 50));
		jtp_south.setSize(100, 10);
		jp_south_first.add(jsp_south);
		jp_south_first.add(jbtn_send);
		jp_south_second.add(jbtn_imo);
		jp_south_second.add(jbtn_file);
		jp_south_second.add(jbtn_img);
		jp_south.add("North", jp_south_first);
		jp_south.add("South", jp_south_second);

		// 창이 닫힐 때 자원반납하기
		this.setLayout(new BorderLayout());
		this.add("Center", jsp_center);
		this.add("North", jp_north);
		this.add("South", jp_south);
		this.setSize(366, 600);
		this.setVisible(true);
		this.setTitle(map.get("mem_nick") + "님과의 대화방");
	}

	// * 개행처리 메소드
	public String wrapLine() {
		// jtp의 Text 값을 가져올 때 필요한 그래픽 객체
		Graphics g = jtp_south.getGraphics();
		// jtp의 글씨를 가져옴
		String getstr = jtp_south.getText();
		// 해당 글씨의 픽셀 값을 가져옴
		int width = g.getFontMetrics().stringWidth(getstr);
		String msg = null;
		if (width < 150) {// 일정 길이 이하일 때는 해당 텍스트의 길이 만큼 메시지 상자를 맞춰줌
			msg = "<html><p style=\"width:" + width + "px\">" + getstr + "</p></html>";
		} else {// 개행처리를 위한 코드
			msg = "<html><p style=\"width:100px\">" + getstr + "</p></html>";
		}
		return msg;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();
		if (obj == jbtn_send) {
			try {
				String msg = wrapLine();
				cr = new ChatRight("test");
				cr.jlb_rightimg.setText(msg);
				jtp_center.insertComponent(cr);
				sd_center.insertString(sd_center.getLength(), "\n", null);
			} catch (Exception ae) {
				ae.printStackTrace();
			}
			jtp_south.setText("");
		}
	}


}
