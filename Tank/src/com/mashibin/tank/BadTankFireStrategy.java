package com.mashibin.tank;

public class BadTankFireStrategy implements FireStrategy{

	@Override
	public void fire(Tank t) {
		int bx = t.getX() + Tank.TANK_WIDTH / 2 - Bullet.WIDTH / 2;
		int by = t.getY() + Tank.TANK_HEIGHT / 2 - Bullet.HEIGHT / 2;
		
		new Bullet(t.tf, bx, by, t.dir, t.id);
		// 加入开火的声音 自己的才出声音
//入为audio thread,
		//new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
		new Thread(new AudioThread("audio/tank_fire.wav")).start();
		

		//注掉，用上面这句话，用LAMBDA表达式
		
/*		if (t.bGood) {
			new Thread(new Runnable() {
				public void run() {
					new Audio("audio/tank_fire.wav").play();
				}
			}).start();
		}*/
		
	}

}
