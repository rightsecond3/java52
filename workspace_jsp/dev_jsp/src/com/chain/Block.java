package com.chain;

import java.util.Date;

import com.util.Sha256Util;

public class Block {
	public String hash = null; //해쉬 값을 담을 변수
	public String previousHash = null; //이전 해쉬값을 담을 변수
	private String data = null; //블록에 저장할 데이터 - ex.금액
	//new Date().getTime();
	private long timeStamp = 0; //1970년1월1일부터 millisec단위로 숫자값
	
	public Block(String data, String previousHash) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		this.hash = calculateHash();
	}
	
	private String calculateHash() {
		String calculatehash = Sha256Util.applySha256(
				previousHash //이전 거래 내역을 확인할 수 있는 해쉬값
				+ Long.toString(timeStamp) // 채굴한 값이 겹치는 것을 방지
				+ data
				);
		return calculatehash;
	}
}
