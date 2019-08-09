package com.helpme5;


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
