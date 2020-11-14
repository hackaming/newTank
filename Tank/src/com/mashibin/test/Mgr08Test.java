package com.mashibin.test;

import com.mashibin.tank.ResourceManager;

public class Mgr08Test {
	public static void main(String[] argv){
		for (int i=0;i<100;i++){
			System.out.println(Mgr08.INSTANCE.getInstance().hashCode());			
		}
	}
}
