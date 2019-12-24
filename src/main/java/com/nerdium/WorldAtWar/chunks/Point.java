package com.nerdium.WorldAtWar.chunks;

public class Point {
	private int x;
	private int y;
	
	public Point() {
		setPos(0, 0);
	}
	
	public Point(int x, int y) {
		setPos(x, y);
	}
	
	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
