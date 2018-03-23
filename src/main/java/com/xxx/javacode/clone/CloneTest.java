package com.xxx.javacode.clone;

import org.junit.Test;

public class CloneTest {

	@Test
	public void test1() throws CloneNotSupportedException {
		Student s1 = new Student("张飞", 28);
		Student s2 = (Student) s1.clone();

		// 拷贝后的内容
		System.out.println(s2);

		s2.setAge(18);
		// 说明s1和s2是两个不同的对象 =>浅拷贝
		System.out.println("student1=" + s1);
		System.out.println("student2=" + s2);

	}

	@Test
	public void test2() throws CloneNotSupportedException {

		Teacher teacher = new Teacher("刘老师", 30);
		Student2 stu = new Student2("小明", 6, teacher);
		
		Student2 stu2 = (Student2) stu.clone();
		
		System.out.println("stu="+stu);
		System.out.println("stu2="+stu2);
		System.out.println("----修改内容----");
		
		stu2.setName("小名");
		stu2.getTeacher().setAge(35);
		stu2.getTeacher().setName("Wang");
		//Teacher的信息一起被修改说明是同一个引用 =>浅拷贝
		System.out.println("stu="+stu);
		System.out.println("stu2="+stu2); 
		
	}
	@Test
	public void test3() throws CloneNotSupportedException {
		Teacher2 teacher = new Teacher2("刘老师", 30);
		Student3 stu = new Student3("小明", 6, teacher);
		
		Student3 stu2 = (Student3) stu.clone();
		
		System.out.println("stu="+stu);
		System.out.println("stu2="+stu2);
		System.out.println("----修改内容----");
		
		stu2.setName("小名");
		stu2.getTeacher().setAge(35);
		stu2.getTeacher().setName("Wang");
		
		//Teacher的信息没有被修改说明是不同的引用 =>深拷贝
		System.out.println("stu="+stu);
		System.out.println("stu2="+stu2); 
	}
	
	@Test
	public void test4() throws Exception {
		//序列化的方式进行深拷贝
		
		Account account = new Account("admin","123");
		Member m1 = new Member("张三","火星",account);
		Member m2 = (Member) m1.deepClone();
		
		System.out.println(m1);
		System.out.println(m2);
		
		m2.getAccount().setPassword("123456");
		System.out.println("after="+m1);
		System.out.println("after="+m2);
	}
	
}
