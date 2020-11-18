package com.mashibin.tank.abstractFactory;

import java.awt.Graphics;

public abstract class BaseTank {
	
	public abstract void paint(Graphics g);

	public abstract void setMoving(boolean b) ;

	public abstract int getId();
	
}
