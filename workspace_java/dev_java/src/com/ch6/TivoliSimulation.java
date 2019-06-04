package com.ch6;
class Tivoli{
	String carName = null;
	Tivoli() {}
	Tivoli(String carName){
		this.carName = carName;
	}
}

public class TivoliSimulation {
	Tivoli methodA() {
		return new Tivoli();
	}
	void methodB(Tivoli herCar) {
		herCar.carName = "2020년형 티볼리";
	}
	public static void main(String[] args) {
		TivoliSimulation ts = new TivoliSimulation();
		Tivoli myCar = ts.methodA();
		myCar.carName = "2019년형 티볼리";
		System.out.println(myCar.carName);
	}
}
