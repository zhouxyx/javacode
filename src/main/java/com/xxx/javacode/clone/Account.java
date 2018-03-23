package com.xxx.javacode.clone;

import java.io.Serializable;

public class Account implements Serializable{

	private static final long serialVersionUID = 1682127103051742490L;

	private String account;
	private String password;
	@Override
	public String toString() {
		return "Account [account=" + account + ", password=" + password + "]";
	}
	public Account(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
