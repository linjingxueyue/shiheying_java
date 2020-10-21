package middlejava;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *    �����̵߳ķ�ʽ���� 
 *    		ʹ��Callable�ķ�ʽ                   ---------------- ����100���ڵ�ż�����������������ĺ�
 *    			1�� ����һ��ʵ��callable�ӿڵ���
 *    			2�� ����ʵ��call()�����������߳���Ҫִ�еĲ���������call()�С�
 *    			3�� ����һ��callable�ӿ�ʵ����Ķ���
 *    			4�� ���ö��󴫵ݵ�FutureTask�������У�����FutureTask�Ķ���
 *    			5�� FutureTask�Ķ��� ���ݵ�Thread��Ĺ������У�����Thread��Ķ��󡣲�����start()������
 *    			6�� �����Ҫ����ֵ������ FutureTask�Ķ���d��get������
 *    ----------------------------------------------------------------------------------------
 *    ������ ����Callable�ӿڷ�ʽ�����Ķ��̱߳�Runnable��ʽǿ��
 *    	1�� call() �з���ֵ
 *    	2�� call() �����׳��쳣�������沶��
 *    	3�� callable ֧�ַ��͡�
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020��9��26������7:13:12
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
		//װ��
		return sum;
	}
	
}
public class day2_thread8 {
	public static void main(String[] args) {
		NumThread numThread = new NumThread();
		FutureTask f1 = new FutureTask(numThread);
		new Thread(f1).start();
		try {
			// get()����ֵ����FutureTask����������Callableʵ������дcall()�ķ���ֵ
			Object o1 = f1.get();
			System.out.println("sum: "+o1);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("sdas");
	}
}
