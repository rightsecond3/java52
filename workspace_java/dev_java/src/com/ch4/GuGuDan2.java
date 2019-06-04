package com.ch4;

public class GuGuDan2 {

	public static void main(String[] args) {
		int i;
		int j=0;
		for(i=1;i<=9;i++) {
			for(j=2;j<=9;j++) {
				System.out.print(j+"X"+i+"="+i*j+"\t");
			}
			System.out.print("\n");
		}
	}
}
