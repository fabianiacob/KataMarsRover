package com.fabian.iacob.KataMarsRover;

import java.util.Arrays;

public class CommandsService {
	private Grid grid;

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	public CommandsService(Grid grid) {
		this.grid = grid;
	}
	
	public void moveForward(MarsRover mr) {
		switch(mr.getDirection()) {
		case('N'):
			move(mr.getX(), (mr.getY()+1)%grid.getHeight(), mr);
			break;
		case('S'):
			int newY = mr.getY()-1;
			if(newY < 0)
				newY = grid.getHeight()+newY;
			move(mr.getX(), newY, mr);
			break;
		case('E'):
			move((mr.getX()+1)%grid.getWidth(), mr.getY(), mr);
			break;
		case('W'):
			int newX = mr.getX()-1;
			if(newX < 0)
				newY = grid.getHeight()+newX;
			move(newX, mr.getY(), mr);
			break;
		}
	}
	
	public void moveBackward(MarsRover mr) {
		switch(mr.getDirection()) {
		case('S'):
			move(mr.getX(), (mr.getY()+1)%grid.getHeight(), mr);
			break;
		case('N'):
			int newY = mr.getY()-1;
			if(newY < 0)
				newY = grid.getHeight()+newY;
			move(mr.getX(), newY, mr);
			break;
		case('W'):
			move((mr.getX()+1)%grid.getWidth(), mr.getY(), mr);
			break;
		case('E'):
			int newX = mr.getX()-1;
			if(newX < 0)
				newY = grid.getHeight()+newX;
			move(newX, mr.getY(), mr);
			break;
		}
	}
	
	public void move(int x, int y, MarsRover mr) {
		if(checkObstacle(x,y)) {
			System.out.println("Obstaculo encontrado en (" + x + ", " + y + ")");
			mr.setFoundObstacle(true);
			return;
		}
		mr.setX(x);
		mr.setY(y);
		
		
			
	}
	
	public void turnRight(MarsRover mr) {
		switch(mr.getDirection()) {
		case('N'):
			mr.setDirection('E');
			break;
		case('E'):
			mr.setDirection('S');
			break;
		case('S'):
			mr.setDirection('W');
			break;
		case('W'):
			mr.setDirection('N');
			break;
			
		}
	}
	
	public void turnLeft(MarsRover mr) {
		switch(mr.getDirection()) {
		case('N'):
			mr.setDirection('W');
			break;
		case('W'):
			mr.setDirection('S');
			break;
		case('S'):
			mr.setDirection('E');
			break;
		case('E'):
			mr.setDirection('N');
			break;
			
		}
	}
	
	public void executeCommands(MarsRover mr) {
		for(int i = 0; !mr.getFoundObstacle() && i < mr.getCommands().length(); i++) {
			switch(mr.getCommands().charAt(i)) {
			case('f'):
				moveForward(mr);
				break;
			case('b'):
				moveBackward(mr);
				break;
			case('r'):
				turnRight(mr);
				break;
			case('l'):
				turnLeft(mr);
				break;
			}
		}
	}
	
	public boolean checkObstacle(int x, int y) {
		if(grid.getObstacles() != null) {
			for(int[] obstacle : grid.getObstacles()) {
				if(x == obstacle[0] && y == obstacle[1])
					return true;
			}
		}
		return false;
	}
	
	

}
