package com.xxx.javacode.base.oop;

public class Human {

	public int age = 100;
	protected int height = 50;

	{
		System.out.println("父类普通代码块");
	}
	static {

		System.out.println("父类静态代码块1");
	}
	static {

		System.out.println("父类静态代码块2");
	}

	public Human(int age, int height) {
		super();
		this.age = age;
		this.height = height;
		System.out.println("父类带参数构造器");
	}

	public Human() {
		super();
		System.out.println("父类构造器");
	}

	protected void eat() {
		System.out.println("human:eat()...");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
