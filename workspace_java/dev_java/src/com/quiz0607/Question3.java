package com.quiz0607;

public class Question3 {
	
	private String cardID;
	private Integer limit;
	public String ownerName;
	
	public void setCardInformation(String cardID, String ownerName, Integer limit) {
		this.cardID=cardID;
		this.ownerName=ownerName;
		this.limit=limit;
	}
}
