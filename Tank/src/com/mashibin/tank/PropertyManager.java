package com.mashibin.tank;

import java.io.IOException;
import java.util.Properties;
/**
 * 应用枚举类型的单例模式
 * @author xianming
 *
 */
public enum PropertyManager {
	INSTANCE;
	private  Properties instance;
	public  Properties getInstance(){
		return instance;
	}
	PropertyManager(){
		instance = new Properties();
		try{
		instance.load(PropertyManager.class.getClassLoader().getResourceAsStream("configuration.ini"));
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	public String getString(String key){
		return instance.get(key).toString();
	}
	public int getInt(String key){
		return Integer.parseInt(instance.get(key).toString());
	}
	public boolean getBoolean(String key){
		return Boolean.parseBoolean(instance.get(key).toString());
	}
	public Double getDouble(String key){
		return Double.parseDouble(instance.get(key).toString());
	}
}
