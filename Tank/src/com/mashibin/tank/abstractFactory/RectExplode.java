package com.mashibin.tank.abstractFactory;

import java.awt.Color;
import java.awt.Graphics;

import com.mashibin.tank.AudioThread;
import com.mashibin.tank.ResourceManager;
import com.mashibin.tank.TankFrame;

public class RectExplode extends BaseExplode{

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

	public RectExplode(TankFrame tf,int x, int y) {
		this.tf = tf;
		this.x = x;
		this.y = y;
		//只放一个声音，看能不能降低HEAP溢出的可能
		new Thread(new AudioThread("audio/explode.wav")).start();
		
/*		new Thread(new Runnable(){
			public void run(){
				new Audio("audio/explode.wav").play();
			}
		}).start();
	*/
	}
	@Override
	public void paint(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.RED);
		
/*		int bx = x+Tank.TANK_WIDTH/2-Bullet.WIDTH/2;
		int by = y+Tank.TANK_HEIGHT/2-Bullet.HEIGHT/2;*/
		
		for (int i=0;i<ResourceManager.rectexplosion.size();i++){
			g.drawImage(ResourceManager.rectexplosion.get(i), x, y, null);
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
