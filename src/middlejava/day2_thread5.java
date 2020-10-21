package middlejava;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: ʹ�� Lock ���ķ�ʽ ����̵߳İ�ȫ���� ------------- �� ��������Ϊ�������
 * @author: linjing 1395876278@qq.com
 * @date: 2020��9��25������8:31:04
 * 
 * 	
 * 1�� ʹ��Lock��ʽ����̵߳İ�ȫ����
 * 
 * 2:  synchronized �� Lock ����ͬ��		
 *  		��ͬ�㣺 ���߶����Խ���̰߳�ȫ����
 *  		��ͬ�㣺 synchronized ������ִ������Ӧ��ͬ������󣬻��Զ��ͷ�ͬ����������
 *  				Lock��Ҫ�ֶ�����ͬ����lock()����ͬʱ������ͬ��Ҳ��Ҫ�ֶ�ʵ�֣�unlock()����
 *  
 * 3�� ע���: Lock�ķ�ʽҲ��Ҫע�⣺����߳���Ҫ����һ��Lock �ſ���ʵ��ͬ��
 */
class Window6 implements Runnable {
	private int ticket = 100;
	private ReentrantLock Lock =  new ReentrantLock();
	
	
	public void run() {
		while (true) {
			try {
				// ���� Lock.lock()����
				Lock.lock();
				if (ticket > 0) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("���ں�Ϊ�� "+Thread.currentThread().getName()+"  ����ȥ��Ʊ��Ϊ�� " + ticket);
					ticket--;
				} else {
					break;
				}
			}finally {
				// ����unlock() �������н�����
				Lock.unlock();
			}
			
		}
	};
}

public class day2_thread5 {
	public static void main(String[] args) {
		Window6 window2 = new Window6();
		Thread t1 = new Thread(window2);
		Thread t2 = new Thread(window2);
		Thread t3 = new Thread(window2);
		t1.start();
		t2.start();
		t3.start();

	}
}
