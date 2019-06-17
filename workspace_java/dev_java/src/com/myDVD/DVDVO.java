package com.myDVD;

public class DVDVO {
	private String dvd_serial   = null;
	private String dvd_genre    = null;
	private String dvd_class    = null;
	private String dvd_title    = null;
	private String dvd_maker    = null;
	public DVDVO() {}
	public DVDVO(String dvd_serial, String dvd_genre
			      , String dvd_class, String dvd_title) {
		this.dvd_serial = dvd_serial;
		this.dvd_genre  = dvd_genre;
		this.dvd_class  = dvd_class;
		this.dvd_title  = dvd_title;
	}
	public String getDvd_serial() {
		return dvd_serial;
	}
	public void setDvd_serial(String dvd_serial) {
		this.dvd_serial = dvd_serial;
	}
	public String getDvd_genre() {
		return dvd_genre;
	}
	public void setDvd_genre(String dvd_genre) {
		this.dvd_genre = dvd_genre;
	}
	public String getDvd_class() {
		return dvd_class;
	}
	public void setDvd_class(String dvd_class) {
		this.dvd_class = dvd_class;
	}
	public String getDvd_title() {
		return dvd_title;
	}
	public void setDvd_title(String dvd_title) {
		this.dvd_title = dvd_title;
	}	
	public String getDvd_maker() {
		return dvd_maker;
	}
	public void setDvd_maker(String dvd_maker) {
		this.dvd_maker = dvd_maker;
	}	
}
