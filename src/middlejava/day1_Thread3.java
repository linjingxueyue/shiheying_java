package middlejava;

/**
 * 创建多线程的步骤:
 *  1: 创建一个实现了Runnable接口的类 
 *  2：实现类的抽象方法，run()
 *  3: 创建该类的实例化对象
 *  4：将此对象传递到Thread类的构造器中，实例化一个Thread类的对象 
 *  5： 调用Thread类对象的start()方法
 * 
 * @Description:
 * @author: linjing 1395876278@qq.com
 * @date: 2020年9月25日下午12:50:43
 */

class MyThread4 implements Runnable {
	public void run() {
		for (int i = 0; i < 100; i++) {
			if (i % 2 == 0) {
				System.out.println(Thread.currentThread().getName() + ": " + i);
			}
		}
	}
}

public class day1_Thread3 {
	public static void main(String[] args) {
		MyThread4 myThread4 = new MyThread4();
		Thread thread = new Thread(myThread4);
		// start前给所创建的线程 取名
		thread.setName("linjing");
		thread.start();
		// 给 主线程取名
		Thread.currentThread().setName("主线程：");
		for (int i = 0; i < 100; i++) {
			if (i % 2 != 0) {
				System.out.println(Thread.currentThread().getName() + ": " + i);
			}
		}
		System.out.println("---------------------------------" + thread.isAlive());

	}
}
