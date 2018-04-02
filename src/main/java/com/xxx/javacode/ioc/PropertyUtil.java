package com.xxx.javacode.ioc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {
	
	private static Properties pro = new Properties();
	
	static {
		try {
			InputStream in = PropertyUtil.class.getClassLoader().getResourceAsStream("bean.properties"); 
			pro.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getStringValue(String key ,String defaultValue) {
		String val = pro.getProperty(key);
		return val==null? defaultValue : val;
	}
	
	public static String getStringValue(String key) {
		return getStringValue(key, null);
	}
}
