package com.mashibin.tank;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Properties;
import java.util.Random;

public class T {
	public static void main(String[] args) {
		
		Properties p = PropertyManager.INSTANCE.getInstance();
		
		int tankCount = Integer.parseInt(p.get("initializationOfEnemyTank").toString());
		int width = Integer.parseInt(p.get("gamewidth").toString());
		int height = Integer.parseInt(p.get("gameheight").toString());
		TankFrame tf = new TankFrame(width,height);
		int tankspeed = Integer.parseInt(p.get("tankspeed").toString());
		int bulletspeed = Integer.parseInt(p.get("gamewidth").toString());
		
		for ( int i=0;i<tankCount;i++){
			Tank t = new Tank(tf,50+i*50,40+i*50,Dir.values()[new Random().nextInt(4)],false);
			System.out.println(t.getId()+" joined!");
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
