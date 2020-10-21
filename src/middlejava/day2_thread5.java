package middlejava;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 使用 Lock 锁的方式 解决线程的安全问题 ------------- 以 下面例子为解决对象
 * @author: linjing 1395876278@qq.com
 * @date: 2020年9月25日下午8:31:04
 * 
 * 	
 * 1： 使用Lock方式解决线程的安全问题
 * 
 * 2:  synchronized 与 Lock 的异同：		
 *  		相同点： 二者都可以解决线程安全问题
 *  		不同点： synchronized 机制再执行完相应的同步代码后，会自动释放同步监视器。
 *  				Lock需要手动启动同步（lock()）。同时，结束同步也需要手动实现（unlock()）。
 *  
 * 3： 注意点: Lock的方式也需要注意：多个线程需要共用一个Lock 才可以实现同步
 */
class Window6 implements Runnable {
	private int ticket = 100;
	private ReentrantLock Lock =  new ReentrantLock();
	
	
	public void run() {
		while (true) {
			try {
				// 调用 Lock.lock()方法
				Lock.lock();
				if (ticket > 0) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("窗口号为： "+Thread.currentThread().getName()+"  卖出去的票号为： " + ticket);
					ticket--;
				} else {
					break;
				}
			}finally {
				// 调用unlock() 方法进行解锁。
				Lock.unlock();
			}
			
		}
	};
}

public class day2_thread5 {
	public static void main(String[] args) {
		Window6 window2 = new Window6();
		Thread t1 = new Thread(window2);
		Thread t2 = new Thread(window2);
		Thread t3 = new Thread(window2);
		t1.start();
		t2.start();
		t3.start();

	}
}
