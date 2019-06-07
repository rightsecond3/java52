package com.design;

public class DuckSimulation {

	public static void main(String[] args) {
		Duck myDuck = new MallardDuck();
		myDuck.prefly();
		myDuck.preQuack();
		Duck rubberDuck = new RubberDuck();
		rubberDuck.prefly();
		rubberDuck.preQuack();
		Duck woodDuck = new WoodDuck();
		woodDuck.prefly();
		woodDuck.preQuack();
	}
}
