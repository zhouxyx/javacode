package com.xxx.javacode.thread;

public class TaskThread extends Thread{

	private boolean run = true;
	public void run() {
		while(run) {
			System.out.println("hello world");
		}
	}
	public void shutdown() {
		run = false;
	}
}
