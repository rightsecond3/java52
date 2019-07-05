package com.network;

import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
/*
 * TimeClientVer2는 스레드가 필요하지 않아요
 * 왜냐하면 클라리언트는 서버를 개설할 필요가 없다.
 */
public class TimeClientVer2 extends JFrame {
	Socket client = null;//내가 필요한 소켓정보 하나만 가지고있다.
	//AddressBook에 생성한 jlb_time에 시간정보를 출력해야하니까
	//인스턴스화 하지 않고 AddressBook에서 원본 주소번지를 받아옴
	JLabel jlb_time = null;
	
	public TimeClientVer2() {}
	public TimeClientVer2(JLabel jlb_time) {
		this.jlb_time = jlb_time;
	}
	public void initDisplay() {
		this.add("North",jlb_time);
		this.setTitle("내 단말기");
		this.setSize(500, 400);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		TimeClientVer2 tc2 = new TimeClientVer2();
		try {
			tc2.client = new Socket("192.168.0.211",3000);
			ClientThread ct = new ClientThread(tc2);
			ct.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}