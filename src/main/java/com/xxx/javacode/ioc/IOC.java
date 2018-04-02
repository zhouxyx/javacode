package com.xxx.javacode.ioc;

import java.util.Map;

public class IOC {

	private static Map<Class<?>, Object> beanInstanceMap ;
	
	static {
		beanInstanceMap = BeanHelper.getBeanMap();
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> clazz){
		if(beanInstanceMap.containsKey(clazz)) {
			return (T)beanInstanceMap.get(clazz);
		}else {
			return null;//找不对实例返回空 
		}
	}
}
