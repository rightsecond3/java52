package com.ch15;

import java.io.FileReader;
import java.io.FileWriter;

public class FileCopy {

	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader(".\\src\\com\\ch15\\scan.txt");//복제 할 파일
			fw = new FileWriter(".\\src\\com\\ch15\\scan_copy.txt");//복제본
			int data = 0;
			while((data=fr.read())!=-1) { //-1 : end of file, 끝까지 읽었다.
				fw.write(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(fw!=null) fw.close();
				if(fr!=null) fw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
