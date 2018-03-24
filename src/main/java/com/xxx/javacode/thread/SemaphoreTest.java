package com.xxx.javacode.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {

	public static void main(String[] args) {
		//信号量 newCachedThreadPool 没有线程可用就会创建一个(cached...)
	    ExecutorService exec = Executors.newCachedThreadPool();
	    //同时只有10个线程可以访问
	    final Semaphore semp = new Semaphore(10);
	    
	    for (int index = 0; index < 50; index++) {
	        final int NO = index;
	        Runnable run = new Runnable() {
	            public void run() {
	                try {
	                    semp.acquire();
	                    System.out.println("No=" + NO);
	                    Thread.sleep((long) (Math.random() * 6000));
	                    semp.release();
	                    System.out.println("剩余可访问的信号量：" + semp.availablePermits()); 
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
	        };
	        exec.execute(run);
	    }
	    exec.shutdown();
	}
}
