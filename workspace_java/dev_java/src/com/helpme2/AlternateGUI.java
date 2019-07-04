package com.helpme2;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;

public class AlternateGUI {
   private JList people;
    private DefaultListModel dlm;
    private JLabel l1, l2, l3;
    private   JPanel p1, p2, p3;
    private JFrame alternateGUIFrame;
    private final static ImageIcon unavailableIcon = new ImageIcon("offline.png");

    public static void main(String[] args)
    {
        AlternateGUI ls = new AlternateGUI();
        ls.drawGui();
    }

    public AlternateGUI(){
        dlm = new DefaultListModel();
        people = new JList(dlm);

        alternateGUIFrame = new JFrame();

        JScrollPane peopleScroller = new JScrollPane(people, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        people.setCellRenderer(new CellRenderer());

        GroupLayout alternateGUILayout = new GroupLayout(alternateGUIFrame.getContentPane());
        alternateGUIFrame.getContentPane().setLayout(alternateGUILayout);

        alternateGUILayout.setAutoCreateGaps(true);
        alternateGUILayout.setAutoCreateContainerGaps(true);
        alternateGUILayout.setHorizontalGroup(alternateGUILayout.createSequentialGroup()
                .addComponent(peopleScroller));
        alternateGUILayout.setVerticalGroup(alternateGUILayout.createSequentialGroup()
                .addComponent(peopleScroller));
        }

    public void drawGui() {
        l1 = new JLabel("Hi", unavailableIcon , JLabel.LEFT);
        l2 = new JLabel("Hello", unavailableIcon , JLabel.LEFT);
        l3 = new JLabel("Bye", unavailableIcon , JLabel.LEFT);
        p1 = new JPanel();
        p1.setBackground(Color.black);
        p2 = new JPanel();
        p2.setBackground(Color.blue);
        p3 = new JPanel();
        p3.setBackground(Color.red);
        p1.add(l1);
        p2.add(l2);
        p3.add(l3);
        dlm.addElement(p1);
        dlm.addElement(p2);
        dlm.addElement(p3);
        alternateGUIFrame.pack();
        alternateGUIFrame.setSize(200,300);
        alternateGUIFrame.setVisible(true);
    }

    class CellRenderer implements ListCellRenderer
    {
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
        {
            Component com = (Component)value;
            return com;
        }
    }
}