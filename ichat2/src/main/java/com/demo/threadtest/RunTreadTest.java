package com.demo.threadtest;

public class RunTreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Extend the Thread class
		ExtendThreadTest et=new ExtendThreadTest();
		et.start();
		
		//Implement the Runnable interface
		ImplementRunnable ir=new ImplementRunnable();
		Thread th=new Thread(ir);
		th.start();
		

	}

}
