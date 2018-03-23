package com.xxx.javacode.clone;

public class Student2 implements Cloneable{
	private String name;
	private int age;
	private Teacher teacher;
	
	public Student2(String name, int age, Teacher teacher) {
		super();
		this.name = name;
		this.age = age;
		this.teacher = teacher;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Student2(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Student2() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Student2 [name=" + name + ", age=" + age + ", teacher=" + teacher + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Object object = super.clone();
		return object;
	}
}
