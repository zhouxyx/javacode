package com.xxx.javacode.base.oop;

public class ObjectInit extends Human{
	
	static final String name = "object"; //final 修饰的属性 必须赋值,或者在代码块中实现
	
	static final String addr ;
	
	static String company ;
	
	static {
		addr = "中国";
		System.out.println("静态代码块");
	}
	
	{
		System.out.println("普通代码块");
	}

	public ObjectInit() {
		System.out.println("默认构造器");
		
	}
	
	public ObjectInit(int age, int height) {
		super(age, height);
		System.out.println("子类构造器");
	}

	public static void main(String[] args) {
		
		new ObjectInit();
		//执行的顺序为： 
		/*
		 * 1.先执行静态代码块：父类 > 子类 
		 * 2.再执行父类普通代码块，构造器：父类代码块 > 父类构造器
		 * 3.最后执行子类代码块，构造器：子类代码块 > 子类构造器
		 */
		
	}

}
