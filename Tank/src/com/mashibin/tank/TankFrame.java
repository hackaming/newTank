package com.mashibin.tank;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.mashibin.tank.abstractFactory.BaseBullet;
import com.mashibin.tank.abstractFactory.BaseExplode;
import com.mashibin.tank.abstractFactory.DefaultFactory;
import com.mashibin.tank.abstractFactory.GameFactory;
import com.mashibin.tank.abstractFactory.RectFactory;

public class TankFrame extends Frame {
	public List<Tank> tkList = new ArrayList<Tank>();
	public List<BaseBullet> bulletList = new ArrayList<>();
	public List<BaseExplode> explodeList = new ArrayList<>();
	public GameFactory gf = RectFactory.getInstance();
	private Tank myTank = null;
	public static int GAME_WIDTH;
	public static int GAME_HEIGHT;
	private Random random = new Random();
	private boolean stopGame = false;
	
	
	public TankFrame(int w,int h) {
		this.GAME_WIDTH = w;
		this.GAME_HEIGHT = h;
		setSize(GAME_WIDTH, GAME_HEIGHT);
		setResizable(false);
		setTitle("TankWar");
		setVisible(true);
		ResourceManager r = new ResourceManager();

		myTank = new Tank(this, GAME_WIDTH-300, GAME_HEIGHT-300, Dir.UP, true);
		System.out.println("MyTank joined!");
		tkList.add(myTank);
		// Bullet b = new Bullet(this,30,30,Dir.DOWN);
		// bulletList.add(b);

		addKeyListener(new MyKeyListener());
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				stopGame = false; ///如何等待这个声音的线程结束？？需要同步
				System.exit(0);
			}
		});
		//加入声音，这里要新建一个线程，等待它结束
		new Thread(new Runnable(){
			public void run(){
				while (!stopGame){
					new Audio("audio/war1.wav").play();
				}
			}
		}).start();
		{
		}
	}

	public void addBullet(Bullet b) {
		bulletList.add(b);
	}

	public void addTank(Tank t) {
		tkList.add(t);
	}

	Image offScreenImage = null;

	@Override
	public void update(Graphics g) {
		if (offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_WIDTH);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}

	@Override
	public void paint(Graphics g) {
		// 设显示子弹数量字符串
		Color c = g.getColor();
		g.setColor(Color.GREEN);
		g.drawString("子弹的数量：" + bulletList.size(), 50, 50);
		g.drawString("坦克的数量：" + tkList.size(), 50 + 300, 50);
		g.setColor(c);

		for (int i = 0; i < tkList.size(); i++) {
			tkList.get(i).paint(g);
		}
		for (int i = 0; i < bulletList.size(); i++) {
			bulletList.get(i).paint(g);
		}
		
		for (int i = 0; i < bulletList.size(); i++) {
			int tankid = bulletList.get(i).getOwnerID(); //避免list越界
			for (int j = 0; j < tkList.size(); j++) {
				try {
					if (tankid != tkList.get(j).getId()) { // 判断一子弹是不是和该坦克来自同一辆，否则不检测，避免自杀
						//System.out.println("i="+i+"   bulletlist size："+bulletList.size()+"   j="+j+"   tank list size:"+tkList.size()); //for debugging
						if (i<bulletList.size() && j < tkList.size()){
							bulletList.get(i).collidewithTank(tkList.get(j));	
						}
					}
				} catch (IndexOutOfBoundsException e) {
					System.out.println("Tklist or bulletList indexout of bounds exception detected!");
					System.out.println("i="+i+"   bulletlist size："+bulletList.size()+"   j="+j+"   tank list size:"+tkList.size());
					e.printStackTrace();
				}
			}
		}

		for (int i = 0; i < explodeList.size(); i++) { //explosion
			explodeList.get(i).paint(g);
			explodeList.remove(i);
		}
	}

	class MyKeyListener extends KeyAdapter {
		private boolean bL = false, bU = false, bR = false, bD = false;

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				bL = true;
				break;
			case KeyEvent.VK_RIGHT:
				bR = true;
				break;
			case KeyEvent.VK_UP:
				bU = true;
				break;
			case KeyEvent.VK_DOWN:
				bD = true;
				break;
			default:
				break;
			}
			setMainTankDir();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				bL = false;
				break;
			case KeyEvent.VK_RIGHT:
				bR = false;
				break;
			case KeyEvent.VK_UP:
				bU = false;
				break;
			case KeyEvent.VK_DOWN:
				bD = false;
				break;
			case KeyEvent.VK_CONTROL:
				myTank.fire(); // 需要把这个地方的mytank控制好，删了，因为已经加入到，LIST中去了，这里会有一个BUG
				break;
			case KeyEvent.VK_F1:
				Tank t = new Tank(myTank.getTf(), random.nextInt(GAME_WIDTH), random.nextInt(GAME_HEIGHT), myTank.getDir(), false); //位置随机
				t.setMoving(true);
				tkList.add(t);
				System.out.println("F1 is pressed!");
				break;
			default:
				break;
			}
			setMainTankDir();
		}

		private void setMainTankDir() {
			if (bL)
				myTank.setDir(Dir.LEFT);
			if (bR)
				myTank.setDir(Dir.RIGHT);
			if (bU)
				myTank.setDir(Dir.UP);
			if (bD)
				myTank.setDir(Dir.DOWN);
			if (bL && bD)
				myTank.setDir(Dir.LEFTDOWN);
			if (bL && bU)
				myTank.setDir(Dir.LEFTUP);
			if (bR && bD)
				myTank.setDir(Dir.RIGHTDOWN);
			if (bR && bU)
				myTank.setDir(Dir.RIGHTUP);
			if (!bL && !bR && !bU && !bD) {
				myTank.setMoving(false);
			} else {
				myTank.setMoving(true);
			}
		}
	}
}
