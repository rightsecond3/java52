package com.design;
//추상클래스
public abstract class Duck {
	int leg;
	FlyBehavior flyBehavior = null;
	QuackBehavior quackBehavior = null;
	public Duck() {
		
	}
	public void prefly() {
		flyBehavior.fly();
	}
	public void preQuack() {
		quackBehavior.quack();
	}
	public abstract void display(); 
	public void swimming() {
		System.out.println("모든 오리는 물에 뜹니다.");
	}
}
