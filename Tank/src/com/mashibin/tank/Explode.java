package com.mashibin.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Explode {
	private  int x=0,y=0;
	public static final int WIDTH = ResourceManager.explosion.get(0).getWidth(),HEIGHT = ResourceManager.explosion.get(0).getHeight();


	private boolean bAlive = true;
	public boolean isbAlive() {
		return bAlive;
	}
	public void setbAlive(boolean bAlive) {
		this.bAlive = bAlive;
	}
	private TankFrame tf;
	public Explode(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Explode(TankFrame tf,int x, int y) {
		this.tf = tf;
		this.x = x;
		this.y = y;
	}
	public void paint(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.RED);
		
/*		int bx = x+Tank.TANK_WIDTH/2-Bullet.WIDTH/2;
		int by = y+Tank.TANK_HEIGHT/2-Bullet.HEIGHT/2;*/
		
		for (int i=0;i<ResourceManager.explosion.size();i++){
			g.drawImage(ResourceManager.explosion.get(i), x, y, null);
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		g.setColor(c);
	}
}
