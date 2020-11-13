package com.mashibin.tank;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Properties;
import java.util.Random;

public class T {
	public static void main(String[] args) {
		TankFrame tf = new TankFrame();
		PropertyManager p = new PropertyManager();
		int tankCount = Integer.parseInt(p.get("initializationOfEnemyTank").toString());
		
		for ( int i=0;i<tankCount;i++){
			Tank t = new Tank(tf,50+i*50,40+i*50,Dir.values()[new Random().nextInt(4)],false);
			t.setMoving(true);
			tf.tkList.add(t);
		}
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
