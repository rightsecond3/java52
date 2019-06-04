package com.ch7;

public class BookVOSimulation {
	public static void main(String[] args) {
		BookVO bVO = new BookVO(); //책을 한권만 담을 수 있다
		//방이 3개, 그안에 있는건 - null
		BookVO[] bVOS = new BookVO[3]; //객체배열 선언
		for(BookVO bVO2:bVOS) {
			System.out.println(bVO2);
		}
		for(int i=0; i<bVOS.length; i++) {
			System.out.println(bVOS[i]);
		}
		System.out.println(bVOS);//배열의 주소지가 나온다
//		String book_title=bVOS[0].getBook_title();
//		System.out.println(book_title);
		
		bVOS[0] = new BookVO();
		bVOS[0].setBook_title("자바의 정석");
		bVOS[0].setBook_price(35000);
		bVOS[0].setBook_author("장원형");
		
		bVOS[1] = new BookVO();
		bVOS[1].setBook_title("오라클 11g");
		bVOS[1].setBook_price(40000);
		bVOS[1].setBook_author("박상범");

		if(bVOS[0]!=null) {
			System.out.println(bVOS[0].getBook_title()+
					bVOS[0].getBook_price()+bVOS[0].getBook_author());
		}else {
			System.out.println("bVOS[0]안에 객체가 생성되지 않았음");
		}
		System.out.println(bVOS[1].getBook_title()+
				bVOS[1].getBook_price()+bVOS[1].getBook_author());
	}

}
