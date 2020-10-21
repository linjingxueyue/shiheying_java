package middlejava;
/**
 *  Thread 类中的常用方法：
 *  	1：start(): 	启动当前线程，调用当前线程的run()
 *      2：run():   	通常需要重写Thread类的此方法。将创建线程的执行操作，放在此线程中
 *      3：currentThread(): 返回当前执行代码所处的线程
 *      4：getName():	获取当前线程的名字
 *      5：setName():   设置当前线程的名字
 *      6: yield():		释放当前CPU的执行权，与sleep一样，不释放当前的锁
 *      7：join():		在线程A中调用线程B.join()方法，此时线程A就进入阻塞状态，直到线程B执行完毕，才会结束阻塞，继续开始执行线程A。
 *      8：sleep(long milltime):  该方法的参数是毫秒。阻塞milltime毫秒，阻塞结束后等待CPU分配任务
 *      9: isAlive(): 	判断线程是否存活
 *      10.getPrioruty():  获取线程的优先级
 *      11： setPrioruty(): 设置线程的优先级
 *      -----------------------------------------------------------------------------------------
 *      线程通信常用的三个方法： （这三个方法都是声明在Object类当中）
 *      	wait()、notify()、notifyAll() 
 *      	wait()执行后,如果处于同步状态,就会释放锁
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020年9月25日下午12:50:43
 */

class MyThread3 extends Thread{
	public void run() {
		for(int i=0;i<100;i++) {
			if(i%2==0) {
				try {
					sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+": "+i);
			}
		}
	}
}

public class day1_Thread2 {
	public static void main(String[] args) {
		MyThread3 myThread3 = new MyThread3();
		// start前给所创建的线程 取名
		myThread3.setName("linjing");
		myThread3.start();
		// 给 主线程取名
		Thread.currentThread().setName("主线程：");
		for(int i=0;i<100;i++) {
			if(i%2!=0) {
				System.out.println(Thread.currentThread().getName()+": "+i);
				if(i==19) {
					try {
						myThread3.join();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		System.out.println("---------------------------------"+myThread3.isAlive());
		
	}
}
