package middlejava;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *    创建线程的方式三： 
 *    		使用Callable的方式                   ---------------- 便利100以内的偶数，并返回所有数的和
 *    			1： 创建一个实现callable接口的类
 *    			2： 该类实现call()方法，将此线程需要执行的操作声明再call()中。
 *    			3： 创建一个callable接口实现类的对象
 *    			4： 将该对象传递到FutureTask构造器中，创建FutureTask的对象
 *    			5： FutureTask的对象 传递到Thread类的构造器中，创建Thread类的对象。并调用start()方法。
 *    			6： 如果需要返回值，调用 FutureTask的对象d的get方法。
 *    ----------------------------------------------------------------------------------------
 *    如何理解 创建Callable接口方式创建的多线程比Runnable方式强大：
 *    	1： call() 有返回值
 *    	2： call() 可以抛出异常，被外面捕获
 *    	3： callable 支持泛型。
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020年9月26日下午7:13:12
 */

class NumThread implements Callable{

	@Override
	public Object call() throws Exception {
		int sum = 0;
		for(int i = 0;i<100;i++) {
			if(i%2==0) {
				sum +=i;
				System.out.println(i);
			}
		}
		//装箱
		return sum;
	}
	
}
public class day2_thread8 {
	public static void main(String[] args) {
		NumThread numThread = new NumThread();
		FutureTask f1 = new FutureTask(numThread);
		new Thread(f1).start();
		try {
			// get()返回值就是FutureTask构造器参数Callable实现类重写call()的返回值
			Object o1 = f1.get();
			System.out.println("sum: "+o1);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("sdas");
	}
}
