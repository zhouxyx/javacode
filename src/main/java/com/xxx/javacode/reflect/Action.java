package com.xxx.javacode.reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = { ElementType.TYPE })
@Retention(RetentionPolicy.SOURCE)
public @interface Action {

	public String value() default "";
}
