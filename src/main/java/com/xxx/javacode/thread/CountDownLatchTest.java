package com.xxx.javacode.thread;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(2);
		Worker w1 = new Worker("王朝", latch);
		Worker w2 = new Worker("马汉", latch);
		w1.start();
		w2.start();
		latch.await();
		System.out.println("---" + new Date());
	}

	static class Worker extends Thread {

		String name;
		CountDownLatch downLatch;

		public Worker(String name, CountDownLatch downLatch) {
			super();
			this.name = name;
			this.downLatch = downLatch;
		}

		public void run() {
			doWork();
			System.out.println(name + "--" + new Date());
			downLatch.countDown();// 计数器减1
		}

		public void doWork() {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
