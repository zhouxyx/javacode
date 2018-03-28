package com.xxx.javacode.base.oop;

public interface MyInterface {
	
	public void method(String xx);
	
	//jdk1.8的写法
	default int method2(int x) {
		System.out.println("hello world");
		return x;
	}
	
}
