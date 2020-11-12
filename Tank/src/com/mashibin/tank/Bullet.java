package com.mashibin.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet {
	private  int x=0,y=0;
	public static final int SPEED = 20,WIDTH = ResourceManager.missileRU.getWidth(),HEIGHT = ResourceManager.missileRU.getHeight();
	private Dir dir;
	private int ownerID;
	public int getOwnerID() {
		return ownerID;
	}
	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
	}
	private boolean bAlive = true;
	public boolean isbAlive() {
		return bAlive;
	}
	public void setbAlive(boolean bAlive) {
		this.bAlive = bAlive;
	}
	private TankFrame tf;
	public Bullet(int x, int y, Dir dir,int id) {
		this.ownerID = id;
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	public Bullet(TankFrame tf,int x, int y, Dir dir, int id) {
		this.ownerID = id;
		this.tf = tf;
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	public void paint(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.RED);
		switch(dir){
		case LEFT:
			g.drawImage(ResourceManager.missileL, x, y, null);
			break;
		case RIGHT:
			g.drawImage(ResourceManager.missileR, x, y, null);
			break;
		case DOWN:
			g.drawImage(ResourceManager.missileD, x, y, null);
			break;
		case UP:
			g.drawImage(ResourceManager.missileU, x, y, null);
			break;
		case LEFTDOWN:
			g.drawImage(ResourceManager.missileLD, x, y, null);
			break;
		case LEFTUP:
			g.drawImage(ResourceManager.missileLU, x, y, null);
			break;
		case RIGHTDOWN:
			g.drawImage(ResourceManager.missileRD, x, y, null);
			break;
		case RIGHTUP:
			g.drawImage(ResourceManager.missileRU, x, y, null);
			break;
		}
		
		g.setColor(c);
		move();
	}
	private void move() {
		switch(dir){ //这里要加上8个方向的移动,更改XY坐标
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
		if ((x<0) || (y<0) || (x>TankFrame.GAME_WIDTH) || (y> TankFrame.GAME_HEIGHT)){
			this.bAlive = false;
			tf.bulletList.remove(this);
		}
		
	}
	public void die(){
		this.bAlive = false;
		tf.bulletList.remove(this);
	}
	public void collidewithTank(Tank tank){
		Rectangle rect1 = new Rectangle(x,y,WIDTH,HEIGHT);
		Rectangle rect2 = new Rectangle(tank.getX(),tank.getY(),tank.TANK_WIDTH,tank.TANK_HEIGHT);
		if (rect1.intersects(rect2)){
			//我感觉这里还要产生一个爆炸
			
			this.die();
			tank.die();
		}
	}
}
