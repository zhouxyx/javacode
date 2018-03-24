package com.xxx.javacode.thread;

public class ThreadMainTest {
	
		public static void main(String[] args) throws InterruptedException {
//			TaskThread t = new TaskThread();
//			t.start();//启动线程
			
			TaskRunable tr = new TaskRunable();
			
			Thread t2 = new Thread(tr);
			
			t2.start();
			
			Thread.sleep(1000);
			
			tr.shutdown(); 
//			t.shutdown();//run方法结束，线程退出
			
			
		}
		
		
}
