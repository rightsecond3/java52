package com.ch15;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ViewURL {
	ViewURL(String url) {
		URL myURL = null;
		URLConnection myCon = null;
		InputStream is = null;//추상클래스
		BufferedReader br = null;//필터 스트림 클래스
		String data = null;
		String headerType = null;
		try {
			myURL = new URL(url);
			myCon = myURL.openConnection();
			myCon.connect();//연결됨
			headerType = myCon.getContentType();
			is = myCon.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);//읽기
			br = new BufferedReader(isr);//쓰기
			while((data=br.readLine())!=null) {
				System.out.println(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ViewURL("http://192.168.0.211:8000/google/multiMarkergoogleMap.html");
	}

}
