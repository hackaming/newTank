package com.mashibin.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
	private int x=0,y=0;
	public TankFrame(){
		setSize(800,600);
		setResizable(false);
		setTitle("TankWar");
		setVisible(true);
		addKeyListener(new MyKeyListener());
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	@Override
	public void paint(Graphics g){
		g.fillRect(x, y, 50, 50);
		x += 200;
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
			}
			if (bL){
				x-=10;
			}
			if (bR){
				x+=10;
			}
			if (bU){
				y-=10;
			}
			if (bD){
				y+=10;
			}
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
			}
		}
	}
}
