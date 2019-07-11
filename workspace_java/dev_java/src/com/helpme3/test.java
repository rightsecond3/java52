package com.helpme3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class test extends JPanel{
	///////////////생성부
	///////////////////위쪽 검색창///////////////////////////
	JPanel jp_serch = new JPanel();
	JButton jbtn_serch = new JButton("검색");
	JTextField jtf_serch = new JTextField(20){
        @Override
        public void setBorder(Border border) {}
    };	

    
    ///////////////중간 친구 목록/////////////////////////////////
	JPanel jp_center = new JPanel();	
	JScrollPane jsp = new JScrollPane(jp_center){
        @Override
        public void setBorder(Border border) {}
    };
    //////////////////////////////////////////////////////    
	public test() {
		//////////////검색창 색조절///////////////////////
          jp_serch.setBackground(new Color(220, 111, 0));
		  jp_serch.setLayout(new FlowLayout(FlowLayout.RIGHT));	
		  jtf_serch.setBackground(new Color(215, 132, 48));
		  jp_serch.add(jtf_serch);
		  jp_serch.add(jbtn_serch);		  	  
		/////////////groupLayout 넣기///////////////////  
	      this.setLayout(new BorderLayout());
		  GridLayout gr = new GridLayout(2,1);
	      gr.setRows(10);	      
	      jp_center.setLayout(gr);
	      for (int i = 0; i < 10; i++) {
	    	  FriendView frl = new FriendView();
	          jp_center.add(frl);
	       }
	      this.add("North",jp_serch);
	      this.add("Center",jsp);
	}

}
