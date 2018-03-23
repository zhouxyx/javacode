package com.xxx.javacode.clone;

public class Student3 implements Cloneable{
	private String name;
	private int age;
	private Teacher2 teacher;
	
	public Student3(String name, int age, Teacher2 teacher) {
		super();
		this.name = name;
		this.age = age;
		this.teacher = teacher;
	}

	public Teacher2 getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher2 teacher) {
		this.teacher = teacher;
	}

	public Student3(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Student3() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Student3 [name=" + name + ", age=" + age + ", teacher2=" + teacher + "]";
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
		//深拷贝
		Student3 student = (Student3) super.clone();
		student.setTeacher((Teacher2) student.getTeacher().clone());
		return student;
	}
}
