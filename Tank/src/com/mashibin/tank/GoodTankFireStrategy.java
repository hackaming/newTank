package com.mashibin.tank;

public class GoodTankFireStrategy implements FireStrategy{

	@Override
	public void fire(Tank t) {
		int bx = t.getX() + Tank.TANK_WIDTH / 2 - Bullet.WIDTH / 2;
		int by = t.getY() + Tank.TANK_HEIGHT / 2 - Bullet.HEIGHT / 2;
		for (Dir dir:Dir.values()){
			//改为用抽象工厂产生子
			t.tf.gf.createBullet(t.tf, bx, by, dir, t.id);
			//new Bullet(t.tf, bx, by, dir, t.id);
		}
		//改为audio thread
		new Thread(new AudioThread("audio/tank_fire.wav")).start();
		//new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
	}
}
