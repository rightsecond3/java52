package com.helpme5;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class ShowMessage extends JDialog {
       JLabel jlb_msg = new JLabel("새로운 메세지가 도착하였습니다.");
       public ShowMessage() {
    	   init();
       }
	   public void init() {
		      Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		      jlb_msg.setHorizontalAlignment(JLabel.CENTER);
		      this.setSize(250, 120);
		      //사이즈를 주고 나서 위치를 지정해야 가로 세로 길이가 나온다
		      int width = (int) (dim.getWidth()-this.getWidth());
		      int height = (int) (dim.getHeight()-this.getHeight());
		      this.setLocation(width, height-38);
		      this.setVisible(true);
		      this.add(jlb_msg);
		   }
//		   public static void main(String[] args) {
//			   ShowMessage wt = new ShowMessage();
//		      wt.init();
//		   }

}
