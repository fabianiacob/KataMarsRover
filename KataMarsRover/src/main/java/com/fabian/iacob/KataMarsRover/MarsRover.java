package com.fabian.iacob.KataMarsRover;

public class MarsRover {
	private int x;
	private int y;
	private char direction;
	private boolean foundObstacle = false;
	private String commands;
	
	public boolean getFoundObstacle() {
		return foundObstacle;
	}
	public void setFoundObstacle(boolean obstacle) {
		this.foundObstacle = obstacle;
	}
	
	
	public String getCommands() {
		return commands;
	}
	public void setCommands(String commands) {
		this.commands = commands;
	}
	
	
	public MarsRover(int x, int y, char direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public char getDirection() {
		return direction;
	}
	public void setDirection(char direction) {
		this.direction = direction;
	}
	

}
