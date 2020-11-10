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
	}
	class MyKeyListener extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println("key pressed");
		}

		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("key released");
		}
	}
}
