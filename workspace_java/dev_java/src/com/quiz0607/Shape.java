package com.quiz0607;

public abstract class Shape {
int x;
int y;
	public abstract void draw();
	public void sentAnchor(int x, int y) {
		this.x=x;
		this.y=y;
	}
}
