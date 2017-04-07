package com.demo.synchronizedtest;

public class SynchronizedTest {

	void method1() {
		System.out.println("Method 1 start");
		try {
			System.out.println("Method 1 execute");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Method 1 end");
	}

	void method2() {
		System.out.println("Method 2 start");
		try {
			System.out.println("Method 2 execute");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Method 2 end");
	}
	//Synchronized method
	synchronized void method3() {
		System.out.println("Method 3 start");
		try {
			System.out.println("Method 3 execute");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Method 3 end");
	}

	synchronized void method4() {
		System.out.println("Method 4 start");
		try {
			System.out.println("Method 4 execute");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Method 4 end");
	}
	

	public static void main(String[] args) {
		// code 1
		withoutSynchronized();
		/*
		 * output result:
		 Method 2 start
		 Method 2 execute
		 Method 1 start
		 Method 1 execute
		 Method 2 end
		 Method 1 end
		 */
		
		//code 2
		//generalSynchronized();
		/*
		 * output result:
		 Method 3 start
		 Method 3 execute
		 Method 3 end
		 Method 4 start
		 Method 4 execute
		 Method 4 end
		 */
	}

	static void withoutSynchronized() {
		SynchronizedTest ws = new SynchronizedTest();
		//线程的实现有两种方式，一是继承Thread类，二是实现Runnable接口,this is implement Runnable interface.
		new Thread(new Runnable() {
			@Override
			public void run() {
				ws.method1();
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				ws.method2();
			}
		}).start();
	}
	//对普通方法同步：
	static void generalSynchronized(){
		SynchronizedTest ws = new SynchronizedTest();
		new Thread(new Runnable(){
			@Override
			public void run(){
				ws.method3();
			}
		}).start();
		
		new Thread( new Runnable(){
			@Override
			public void run(){
				ws.method4();
			}
		}).start();
	}

}
