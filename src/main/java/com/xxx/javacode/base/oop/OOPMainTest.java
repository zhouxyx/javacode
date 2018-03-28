package com.xxx.javacode.base.oop;

public class OOPMainTest {

	public static void main(String[] args) {
		
		Human human = new Man();
		
		//多态：运行时多态性，由于覆盖了父类的方法，因此在编译时无法知道执行的是那个方法
		human.eat();
		System.out.println(human.getAge());
		
		Man man = new Man();
		//继承了父类的方法
		man.eat();
		//重载（相同类中方法名相同参数不同）
		man.eat("牛肉");
		
		System.out.println(man.height);
		
		//属性没有重写的说法
		System.out.println(man.getAge());
		
		//匿名内部类（针对接口或者抽象类，不能直接new对象的情况）
		MyInterface m = new MyInterface() {
			public void method(String xx) {
				System.out.println(xx+"世界.你好");
			}
		};
		m.method("xx");
		m.method2(100);
		
		
		//普通类的调用方式
		Student stu = new OOPMainTest().new Student("9527");
		stu.printStuNo();
		
		//静态内部类的调用
		Teacher t = new OOPMainTest.Teacher();
		t.hello1();
		//t.staticMethod(); 这样调用也可以。正常情况下应该是：
		Teacher.staticMethod();
		
		//匿名内部类
		AbstractObject ao = new AbstractObject() {
			@Override
			public void method4() {
				System.out.println("重写抽象方法");
			}
		};
		
		ao.method4();
		ao.method1();
		AbstractObject.method2();
		
	}
	
	//静态内部类
	static class Teacher{
		
		String name;
		static String school;
		
		public void hello1() {
			System.out.println("普通方法");
			staticMethod();//可以这么调用 。对象被实例化后 必然可以调用静态方法
		}
		
		public static void staticMethod() {
			//hello1(); //不能这样调用，原因是类加载时会先创建static相关的属性方法
			System.out.println("静态方法");
		}
		
	}
	
	//内部类(属性，方法不能使用static来修饰)
	class Student{
		String stuNo;
		
		public void xx() {
			System.out.println("stu xx");
		}
		
		//final修饰的方法不能被重写
		public final void printStuNo() {
			System.out.println(stuNo);
		}
		
		public Student(String stuNo) {
			this.stuNo = stuNo;
		}
	}
	
}
//java平行的类中不能有public关键字
/*public*/ class Hello{
	
	public String str;

	public Hello(String str) {
		super();
		this.str = str;
	}
	
}
