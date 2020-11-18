package com.mashibin.tank.abstractFactory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.mashibin.tank.Dir;
import com.mashibin.tank.PropertyManager_old_Works;
import com.mashibin.tank.ResourceManager;
import com.mashibin.tank.Tank;
import com.mashibin.tank.TankFrame;

public class RectBullet extends BaseBullet{
	private  int x=0,y=0;
	public static final int SPEED = Integer.parseInt(PropertyManager_old_Works.getInstance().get("bulletspeed").toString()),WIDTH = ResourceManager.missileRU.getWidth(),HEIGHT = ResourceManager.missileRU.getHeight();
	private Dir dir;
	private int ownerID;
	Rectangle rect;
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
	public RectBullet(int x, int y, Dir dir,int id) {
		rect = new Rectangle(x,y,WIDTH,HEIGHT);
		this.ownerID = id;
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	public RectBullet(TankFrame tf,int x, int y, Dir dir, int id) {
		rect = new Rectangle(x,y,WIDTH,HEIGHT);
		this.ownerID = id;
		this.tf = tf;
		this.x = x;
		this.y = y;
		this.dir = dir;
		tf.bulletList.add(this);
	}
	@Override
	public void paint(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillRect(x, y, 20, 20);
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
		case LEFTDOWN:
			x-=SPEED;y+=SPEED;
			break;
		case LEFTUP:
			x-=SPEED;y-=SPEED;
			break;
		case RIGHTDOWN:
			x+=SPEED;y+=SPEED;
			break;
		case RIGHTUP:
			x+=SPEED;y-=SPEED;
			break;
		}
		rect.x = x;
		rect.y = y;
		
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
		if (this.rect.intersects(tank.getRect())){
			//我感觉这里还要产生一个爆炸
			this.die();
			tank.die();
			//通过抽象工厂创建一个爆炸
			tf.explodeList.add(tf.gf.createExplode(tf, tank.getX(), tank.getY()));
		}
	}
}
