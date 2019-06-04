package com.ch7;

import java.util.Random;

public class Test02 {
	int[] a = new int[5];
	int[] cnt = new int[10];
	public void Count() {
		for(int i=0; i<a.length; i++) {
			if(i==a[i]) {
				cnt[i]++;
			}
		}
	}
	
	public void arrayInIt(){
		Random r = new Random();
		for(int i=0; i<a.length; i++) {
			a[i] = r.nextInt(100);
		}
	}
	public void arrayPrint() {
		for(int i=0; i<a.length; i++) {
			System.out.println(a[i]);
			System.out.println(cnt[i]);
		}
	}
	public static void main(String[] args) {
		
	}
}
