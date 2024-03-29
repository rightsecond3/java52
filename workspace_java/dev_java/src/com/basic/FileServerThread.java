package com.basic;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class FileServerThread extends Thread {
	FileServer fserver = null;
	public FileServerThread(FileServer fserver) {
		this.fserver = fserver;
		try {
			fserver.jta_log.setCaretPosition(fserver.jta_log.getDocument().getLength());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		boolean isStop = false;
		try {
			InputStream in = null;
			FileOutputStream out = null;
			in = fserver.cSocket.getInputStream();
			DataInputStream din = new DataInputStream(in);
			while(!isStop) {
				int data = din.readInt();
				String filename = din.readUTF();
				System.out.println("클라에서 준 : "+filename);
				File file = new File("C:\\workspace_java\\dev_java\\src\\test\\"+filename);
				out = new FileOutputStream(file);
				
				int datas = data;
				byte[] buffer = new byte[1024];
				int len;
				
				for(;data>0;data--) {
					len = in.read(buffer);
					out.write(buffer,0,len);
				}
				System.out.println("약"+datas+"kbps");
				out.flush();
				out.close();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
