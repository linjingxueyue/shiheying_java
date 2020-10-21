package middlejava;

/**
 * @Description: 线程的安全问题 ------------- 以 下面例子为解决对象
 * @author: linjing 1395876278@qq.com
 * @date: 2020年9月25日下午8:31:04
 * 
 * 	1：问题： 在免票过程中，出现了重票、错票---》出现了线程安全问题
 * 
 *  2：问题出现的原因：
 *  	当某个线程操作车票的过程中，尚未操作结束时候，其余线程参与进来操作车票。
 *  
 *  3：如何解决： 当一个线程A在操作ticket的时候，其余线程不能参与进来。直到线程A操作完毕后，才允许其他线程进去。
 *         		  线程A未操作完毕时，即使线程A处于阻塞状态，其余线程也不能进去。
 *         
 *  4： 在JAVA中，是通过同步机制来解决线程安全问题。
 *  			方式1： 同步代码块
 *  				 synchronized(同步监视器){
 *  						// 需要被同步的代码
 *  	   						说明： 操作共享数据的代码就是共享代码。
 *  								   共享数据： 多个线程共同操作的数据。 在本例中就是ticket
 *  								   同步监视器: 俗称：锁。任何一个类的对象都可以称作锁。
 *  											   锁的要求： 要求这些线程必须共用同一把锁。
 *  				 }
 *  			方式2： 同步方法
 *  				如果操作共享数据的方法完整的声明在一个方法中，我们可以把这个方法声明为同步的
 *  			方式3：
 *  					Lock的方式
 *  5：同步的方式，解决了线程安全问题。
 *  	 操作同步代码时候，只能有一个线程参与，其他线程等待，相当于是一个单线程的过程。
 */

class Window implements Runnable {
	private int ticket = 100;
	public void run() {
		while(true) {
			synchronized (this) {
				if(ticket >0 ) {
					System.out.println("卖出去的票号为： "+ticket);
					ticket -- ;
				}else {
					break;
				}
			}
		}
	};
}

public class day2_thread1 {
	public static void main(String[] args) {
		Window window = new Window();
		Thread t1 = new Thread(window);
		Thread t2 = new Thread(window);
		Thread t3 = new Thread(window);
		t1.start();
		
		t2.start();
		t3.start();
		System.out.println("------------------------"+t1.isAlive()+" "+t2.isAlive()+" "+t3.isAlive());

	}
}
