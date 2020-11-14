package com.mashibin.tank;

public class AudioThread extends Audio implements Runnable{
	public static int numberOfExplode = 0;
	public static int numberOfTankFire = 0;
	public static int numberOfTankOfMove = 0;
	private String sFileName = null;
	public static int threadCount = 0;
	public AudioThread(String fileName) {
		super(fileName);
		System.out.println("AudioThread is newd!");
		this.sFileName = fileName;
		// TODO Auto-generated constructor stub
		threadCount++;
	}

	@Override
	public void run() {
		//这里的爆炸次数播放可以写进配置文件，
		System.out.println("AudioThread.run is called,numberOfExplode,numberOfTankFire,numberOfTankOfMove"+numberOfExplode+"  "+numberOfTankFire+"  "+numberOfTankOfMove+sFileName);
		if (sFileName.equals("audio/explode.wav") && numberOfExplode < 10){
			numberOfExplode++;
			this.play();
			System.out.println("audio/explode.wav is called! in AudioThread class");
			numberOfExplode--;
		} else if (sFileName.equals("audio/tank_fire.wav") && numberOfTankFire < 10){
			numberOfTankFire++;
			this.play();
			System.out.println("tank_fire.wav is called! in AudioThread class");
			numberOfTankFire--;
		} else if (sFileName.equals("audio/tank_move.wav") && numberOfTankOfMove < 10){
			numberOfTankOfMove++;
			this.play();
			System.out.println("audio/tank_move.wav is called! in AudioThread class");
			numberOfTankOfMove--;
		}
		System.out.println("Total Audio thread running:"+threadCount);
		threadCount--;
		System.out.println("Audio Thread is ended!");
	}
	public static void main(String[] args) {
		for (int i=0;i<10;i++){
			new Thread(new AudioThread("audio/tank_fire.wav")).start();
		}

	}
}
