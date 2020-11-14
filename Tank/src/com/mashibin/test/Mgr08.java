package com.mashibin.test;

import com.mashibin.tank.PropertyManager_old_Works;
import com.mashibin.tank.ResourceManager;

public enum Mgr08 {
	INSTANCE;
	private ResourceManager instance;
	Mgr08() {
		instance = new ResourceManager();
	}
	public ResourceManager getInstance(){
		return instance;
	}

/*	public static void main(String[] args) {
		for (int i=0;i<100;i++){
			new Thread(()->{
				System.out.println(Mgr08.INSTANCE.hashCode());
			}).start();
		}
	}*/
}
