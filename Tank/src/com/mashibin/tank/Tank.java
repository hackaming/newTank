package com.mashibin.tank;

import java.awt.Graphics;

public class Tank {
	public int x=0,y=0;
	public Dir dir = Dir.UP;
	public Dir getDir() {
		return dir;
	}
	public void setDir(Dir dir) {
		this.dir = dir;
	}
	private static final int  SPEED = 10;
	public Tank(int x, int y, Dir dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	public void paint(Graphics g) {
		g.fillRect(x, y, 50, 50);
		switch(dir){
		case LEFT:
			x-=SPEED;
			break;
		case RIGHT:
			x+=SPEED;
			break;
		case UP:
			y-=SPEED;
			break;
		case DOWN:
			y+=SPEED;
			break;
		case STOP:
			break;
		}
		
	}

}
