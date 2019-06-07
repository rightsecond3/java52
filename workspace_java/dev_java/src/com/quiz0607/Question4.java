package com.quiz0607;

public class Question4 {
	private String country, name;
	public String getCountry() { return country; }
}

class Yen extends Question4{
//	public Stirng getCountry { return super.country; }
}

class Euro extends Question4 {
	public String getCountry(String timeZone) {
		return super.getCountry();
	}
}