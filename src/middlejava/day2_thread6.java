package middlejava;



/**
 * @Description: 线程的通信 ----- 使用两个线程交替打印1 到 100
 * @author: linjing 1395876278@qq.com
 * @date: 2020年9月25日下午8:31:04
 * ------------------------------------- ----------------------------------------------
 * 	1:	线程通信wait notify notifyAll  只能用于同步代码块或同步方法中.   (synchronized)
 * 		Lock 方式的 线程通信,不能用上面的方法
 *  
 *  2:    synchronized  方式的线程通信中,三个通信函数的调用者必须与synchronized中的同步监视器(锁)是同一个对象.
 *      否则,报错.
 *      
 *  3:  上面的三个通信方法,是定义在 Java.lang.Object 当中.
 * -----------------------------------------------------------------------------------------
 * 	 wait()     : 一旦执行此方法,当前线程就会进入阻塞状态,并释放同步监视器(锁)
 *   notify()   : 一旦执行此方法,就会唤醒被wait()的一个线程,如果有多个线程被wait(),就会唤醒优先级高的那个
 *   NotifyAll(): 唤醒所有wait()的线程.
 * -------------------------------------------------------------------------=-------------------
 * 	4： sleep() 与wait()方式的异同：
 * 		1：相同点： 一旦执行方法，都可以使得线程进入阻塞状态。
 * 		2：不同点： a.声明位置不同： sleep() 方法声明在Thread类中，wait()方法声明在Object类中
 * 					b.调用要求不同： sleep()可以在任何需要的场景下调用。wait()方法只能在同步方法或同步代码块中进行调用。
 * 					c.是否是否监视器问题： 如果两者都在同步方法或同步监视器中调用，wait()会释放同步监视器，sleep()不会。
 */
class Number implements Runnable {
	private  int number = 0;
	
	public void run() {
		while(true) {
			synchronized (this) {
				notify();
				if (number <= 100) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + " : " + number);
					System.out.println("-----------------------");
					number++;
					 
				} else {
					break;
				}
			}
		}
	};
}

public class day2_thread6 {
	public static void main(String[] args) {
		Number n1 = new Number();
		Thread t1 = new Thread(n1);
		Thread t2 = new Thread(n1);
		t1.start();
		t2.start();
	}
}
