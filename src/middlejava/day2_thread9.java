package middlejava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 创建线程的方式三： 使用线程池的方式 
 * 		1： 提高响应速度（减少创建线程时间）
 * 	    2： 降低资源消耗（重复利用线程池中的线程，不需要每次都创建） 3：
 * 便于线程管理
 * 
 * 
 * ----------------------------------------------------------------------------------------
 * 
 * @Description:
 * @author: linjing 1395876278@qq.com
 * @date: 2020年9月26日下午7:13:12
 */
// 输出偶数
class NumThread2 implements Runnable {

	@Override
	public void run() {

		for (int i = 0; i < 100; i++) {
			if (i % 2 == 0) {

				System.out.println(Thread.currentThread().getName() + " : " + i);
			}
		}
	}

}

// 输出奇数
class NumThread2_2 implements Runnable {

	@Override
	public void run() {

		for (int i = 0; i < 100; i++) {
			if (i % 2 != 0) {

				System.out.println(Thread.currentThread().getName() + " : " + i);
			}
		}
	}

}

public class day2_thread9 {
	public static void main(String[] args) {
		// 1： 提供指定线程数量的线程池
		ExecutorService pool = Executors.newCachedThreadPool();

		// 1.1 设置线程池的属性---需要先进行转换。因为ExecutorService是一个接口，并不是一个对象。
		ThreadPoolExecutor s1 = (ThreadPoolExecutor) pool;
		s1.setCorePoolSize(15);

		// 2： 执行指定的线程操作，需要提供实现Runnable或Callable接口的对象
		s1.execute(new NumThread2()); // 适合用于Runnable
		s1.execute(new NumThread2_2()); // 适合用于Runnable
//		FutureTask f1 = pool.submit();					// 适合用于Callable

		// 3： 关闭线程池
		s1.shutdown();
	}
}
