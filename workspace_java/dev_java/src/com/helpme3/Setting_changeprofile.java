package com.helpme3;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * 설정 - 프사바꾸기
 */
public class Setting_changeprofile extends JFrame {
	//// 선언부//////
	SettingView sv = null;
	VOMem VOmem = new VOMem();
	// 전체 패널
	JPanel jp_1 = new JPanel();
	// 프사 패널
	JPanel jp_prof = new JPanel();
	// 파일 url있는 패널
	JPanel jp_url = new JPanel();
	JTextField tf_url = new JTextField(20);
	JButton jbtn_set = new JButton("적용");
	// 새로운 프사가 저장될 이미지 경로
	String profilePath = "C:\\workspace_java\\dev_java\\src\\images\\profile\\";
	// 기존 프사 이미지 경로
	String imgPath = "C:\\workspace_java\\dev_java\\src\\images\\";
	JLabel imageLabel = null;
	Image img = null;
	String profileName = null;

	// 생성자
	public Setting_changeprofile(SettingView sv) {
		this.sv = sv;
		profileName = imgPath + sv.mem_img;
		File defaultProfile = new File(profileName);
		try {
			img = ImageIO.read(defaultProfile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		imageLabel = new JLabel(new ImageIcon(img));
		initDisplay();
	}

	// 화면처리
	public void initDisplay() {
		// 적용 버튼을 눌렀을 때 일어나는 이벤트
		jbtn_set.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jp_prof.removeAll();// 기존 파일 지워주고
				String profURL = tf_url.getText();// url주소 읽고
				profileName = Long.valueOf(new Date().getTime()).toString();// 새로운 파일 이름 형식 선언
				eventProfile(profURL, profileName);// 프로필 바꾸는 메소드 호출

			}
		});

		jp_prof.setLayout(null);
		jp_prof.add(imageLabel);
		imageLabel.setBounds(60, 10, 180, 180);

		jp_url.setLayout(null);
		jp_url.add(tf_url);
		tf_url.setBounds(20, 10, 250, 20);
		jp_url.add(jbtn_set);
		jbtn_set.setBounds(115, 40, 60, 30);
		jbtn_set.setBackground(Color.white);
		jp_url.setBackground(Color.white);
		jp_prof.setBackground(Color.white);

		GroupLayout gl = new GroupLayout(jp_1);
		jp_1.setLayout(gl);
		gl.setHorizontalGroup(gl.createSequentialGroup()
				.addGroup(gl.createParallelGroup().addComponent(jp_prof).addComponent(jp_url)));
		gl.setVerticalGroup(gl.createSequentialGroup().addGroup(gl.createParallelGroup())
				.addComponent(jp_prof, 180, 180, 180).addGroup(gl.createParallelGroup()).addComponent(jp_url));
		this.add("Center", jp_1);
		this.setLocation(200, 200);
		this.setSize(300, 300);
		this.setVisible(true);
		this.setResizable(false);
	}

//	public void jp_profile() {
//		sv.jp_profile.add(sv.jp_pro_picture);
//		sv.jp_pro_picture.add(sv.jl_prof);
//		sv.jl_prof.add(imageLabel);
//		
//	}
	// 프로필 바꾸는 메소드
	public void eventProfile(String profURL, String fileName) {
		String saveFileName = fileName + ".png";
		String fileFormat = "png";
		String filePath = profilePath + saveFileName;
		File saveFile = new File(filePath);
		saveImage(profURL, saveFile, fileFormat);
		Image img = null;
		Image nimg = null;
		Image pnimg = null;
		try {
			img = ImageIO.read(saveFile);// 이미지 변경
			nimg = img.getScaledInstance(180, 180, Image.SCALE_SMOOTH);// 사이즈 조절
		} catch (Exception e) {
			e.printStackTrace();
		}
		imageLabel = new JLabel(new ImageIcon(nimg));// 조절한 이미지 붙여주기!!
		initDisplay();// 설정 이벤트 창
//		sv.jl_prof.setIcon(new ImageIcon(profilePath+profileName+".png"));
		pnimg = nimg.getScaledInstance(130, 120, Image.SCALE_SMOOTH);// 세팅창의 프로필 사진 이미지 크기 재조정
		sv.jl_prof.setIcon(new ImageIcon(pnimg));// 세팅창 프로필 사진 붙여주기
		this.repaint();

	}

	// 파일 저장하는 메소드
	public void saveImage(String profURL, File saveFile, String fileFormat) {
		URL url = null;
		BufferedImage bi = null;
		try {
			url = new URL(profURL);
			bi = ImageIO.read(url);
			ImageIO.write(bi, fileFormat, saveFile);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
//	public static void main(String[] args) {
//		SettingEvent se = new SettingEvent();
//		se.initDisplay();
//
//	}
}