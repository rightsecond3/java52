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
///////////////단톡방 친구목록에 넣기위한 개개인의 패널 만들기
public class FriendGroupListpanel extends JPanel implements ItemListener{
	///////////선언부
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
	FriendGroupList fgl = null;
	Map<String, Object> map = null;
	////////////생성자
	public FriendGroupListpanel(Map<String, Object> map, FriendGroupList fgl) {
		this.map = map;
		this.fgl = fgl;
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
			if(fgl.friends.size()>0&&fgl.friends!=null) {//////////친구 리스트 사이즈가 0이상/널이 아닐때
				for(int i=0;i<fgl.friends.size();i++) {
					////////////////리스트 안에 아이디가 존재하면 나가기
					if(fgl.friends.get(i).equals(map.get("mem_id"))) {
						break;
					}
					////////////////아이디가 없으면 친구 리스트에 추가하기
					else {
						fgl.friends.add((String) map.get("mem_id"));
						break;
					}
				}
			}else {/////////////////리스트 사이즈가 0이면 그냥 추가
				fgl.friends.add((String) map.get("mem_id"));
			}
		}else if(e.getStateChange()==e.DESELECTED){/////////라디오 버튼이 해제되었을때
			for(int i=0;i<fgl.friends.size();i++) {
				if(fgl.friends.get(i).equals(map.get("mem_id"))) {/////////리스트에 아이디가 존재하면 삭제
					fgl.friends.remove(i);
				}
			}
		}
	}
	

}
