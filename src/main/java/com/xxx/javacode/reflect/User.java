package com.xxx.javacode.reflect;

import java.io.Serializable;
import java.util.List;

@Action
@Log(value = "DEBUG")
public class User extends Account implements Serializable, Cloneable {

	private static final long serialVersionUID = 1204048563772721664L;

	private String address;
	protected int age;
	String school;
	public String company;

	private List<String> companys;

	public List<String> getCompanys() {
		return companys;
	}

	public void setCompanys(List<String> companys) {
		this.companys = companys;
	}

	public User(List<String> companys) {
		super();
		this.companys = companys;
	}

	public User(String address, int age, String school, String company) {
		super();
		this.address = address;
		this.age = age;
		this.school = school;
		this.company = company;
	}

	public User() {
		super();
	}

	public Double salary(double monthSalary) {
		hello();
		return 12 * monthSalary;
	}

	private String hello() {
		return "hello world";
	}
	
	public String getAddress() {
		return address;
	}

	public int getAge() {
		return age;
	}

	public String getSchool() {
		return school;
	}

	public String getCompany() {
		return company;
	}

}
