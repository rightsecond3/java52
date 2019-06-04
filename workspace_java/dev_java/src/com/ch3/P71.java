package com.ch3;

public class P71 {

	public static void main(String[] args) {
		int i = 1; // i=1
		int j = i++; //j=1, i=2
		if((i == j && (++i == j))) {
			i+=j;		
		}
		System.out.println("i= "+i);
	}

}
