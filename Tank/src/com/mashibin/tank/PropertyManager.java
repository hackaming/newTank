package com.mashibin.tank;

import java.io.IOException;
import java.util.Properties;
<<<<<<< HEAD
/**
 * 应用枚举类型的单例模式
 * @author xianming
 *
 */
public enum PropertyManager {
	INSTANCE;
	private  Properties instance;
	public  Properties getInstance(){
=======

public class PropertyManager {
	private static Properties prop = new Properties();
	private static PropertyManager instance = null;
	private PropertyManager(){
		
	}
	
	public static PropertyManager getInstance(){
		if (null == instance){
			instance = new PropertyManager();
		}
>>>>>>> parent of 151cefa... 重构了部分代码，增加了敌我的开火方式，应用策略，从文件读开火的类。
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
