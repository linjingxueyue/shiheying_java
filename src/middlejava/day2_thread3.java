package middlejava;

/**
 * @Description: 单例模式中懒汉式 遗留的线程安全问题解决
 * @author: linjing 1395876278@qq.com
 * @date: 2020年9月25日下午8:31:04
 * 
 * 		解决方式：
 * 			采用 同步方法的 模式：
 * 					public  static  synchronized Window4 createInstance() {
 * 			采用synchronized代码块的方式。
 * 					synchronized (Window4.class) {
 * 					}
 * 		解决方式的优化：
 * 			这两种方式的效率都比较低，因为针对懒汉式单例模式的线程安全问题，也就停留在一开始多个线程同事涌入，创建多个实例的
 *   	  时候，当实例创建完毕，也就不存在所谓的线程安全问题，此时再弄这些同步方法（代码块）就使得程序效率变低。
 *   		优化的方式：使得也就是开始进行了同步方法（代码块）的使用，往后就正常使用。
 */

// 懒汉式
class Window4  {
	private static Window4 instanceWindow4 = null;

	private Window4() {

	}
// 采用 同步方法的 模式：
	//	public  static  synchronized Window4 createInstance() {
	//		if (instanceWindow4 == null) {
	//			instanceWindow4 = new Window4();
	//		}
	//		return instanceWindow4;
	//	}

// 采用synchronized代码块的方式。
	//	public  static   Window4 createInstance() {
	//		synchronized (Window4.class) {
	//			if (instanceWindow4 == null) {
	//				instanceWindow4 = new Window4();
	//			}
	//			return instanceWindow4;
	//		}
	//	}
// 优化
	public  static   Window4 createInstance() {
		if(instanceWindow4 == null) {
			synchronized (Window4.class) {
				if (instanceWindow4 == null) {
					instanceWindow4 = new Window4();
				}
			}
		}
		return instanceWindow4;
	}
}

public class day2_thread3 {
	public static void main(String[] args) {

	}
}
