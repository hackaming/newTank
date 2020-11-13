package com.mashibin.tank;

import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
	private static Properties prop = new Properties();
	private static PropertyManager instance = null;
	private PropertyManager(){
		
	}
	
	public static PropertyManager getInstance(){
		if (null == instance){
			instance = new PropertyManager();
		}
		return instance;
	}
	
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
	
	//增加以下代码段，直接获取一个string,int,boolean
	public String getString(String key){
		if (null == key){
			return null;
		}
		return (String) prop.get(key);
	}
	public int getInt(String key){
		if (null == key){
			return 0;
		}
		return (int) prop.get(key);
	}
	public boolean getBoolean(String key){
		if (null == key){
			return false;
		}
		return (boolean) prop.get(key);
	}
	
	public static void main(String[] args) {
		PropertyManager n = new PropertyManager();
		System.out.println(n.get("initializationOfEnemyTank"));
	}
}
