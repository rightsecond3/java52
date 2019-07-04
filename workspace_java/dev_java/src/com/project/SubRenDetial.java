package com.project;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SubRenDetial extends JDialog implements ActionListener{
	private JLabel labelDetailnum;
	private JTextField txtDetailnum;
	private JLabel labelSerialnum;
	private JTextField txtSerialnum;
	private JLabel labelRnum;
	private JTextField txtRnum;
	
	JPanel jp_center = new JPanel();
	JPanel jp_south = new JPanel();
	JButton jbtn_save = new JButton("저장");
	JButton jbtn_cancel = new JButton("취소");
	String title = null;
	String u_rnum = null;
	RenDetail rDetail = null;
	RenDetailVO rdVO = null;
	
	public SubRenDetial() {
		initDisplay();
	}

	public void initDisplay() {
		jbtn_cancel.addActionListener(this);
		jbtn_save.addActionListener(this);
		jp_center.setLayout(null);
		labelRnum = new JLabel("대여번호");
		labelDetailnum = new JLabel("대여상세번호");
		labelSerialnum = new JLabel("DVD번호");
		txtRnum = new JTextField(20);
		txtDetailnum = new JTextField(20);
		txtSerialnum = new JTextField(20);
		
		labelRnum.setBounds(20, 20, 150, 20);
		txtRnum.setBounds(120, 20, 150, 20);
		labelDetailnum.setBounds(20, 50, 150, 20);
		txtDetailnum.setBounds(120, 50, 150, 20);
		labelSerialnum.setBounds(20, 80, 150, 20);
		txtSerialnum.setBounds(120, 80, 150, 20);
		// 컴포넌트 패널에 붙히기
		jp_center.add(labelRnum);
		jp_center.add(txtRnum);
		jp_center.add(labelDetailnum);
		jp_center.add(txtDetailnum);
		jp_center.add(labelSerialnum);
		jp_center.add(txtSerialnum);
		this.setLayout(new BorderLayout());
		jp_south.add(jbtn_save);
		jp_south.add(jbtn_cancel);
		this.add("South", jp_south);
		this.add("Center", jp_center);
		this.setSize(300, 380);
		this.setVisible(false);
	}
	////////화면에서 입력받은 값 혹은 화면에 출력한 값 처리 getter/setter ////////
	public String getRnum() {return txtRnum.getText(); }
	public void setRnum(String rnum) { txtRnum.setText(rnum); }
	public String getDetailnum() {return txtDetailnum.getText(); }
	public void setDetailnum(String dnum) { txtDetailnum.setText(dnum); }
	public String getSerialnum() {return txtSerialnum.getText(); }
	public void setSerialnum(String snum) { txtSerialnum.setText(snum); }

	public void set(RenDetailVO rdVO,String title,RenDetail rDetail, boolean isEdit,String u_rnum) {
		this.rdVO = rdVO;
		this.title = title;
		this.rDetail = rDetail;
		this.u_rnum = u_rnum;
		this.setValue();
		this.setTitle(title);
		this.setVisible(true);
		this.setEditable(isEdit);
	    if("수정".equals(title)) {
	    	txtRnum.setEditable(false);
	    } else if("상세조회".equals(title)) {
	    	txtRnum.setEditable(false);
	    }
	}
	public void setEditable(boolean isEdit) {
		txtDetailnum.setEditable(isEdit);
		txtSerialnum.setEditable(isEdit);
	}
	public void setValue() {
		if(rdVO==null) {
			setRnum(u_rnum);
			setSerialnum("");
			setDetailnum("");
			//대여번호는 외래키이고 그 키로인해 접근하는 것이기 때문에 수정불가처리
			txtRnum.setEditable(false);
		} else {
			setRnum(rdVO.getR_num());
			setSerialnum(rdVO.getSerialnum());
			setDetailnum(rdVO.getR_detailnum());
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj==jbtn_save) {
			if(rdVO == null) { //입력인경우
				try {
					System.out.println("저장버튼");
					RenDetailVO rdpaVO = new RenDetailVO();
					rdpaVO.setCommand("insert");
					rdpaVO.setR_num(getRnum());
					rdpaVO.setSerialnum(getSerialnum());
					rdpaVO.setR_detailnum(getDetailnum());
					RenDetailCtrl rdCtrl = new RenDetailCtrl();
					RenDetailVO rdraVO = rdCtrl.send(rdpaVO);
					if(rdraVO!=null ) {
						if(rdraVO.getStatus()==1) {
							JOptionPane.showMessageDialog(rDetail, "입력성공");
							this.dispose();
							rDetail.refreshData();
						} else {
							JOptionPane.showMessageDialog(rDetail, "입력실패");
							return;
						}
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			} else { //수정인경우
				try {
					RenDetailVO rdpaVO = new RenDetailVO();
					rdpaVO.setCommand("update");
					rdpaVO.setU_detailnum(rdVO.getR_detailnum());
					rdpaVO.setR_num(rdVO.getR_num());
					rdpaVO.setR_detailnum(getDetailnum());
					rdpaVO.setSerialnum(getSerialnum());
					RenDetailCtrl rdCtrl = new RenDetailCtrl();
					RenDetailVO rdraVO = rdCtrl.send(rdpaVO);
					if(rdraVO!=null) {
						if(rdraVO.getStatus()==1) {
							JOptionPane.showMessageDialog(this, "입력성공");
							this.dispose();
							rDetail.refreshData();
						} else {
							JOptionPane.showMessageDialog(this, "입력실패");
							return;
						}
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		} else if(obj==jbtn_cancel) {
			this.dispose();
		}
		
	}
}
