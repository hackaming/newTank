package com.mashibin.test;

import com.mashibin.tank.PropertyManager;

public class PropertyManagerTest {
	public static void main(String[] args) {
		System.out.println(PropertyManager.INSTANCE.getString("goodTankStrategy"));
	}
}
