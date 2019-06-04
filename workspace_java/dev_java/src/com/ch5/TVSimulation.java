package com.ch5;

public class TVSimulation {

	public static void main(String[] args) {
		//선언만 했을 경우 생성자가 호출 되지 않는다
		//반드시 생성부가 있어야 한다.
		TV myTV = new TV();
		TV herTV = new TV();
		TV gnomTV = new TV();
		gnomTV.onoff=true;
		TV himTV = null;
		himTV = new TV(true);
		himTV.onoff = true;
		System.out.println("그의 TV는 현재 켜진 상태인가요? " + himTV.onoff);
	}

}
