package com.example.asususder.test1;

public class Segment {
	public int x;
	public int y;
	public int direction;
	

	public Segment(int x, int y){
		this.x = x;
		this.y = y;
		this.direction = 1;
	}
	public String toString() {
		return ("x = " + x + ", y = " + y + ";" + "direction = " + direction);
	}
}