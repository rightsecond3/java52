package com.ch5;
class Param{
	int ival = 0;
}
public class TestParam {
	public void effectParam(Param p) {
		p=new Param();
		p.ival = 500; //effectParam의 새로운 p 생성
		System.out.println("effectParam"+p.ival);
		//insert here - sub ival = 500
	}
	public static void main(String[] args) {
		TestParam tp = new TestParam();
		Param p = new Param(); //main의 새로운 p 생성
		p.ival = 100;
		tp.effectParam(p);
		System.out.println("메인"+p.ival);
		//insert here = main ival = 100
	}
}
