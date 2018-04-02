package com.xxx.javacode.ioc.sample.impl;

import com.xxx.javacode.ioc.annotation.Component;
import com.xxx.javacode.ioc.sample.UserService;

@Component
public class UserServiceImpl implements UserService {

	public String say(String message) {
		return "hello:"+message;
	}

}
