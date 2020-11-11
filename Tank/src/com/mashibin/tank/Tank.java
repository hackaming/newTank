package com.mashibin.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Tank {
	private int x=0,y=0;
	private Dir dir = Dir.UP;
	private boolean moving = false;
	private TankFrame tf = null;
	public boolean isMoving() {
		return moving;
	}
	public void setMoving(boolean moving) {
		this.moving = moving;
	}
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
	public Tank(TankFrame tf,int x, int y, Dir dir) {
		this.tf = tf;
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, 50, 50);
		g.setColor(c);
		move();
	}
	public void move(){
		if (!moving){
			return;
		}
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
	public void fire() {
		Bullet b = new Bullet(x,y,this.dir);
		tf.addBullet(b);
	}

}
