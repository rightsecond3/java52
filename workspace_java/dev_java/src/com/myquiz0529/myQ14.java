package com.myquiz0529;

public class myQ14 {
	 public String makinStrings() {
		 String s = "Fred";
		 s = s + "47";  //s=”Fred47” 
		 s = s.substring(2, 5);  //s=”ed4”  
		 s = s.toUpperCase();  //s=”ED4”
		 return s.toString();
		 }
	public static void main(String[] args) {
		myQ14 q14 = new myQ14();
		System.out.println(q14.makinStrings());
		
	}
}