package com.xxx.javacode.base.oop;

//抽象类：可以有抽象方法，也可以没有抽象方法
public abstract class AbstractObject {
	
	//不能像接口那么写(JDK1.8)
	/*default void xx() {
		System.out.println("hello");
	}*/
	
	public void method1() {
		System.out.println("普通方法1");
	}
	public static void method2() {
		System.out.println("普通方法2");
	}
	
	//抽象方法不能这么写
	//public static void method3(); OR public static abstract void method4(); OR public void method3();
	
	//抽象方法的写法 ：继承改类的子类必须要实现改方法和接口一样
	public abstract void method4();
	
}
