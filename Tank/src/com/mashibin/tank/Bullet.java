package com.mashibin.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
	private  int x=0,y=0;
	private static final int SPEED = 20,WIDTH = 5,HEIGHT = 5;
	private Dir dir;
	public Bullet(int x, int y, Dir dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	public void paint(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(x, y, WIDTH, HEIGHT);
		g.setColor(c);
		move();
	}
	private void move() {
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
		}
		
	}
	

}
