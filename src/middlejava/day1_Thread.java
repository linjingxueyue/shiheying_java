package middlejava;
/**
 *   
 *   线程与进程的对比：
 *      1：进程： 资源分配的最小单位。
 *      2：线程： 作为资源调度与执行的单位
 *   每个线程都拥有自己独立的：栈、程序计数器
 *   一个进程可以拥有多个线程，这些线程共享一个方法区、堆
 * ------------------------------------------------------------------------------
 * 	1：Thread 类中的常用方法见下一小节
 *  2：创建多线程的第二种方式见 小节3
 *  
 *  ---------------------------------------------------------------------------
 *  总结 创建Thread线程的两种方式：
 *  	1： 采用继承 Thread类的方式
 *  	2： 采用 实现Runnable接口的方式
 *  	3: 采用Callable方式
 *  	4: 使用线程池
 *  
 *  比较 两种 创建线程的方式：
 *    a.开发过程中，优先考虑实现接口的方式
 *  	  1： 实现接口的方式，可以让该类额外能够继承别的类。第一种方式只能继承Thread类。
 *  	  2： 实现接口的方式，天然具有处理多个线程共享数据的情况。
 *  	本质原因在于多个线程实例的情况下，仅仅只创建了一个实现接口类的对象
 *    b. 两种方式的相同点：
 *    		都需要重写run()方法，将线程要执行的逻辑声明写在run()方法中。	
 *      
 * @Description:创建自定义线程，需要重写run方法 
 * @author: linjing 1395876278@qq.com
 * @date: 2020年9月25日上午8:16:57
 */
class MyThread extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			if(i%2==0) {
				System.out.println(Thread.currentThread().getName()+"=====>"+i);
			}
		}
	}
}
public class day1_Thread {
	public static void main(String[] args) {
		// 1: 创建一个新的线程
		MyThread myThread = new MyThread();
		// 2：通过对象.start() 方法启动一个新的的线程，并处理run()方法
		  //  2.1 直接通过对象.run()方法并不会启动一个新的线程，
		myThread.start();
//		myThread.run();		
		 // 2.2 再启动一个线程去遍历100以内的偶数，不可以让已经start的对象继续start
		MyThread myThread2 = new MyThread();
		myThread2.start();
		// 3： 如下操作仍是在主线程内部执行
		for (int i = 0; i < 100; i++) {
			if(i%2!=0) {
				System.out.println(Thread.currentThread().getName()+"---------------------main-----------------");
			}
		}
	}
}
