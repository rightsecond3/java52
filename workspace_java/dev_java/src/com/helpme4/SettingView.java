package com.helpme4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import com.helpme4.VOMem;

public class SettingView extends JPanel implements ActionListener{
   Setting_changeprofile se = null;
   Setting_info si = null;
   Setting_notice sn = null;
   VOMem VOmem = new VOMem();
   //전체 패널
   JPanel jp_profile = new JPanel();
   JPanel jp_setting = new JPanel();
   
   ///jp_profile에 붙는 패널
   JPanel jp_pro_picture = new JPanel();
   JPanel jp_pro_introduce = new JPanel();
   
//   JButton jbtn_picture = new JButton();//프로필 사진
   String imgPath = "C:\\workspace_java\\dev_java\\src\\images\\";
   ImageIcon img_prof = new ImageIcon(imgPath+"memo.jpg");
   JLabel jl_prof = new JLabel();
   String mem_img = null;
   JLabel   jl_picture_nick = new JLabel();
   JLabel   jl_picture_status = new JLabel();
   
   ////jp_setting 에 붙는 버튼
   JButton jbtn_nickname = new JButton();//닉네임
   JButton jbtn_pimage = new JButton();//프사
   JButton jbtn_status = new JButton();//상태메시지 변경
   JButton jbtn_info = new JButton();//몽톡정보
   JButton jbtn_notice = new JButton();//몽톡정보
   
   //버튼에 붙는 패널
   JPanel jp_nickname = new JPanel();
   JPanel jp_pimage = new JPanel();
   JPanel jp_status = new JPanel();
   JPanel jp_info = new JPanel();
   JPanel jp_notice = new JPanel();
   
   //버튼 패널에 붙는 이미지와 라벨
   ImageIcon img_nick = new ImageIcon(imgPath+"nickname.png");
   JLabel jl_nick = new JLabel("닉네임 변경",img_nick,JLabel.CENTER);
   ImageIcon img_pimage = new ImageIcon(imgPath+"pimage.png");
   JLabel jl_pimage = new JLabel("프로필 이미지 변경",img_pimage,JLabel.CENTER);
   ImageIcon img_status = new ImageIcon(imgPath+"talk.jpg");
   JLabel jl_status = new JLabel("상태메시지 변경",img_status,JLabel.CENTER);
   ImageIcon img_info = new ImageIcon(imgPath+"info.png");
   JLabel jl_info = new JLabel("몽톡 정보",img_info,JLabel.CENTER);
   ImageIcon img_notice = new ImageIcon(imgPath+"notice.png");
   JLabel jl_notice = new JLabel("공지사항",img_notice,JLabel.CENTER);

   String mem_id =null;
   String mem_nick =null;
   
   Login login = null;
   public SettingView(Map<String, Object> map, Login login){
	   this.login = login;
      //이벤트 처리하기
      jbtn_notice.addActionListener(this);
      jbtn_nickname.addActionListener(this);
      jbtn_status.addActionListener(this);
      jbtn_pimage.addActionListener(this);
      jbtn_info.addActionListener(this);
       //패널_프로필 구역 나누기
      jp_profile.setLayout(new FlowLayout(FlowLayout.LEFT));
      jp_profile.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
      jp_profile.setBackground(Color.white);
       jp_profile.add(jp_pro_picture);
       //jp_pro_picture.setMinimumSize(new Dimension(100,700));
       //패널_프로필_사진에 라벨 프사 이미지 붙이기
       jp_pro_picture.setBackground(Color.white);
       jp_pro_picture.add(jl_prof);
       
   	// 이미지 자르기 경로에 VO.getimg 넣기
		ImageIcon img = new ImageIcon(imgPath + map.get("mem_img").toString() + ".png");
		Image originImg = img.getImage();
		Image changedImg = originImg.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
		// 이미지 자르기 끝
       jl_prof.setIcon(new ImageIcon(changedImg));//프로필 이미지 붙이기

       
     //패널_프로필_소개 구역에 라벨 붙이기
       jp_profile.add(jp_pro_introduce);
         jp_pro_introduce.setLayout(new GridLayout(2,1));
         jp_pro_introduce.setBackground(Color.white);
         jp_pro_introduce.add(jl_picture_nick);
         jl_picture_nick.setText((String) map.get("mem_nick"));
         jl_picture_nick.setFont(new Font("명조", Font.CENTER_BASELINE, 20));
         jp_pro_introduce.add(jl_picture_status);
         jl_picture_status.setText((String) map.get("mem_status"));
         jl_picture_status.setFont(new Font("명조", Font.CENTER_BASELINE, 20));
         jl_picture_status.setVerticalAlignment(JLabel.BOTTOM);
         jl_picture_nick.setVerticalAlignment(JLabel.TOP);

      
       //세팅 구역에 버튼 붙이기
      jp_setting.setLayout(new GridLayout(5,1));
      jp_setting.setBackground(Color.white);
      jp_setting.add(jbtn_nickname);
      jp_setting.add(jbtn_pimage);
      jp_setting.add(jbtn_status);
      jp_setting.add(jbtn_info);
      jp_setting.add(jbtn_notice);
      //세팅 구역 버튼에 패널 붙이기. -닉네임
       jbtn_nickname.add(jp_nickname);
       jbtn_nickname.setBackground(Color.white);
       jbtn_nickname.setFocusPainted(false);
       jbtn_nickname.setContentAreaFilled(false);
       jp_nickname.setLayout(new FlowLayout(FlowLayout.LEFT));
       jp_nickname.setBackground(Color.white);
       jp_nickname.add(jl_nick);
       //세팅 구역 버튼에 패널 붙이기. -프로필 이미지 변경
       jbtn_pimage.add(jp_pimage);
       jbtn_pimage.setBackground(Color.white);
       jbtn_pimage.setContentAreaFilled(false);
       jp_pimage.setLayout(new FlowLayout(FlowLayout.LEFT));
       jp_pimage.setBackground(Color.white);
       jp_pimage.add(jl_pimage);
       //세팅 구역 버튼에 패널 붙이기. -상태메세지
       jbtn_status.add(jp_status);
       jbtn_status.setBackground(Color.white);
       jbtn_status.setContentAreaFilled(false);
       jp_status.setLayout(new FlowLayout(FlowLayout.LEFT));
       jp_status.setBackground(Color.white);
       jp_status.add(jl_status);
       //세팅 구역 버튼에 패널 붙이기. -몽톡 정보
       jbtn_info.add(jp_info);
       jbtn_info.setBackground(Color.white);
       jbtn_info.setContentAreaFilled(false);
       jp_info.setLayout(new FlowLayout(FlowLayout.LEFT));
       jp_info.setBackground(Color.white);
       jp_info.add(jl_info);
       
       //세팅 구역 버튼에 패널 붙이기. -공지사항
       jbtn_notice.add(jp_notice);
       jbtn_notice.setBackground(Color.white);
       jbtn_notice.setContentAreaFilled(false);
       jp_notice.setLayout(new FlowLayout(FlowLayout.LEFT));
       jp_notice.setBackground(Color.white);
       jp_notice.add(jl_notice); 
       jp_profile.setMaximumSize(new Dimension(500,20));
       this.setLayout(new GridLayout(2,1));
       this.add(jp_profile);
       this.add(jp_setting);


       jp_profile.setMaximumSize(new Dimension(500,70));
      
      GroupLayout gl = new GroupLayout(this);
      this.setLayout(gl);
      gl.setHorizontalGroup(gl.createSequentialGroup()
            .addGroup(gl.createParallelGroup()
                  .addComponent(jp_profile)
                  .addComponent(jp_setting)
                  ));
      gl.setVerticalGroup(
            gl.createSequentialGroup()
            .addGroup(gl.createParallelGroup())
               .addComponent(jp_profile)
            .addGroup(gl.createParallelGroup())
               .addComponent(jp_setting)
            );
   }



   @Override
   public void actionPerformed(ActionEvent e) {
      Object obj = e.getSource();
      if(obj==jbtn_nickname) {
         String afterName =
               JOptionPane.showInputDialog("변경할 대화명을 입력하세요.");
         try {
			login.oos.writeObject(Protocol.SETTING_NICK+Protocol.seperator+login.mem_id+Protocol.seperator+afterName);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
         
      }
      if(obj==jbtn_status) {
    	  String afterstatus = 
    	            JOptionPane.showInputDialog("변경할 메세지를 입력하세요.");
    	  try {
			login.oos.writeObject(Protocol.SETTING_STATUS+Protocol.seperator+login.mem_id+Protocol.seperator+afterstatus);
		} catch (Exception e2) {
			// TODO: handle exception
		}
      }
      if(obj==jbtn_pimage) {
    	  SettingImg sim = new SettingImg(login);
      }
      if(obj==jbtn_info) {
         si = new Setting_info(this);
      }if(obj==jbtn_notice) {
         //sn = new Setting_notice(this);
         
      }
      
      
   }

}