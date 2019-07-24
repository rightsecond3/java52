package com.helpme3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.net.MalformedURLException;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.border.TitledBorder;
/*
 * 채팅 오른쪽 뷰
 */
public class ChatRight extends JPanel{
   /////////////////////===========선언부=================///////////////////
   //채팅 보낸 시간 분 표시 라벨 붙일 패널
   JPanel jp_time;
   //채팅창에 프로필 사진
   JLabel jlb_right;
   //채팅 보낸 시간 분 표시 하는 라벨
   JLabel jlb_time;
   //메세지를 붙일 라벨
   public JLabel jlb_rightimg;
   //말풍선을 넣을 페널
   JPanel chat_right;
   String imgPath = "C:\\workspace_java\\dev_java\\src\\images\\";
   
   //////////////////////========생성자===========///////////////////////
   public ChatRight(String id) throws MalformedURLException {
	   //시간 분 처리부
       jp_time = new JPanel(new BorderLayout());
       jlb_time = new JLabel();
       jlb_time.setHorizontalAlignment(JLabel.RIGHT);
       jlb_time.setText("13:00");
       jp_time.add("South", jlb_time);
       jp_time.setOpaque(false);
       
       //프로필 사진 붙이는 부분
       jlb_right = new JLabel();   
       jlb_right.setIcon(new ImageIcon(imgPath+"user-3.png"));  //--> 프로필 사진 붙이는거
      
       //메세지 붙이는 부분의 처리
       jlb_rightimg = new JLabel();

       //말풍선 처리
       chat_right = new ChatRightBubble();
       
       //이 패널의 투명도를 투명하게 만드는것.
       this.setOpaque(false);
       
       
       /////////////////RIGHT BUBBLE///////////////////////////// 의 그룹레이아웃 설정
       jlb_time.setText("13:00");
       GroupLayout chat_rightLayout = new GroupLayout(chat_right);
       chat_right.setLayout(chat_rightLayout);
       chat_rightLayout.setHorizontalGroup(
       		chat_rightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
       		.addGroup(GroupLayout.Alignment.TRAILING, chat_rightLayout.createSequentialGroup()
       		.addGap(25, 25, 25)//말풍선 안에서 말풍선과 문장 시작부분 gap
               .addComponent(jlb_rightimg)        
               .addGap(31, 31, 31))
       );
       chat_rightLayout.setVerticalGroup(
       		chat_rightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
       		.addGroup(chat_rightLayout.createSequentialGroup()
       		.addGap(6, 6, 6) //말풍선 안에서 말풍선위쪽라인과 텍스트사이 gap 
       		.addComponent(jlb_rightimg)
               .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addGap(6, 6, 6))
       );

       GroupLayout layout = new GroupLayout(this);
       this.setLayout(layout);     
       
       layout.setHorizontalGroup(
           layout.createParallelGroup(GroupLayout.Alignment.LEADING)
           		.addGroup(layout.createSequentialGroup()	
           		.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
           		.addContainerGap()
           		.addGap(6,6,6)
           		.addContainerGap()
           		.addComponent(jp_time)
           		.addGap(15,15,15)
           		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
           		.addComponent(chat_right, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(10,10,10)
           		.addComponent(jlb_right)
           )
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(GroupLayout.Alignment.LEADING)
           	.addGroup(layout.createSequentialGroup()
               .addContainerGap()
               .addGap(6, 6, 6)
               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
               .addComponent(jp_time)
               .addComponent(jlb_right)
               .addComponent(chat_right, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
               .addContainerGap()
               )
       );
    }
}