package com.helpme5;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

public class ChatFriendAddPanel extends JPanel implements ItemListener{
	JRadioButton jrb = new JRadioButton(){
	      @Override
	      public void setBorder(Border border) {
	      }
	   };//버튼
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	JPanel jp3 = new JPanel();
	JLabel jl1 = new JLabel();//사진
	JLabel jl2 = new JLabel();//닉네임
	String imgPath = "C:\\workspace_java\\dev_java\\src\\images\\";
	ChatFriendAdd cha = null;
	Map<String, Object> map = null;
	////////////생성자
	public ChatFriendAddPanel(Map<String, Object> map, ChatFriendAdd cha) {
		this.map = map;
		this.cha = cha;
		//////////////////////////////////////////////// 프로필
		ImageIcon img = new ImageIcon(imgPath + "default" + ".png");
		Image originImg = img.getImage();
		Image changedImg = originImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		jl1.setIcon(new ImageIcon(changedImg));
		////////////////////////////////////////////////// 닉네임
		jl2.setText(map.get("fri_fnick").toString());
		////////////////////////////////////////////////// 라디오 버튼 액션
		jrb.addItemListener(this);
		
		jp1.add(jrb);
		jp2.add(jl1);
		jp3.add(jl2);
		jp3.setLayout(new FlowLayout(FlowLayout.RIGHT));
		GroupLayout gl = new GroupLayout(this);
		this.setLayout(gl);
		
						
		gl.setHorizontalGroup(gl.createSequentialGroup()
				.addComponent(jp1, 50, 50, GroupLayout.PREFERRED_SIZE)
				.addComponent(jp2, 50, 50, GroupLayout.PREFERRED_SIZE).addComponent(jp3));
		// 수평
		gl.setVerticalGroup(gl.createSequentialGroup()
				.addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jp1, 50, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(jp2, 50, 50, GroupLayout.PREFERRED_SIZE).addComponent(jp3)));
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange()==e.SELECTED) {///////////라디오버튼이 클릭 됐을때
			if(cha.friends.size()>0&&cha.friends!=null) {//////////친구 리스트 사이즈가 0이상/널이 아닐때
				System.out.println(map.get("fri_fid"));
				for(int i=0;i<cha.friends.size();i++) {
					////////////////리스트 안에 아이디가 존재하면 나가기
					if(cha.friends.get(i).equals(map.get("fri_fid"))) {
						System.out.println("2");
						break;
					}
					////////////////아이디가 없으면 친구 리스트에 추가하기
					else {
						cha.friends.add((String) map.get("fri_fid"));
						System.out.println("1");
						break;
					}
				}
			}else {/////////////////리스트 사이즈가 0이면 그냥 추가
				cha.friends.add((String) map.get("fri_fid"));
			}
		}else if(e.getStateChange()==e.DESELECTED){/////////라디오 버튼이 해제되었을때
			for(int i=0;i<cha.friends.size();i++) {
				if(cha.friends.get(i).equals(map.get("fri_fid"))) {/////////리스트에 아이디가 존재하면 삭제
					cha.friends.remove(i);
				}
			}
		}
	}
	
}
