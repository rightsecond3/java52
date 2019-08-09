package com.helpme4;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.google.gson.Gson;

public class MemberJoin extends JDialog implements ActionListener, Runnable {
	private JLabel jl_id = new JLabel("아이디[필수이름]");
	private JLabel jl_name = new JLabel("이름");
	private JLabel jl_pw = new JLabel("비밀번호");
	private JLabel jl_nick = new JLabel("닉네임");
	private JLabel jl_hp = new JLabel("전화번호");
	private JLabel jl_birth = new JLabel("생년월일");
	private JTextField jtf_id = new JTextField();
	private JTextField jtf_name = new JTextField();
	private JTextField jtf_pw = new JTextField();
	private JTextField jtf_nick = new JTextField();
	private JTextField jtf_hp = new JTextField();
	private JTextField jtf_birth = new JTextField();

	JPanel jp_center = new JPanel(); // 붙힐꺼
	JPanel jp_south = new JPanel(); // 가입 | 취소
	JButton jbtn_save = new JButton("가입");
	JButton jbtn_cancel = new JButton("취소");
	JButton jbtn_overlap = new JButton("중복검사");
	Login login = null;
	String overlap = "중복안함";

	public MemberJoin(Login login) {
		this.login = login;
		initDisplay();		
		new Thread(this).start();
	}

	public void initDisplay() {
		jbtn_save.addActionListener(this);
		jbtn_cancel.addActionListener(this);
		jbtn_overlap.addActionListener(this);
		jp_center.setBackground(new Color(229, 153, 90));
		jp_south.setBackground(new Color(229, 153, 90));
		jp_center.setLayout(null);
		jl_id.setBounds(20, 20, 200, 20);
		jtf_id.setBounds(140, 20, 200, 20);
		jbtn_overlap.setBounds(350, 20, 90, 20);
		jl_name.setBounds(20, 45, 200, 20);
		jtf_name.setBounds(140, 45, 200, 20);
		jl_pw.setBounds(20, 70, 200, 20);
		jtf_pw.setBounds(140, 70, 200, 20);
		jl_nick.setBounds(20, 95, 200, 20);
		jtf_nick.setBounds(140, 95, 200, 20);
		jl_hp.setBounds(20, 120, 200, 20);
		jtf_hp.setBounds(140, 120, 200, 20);
		jl_birth.setBounds(20, 145, 200, 20);
		jtf_birth.setBounds(140, 145, 200, 20);

		jp_center.add(jbtn_overlap);
		jp_center.add(jl_id);
		jp_center.add(jl_name);
		jp_center.add(jl_pw);
		jp_center.add(jl_nick);
		jp_center.add(jl_hp);
		jp_center.add(jl_birth);
		jp_center.add(jtf_id);
		jp_center.add(jtf_name);
		jp_center.add(jtf_pw);
		jp_center.add(jtf_nick);
		jp_center.add(jtf_hp);
		jp_center.add(jtf_birth);
		jp_south.add(jbtn_save);
		jp_south.add(jbtn_cancel);

		this.add("Center", jp_center);
		this.add("South", jp_south);
		this.setSize(470, 250);
		this.setVisible(true);

	}

//	public static void main(String[] args) {
//		MemberJoin mj = new MemberJoin(null);
//		mj.initDisplay();
//	}
	public void join_process() {
	   	String mem_id = jtf_id.getText();
	    String mem_pw = jtf_pw.getText();
	    String mem_name = jtf_name.getText();
	    String mem_nick = jtf_nick.getText();
	    String mem_hp = jtf_hp.getText();
	    String mem_birth = jtf_birth.getText();
	    
	    Map<String,Object> join = new HashMap<>();
	    join.put("mem_id", mem_id);
	    join.put("mem_pw", mem_pw);
	    join.put("mem_name", mem_name);
	    join.put("mem_nick", mem_nick);
	    join.put("mem_hp", mem_hp);
	    join.put("mem_birth", mem_birth);
	    
	    Gson g = new Gson();
	    String map = g.toJson(join);
	    try {
	    	 login.oos.writeObject(Protocol.JOIN
			                      +Protocol.seperator+map
			         );
		} catch (Exception e) {
			e.printStackTrace();
		}
	   
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == jbtn_save) {
			if ("중복안함".equals(overlap)) {
				JOptionPane.showMessageDialog(this, "아이디 중복검사를 해주세요.");
			}
			else if("통과".equals(overlap)) {
				join_process();
			}
		} else if (obj == jbtn_cancel) {

		} else if (obj == jbtn_overlap) {
			String mem_id = jtf_id.getText();
			try {
				login.oos.writeObject(Protocol.OVERLAP + Protocol.seperator + mem_id);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		String msg = null;
		boolean isStop = false;
		run_start:
		while (!isStop) {
			try {
				msg = (String) login.ois.readObject();
				StringTokenizer st = null;
				int protocol = 0;

				if (msg != null) {
					st = new StringTokenizer(msg, Protocol.seperator);
					protocol = Integer.parseInt(st.nextToken());
				}
				System.out.println(protocol);
				switch (protocol) {
				case Protocol.OVERLAP: {
					String mem_id = st.nextToken();
					if ("중복".equals(mem_id)) {
						JOptionPane.showMessageDialog(this, "아이디가 중복 됩니다.");
					} else {
						JOptionPane.showMessageDialog(this, "사용가능한 아이디 입니다.");
						overlap = "통과";
					}
				}
					break;
				case Protocol.JOIN: {
                    String mem_id = st.nextToken();
                    if("실패".equals(mem_id)) {
                    	JOptionPane.showMessageDialog(this, "회원가입에 실패하였습니다.");
                    }
                    else {
                    	JOptionPane.showMessageDialog(this, "회원가입에 성공하였습니다.");
                    	this.dispose();
                    	break run_start;
                    }
				}break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
