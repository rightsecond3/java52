package com.chain;

public class ChainTest1 {
	
	public static void main(String[] args) {
		Block firstBlock = new Block("2000", "0"); //2000원 주문
		System.out.println("firstBlock : "+firstBlock.hash);
		
		Block secondBlock = new Block("3000", firstBlock.hash); //2000원 주문
		System.out.println("secondBlock : "+secondBlock.hash);
		
		Block thirdBlock = new Block("9000", secondBlock.hash); //2000원 주문
		System.out.println("thirdBlock : "+thirdBlock.hash);
		
	}
}
