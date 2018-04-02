package com.xxx.javacode.ioc.sample;

import com.xxx.javacode.ioc.annotation.Component;
import com.xxx.javacode.ioc.annotation.Reference;

@Component
public class UserAction {

	@Reference
	private UserService userService;
	
	public String sayHello(String message) {
		return userService.say(message);
	}
}
