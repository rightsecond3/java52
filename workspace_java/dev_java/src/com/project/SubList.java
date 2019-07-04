package com.project;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class SubList extends JDialog implements ActionListener{
   
   private JLabel labelserialnum;// 아이디 라벨
   private JTextField txtserialnum;// 아이디를 입력하는 컴포넌트
   private JLabel labelgenre;// 이름라벨
   private JTextField txtgenre;// 이름을 입력하는 컴포넌트
   private JLabel labelmov_class;
   private JTextField txtmov_class;
   private JLabel labelmov_title;
   private JTextField txtmov_title;
   private JLabel labelmaker;
   private JTextField txtmaker;
   private JLabel labelnation;
   private JTextField txtnation;
   private JLabel labelactor;
   private JTextField txtactor;
   private JLabel labeldirector;
   private JTextField txtdirector;
   private JLabel labelmov_date;
   private JTextField txtmov_date;
   private JLabel labelv_date;
   private JTextField txtv_date;
   private JLabel labeldamage;
   private JTextField txtdamage;
   private JLabel labelr_check;
   private JTextField txtr_check;
   private JLabel labelr_fee;
   private JTextField txtr_fee;
   
   Font font = new Font("돋움체", Font.PLAIN, 14);
   JPanel jp_center = new JPanel();//입력에 필요한 화면을 배치(좌표값 배치)
   JPanel jp_south = new JPanel();
   JButton jbtn_save = new JButton("저장");
   JButton jbtn_cancel = new JButton("취소");
   String title = null;
   
   ListDVD dList = null;
   JScrollPane jsp_line = new JScrollPane(jp_center);
   ListVO lVO = null;
   
   public SubList() {
      initDisplay();
   }

   public void initDisplay() {
      jp_center.setLayout(null);
      
      labelserialnum = new JLabel("시리얼넘버 ");
      labelgenre     = new JLabel("장르 ");
      labelmov_class = new JLabel("영화등급 ");
      labelmov_title = new JLabel("영화제목 ");
      labelmaker     = new JLabel("제작사 ");
      labelnation    = new JLabel("제작국가 ");
      labelactor     = new JLabel("주연배우 ");
      labeldirector  = new JLabel("영화감독 ");
      labelmov_date  = new JLabel("개봉일자 ");
      labelv_date    = new JLabel("비디오출시일 ");
      labeldamage    = new JLabel("파손여부 ");
      labelr_check   = new JLabel("대여여부 ");
      labelr_fee     = new JLabel("대여료 ");
      
      
      txtserialnum = new JTextField(20);
      txtgenre     = new JTextField(20);
      txtmov_class = new JTextField(20);
      txtmov_title = new JTextField(20);
      txtmaker     = new JTextField(20);
      txtnation    = new JTextField(20);
      txtactor     = new JTextField(20);
      txtdirector  = new JTextField(20);
      txtmov_date  = new JTextField(20);
      txtv_date    = new JTextField(20);
      txtdamage    = new JTextField(20);
      txtr_check   = new JTextField(20);
      txtr_fee     = new JTextField(20);
   
      
      labelserialnum.setBounds(20,20, 150,20);
      txtserialnum.setBounds(120,20, 150,20);  
      labelgenre.setBounds(20,45, 150,20);    
      txtgenre.setBounds(120,45, 150,20);      
      labelmov_class.setBounds(20,70, 150,20);
      txtmov_class.setBounds(120,70, 150,20);  
      labelmov_title.setBounds(20,95, 150,20);
      txtmov_title.setBounds(120,95, 150,20);  
      labelmaker.setBounds(20,120, 150,20);    
      txtmaker.setBounds(120,120, 150,20);      
      labelnation.setBounds(20,145, 150,20);   
      txtnation.setBounds(120,145, 150,20);     
      labelactor.setBounds(20,170, 150,20);    
      txtactor.setBounds(120,170, 150,20);      
      labeldirector.setBounds(20,195, 150,20); 
      txtdirector.setBounds(120,195, 150,20);   
      labelmov_date.setBounds(20,220, 150,20);
      txtmov_date.setBounds(120,220, 150,20);   
      labelv_date.setBounds(20,245, 150,20);   
      txtv_date.setBounds(120,245, 150,20);     
      labeldamage.setBounds(20,270, 150,20);   
      txtdamage.setBounds(120,270, 150,20);     
      labelr_check.setBounds(20,295, 150,20);  
      txtr_check.setBounds(120,295, 150,20);    
      labelr_fee.setBounds(20,320, 150,20);    
      txtr_fee.setBounds(120,320, 150,20);      
      
      
      jp_center.add (labelserialnum );
      jp_center.add (txtserialnum   );
      jp_center.add (labelgenre     );
      jp_center.add (txtgenre       );
      jp_center.add (labelmov_class );
      jp_center.add (txtmov_class   );
      jp_center.add (labelmov_title );
      jp_center.add (txtmov_title   );
      jp_center.add (labelmaker     );
      jp_center.add (txtmaker       );
      jp_center.add (labelnation    );
      jp_center.add (txtnation      );
      jp_center.add (labelactor     );
      jp_center.add (txtactor       );
      jp_center.add (labeldirector  );
      jp_center.add (txtdirector    );
      jp_center.add (labelmov_date  );
      jp_center.add (txtmov_date    );
      jp_center.add (labelv_date    );
      jp_center.add (txtv_date      );
      jp_center.add (labeldamage    );
      jp_center.add (txtdamage      );
      jp_center.add (labelr_check   );
      jp_center.add (txtr_check     );
      jp_center.add (labelr_fee     );
      jp_center.add (txtr_fee       );
      
      
      jbtn_save.addActionListener(this);
      jbtn_cancel.addActionListener(this);
      this.setLayout(new BorderLayout());
      jp_south.add(jbtn_save);
      jp_south.add(jbtn_cancel);
      this.add("South", jp_south);
      this.add("Center",jsp_line);
      this.setSize(325, 450);
      this.setVisible(false);
   }
 
   @Override
   public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==jbtn_save) {
			if(lVO == null) {//입력인경우
				try {
					ListVO paVO = new ListVO();
					paVO.setCommand("insert");
					paVO.setSerialnum(getSerialnum());
					paVO.setGenre(getGenre());
					paVO.setMov_class(getMov_class());
					paVO.setMov_title(getMov_title());
					paVO.setMaker(getMaker());
					paVO.setNation(getNation());
					paVO.setLeadingactor(getActor());
					paVO.setDirector(getDirector());
					paVO.setMov_date(getMov_date());
					paVO.setV_date(getV_date());
					paVO.setDamage(getDamage());
					paVO.setR_check(getR_check());
					paVO.setR_fee(getR_fee());
					ListCtrl lCtrl = new ListCtrl();
					ListVO raVO = lCtrl.send(paVO);
					if(raVO!=null) {
						if(raVO.getStatus()==1) {
							JOptionPane.showMessageDialog(dList, "입력성공");
							this.dispose();
							dList.refreshData();
						} else {
							JOptionPane.showMessageDialog(dList, "입력실패");
							return;
						}
					}
				} catch (Exception e2) {
				}
			} else {//수정인 경우
				try {
					ListVO paVO = new ListVO();
					paVO.setCommand("update");
					paVO.setSerialnum(lVO.getSerialnum());
					paVO.setGenre(getGenre());
					paVO.setMov_class(getMov_class());
					paVO.setMov_title(getMov_title());
					paVO.setMaker(getMaker());
					paVO.setNation(getNation());
					paVO.setLeadingactor(getActor());
					paVO.setDirector(getDirector());
					paVO.setMov_date(getMov_date());
					paVO.setV_date(getV_date());
					paVO.setDamage(getDamage());
					paVO.setR_check(getR_check());
					paVO.setR_fee(getR_fee());
					ListCtrl lCtrl = new ListCtrl();
					ListVO raVO = lCtrl.send(paVO);
					if(raVO!=null) {
						if(raVO.getStatus()==1) {
							JOptionPane.showMessageDialog(dList, "입력성공");
							this.dispose();
							dList.refreshData();
						} else {
							JOptionPane.showMessageDialog(dList, "입력실패");
							return;
						}
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		if(obj==jbtn_cancel) {
			this.dispose();
		}
	}


   public void setValue() {
	   //입력일 때
		if(lVO==null) {
		   //JOptionPane.showMessageDialog(aBook,"aVO:"+aVO.getId());
		   setSerialnum("");
		   setGenre("");    
		   setMov_class("");
		   setMov_title("");
		   setMaker("");    
		   setNation("");   
		   setActor("");    
		   setDirector(""); 
		   setMov_date(""); 
		   setV_date("");   
		   setDamage("");   
		   setR_check("");  
		   setR_fee(0);    
		}
		//상세조회나 수정시는 aVO에 있는 값으로 각 컴포넌트(txtId, txtName...를 초기화 한다.)
		else {
		   //JOptionPane.showMessageDialog(aBook,"aVO:"+aVO.getId());
		   setSerialnum(lVO.getSerialnum());
		   setGenre(lVO.getGenre());    
		   setMov_class(lVO.getMov_class());
		   setMov_title(lVO.getMov_title());
		   setMaker(lVO.getMaker());    
		   setNation(lVO.getNation());   
		   setActor(lVO.getLeadingactor());    
		   setDirector(lVO.getDirector()); 
		   setMov_date(lVO.getMov_date()); 
		   setV_date(lVO.getV_date());   
		   setDamage(lVO.getDamage());   
		   setR_check(lVO.getR_check());  
		   setR_fee(lVO.getR_fee());
		}
   }
   //////////////////get set//////////////////
   public void setR_fee(int fee) {txtr_fee.setText(String.valueOf(fee));}
   public int getR_fee() {return Integer.parseInt(txtr_fee.getText());}
   public void setR_check(String check) {txtr_check.setText(check);}
   public String getR_check() {return txtr_check.getText();}
   public void setDamage(String damage) {txtdamage.setText(damage);}
   public String getDamage() {return txtdamage.getText();}
   public void setV_date(String vdate) {txtv_date.setText(vdate);}
   public String getV_date() {return txtv_date.getText();}
   public void setMov_date(String mdate) {txtmov_date.setText(mdate);}
   public String getMov_date() {return txtmov_date.getText();}
   public void setDirector(String direc) {txtdirector.setText(direc);}
   public String getDirector() {return txtdirector.getText();}
   public void setActor(String actor) {txtactor.setText(actor);}
   public String getActor() {return txtactor.getText();}
   public void setNation(String nation) {txtnation.setText(nation);}
   public String getNation() {return txtnation.getText();}
   public void setMaker(String maker) {txtmaker.setText(maker);}
   public String getMaker() {return txtmaker.getText();}
   public void setMov_title(String mtitle) {txtmov_title.setText(mtitle);}
   public String getMov_title() {return txtmov_title.getText();}
   public void setMov_class(String mclass) {txtmov_class.setText(mclass);}
   public String getMov_class() {return txtmov_class.getText();}
   public void setGenre(String genre) {txtgenre.setText(genre);}
   public String getGenre() {return txtgenre.getText();}
   public void setSerialnum(String serial) {txtserialnum.setText(serial);}
   public String getSerialnum() {return txtserialnum.getText();}
   
   public void set(ListVO lVO,String title, ListDVD dList, boolean isEdit) {
	      this.lVO = lVO;
	      this.title = title;
	      this.dList = dList;
	      this.setValue();
	      this.setTitle(title);
	      this.setVisible(true);
	      this.setEditable(isEdit);
	      if("수정".equals(title)) {
	          txtserialnum.setEditable(false);
	       }
   }
   public void setEditable(boolean isEdit) {
       txtserialnum.setEditable(isEdit);
       txtgenre.setEditable(isEdit);    
       txtmov_class.setEditable(isEdit);
       txtmov_title.setEditable(isEdit);
       txtmaker.setEditable(isEdit);    
       txtnation.setEditable(isEdit);   
       txtactor.setEditable(isEdit);    
       txtdirector.setEditable(isEdit); 
       txtmov_date.setEditable(isEdit); 
       txtv_date.setEditable(isEdit);   
       txtdamage.setEditable(isEdit);   
       txtr_check.setEditable(isEdit);  
       txtr_fee.setEditable(isEdit);    
   }
}
