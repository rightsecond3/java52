package com.helpme5;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class ChangeFriNick extends JDialog implements ActionListener {
    JPanel jp_center = new JPanel();
      Login login = null;
      JTextField jtf_search = new JTextField(20){
         @Override
         public void setBorder(Border border) {
         }};
      JButton jbtn_search = new JButton(){
         @Override
         public void setBorder(Border border) {
         }
      };
      String imgPath = "C:\\workspace_java\\dev_java\\src\\images\\";
      String your_id = null;
      public ChangeFriNick(String your_id, Login login) {
        this.your_id = your_id;
        this.login = login;
         initDisplay();
      }
      public void initDisplay() {
            jbtn_search.addActionListener(this);
            ImageIcon img = new ImageIcon(imgPath + "search.png");
            Image originImg = img.getImage();
            Image changedImg = originImg.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            jbtn_search.setIcon(new ImageIcon(changedImg));
            jbtn_search.setBorderPainted(false);
            jbtn_search.setFocusPainted(false);
            jbtn_search.setContentAreaFilled(false);
            jp_center.setBackground(new Color(220, 220, 220));
            jp_center.add(jtf_search);
            jp_center.add(jbtn_search);
            this.add(jp_center);
            this.pack();
            this.setVisible(true);
      }
   @Override
   public void actionPerformed(ActionEvent e) {
       Object obj = e.getSource();
       if(obj==jbtn_search) {
           String change_nick = jtf_search.getText();
           String mem_id = login.mem_id;
           try {
            login.oos.writeObject(Protocol.FRIEND_CHANGE_NICK
                               +Protocol.seperator+mem_id
                               +Protocol.seperator+your_id
                               +Protocol.seperator+change_nick
                               );
            login.oos.writeObject(Protocol.FRIEND_LIST
                              +Protocol.seperator+login.mem_id
                            );
            this.dispose();
         } catch (Exception e2) {
            e2.printStackTrace();
         }
       }      
   }
}