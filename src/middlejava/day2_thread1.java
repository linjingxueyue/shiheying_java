package middlejava;

/**
 * @Description: �̵߳İ�ȫ���� ------------- �� ��������Ϊ�������
 * @author: linjing 1395876278@qq.com
 * @date: 2020��9��25������8:31:04
 * 
 * 	1�����⣺ ����Ʊ�����У���������Ʊ����Ʊ---���������̰߳�ȫ����
 * 
 *  2��������ֵ�ԭ��
 *  	��ĳ���̲߳�����Ʊ�Ĺ����У���δ��������ʱ�������̲߳������������Ʊ��
 *  
 *  3����ν���� ��һ���߳�A�ڲ���ticket��ʱ�������̲߳��ܲ��������ֱ���߳�A������Ϻ󣬲����������߳̽�ȥ��
 *         		  �߳�Aδ�������ʱ����ʹ�߳�A��������״̬�������߳�Ҳ���ܽ�ȥ��
 *         
 *  4�� ��JAVA�У���ͨ��ͬ������������̰߳�ȫ���⡣
 *  			��ʽ1�� ͬ�������
 *  				 synchronized(ͬ��������){
 *  						// ��Ҫ��ͬ���Ĵ���
 *  	   						˵���� �����������ݵĴ�����ǹ�����롣
 *  								   �������ݣ� ����̹߳�ͬ���������ݡ� �ڱ����о���ticket
 *  								   ͬ��������: �׳ƣ������κ�һ����Ķ��󶼿��Գ�������
 *  											   ����Ҫ�� Ҫ����Щ�̱߳��빲��ͬһ������
 *  				 }
 *  			��ʽ2�� ͬ������
 *  				��������������ݵķ���������������һ�������У����ǿ��԰������������Ϊͬ����
 *  			��ʽ3��
 *  					Lock�ķ�ʽ
 *  5��ͬ���ķ�ʽ��������̰߳�ȫ���⡣
 *  	 ����ͬ������ʱ��ֻ����һ���̲߳��룬�����̵߳ȴ����൱����һ�����̵߳Ĺ��̡�
 */

class Window implements Runnable {
	private int ticket = 100;
	public void run() {
		while(true) {
			synchronized (this) {
				if(ticket >0 ) {
					System.out.println("����ȥ��Ʊ��Ϊ�� "+ticket);
					ticket -- ;
				}else {
					break;
				}
			}
		}
	};
}

public class day2_thread1 {
	public static void main(String[] args) {
		Window window = new Window();
		Thread t1 = new Thread(window);
		Thread t2 = new Thread(window);
		Thread t3 = new Thread(window);
		t1.start();
		
		t2.start();
		t3.start();
		System.out.println("------------------------"+t1.isAlive()+" "+t2.isAlive()+" "+t3.isAlive());

	}
}
