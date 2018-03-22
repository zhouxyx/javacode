package com.xxx.javacode.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

public class ReflectMainTest {
	
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		//基于JDK8
		Class<?> clazz = Class.forName("com.xxx.javacode.reflect.User");
		
		//获取注解 忽视继承的注解，并且注解的@Retention=Source 或者Class时是无法获得的
		Annotation[] declaredAnnotations = clazz.getDeclaredAnnotations();
		
		for (Annotation annotation : declaredAnnotations) {
			System.out.println("注解1："+annotation.annotationType().getSimpleName());
		}
		//获取注解，并且注解的@Retention=Source 或者Class时是无法获得的
		Annotation[] annotations = clazz.getAnnotations();
		for (Annotation annotation : annotations) {
			System.out.println("注解2："+annotation.annotationType().getSimpleName());
		}
		
		//获取所有声明的属性(包含各种访问权限的属性)
		Field[] declaredFields = clazz.getDeclaredFields();
		for (Field field : declaredFields) {
			System.out.println("Field1："+field.getName());
		}
		//获取public类型的属性
		Field[] fields = clazz.getFields();
		for (Field field : fields) {
			System.out.println("Field2："+field.getName());
		}
		//获取方法
		Method[] declaredMethods = clazz.getDeclaredMethods();
		
		for (Method method : declaredMethods) {
			System.out.println("method=>"+method.getName());
		}
		
		//获取构造器 
		Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
		for (Constructor<?> constructor : declaredConstructors) {
			System.out.println("constructor=>"+constructor.getName()+", params count="+constructor.getParameterCount());
		}
		//获取接口
		Class<?>[] interfaces = clazz.getInterfaces();
		for (Class<?> class1 : interfaces) {
			System.out.println("interface=>"+class1.getName());
		}
		
		//获取继承类
		Class<?> superclass = clazz.getSuperclass();
		System.out.println("superclass=>"+superclass.getName());
		
		//方法调用
		Object newInstance = clazz.newInstance();
		Method helloMethod = clazz.getDeclaredMethod("hello");
		helloMethod.setAccessible(true);//访问私有方法
		Object invoke = helloMethod.invoke(newInstance);
		System.out.println("result="+invoke);
		
		Method declaredMethod = clazz.getDeclaredMethod("salary", double.class); //注意这里必须和方法的参数一致，不能使用Double.class
		
		Object invoke2 = declaredMethod.invoke(newInstance, 20000.0);
		System.out.println("result="+invoke2);
		
		//属性类型
		Field declaredField = clazz.getDeclaredField("companys");
		Field declaredField2 = clazz.getDeclaredField("age");
		System.out.println("属性类型=>"+declaredField.getGenericType().getTypeName());
		System.out.println("属性类型=>"+declaredField2.getGenericType().getTypeName());
		
		Type type = declaredField.getGenericType();
		ParameterizedTypeImpl parameterizedType = (ParameterizedTypeImpl) type; //强转成具体的实现类  
        Type[] genericTypes = parameterizedType.getActualTypeArguments();
		System.out.println("泛型类型=>"+genericTypes[0]);
		
		
		
	}

}
