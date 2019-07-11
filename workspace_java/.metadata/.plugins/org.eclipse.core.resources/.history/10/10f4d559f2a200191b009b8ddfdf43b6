package com.helpme3;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class ChatGroup extends JPanel {
	JPanel jp_search = new JPanel();
	JButton jbtn_search = new JButton("검색");
	JTextField jtf_search = new JTextField("친구 검색",20){
	     @Override
	     public void setBorder(Border border) {}
	 };   

	JPanel jp_center = new JPanel();   
	JScrollPane jsp = new JScrollPane(jp_center){
	     @Override
	     public void setBorder(Border border) {}
	 };
	 JPanel jp1 = new JPanel();
	 JPanel jp2 = new JPanel();
	 JPanel jp3 = new JPanel();
	 
	 JLabel jl1 = new JLabel("1");
	 JLabel jl2 = new JLabel("2");
	 JLabel jl3 = new JLabel("3");

	 public ChatGroup() { 
	      jp_search.setBackground(new Color(220, 111, 0));
	     jp_search.setLayout(new FlowLayout(FlowLayout.RIGHT));   
	     jtf_search.setBackground(new Color(215, 132, 48));
	     jp_search.add(jtf_search);
	     jp_search.add(jbtn_search);   
	     
	      jp1.add(jl1);
	      jp2.add(jl2);
	      jp3.add(jl3);      

	      
	      GroupLayout gl = new GroupLayout(this);      
	      this.setLayout(gl);


	      // 수직
	      gl.setHorizontalGroup(gl.createSequentialGroup()                
	                    .addComponent(jp1, 50, 50, GroupLayout.PREFERRED_SIZE)                
	                    .addComponent(jp2, 158, 158, GroupLayout.PREFERRED_SIZE)                 
	                    .addComponent(jp3));
	      // 수평
	      gl.setVerticalGroup(gl.createSequentialGroup()
	            .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                  .addComponent(jp1, 50, 50, GroupLayout.PREFERRED_SIZE)
	                  .addComponent(jp2, 50, 50, GroupLayout.PREFERRED_SIZE)
	                  .addComponent(jp3)));

	   }
}
