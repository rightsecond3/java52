package com.basic;

public class Car {
	Wheel wheel = new Wheel();
	Sonata s = new Sonata();
	int x =0;
	public void run() {
		s.execute(wheel);
		System.out.println(wheel.getWheel());
	}
	public void x() {
		s.x(x);
		System.out.println(x);
	}
	public static void main(String[] args) {
		Car c = new Car();
		c.run();
		c.x();
	}

}