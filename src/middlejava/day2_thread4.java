package middlejava;

/**
 * 	
 * @Description: 死锁问题 的演示
 * @author: linjing 1395876278@qq.com
 * @date: 2020年9月25日下午11:49:13
 */
public class day2_thread4 {
	public static void main(String[] args) {
		StringBuffer s1 = new StringBuffer();
		StringBuffer s2 = new StringBuffer();
		new Thread() {
			public void run() {
				synchronized (s1) {
					s1.append('a');
					s2.append('1');
					try {
						sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized (s2) {
						s1.append('b');
						s2.append('2');
					}
				}
			};
		}.start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized (s2) {
					s1.append('c');
					s2.append('3');
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized (s1) {
						s1.append('d');
						s2.append('4');
					}
				}
			}
			
		}).start();
		System.out.println("---");
	}
} 
