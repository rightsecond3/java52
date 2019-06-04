package com.ch7;

import java.util.Random;

public class Test01 {
	int a[] = new int[10];
	public void orderBy() {
		int tmp = 0;
		for(int i=0;i<a.length;i++) {
			for(int j=i+1; j<a.length;j++) {
				if(a[i] > a[j]) {
					tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
				}
			}
		}
	}
	public void arrayIntit() {
		Random r = new Random();
		for(int i=0; i<a.length;i++) {
			a[i]=r.nextInt(21);
		}
	}
	public void arrayPrint() {
		for(int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}
	}
	public static void main(String[] args) {
		Test01 t1 = new Test01();
		t1.arrayIntit();
		t1.orderBy();
		t1.arrayPrint();
	}
}


