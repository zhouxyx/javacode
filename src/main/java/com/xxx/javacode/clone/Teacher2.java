package com.xxx.javacode.clone;

public class Teacher2 implements Cloneable{
    private String name;
    private int age;
    
    
    @Override
	public String toString() {
		return "Teacher2 [name=" + name + ", age=" + age + "]";
	}

	public Teacher2(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Teacher2() {
		super();
	}

	public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    @Override
	public Object clone() throws CloneNotSupportedException {
		Object object = super.clone();
		return object;
	}
}
