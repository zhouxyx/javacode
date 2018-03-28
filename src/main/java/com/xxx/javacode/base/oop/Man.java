package com.xxx.javacode.base.oop;

public class Man extends Human {

	private int age = 10;

	@Override //重写
	protected void eat() {
		// super.xx调用父类的方法或者属性
		// super.eat();
		System.out.println("Man:eat()...");
	}

	//重载
	public void eat(String xx) {
		System.out.println("Man:eat('"+xx+"')");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
