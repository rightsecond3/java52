package com.mvc1;
/*
 * 표준 서블릿이 제공하는 메소드는 모두 리턴 타입이 void
 * 내가 설계 하는 클래스에서는 리턴 타입을 따로 설계하여 추가 하려고 함
 * execute 메소드의 리턴 타입을 ActionForward로 함
 * 
 */
public class ActionForward {
	private String viewName = null;
	//true이면 redirect, flase이면 forward
	private boolean isRedirect = false;
	
	public String getViewName() {
		return viewName;
	}
	public void setViewName(String viewName) {
		this.viewName = viewName;
	} 
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
}
