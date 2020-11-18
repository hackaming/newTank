package com.mashibin.tank.abstractFactory;

import com.mashibin.tank.Dir;
import com.mashibin.tank.Tank;
import com.mashibin.tank.TankFrame;

public class RectFactory extends GameFactory{
	
	private static final RectFactory INSTANCE = new RectFactory();
	private RectFactory (){
		
	}
	public static RectFactory getInstance(){
		return INSTANCE;
	}

	@Override
	public BaseTank createTank(TankFrame tf, int x, int y, Dir dir, boolean bGood) {
		// TODO Auto-generated method stub
		return new Tank(tf,x,y,dir,bGood);
	}

	@Override
	public BaseExplode createExplode(TankFrame tf, int x, int y) {
		// TODO Auto-generated method stub
		return new RectExplode(tf,x,y);
	}

	@Override
	public BaseBullet createBullet(TankFrame tf, int x, int y, Dir dir, int id) {
		// TODO Auto-generated method stub
		return new RectBullet(tf,x,y,dir,id);
	}

}
