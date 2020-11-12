package com.mashibin.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Tank {
	private int x=5,y=5;
	private Dir dir = Dir.UP;
	private boolean moving = false;
	private TankFrame tf = null;
	public static final int TANK_WIDTH = ResourceManager.tankD.getWidth();
	public static final int TANK_HEIGHT = ResourceManager.tankD.getWidth();
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
		//g.fillRect(x, y, TANK_WIDTH, TANK_HEIGHT);
		switch(dir){
		case LEFT:
			g.drawImage(ResourceManager.tankL, x, y, null);
			break;
		case RIGHT:
			g.drawImage(ResourceManager.tankR, x, y, null);
			break;
		case DOWN:
			g.drawImage(ResourceManager.tankD, x, y, null);
			break;
		case UP:
			g.drawImage(ResourceManager.tankU, x, y, null);
			break;
		case LEFTDOWN:
			g.drawImage(ResourceManager.tankLD, x, y, null);
			break;
		case LEFTUP:
			g.drawImage(ResourceManager.tankLU, x, y, null);
			break;
		case RIGHTDOWN:
			g.drawImage(ResourceManager.tankRD, x, y, null);
			break;
		case RIGHTUP:
			g.drawImage(ResourceManager.tankRU, x, y, null);
			break;
		}
		g.setColor(c);
		move();
	}
	public void move(){
		if (!moving){
			return;
		}
		switch(dir){ //这里要加上另外4个方向，一共8个方向的移动，修改X,Y坐标，否则没法斜着走
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
		int bx = x+Tank.TANK_WIDTH/2-Bullet.WIDTH/2;
		int by = y+Tank.TANK_HEIGHT/2-Bullet.HEIGHT/2;
		tf.addBullet(new Bullet(this.tf,bx,by,this.dir));
	}

}
