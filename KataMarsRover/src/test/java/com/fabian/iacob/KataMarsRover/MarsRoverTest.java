package com.fabian.iacob.KataMarsRover;

import org.junit.Assert;
import org.junit.Test;



public class MarsRoverTest {
	
	@Test
	public void testMarsRoverConfiguration()  {
		MarsRover mr = new MarsRover(2,2,'N');
		
		int x = mr.getX();
		int y = mr.getY();
		char direction = mr.getDirection();
		
		Assert.assertEquals(x, 2);
		Assert.assertEquals(y, 2);
		Assert.assertEquals(direction, 'N');
	}
	
	@Test
	public void testCharArray() {
		MarsRover mr = new MarsRover(2,2,'N');
		
		String commands = "ffrff";
		
		mr.setCommands(commands);
		
		Assert.assertEquals(commands, mr.getCommands());
	}
	
	@Test
	public void testForward() {
		MarsRover mr = new MarsRover(2,2,'N');
		
		Grid g = new Grid(100, 100);
		CommandsService cs = new CommandsService(g);
		
		cs.moveForward(mr);
		
		Assert.assertEquals(2, mr.getX());
		Assert.assertEquals(3, mr.getY());
		Assert.assertEquals('N', mr.getDirection());
	}
	
	@Test
	public void testBackward() {
		MarsRover mr = new MarsRover(2,2,'N');
		Grid g = new Grid(100, 100);
		CommandsService cs = new CommandsService(g);
		
		cs.moveBackward(mr);
		
		Assert.assertEquals(2, mr.getX());
		Assert.assertEquals(1, mr.getY());
		Assert.assertEquals('N', mr.getDirection());
	}
	
	@Test
	public void testRight() {
		MarsRover mr = new MarsRover(2,2,'N');
		Grid g = new Grid(100, 100);
		CommandsService cs = new CommandsService(g);
		
		cs.turnRight(mr);
		

		Assert.assertEquals('E', mr.getDirection());
	}
	
	@Test
	public void testLeft() {
		MarsRover mr = new MarsRover(2,2,'N');
		Grid g = new Grid(100, 100);
		CommandsService cs = new CommandsService(g);
		
		cs.turnLeft(mr);
		

		Assert.assertEquals('W', mr.getDirection());
	}
	
	@Test
	public void testCommands() {
		MarsRover mr = new MarsRover(0,0,'N');
		Grid g = new Grid(100, 100);
		CommandsService cs = new CommandsService(g);
		
		mr.setCommands("ffrff");
		
		cs.executeCommands(mr);
		

		Assert.assertEquals(2, mr.getX());
		Assert.assertEquals(2, mr.getY());
		Assert.assertEquals('E', mr.getDirection());
	}
	
	@Test
	public void testCommandsWithObstacles() {
		MarsRover mr = new MarsRover(0,0,'N');
		Grid g = new Grid(100, 100);
		
		int[][] obstacles = {{2,2},{50,5},{99,1}};
		
		g.setObstacles(obstacles);
		CommandsService cs = new CommandsService(g);
		
		mr.setCommands("ffrff");
		
		cs.executeCommands(mr);
		

		Assert.assertEquals(1, mr.getX());
		Assert.assertEquals(2, mr.getY());
		Assert.assertEquals('E', mr.getDirection());
	}

}
