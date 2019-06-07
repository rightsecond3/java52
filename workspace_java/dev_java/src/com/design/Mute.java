package com.design;

public class Mute implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("조용~~~~~");
	}

}
