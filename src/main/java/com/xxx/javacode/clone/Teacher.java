package com.xxx.javacode.clone;

public class Teacher implements Cloneable{
    private String name;
    private int age;
    
    
    @Override
	public String toString() {
		return "Teacher [name=" + name + ", age=" + age + "]";
	}

	public Teacher(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Teacher() {
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


}
