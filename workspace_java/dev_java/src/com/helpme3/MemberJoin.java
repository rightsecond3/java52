package com.helpme3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MemberJoin extends JDialog {
	private JLabel jl_id      =   new JLabel("아이디[필수이름]");
	private JLabel jl_name    =   new JLabel("이름");
	private JLabel jl_pw      =   new JLabel("비밀번호");
	private JLabel jl_nick    =   new JLabel("닉네임");
	private JLabel jl_hp      =   new JLabel("전화번호");
	private JLabel jl_birth   =   new JLabel("생년월일");
	private JTextField jtf_id      =   new JTextField(); 
	private JTextField jtf_name    =   new JTextField(); 
	private JTextField jtf_pw      =   new JTextField(); 
	private JTextField jtf_nick    =   new JTextField(); 
	private JTextField jtf_hp      =   new JTextField(); 
	private JTextField jtf_birth   =   new JTextField(); 
	
	JPanel jp_center = new JPanel(); // 붙힐꺼
	JPanel jp_south = new JPanel(); // 가입 | 취소
	JButton jbtn_save = new JButton("가입");
	JButton jbtn_cancel = new JButton("취소");
	
	public MemberJoin() {
		initDisplay();
	}
	public void initDisplay() {
		jp_center.setLayout(null);
		jl_id    .setBounds(20,20,200,20); 
		jtf_id    .setBounds(140,20,200,20); 
		jl_name  .setBounds(20,45,200,20); 
		jtf_name  .setBounds(140,45,200,20); 
		jl_pw    .setBounds(20,70,200,20); 
		jtf_pw    .setBounds(140,70,200,20); 
		jl_nick  .setBounds(20,95,200,20); 
		jtf_nick  .setBounds(140,95,200,20); 
		jl_hp    .setBounds(20,120,200,20); 
		jtf_hp    .setBounds(140,120,200,20); 
		jl_birth .setBounds(20,145,200,20); 
		jtf_birth .setBounds(140,145,200,20); 
		
		jp_center.add(jl_id       );
		jp_center.add(jl_name     );
		jp_center.add(jl_pw       );
		jp_center.add(jl_nick     );
		jp_center.add(jl_hp       );
		jp_center.add(jl_birth    );
		jp_center.add(jtf_id      );
		jp_center.add(jtf_name    );
		jp_center.add(jtf_pw      );
		jp_center.add(jtf_nick    );
		jp_center.add(jtf_hp      );
		jp_center.add(jtf_birth   );
		jp_south.add(jbtn_save);
		jp_south.add(jbtn_cancel);
		
		jbtn_save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		jbtn_cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		this.add("Center",jp_center);
		this.add("South",jp_south);
		this.setSize(400, 250);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		MemberJoin mj = new MemberJoin();
		mj.initDisplay();
	}

}