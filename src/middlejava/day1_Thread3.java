package middlejava;

/**
 * �������̵߳Ĳ���:
 *  1: ����һ��ʵ����Runnable�ӿڵ��� 
 *  2��ʵ����ĳ��󷽷���run()
 *  3: ���������ʵ��������
 *  4�����˶��󴫵ݵ�Thread��Ĺ������У�ʵ����һ��Thread��Ķ��� 
 *  5�� ����Thread������start()����
 * 
 * @Description:
 * @author: linjing 1395876278@qq.com
 * @date: 2020��9��25������12:50:43
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
		// startǰ�����������߳� ȡ��
		thread.setName("linjing");
		thread.start();
		// �� ���߳�ȡ��
		Thread.currentThread().setName("���̣߳�");
		for (int i = 0; i < 100; i++) {
			if (i % 2 != 0) {
				System.out.println(Thread.currentThread().getName() + ": " + i);
			}
		}
		System.out.println("---------------------------------" + thread.isAlive());

	}
}
