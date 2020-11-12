package com.mashibin.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Tank {
	private int x=5,y=5;
	
	private Dir dir = Dir.UP;
	private boolean moving = false;
	private TankFrame tf = null;
	public static final int TANK_WIDTH = ResourceManager.tankD.getWidth();
	public static final int TANK_HEIGHT = ResourceManager.tankD.getWidth();
	private boolean bGood = false;
	private boolean isLive = true;
	private static int tankIdBase = 1000;
	private int id;
	private Random random = new Random();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isLive() {
		return isLive;
	}
	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}
	public TankFrame getTf() {
		return tf;
	}
	public void setTf(TankFrame tf) {
		this.tf = tf;
	}
	public void die(){
		this.isLive = false;
		tf.tkList.remove(this);
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
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
	public Tank(int x, int y, Dir dir,boolean bGood) {
		this.bGood = bGood;
		this.id =tankIdBase ++;
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	public Tank(TankFrame tf,int x, int y, Dir dir,boolean bGood) {
		this.bGood = bGood;
		this.id =tankIdBase ++;
		this.tf = tf;
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	public Tank(TankFrame tf,int x, int y, Dir dir,boolean good,boolean bGood){
		this.bGood = bGood;
		this.id =tankIdBase ++;
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
		if ((x<0) || (y<0) || (x>TankFrame.GAME_WIDTH) || (y> TankFrame.GAME_HEIGHT)){
		}
		if (x<0){
			x = TankFrame.GAME_WIDTH;
		}
		if (x>TankFrame.GAME_WIDTH){
			x = 0;
		}
		if ((y<0)){
			y=TankFrame.GAME_HEIGHT;
		}
		if (y>TankFrame.GAME_HEIGHT){
			y=0;
		}
		if (random.nextInt(10)>8 && !bGood){
			fire();
		}
	}
	public void fire() {
		int bx = x+Tank.TANK_WIDTH/2-Bullet.WIDTH/2;
		int by = y+Tank.TANK_HEIGHT/2-Bullet.HEIGHT/2;
		tf.addBullet(new Bullet(this.tf,bx,by,this.dir,this.id));
	}

}
