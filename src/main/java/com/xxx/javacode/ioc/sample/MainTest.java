package com.xxx.javacode.ioc.sample;

import com.xxx.javacode.ioc.IOC;

public class MainTest {
	
	public static void main(String[] args) {
		
		UserAction action = IOC.getBean(UserAction.class);
		String res = action.sayHello("world");
		System.out.println(res);
	}

}
