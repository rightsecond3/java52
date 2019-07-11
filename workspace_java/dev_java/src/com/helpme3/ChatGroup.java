package com.helpme3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

import grouplayout.TextPaneMain;

public class ChatGroup extends JPanel {
	 JPanel jp_img = new JPanel();
	 JPanel jp_second = new JPanel();
	 JPanel jp_time = new JPanel();
	 JLabel jl_img = new JLabel("프사", JLabel.CENTER);
	 JLabel jl_name = new JLabel("이름", JLabel.LEFT);
	 JLabel jl_msg = new JLabel("마지막메세지", JLabel.LEFT);
	 JLabel jl_time = new JLabel("시간", JLabel.RIGHT);
	 
	 public ChatGroup() {
		 
	    jp_img.setLayout(new BorderLayout());
	    jp_second.setLayout(new BorderLayout());
	    jp_time.setLayout(new BorderLayout());
	    
	    jl_name.setVerticalAlignment(JLabel.BOTTOM);
	    jl_msg.setVerticalAlignment(JLabel.TOP);
	    
	    //세컨드 패널에 이름과 마지막 메시지가 들어가는 것임
	    jp_second.setLayout(new GridLayout(2,1));
	    jp_img.add(jl_img);
	    jp_second.add(jl_name);
	    jp_second.add(jl_msg);
	    jp_time.add(jl_time);
	    
        // 마지막 메세지부분 회색 처리
        jl_msg.setForeground(Color.GRAY);
	    
	    GroupLayout gl = new GroupLayout(this);
	    this.setLayout(gl);
	    //수평 그룹
	    gl.setHorizontalGroup(
	          //순차적으로 그룹을 붙히겠다
	          gl.createSequentialGroup()
	             .addComponent(jp_img, 70, 70, 70)
	             //DEFAULT_SIZE : 늘리면 늘리는 만큼 늘어남
	             .addComponent(jp_second, 300, 300, GroupLayout.DEFAULT_SIZE)
	             .addComponent(jp_time, 70, 70, 70)
	          );
	    //수직 그룹
	    gl.setVerticalGroup(
	          //순차적으로 그룹을 붙히겠다
	          gl.createSequentialGroup()
	             .addGroup(gl.createParallelGroup(Alignment.BASELINE)
	                   .addComponent(jp_img, 80, 80, GroupLayout.PREFERRED_SIZE)
	                   .addComponent(jp_second, 80, 80, GroupLayout.PREFERRED_SIZE)
	                   .addComponent(jp_time, 80, 80, GroupLayout.PREFERRED_SIZE)
	                   )
	          );
	 }
}
