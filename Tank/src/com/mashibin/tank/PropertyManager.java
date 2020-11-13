package com.mashibin.tank;

import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
	private static Properties prop = new Properties();

	static {
		try {
			prop.load(PropertyManager.class.getClassLoader().getSystemResourceAsStream("configuration.ini"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Object get(String key){
		if (null == key){
			return null;
		}
		return prop.get(key);
	}
	public static void main(String[] args) {
		PropertyManager n = new PropertyManager();
		System.out.println(n.get("initializationOfEnemyTank"));
	}
}
