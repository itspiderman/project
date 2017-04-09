package com.demo.synchronizedtest;

public class SynchronizedTest {
//Synchronized是Java并发编程中最常用的用于保证线程安全的方式	
	
	// 1. Without synchronized 1,2
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
	//2. Synchronized general method 3,4
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
	//3. static function(class) synchronized 5,6
	public static synchronized void method5(){
		System.out.println("Method 5 start");
		try {
			System.out.println("Method 5 execute");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Method 5 end");
	}
	public static synchronized void method6(){
		System.out.println("Method 6 start");
		try {
			System.out.println("Method 6 execute");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Method 6 end");
	}
	//4. code block synchronized 7,8
	public void method7(){
		System.out.println("Method 7 start");
		try {
			synchronized(this){
				System.out.println("Method 7 execute");
				Thread.sleep(3000);
			}			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Method 7 end");
	}
	public void method8(){
		System.out.println("Method 8 start");
		try {
			synchronized(this){
				System.out.println("Method 8 execute");
				Thread.sleep(2000);
			}			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Method 8 end");
	}

	public static void main(String[] args) {
		// -------  1. Without synchronized 1,2
		//withoutSynchronized();
		/*
		 Method 2 start
		 Method 2 execute
		 Method 1 start
		 Method 1 execute
		 Method 2 end
		 Method 1 end
		 */
		
		// ------- 2. Synchronized general method 3,4		
		//generalSynchronized();
		/*
		 Method 3 start
		 Method 3 execute
		 Method 3 end
		 Method 4 start
		 Method 4 execute
		 Method 4 end
		 */
		// ------- 3. static function(class) synchronized 5,6
//		staticFunctionSynchronized();
		/*
		 Method 5 start
		 Method 5 execute
		 Method 5 end
		 Method 6 start
		 Method 6 execute
		 Method 6 end
		 */
		// ------- 4. code block synchronized 7,8
		codeBlockSynchronized();
		/*
		 Method 7 start
		 Method 7 execute
		 Method 8 start
		 Method 7 end
		 Method 8 execute
		 Method 8 end
		 */
	}
	
	// 1. Without synchronized 1,2
	static void withoutSynchronized() {
		System.out.println("1. Without synchronized 1,2");
		final SynchronizedTest ws1 = new SynchronizedTest();
		//线程的实现有两种方式，一是继承Thread类，二是实现Runnable接口,this is implement Runnable interface.
		new Thread(new Runnable() {
			@Override
			public void run() {
				ws1.method1();
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				ws1.method2();
			}
		}).start();
	}
	//对普通方法同步：//2. Synchronized general method 3,4
	static void generalSynchronized(){
		System.out.println("2. Synchronized general method 3,4");
		final SynchronizedTest ws2 = new SynchronizedTest();
		new Thread(new Runnable(){
			@Override
			public void run(){
				ws2.method3();
			}
		}).start();
		
		new Thread( new Runnable(){
			@Override
			public void run(){
				ws2.method4();
			}
		}).start();
	}
	//3. static function(class) synchronized 5,6
	static void staticFunctionSynchronized(){
		System.out.println("3. static function(class) synchronized 5,6");
		new Thread(new Runnable(){
			@Override
			public void run(){
				method5();
			}
		}).start();
		new Thread(new Runnable(){
			@Override
			public void run(){
				method6();
			}
		}).start();
	}
	// 4. code block synchronized 7,8
	static void codeBlockSynchronized(){
		System.out.println("4. code block synchronized 7,8");
		final SynchronizedTest st=new SynchronizedTest();
		new Thread(new Runnable(){
			@Override
			public void run(){
				st.method7();
			}
		}).start();
		new Thread(new Runnable(){
			@Override
			public void run(){
				st.method8();
			}
		}).start();
	}

}
