package com.xxx.javacode.ioc;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xxx.javacode.ioc.annotation.Component;
import com.xxx.javacode.ioc.annotation.Reference;

public class BeanHelper {

	private static Map<Class<?>, Object> beanInstanceMap = new HashMap<Class<?>, Object>();
	static String packageName = PropertyUtil.getStringValue("scan-package");

	static {
		List<Class<?>> loadClassList = ClassHelper.getInstance().loadClassList(packageName);
		for (Class<?> clazz : loadClassList) {
			if (clazz.isAnnotationPresent(Component.class)) {
				try {
					Object value = clazz.newInstance();
					beanInstanceMap.put(clazz, value);
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}

		for (Map.Entry<Class<?>, Object> entry : beanInstanceMap.entrySet()) {
			Object beanObject = entry.getValue();
			Class<?> clazz = entry.getKey();
			// 获取改类下的所有属性
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				// 声明Reference注解的属性进行设置
				if (field.isAnnotationPresent(Reference.class)) {
					Class<?> impl = findImplementClazz(field.getType());
					if(impl!=null) {
						field.setAccessible(true);
						try {
							field.set(beanObject, beanInstanceMap.get(impl));
						} catch (IllegalArgumentException | IllegalAccessException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	private static Class<?> findImplementClazz(Class<?> fieldType){
		for (Map.Entry<Class<?>, Object> entry : beanInstanceMap.entrySet()) {
			if(fieldType.isAssignableFrom(entry.getKey()) && fieldType!=entry.getKey()) {
				return entry.getKey();
			}
		}
		return null;
	}
	
	
	/*private static Object findReferenceObj(Class<?> clazz, Map<Class<?>, Object> beanInstanceMap) {
		for (Map.Entry<Class<?>, Object> entry : beanInstanceMap.entrySet()) {
			Class<?> clazzKey = entry.getKey();
			if (clazz.equals(clazzKey)) {
				return entry.getValue();
			}
		}
		return beanInstanceMap;
	}*/
	
	public static Map<Class<?>, Object> getBeanMap(){
		return beanInstanceMap;
	}
	
	
}
