package com.mashibin.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
	private  int x=0,y=0;
	private static final int SPEED = 20,WIDTH = 5,HEIGHT = 5;
	private Dir dir;
	private boolean bAlive = true;
	public boolean isbAlive() {
		return bAlive;
	}
	public void setbAlive(boolean bAlive) {
		this.bAlive = bAlive;
	}
	private TankFrame tf;
	public Bullet(int x, int y, Dir dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	public Bullet(TankFrame tf,int x, int y, Dir dir) {
		this.tf = tf;
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
		if ((x<0) || (y<0) || (x>TankFrame.GAME_WIDTH) || (y> TankFrame.GAME_HEIGHT)){
			this.bAlive = false;
			tf.bulletList.remove(this);
/*			System.out.println("x:"+x+"y:"+y+"TankFrame.Height"+TankFrame.HEIGHT);
			System.out.println(x<0);
			System.out.println(y<0);
			System.out.println(x>TankFrame.GAME_WIDTH);
			System.out.println(y> TankFrame.HEIGHT);*/
		}
		
	}
	

}
