package com.design;
//구현체 클래스
//Quack quack = new Quack();
//QuackBehavior qb = new Quack(); -> 다형성
//QuackBehavior qb = new Squeak(); -> 다형성
//QuackBehavior qb = new Mute(); -> 다형성
public class Quack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("꽥~꽥~~~~");
	}

}
