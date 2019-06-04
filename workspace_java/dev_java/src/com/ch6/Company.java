package com.ch6;

public class Company {
	private static Company instance = new Company();//유일하게 생성된 인스턴스
	private Company() {}
	public static Company getInstance() {//객체타입변수
		if(instance==null) {//인스턴스가 비어있냐.->소명되었냐
			instance = new Company();
		}
		return instance;
	}
	public static void main(String[] args) {
		Company myCompany1 = Company.getInstance();
		Company myCompany2 = Company.getInstance();
		System.out.println(myCompany1==myCompany2);//true
	}

}
