package com.basic;


public class FileClientThread extends Thread {
	FileClient fClient = null;
	
	public FileClientThread(FileClient fileClient) {
		this.fClient = fileClient;
	}
	
	@Override
	public void run() {
		String msg = null;
		boolean isStop = false;
		while(!isStop) {
			try {
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
