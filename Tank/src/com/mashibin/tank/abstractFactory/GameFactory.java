package com.mashibin.tank.abstractFactory;

import com.mashibin.tank.Dir;
import com.mashibin.tank.TankFrame;

/**
 * 抽象工厂的父类
 * @author xianming
 *
 */
public abstract class GameFactory {
	public abstract BaseTank createTank(TankFrame tf, int x, int y, Dir dir, boolean bGood);
	public abstract BaseExplode createExplode(TankFrame tf,int x, int y);
	public abstract BaseBullet createBullet(TankFrame tf,int x, int y, Dir dir, int id);
}
