package com.xxx.javacode.thread;

public class TaskRunable implements Runnable {
	private boolean run = true;

	@Override
	public void run() {
		while (run) {
			System.out.println("hello world");
		}
	}

	public void shutdown() {
		run = false;
	}
}
