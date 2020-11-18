package com.mashibin.tank.abstractFactory;

import com.mashibin.tank.Bullet;
import com.mashibin.tank.Dir;
import com.mashibin.tank.Explode;
import com.mashibin.tank.Tank;
import com.mashibin.tank.TankFrame;

public class DefaultFactory  extends GameFactory{
	/**
	 * 应用静态内部类，改为单例
	 */

	private DefaultFactory (){
		
	}
	private static class DefaultFactoryInstance{
		private  static final DefaultFactory instance = new DefaultFactory();
	}
	public static DefaultFactory getInstance(){
		return DefaultFactoryInstance.instance ;
	}
	

	@Override
	public BaseTank createTank(TankFrame tf, int x, int y, Dir dir, boolean bGood) {
		return new Tank(tf,x,y,dir,bGood);
	}

	@Override
	public BaseExplode createExplode(TankFrame tf, int x, int y) {
		return new Explode(tf,x,y);
	}

	@Override
	public BaseBullet createBullet(TankFrame tf, int x, int y, Dir dir, int id) {
		// TODO Auto-generated method stub
		return new Bullet(tf,x,y,dir,id);
	}

}
