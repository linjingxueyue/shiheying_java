package middlejava;

/**
 * @Description: 使用同步方法解决线程的安全问题 ------------- 以 下面例子为解决对象
 * @author: linjing 1395876278@qq.com
 * @date: 2020年9月25日下午8:31:04
 * 
 * 	
 *  4： 使用同步方法解决线程的安全问题
 *  		如果操作共享数据的方法完整的声明在一个方法中，我们可以把这个方法声明为同步的
 *  	 
 *  	同步方法仍然需要同步监视器。
 *  		非静态同步方法的监视器是当前的：	this
 *  		静态的同步方法的监视器是当前类本身：类名.class
 *  
 */

class Window2 implements Runnable {
	private int ticket = 100;
	private synchronized void show() {

		if(ticket >0 ) {
			
			System.out.println("卖出去的票号为： "+ticket);
			ticket -- ;
		}
	}
	public void run() {
		while(true) {
			show();
			if(ticket<=0) {
				// 每个线程都会执行到这里一次，用以推出while的循环。进而结束这个线程.但此时下方的isAlive仍然输出为true。
				//  	System.out.println("------------------------"+t1.isAlive()+" "+t2.isAlive()+" "+t3.isAlive());因为还没有真的退出循环结束线程。
				System.out.println("****:   "+Thread.currentThread().isAlive());
				break;
			}
			System.out.println("----------------------");
		}
	};
}

public class day2_thread2 {
	public static void main(String[] args) {
		Window2 window2 = new Window2();
		Thread t1 = new Thread(window2);
		Thread t2 = new Thread(window2);
		Thread t3 = new Thread(window2);
		t1.start();
		t2.start();
		t3.start();
	
	}
}
