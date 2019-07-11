package com.fabian.iacob.KataMarsRover;

public class Grid {
	private int width;
	private int height;
	private int[][] obstacles;
	
	public Grid(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int[][] getObstacles() {
		return obstacles;
	}
	public void setObstacles(int[][] obstacles) {
		this.obstacles = obstacles;
	}

}
