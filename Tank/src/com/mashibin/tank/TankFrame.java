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

public class TankFrame extends Frame {

	ArrayList<Tank> tkList = new ArrayList<Tank>();
	ArrayList<Bullet> bulletList = new ArrayList<Bullet>();
	private Tank myTank = null;
	private static final int GAME_WIDTH = 800,GAME_HEIGHT=600;
	
	
	public TankFrame(){
		setSize(GAME_WIDTH,GAME_HEIGHT);
		setResizable(false);
		setTitle("TankWar");
		setVisible(true);
		myTank = new Tank(this,200,200,Dir.DOWN);
		tkList.add(myTank);
		Bullet b = new Bullet(30,30,Dir.DOWN);
		bulletList.add(b);
		
		addKeyListener(new MyKeyListener());
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	public void addBullet(Bullet b){
		bulletList.add(b);
	}
	public void addTank(Tank t){
		tkList.add(t);
	}
	
	Image offScreenImage = null;
	@Override
	public void update(Graphics g) {
		if (offScreenImage == null){
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
	public void paint(Graphics g){
		for (Tank t:tkList){
			t.paint(g);
		}
		for (Bullet b:bulletList){
			b.paint(g);
		}
	}
	class MyKeyListener extends KeyAdapter{
		private boolean bL=false,bU=false,bR=false,bD=false;
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			switch(key){
			case KeyEvent.VK_LEFT:
				bL=true;
				break;
			case KeyEvent.VK_RIGHT:
				bR=true;
				break;
			case KeyEvent.VK_UP:
				bU=true;
				break;
			case KeyEvent.VK_DOWN:
				bD=true;
				break;
			default:
					break;
			}
			setMainTankDir();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			switch(key){
			case KeyEvent.VK_LEFT:
				bL=false;
				break;
			case KeyEvent.VK_RIGHT:
				bR=false;
				break;
			case KeyEvent.VK_UP:
				bU=false;
				break;
			case KeyEvent.VK_DOWN:
				bD=false;
				break;
			case KeyEvent.VK_CONTROL:
				myTank.fire(); //需要把这个地方的mytank控制好，删了，因为已经加入到，LIST中去了，这里会有一个BUG
				break;
			default:
				break;
			}
			setMainTankDir();
		}

		private void setMainTankDir() {
			if (bL) myTank.setDir(Dir.LEFT); 
			if (bR) myTank.setDir(Dir.RIGHT);
			if (bU) myTank.setDir(Dir.UP);
			if (bD) myTank.setDir(Dir.DOWN);
			if (!bL&&!bR&&!bU&&!bD){
				myTank.setMoving(false);
			} else {
				myTank.setMoving(true);
			}
		}
		public void fire(){
			Bullet b = new Bullet(30,30,myTank.getDir());
		}
	}
}
