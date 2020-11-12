package com.mashibin.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Tank {
	private int x=5,y=5;
	private Dir dir = Dir.UP;
	private boolean moving = false;
	private TankFrame tf = null;
	private static final int TANK_WIDTH = 50;
	private static final int TANK_HEIGHT = 50;
	public TankFrame getTf() {
		return tf;
	}
	public void setTf(TankFrame tf) {
		this.tf = tf;
	}
	private boolean bGood = true;
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
	public Tank(TankFrame tf,int x, int y, Dir dir,boolean good) {
		this.tf = tf;
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.bGood = good;
	}
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, TANK_WIDTH, TANK_HEIGHT);
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
		tf.addBullet(new Bullet(this.tf,x+TANK_WIDTH/2,y+TANK_HEIGHT/2,this.dir));
	}

}
