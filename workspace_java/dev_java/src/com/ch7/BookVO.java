package com.ch7;
//도서에 대한 정보를 담을 수 있는 클래스임.
//쓰기와 읽기
public class BookVO {
	private String book_title = null;//도서명
	private int    book_price = 0;//도서가격
	private String book_author = null;//저자
	//생성자가 하나라도 있으면 제공안됨
	//제공되는 생성자는 디폴트 생성자뿐이다.
	public BookVO() {}//디폴트 생성자
	public BookVO(String book_title, int book_price, String book_author) {
		this.book_title = book_title;
		this.book_price = book_price;
		this.book_author= book_author;
	}
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public int getBook_price() {
		return book_price;
	}
	public void setBook_price(int book_price) {
		this.book_price = book_price;
	}
	public String getBook_author() {
		return book_author;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
}
