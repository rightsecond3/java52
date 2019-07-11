package com.ch15;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

public class MyEditor extends JFrame {
	///선언부
	//컨테이너 객체 변수를 선언
	Container myCon = null;
	//입력용 텍스트 영역 작성
	JTextArea   jta_text = new JTextArea();
	JScrollPane jsp_text = new JScrollPane(jta_text
							,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
							,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JFileChooser jfc = new JFileChooser();
	//메뉴바 추가
	JMenuBar  jmb       = new JMenuBar();
	JMenu     jm_file   = new JMenu("File");
	JMenuItem jmi_new   = new JMenuItem("New");
	JMenuItem jmi_open  = new JMenuItem("Open");
	JMenuItem jmi_save  = new JMenuItem("Save");
	JMenuItem jmi_exit  = new JMenuItem("Exit");
	JMenu     jm_edit   = new JMenu("Edit");
	JMenuItem jmi_copy  = new JMenuItem("Copy");
	JMenuItem jmi_paste = new JMenuItem("Paste");
	JMenuItem jmi_cut   = new JMenuItem("Cut");
	String imgPath = ".//src//images//";
	// 툴바 추가하기 - 북쪽에 배치함.
	JToolBar jtb = new JToolBar();
	JButton jbtn_ins = new JButton();
	JButton jbtn_sel = new JButton();
	JButton jbtn_upd = new JButton();
	JButton jbtn_del = new JButton();
	//로컬PC의 file경로명을 모두 읽어온다.
	//getClass() : runtime 하는 클래스 - MyEditor
	URL imgURL = getClass().getResource("memo.png");
	//이미지 아이콘
	ImageIcon appIcon = new ImageIcon(imgURL);
	
	//* 생성자
	public MyEditor() {
		//System.out.println(imgURL);
	}
	
	//** 화면처리
	public void initDisplay() {
		jmi_cut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jta_text.cut();
			}
		});
		jmi_paste.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jta_text.paste();
			}
		});
		jmi_copy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jta_text.copy();
			}
		});
		// 버튼 이미지 처리
		jbtn_ins.setIcon(new ImageIcon(imgPath+"new.gif"));
		jbtn_sel.setIcon(new ImageIcon(imgPath+"detail.gif"));
		jbtn_upd.setIcon(new ImageIcon(imgPath+"update.gif"));
		jbtn_del.setIcon(new ImageIcon(imgPath+"delete.gif"));
		jtb.add(jbtn_ins);
		jtb.add(jbtn_sel);
		jtb.add(jbtn_upd);
		jtb.add(jbtn_del);
		jmi_save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//저장 대화 상자 오픈 - 내부클래스(익명)이기 때문에 this를 직접적으로 사용 불가능하다.
				int ret = jfc.showSaveDialog(MyEditor.this);
				if(ret == JFileChooser.APPROVE_OPTION) { //승인 되었을 때
					//파일 저장 처리 - OutputStream
					try {
						File myFile = jfc.getSelectedFile();//파일객체 생성
						PrintWriter pwriter = new PrintWriter
								(new BufferedWriter
										(new FileWriter
												(myFile.getAbsolutePath())));
						pwriter.write(jta_text.getText());//쓰기 -> 저장
						pwriter.close();
					} catch (Exception e2) {
					}
				}
			}
		});
		/*
		 * 익명 함수 - 내부클래스
		 * 자바스크립트 - 내부에 메소드나 변수선언 처리
		 * $("#dg").datagrid({프로그램 코딩부});
		 * ActionListener는 인터페이스 이다.->자신만으로 인스턴스화 불가->구현체클래스가 필요
		 * 캡챠, 네아로, 카카오, UI, Spring Boot
		 */
		jmi_open.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//열기 대화 상자 오픈
				int ret = jfc.showOpenDialog(MyEditor.this);
				//yes or ok 버튼 클릭 시
				if(ret == JFileChooser.APPROVE_OPTION) {
					//파일을 여는 처리
					try {
						//읽어들이기용 String - Gson, JsonObject, JsonArray
						String strLine;
						//파일명에 대한 객체 생성됨. - 내용은 담을 수 없다.(IO 필요)
						File myFile = jfc.getSelectedFile();
						//선택한 파일의 절대경로를 지정하여 BufferedReader 생성함.
						//BufferedReader - 보조
						BufferedReader br = new BufferedReader
								(new FileReader(myFile.getAbsolutePath()));
						//읽은 값을 텍스트 에어리어에서 뿌려줌
						jta_text.setText(br.readLine());
						//2행 부터 행 바꿈 처리 해주기
						while((strLine=br.readLine())!=null) {
							jta_text.append("\n"+strLine);
						}
						br.close();//사용한 리더 닫아주기
					} catch (IOException ioe) {
						ioe.printStackTrace();
					}
				}
			}
		});
		myCon = this.getContentPane();
		myCon.setLayout(new BorderLayout());
		jm_file.add(jmi_new);
		jm_file.add(jmi_open);
		jm_file.add(jmi_save);
		jm_file.add(jmi_exit);
		//Mnemonic - 해당 문자열에 밑줄, Alt+F 시 메뉴바 출력
		jm_file.setMnemonic('F');
		jmb.add(jm_file);
		jm_edit.add(jmi_copy);
		jm_edit.add(jmi_paste);
		jm_edit.add(jmi_cut);
		jm_edit.setMnemonic('E');
		jmb.add(jm_edit);
		jmb.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		this.setJMenuBar(jmb);
		myCon.add("North", jtb);
		myCon.add("Center",jsp_text);
		//Look & Feel 설정
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setIconImage(appIcon.getImage());
		this.setTitle("메모장");
		this.setSize(500,300);
		this.setVisible(true);
	}
	//메인메소드
	public static void main(String[] args) {
		MyEditor myEditor = new MyEditor();
		myEditor.initDisplay();
	}

}
