package middlejava;

/**
 * @Description: ʹ��ͬ����������̵߳İ�ȫ���� ------------- �� ��������Ϊ�������
 * @author: linjing 1395876278@qq.com
 * @date: 2020��9��25������8:31:04
 * 
 * 	
 *  4�� ʹ��ͬ����������̵߳İ�ȫ����
 *  		��������������ݵķ���������������һ�������У����ǿ��԰������������Ϊͬ����
 *  	 
 *  	ͬ��������Ȼ��Ҫͬ����������
 *  		�Ǿ�̬ͬ�������ļ������ǵ�ǰ�ģ�	this
 *  		��̬��ͬ�������ļ������ǵ�ǰ�౾������.class
 *  
 */

class Window2 implements Runnable {
	private int ticket = 100;
	private synchronized void show() {

		if(ticket >0 ) {
			
			System.out.println("����ȥ��Ʊ��Ϊ�� "+ticket);
			ticket -- ;
		}
	}
	public void run() {
		while(true) {
			show();
			if(ticket<=0) {
				// ÿ���̶߳���ִ�е�����һ�Σ������Ƴ�while��ѭ����������������߳�.����ʱ�·���isAlive��Ȼ���Ϊtrue��
				//  	System.out.println("------------------------"+t1.isAlive()+" "+t2.isAlive()+" "+t3.isAlive());��Ϊ��û������˳�ѭ�������̡߳�
				System.out.println("****:   "+Thread.currentThread().isAlive());
				break;
			}
			System.out.println("----------------------");
		}
	};
}

public class day2_thread2 {
	public static void main(String[] args) {
		Window2 window2 = new Window2();
		Thread t1 = new Thread(window2);
		Thread t2 = new Thread(window2);
		Thread t3 = new Thread(window2);
		t1.start();
		t2.start();
		t3.start();
	
	}
}
