package middlejava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * �����̵߳ķ�ʽ���� ʹ���̳߳صķ�ʽ 
 * 		1�� �����Ӧ�ٶȣ����ٴ����߳�ʱ�䣩
 * 	    2�� ������Դ���ģ��ظ������̳߳��е��̣߳�����Ҫÿ�ζ������� 3��
 * �����̹߳���
 * 
 * 
 * ----------------------------------------------------------------------------------------
 * 
 * @Description:
 * @author: linjing 1395876278@qq.com
 * @date: 2020��9��26������7:13:12
 */
// ���ż��
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

// �������
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
		// 1�� �ṩָ���߳��������̳߳�
		ExecutorService pool = Executors.newCachedThreadPool();

		// 1.1 �����̳߳ص�����---��Ҫ�Ƚ���ת������ΪExecutorService��һ���ӿڣ�������һ������
		ThreadPoolExecutor s1 = (ThreadPoolExecutor) pool;
		s1.setCorePoolSize(15);

		// 2�� ִ��ָ�����̲߳�������Ҫ�ṩʵ��Runnable��Callable�ӿڵĶ���
		s1.execute(new NumThread2()); // �ʺ�����Runnable
		s1.execute(new NumThread2_2()); // �ʺ�����Runnable
//		FutureTask f1 = pool.submit();					// �ʺ�����Callable

		// 3�� �ر��̳߳�
		s1.shutdown();
	}
}
