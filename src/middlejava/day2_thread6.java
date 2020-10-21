package middlejava;



/**
 * @Description: �̵߳�ͨ�� ----- ʹ�������߳̽����ӡ1 �� 100
 * @author: linjing 1395876278@qq.com
 * @date: 2020��9��25������8:31:04
 * ------------------------------------- ----------------------------------------------
 * 	1:	�߳�ͨ��wait notify notifyAll  ֻ������ͬ��������ͬ��������.   (synchronized)
 * 		Lock ��ʽ�� �߳�ͨ��,����������ķ���
 *  
 *  2:    synchronized  ��ʽ���߳�ͨ����,����ͨ�ź����ĵ����߱�����synchronized�е�ͬ��������(��)��ͬһ������.
 *      ����,����.
 *      
 *  3:  ���������ͨ�ŷ���,�Ƕ����� Java.lang.Object ����.
 * -----------------------------------------------------------------------------------------
 * 	 wait()     : һ��ִ�д˷���,��ǰ�߳̾ͻ��������״̬,���ͷ�ͬ��������(��)
 *   notify()   : һ��ִ�д˷���,�ͻỽ�ѱ�wait()��һ���߳�,����ж���̱߳�wait(),�ͻỽ�����ȼ��ߵ��Ǹ�
 *   NotifyAll(): ��������wait()���߳�.
 * -------------------------------------------------------------------------=-------------------
 * 	4�� sleep() ��wait()��ʽ����ͬ��
 * 		1����ͬ�㣺 һ��ִ�з�����������ʹ���߳̽�������״̬��
 * 		2����ͬ�㣺 a.����λ�ò�ͬ�� sleep() ����������Thread���У�wait()����������Object����
 * 					b.����Ҫ��ͬ�� sleep()�������κ���Ҫ�ĳ����µ��á�wait()����ֻ����ͬ��������ͬ��������н��е��á�
 * 					c.�Ƿ��Ƿ���������⣺ ������߶���ͬ��������ͬ���������е��ã�wait()���ͷ�ͬ����������sleep()���ᡣ
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
