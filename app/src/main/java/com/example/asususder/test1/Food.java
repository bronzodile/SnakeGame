package com.example.asususder.test1;

import java.util.Random;
public class Food {

	private int width, height;
	private int foodX, foodY;
	
	public Food(int x, int y) {
		width = x;
		height = y; 
		foodX = -1;
		foodY = -1;
	}
	
	public void cook(){
		Random rn = new Random();
		foodX = rn.nextInt(width);
		foodY = rn.nextInt(height);
	}
	
	public int getX(){
		return foodX;
	}

	public int getY(){
		return foodY;
	}
	
	public boolean isFoodThere(int x, int y){
		if ((foodX == x) && (foodY == y))
			return true;
		return false;
	}
}