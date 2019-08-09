package com.helpme4;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
/*
 * 프사 눌렀을 때 뜨는 다이얼로그창
 */
public class FirendDialog extends JDialog {
	///////////////선언부
	///////////////프로필 패널 배경 설정
   JPanel jp_center = new JPanel() {
		   public void paintComponent(Graphics g) {
		ImageIcon icon = new ImageIcon(imgPath+"back.png");
	    g.drawImage(icon.getImage(), 0, 0, null);
	  
	    setOpaque(false);
	    super.paintComponent(g);
	   }
	  };;
   JPanel jp_img = new JPanel();
   JLabel jl_img = new JLabel();
   JPanel jp_nick = new JPanel();
   JLabel jl_nick = new JLabel();
   JPanel jp_mychat = new JPanel();
   JLabel jl_mychat = new JLabel("나와의 채팅");
   JPanel jp_profile = new JPanel();
   JLabel jl_profile = new JLabel("프로필 관리");
   JPanel jp_mychat_1 = new JPanel();
   JButton jbtn_mychat = new JButton();
   JPanel jp_profile_1 = new JPanel();
   JButton jbtn_profile = new JButton();
   String imgPath="C:\\workspace_java\\dev_java\\src\\images\\";
   public void initDisplay(Map<String, Object> map) {
	  jp_center.setLayout(null);
      jp_center.setBackground(Color.darkGray);
      jp_img.add(jl_img);
      jp_img.setBounds(50, 100, 200, 200);
      jp_nick.add(jl_nick);
      jp_nick.setBounds(100, 350, 100, 100);
      jp_mychat_1.add(jbtn_mychat);
      jp_mychat_1.setBounds(82, 470, 35, 35);
      jp_profile_1.add(jbtn_profile);
      jp_profile_1.setBounds(182, 470, 35, 35);
      jp_mychat.add(jl_mychat);
      jp_mychat.setBounds(50, 500, 100, 100);
      jp_profile.add(jl_profile);
      jp_profile.setBounds(150, 500, 100, 100);
     
      
      
      jp_img.setOpaque(false);
      jp_nick.setOpaque(false);
      jp_mychat_1.setOpaque(false);
      jp_profile_1.setOpaque(false);
      jp_mychat.setOpaque(false);
      jp_profile.setOpaque(false);
      //////////////////프로필 닉네임 폰트 설정
      jl_nick.setText(map.get("fri_fnick").toString());
      jl_nick.setFont(new Font("맑은 고딕", Font.CENTER_BASELINE, 20));
      jl_nick.setForeground(Color.black);
      ImageIcon img = new ImageIcon(imgPath+map.get("mem_img").toString()+".png");
  	  Image originImg = img.getImage(); 
  	  Image changedImg= originImg.getScaledInstance(200, 200, Image.SCALE_SMOOTH );	
  	  jl_img.setIcon(new ImageIcon(changedImg));


  	  jp_center.add(jp_img);
  	  jp_center.add(jp_nick);
  	  this.add(jp_center);
      this.setSize(300, 580);
      this.setResizable(false);
      this.setVisible(true);
   }

   public static void main(String[] args) {
      FirendDialog fd = new FirendDialog();
      //fd.initDisplay();
   }

}
