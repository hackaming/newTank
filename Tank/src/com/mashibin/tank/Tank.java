package com.mashibin.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.mashibin.tank.abstractFactory.BaseTank;

public class Tank extends BaseTank{
	private int x = 5, y = 5;

	Dir dir = Dir.UP;
	private boolean moving = false;
	public TankFrame tf = null;
	public static final int TANK_WIDTH = ResourceManager.goodTankD.getWidth();
	public static final int TANK_HEIGHT = ResourceManager.goodTankD.getWidth();
	boolean bGood = false;
	private boolean isLive = true;
	private static int tankIdBase = 1000;
	int id;
	private Random random = new Random();
	private int iRotate = 1; //用来循环显示两图坦克用
	private static final int SPEED = Integer.parseInt(PropertyManager_old_Works.getInstance().get("tankspeed").toString());
	private Rectangle rect;
	private FireStrategy fs;
	public Rectangle getRect() {
		return rect;
	}

	public void setRect(Rectangle rect) {
		this.rect = rect;
	}

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

	public void die() {
		this.isLive = false;
		tf.tkList.remove(this);
		System.out.println(bGood+" tank "+id+"is dead!");
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
	//好像这几段代码可以重构一下，没必要重写。没必要写两个构造
	public Tank(int x, int y, Dir dir, boolean bGood) {
		rect = new Rectangle(x,y,TANK_WIDTH,TANK_HEIGHT);
		this.bGood = bGood;
		this.id = tankIdBase++;
		this.x = x;
		this.y = y;
		this.dir = dir;
		System.out.println(id+"joined good or bad:"+bGood);
		if (bGood){
			System.out.println("position"+x+"and"+y);
		}
		
		//这里加入代码，从配置文件里面读类。
		if (bGood){
			String t = PropertyManager.INSTANCE.getString("goodTankStrategy");
			try {
				fs = (FireStrategy) Class.forName(t).newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			String t = PropertyManager.INSTANCE.getString("badTankStrategy");
			try {
				fs = (FireStrategy) Class.forName(t).newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Tank(TankFrame tf, int x, int y, Dir dir, boolean bGood) {
		this(x,y,dir,bGood);
		this.tf = tf;
	}
	@Override
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.YELLOW);
		// g.fillRect(x, y, TANK_WIDTH, TANK_HEIGHT);
		iRotate++;
		if ( iRotate > 5){ //每循环5次，就显示另外一辆，以此做出动画的效果，总共有两张图片
			iRotate = 0;
			switch (dir) {
			case LEFT:
				g.drawImage(bGood ? ResourceManager.goodTankL : ResourceManager.badTankL, x, y, null);
				break;
			case RIGHT:
				g.drawImage(bGood ? ResourceManager.goodTankR : ResourceManager.badTankR, x, y, null);
				break;
			case DOWN:
				g.drawImage(bGood ? ResourceManager.goodTankD : ResourceManager.badTankD, x, y, null);
				break;
			case UP:
				g.drawImage(bGood ? ResourceManager.goodTankU : ResourceManager.badTankU, x, y, null);
				break;
			case LEFTDOWN:
				g.drawImage(bGood ? ResourceManager.goodTankLD : ResourceManager.badTankLD, x, y, null);
				break;
			case LEFTUP:
				g.drawImage(bGood ? ResourceManager.goodTankLU : ResourceManager.badTankLU, x, y, null);
				break;
			case RIGHTDOWN:
				g.drawImage(bGood ? ResourceManager.goodTankRD : ResourceManager.badTankRD, x, y, null);
				break;
			case RIGHTUP:
				g.drawImage(bGood ? ResourceManager.goodTankRU : ResourceManager.badTankRU, x, y, null);
				break;
			}
		} else {
			switch (dir) {
			case LEFT:
				g.drawImage(bGood ? ResourceManager.goodTank00L : ResourceManager.badTank00L, x, y, null);
				break;
			case RIGHT:
				g.drawImage(bGood ? ResourceManager.goodTank00R : ResourceManager.badTank00R, x, y, null);
				break;
			case DOWN:
				g.drawImage(bGood ? ResourceManager.goodTank00D : ResourceManager.badTank00D, x, y, null);
				break;
			case UP:
				g.drawImage(bGood ? ResourceManager.goodTank00U : ResourceManager.badTank00U, x, y, null);
				break;
			case LEFTDOWN:
				g.drawImage(bGood ? ResourceManager.goodTank00LD : ResourceManager.badTank00LD, x, y, null);
				break;
			case LEFTUP:
				g.drawImage(bGood ? ResourceManager.goodTank00LU : ResourceManager.badTank00LU, x, y, null);
				break;
			case RIGHTDOWN:
				g.drawImage(bGood ? ResourceManager.goodTank00RD : ResourceManager.badTank00RD, x, y, null);
				break;
			case RIGHTUP:
				g.drawImage(bGood ? ResourceManager.goodTank00RU : ResourceManager.badTank00RU, x, y, null);
				break;
			}
		}
		g.setColor(c);
		move();
	}

	public void move() {
		if (!moving && isLive) {
			return;
		}
		switch (dir) { // 这里要加上另外4个方向，一共8个方向的移动，修改X,Y坐标，否则没法斜着走
		case LEFT:
			x -= SPEED;
			break;
		case RIGHT:
			x += SPEED;
			break;
		case UP:
			y -= SPEED;
			break;
		case DOWN:
			y += SPEED;
			break;
		case LEFTDOWN:
			x -= SPEED;
			y += SPEED;
			break;
		case LEFTUP:
			x -= SPEED;
			y -= SPEED;
			break;
		case RIGHTDOWN:
			x += SPEED;
			y += SPEED;
			break;
		case RIGHTUP:
			x += SPEED;
			y -= SPEED;
			break;
		}
		if ((x < 0) || (y < 0) || (x > TankFrame.GAME_WIDTH) || (y > TankFrame.GAME_HEIGHT)) {
		}
		if (x < 0) {
			x = TankFrame.GAME_WIDTH;
		}
		if (x > TankFrame.GAME_WIDTH) {
			x = 0;
		}
		if ((y < 0)) {
			y = TankFrame.GAME_HEIGHT;
		}
		if (y > TankFrame.GAME_HEIGHT) {
			y = 0;
		}
		if (random.nextInt(10) > 8 && !bGood) {
			fire();
		}
		RandomDir();
		rect.x = x;
		rect.y = y;
		if (bGood && isLive) {
			// 加入声音，这里要新建一个线程，等待它结束，自己的，活 着的才出声音，要不太吵了,这样写会堆泄露，必须要等上一个进程 结束了才能再放--BUG,同样的问题存在于其它几个地方
			new Thread(new AudioThread("audio/tank_move.wav")).start();
			
/*			new Thread(new Runnable() {
				public void run() {
					new Audio("audio/tank_move.wav").play();
				}
			}).start();*/
		}
	}

	private void RandomDir() {
		if (!bGood) {
			int x = random.nextInt(100);
			if (x > 95) {
				this.dir = Dir.values()[random.nextInt(4)];
			}
		}
	}
	
	public void fire() {
		fs.fire(this);
		/**
		 * 2020/11/18 :14:43下午
		 
		//把上面这行注掉，变成不要开火的策略模式了，改为直接NEW，这样改动小一点，后面还要改回来。
		int bx = this.getX() + Tank.TANK_WIDTH / 2 - Bullet.WIDTH / 2;
		int by = this.getY() + Tank.TANK_HEIGHT / 2 - Bullet.HEIGHT / 2;
		for (Dir dir:Dir.values()){
			//改为用抽象工厂产生子
			this.tf.gf.createBullet(this.tf, bx, by, dir, this.id);
			//new Bullet(t.tf, bx, by, dir, t.id);
		}
		//改为audio thread
		new Thread(new AudioThread("audio/tank_fire.wav")).start();
		//new Thread(()->new Audio("audio/tank_fire.wav").play()).start();*/
	}



}
