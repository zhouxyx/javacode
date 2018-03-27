package com.xxx.javacode.base;

import java.util.Vector;

public class TransferTest {
	Vector<String> strs;
	
	public static void main(String[] args) {
		
		int x = 1 ;
		System.out.println(x);
		change(x);
		System.out.println(x);
		
		
		Person p = new Person(1);
		
		System.out.println(p);
		
		person(p);
		
		System.out.println(p);
		
		String str = "abcd";
		System.out.println(str);
		str(str);
		System.out.println(str);
		
	}
	
	public static void str(String str) {
		str = "ABCD";
	}
	public static void person(Person p) {
		p.setAge(78);
		p = new Person();
		p.setAge(80);
	}
	
	public static void change(int x) {
		x = 2;
	}
	
	
}

class Person{
	int age ;

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + "]";
	}

	public Person() {
		super();
	}

	public Person(int age) {
		super();
		this.age = age;
	}

	public void setAge(int age) {
		this.age = age;
	} 
}
