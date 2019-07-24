package com.basic;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;

public class WindowTest extends JDialog{
	public void init() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(200, 200);
		//사이즈를 주고 나서 위치를 지정해야 가로 세로 길이가 나온다
		int width = (int) (dim.getWidth()-this.getWidth());
		int height = (int) (dim.getHeight()-this.getHeight());
		this.setLocation(width, height);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		WindowTest wt = new WindowTest();
		wt.init();
	}
}