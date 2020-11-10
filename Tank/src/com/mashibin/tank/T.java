package com.mashibin.tank;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class T {
	public static void main(String[] args) {
		TankFrame tf = new TankFrame();
		while(true){
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tf.repaint();
		}
	}

}
