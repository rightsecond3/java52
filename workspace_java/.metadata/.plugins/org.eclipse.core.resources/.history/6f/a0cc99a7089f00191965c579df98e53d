package com.helpme2;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class SuperView extends JFrame {
	// 선언부

	JLabel jl = new JLabel("  친구 :  ");
	JLabel jl_pro = new JLabel("  프사  ");
	JLabel jl_name = new JLabel("  이름  ");
	JLabel jl_msg = new JLabel("  상메  ");
	JPanel jp_first = new JPanel();
	JPanel jp_first_south = new JPanel();
	JButton jbtn_friend = new JButton();
	JButton jbtn_talk = new JButton();
	JButton jbtn_set = new JButton();
	String imgPath = "C:\\workspace_java\\dev_java\\src\\images\\";
	String img[] = { "friend.jpg", "talk.jpg", "setting.jpg" };
	JButton imgFiles[] = { jbtn_friend, jbtn_talk, jbtn_set };

	JPanel jp_center = new JPanel();
	JScrollPane jsp = new JScrollPane(jp_center,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
			,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JPanel jp_center_first = new JPanel();
	JLabel jl_test1 = new JLabel("테스트1");
	JPanel jp_center_second = new JPanel();
	JLabel jl_test2 = new JLabel("테스트2");
	JPanel jp_center_3 = new JPanel();
	JLabel jl_test3 = new JLabel("테스트3");
	JPanel jp_center_4 = new JPanel();
	JLabel jl_test4 = new JLabel("테스트4");
	JPanel jp_center_5 = new JPanel();
	JLabel jl_test5 = new JLabel("테스트5");
	JPanel jp_center_6 = new JPanel();
	JLabel jl_test6 = new JLabel("테스트6");
	
	
	// 생성자
	public SuperView() {
		initDisplay();
	}

	// 화면구현
	public void initDisplay() {
		////////////////////////////////////////////////

		jp_center_first.add(jl_test1);
		jp_center_second.add(jl_test2);
		jp_center_3.add(jl_test3);
		jp_center_4.add(jl_test4);
		jp_center_first.setBackground(Color.green);
		jp_center_second.setBackground(Color.DARK_GRAY);
		jp_center_3.setBackground(Color.cyan);
		jp_center_4.setBackground(Color.red);
		jp_center_5.setBackground(Color.orange);
		jp_center_6.setBackground(Color.pink);
		/////////////////그리드 레이아웃 시작////////////////////////
		GridLayout gl = new GridLayout(5,1);
		jp_center.setLayout(gl);
		
		Dao dao = new Dao();
		List<testVO> tList = new Vector<>();
		tList = dao.test();
		testVO tVO = new testVO();
		for(int i = 0; i < tList.size(); i++) {
			tVO = tList.get(i);
			FriendGroupLayout frl = new FriendGroupLayout();
			frl.jl1.setText(tVO.getMem_id());
			frl.jl2.setText(tVO.getMem_name());
			frl.jl3.setText(tVO.getMem_email());
			jp_center.add(frl);
		}
		this.add("Center", jsp);
		jp_center.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		//////////////////Dao에서 가져온 값으로 친구목록 넣기 끝////////////////

		for (int i = 0; i < img.length; i++) {
			imgFiles[i].setIcon(new ImageIcon(imgPath + img[i]));
			imgFiles[i].setBorderPainted(false);
			imgFiles[i].setFocusPainted(false);
			imgFiles[i].setContentAreaFilled(true);
		}
		jbtn_friend.setBackground(Color.white);
		jbtn_talk.setBackground(Color.white);
		jbtn_set.setBackground(Color.white);
		jp_first_south.setBackground(Color.white);
		jp_first.setBackground(new Color(229, 153, 90));
		jp_first.setLayout(null);
		jp_first.setBounds(0, 0, 366, 10);
		jp_first_south.setBounds(5, 5, 50, 50);
		jp_first.setLayout(new GridLayout(2, 1));
		jp_first.add(jl);
		jp_first_south.setLayout(new GridLayout(1, 3));
		jp_first_south.add(jbtn_friend);
		jp_first_south.add(jbtn_talk);
		jp_first_south.add(jbtn_set);
		jp_first.add(jp_first_south);
		this.add("North", jp_first);
		this.setSize(500, 600);
		this.setVisible(true);
	}

	// 메인메소드
	public static void main(String[] args) {
		SuperView sv = new SuperView();
		sv.initDisplay();
	}

}
