package com.helpme3;

import java.awt.Color;
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
   JPanel jp_center = new JPanel() {
		   public void paintComponent(Graphics g) {
		ImageIcon icon = new ImageIcon(imgPath+"14f178b5a9d47fc26e9e1d6ea128ec61.jpg");
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
      
      jl_nick.setText(map.get("mem_nick").toString());
      
      ImageIcon img = new ImageIcon(imgPath+map.get("mem_img").toString()+".png");
  	  Image originImg = img.getImage(); 
  	  Image changedImg= originImg.getScaledInstance(200, 200, Image.SCALE_SMOOTH );	
  	  jl_img.setIcon(new ImageIcon(changedImg));

      ImageIcon mychat = new ImageIcon(imgPath+"134932.png");
 	  Image originmychat = mychat.getImage(); 
 	  Image changedmychat= originmychat.getScaledInstance(20, 20, Image.SCALE_SMOOTH );	
 	  jbtn_mychat.setIcon(new ImageIcon(changedmychat));
 	  jbtn_mychat.setBorderPainted(false);
 	  jbtn_mychat.setFocusPainted(false);
 	  jbtn_mychat.setContentAreaFilled(false);
 	
      ImageIcon profile = new ImageIcon(imgPath+"148972.png");
 	  Image originprofile = profile.getImage(); 
 	  Image changedprofile= originprofile.getScaledInstance(20, 20, Image.SCALE_SMOOTH );	
 	  jbtn_profile.setIcon(new ImageIcon(changedprofile));
 	  jbtn_profile.setBorderPainted(false);
 	  jbtn_profile.setFocusPainted(false);
 	  jbtn_profile.setContentAreaFilled(false);
  	  
  	  
  	  
  	  jp_center.add(jp_profile);
  	  jp_center.add(jp_profile_1);
  	  jp_center.add(jp_mychat_1);
  	  jp_center.add(jp_mychat);
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
