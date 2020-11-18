package com.mashibin.tank.abstractFactory;

import java.awt.Graphics;

import com.mashibin.tank.Tank;

public abstract class BaseBullet {
	public abstract void paint(Graphics g);
	public abstract int getOwnerID();
	public abstract void collidewithTank(Tank tank);
}
