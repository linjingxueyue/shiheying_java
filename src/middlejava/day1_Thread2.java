package middlejava;
/**
 *  Thread ���еĳ��÷�����
 *  	1��start(): 	������ǰ�̣߳����õ�ǰ�̵߳�run()
 *      2��run():   	ͨ����Ҫ��дThread��Ĵ˷������������̵߳�ִ�в��������ڴ��߳���
 *      3��currentThread(): ���ص�ǰִ�д����������߳�
 *      4��getName():	��ȡ��ǰ�̵߳�����
 *      5��setName():   ���õ�ǰ�̵߳�����
 *      6: yield():		�ͷŵ�ǰCPU��ִ��Ȩ����sleepһ�������ͷŵ�ǰ����
 *      7��join():		���߳�A�е����߳�B.join()��������ʱ�߳�A�ͽ�������״̬��ֱ���߳�Bִ����ϣ��Ż����������������ʼִ���߳�A��
 *      8��sleep(long milltime):  �÷����Ĳ����Ǻ��롣����milltime���룬����������ȴ�CPU��������
 *      9: isAlive(): 	�ж��߳��Ƿ���
 *      10.getPrioruty():  ��ȡ�̵߳����ȼ�
 *      11�� setPrioruty(): �����̵߳����ȼ�
 *      -----------------------------------------------------------------------------------------
 *      �߳�ͨ�ų��õ����������� ����������������������Object�൱�У�
 *      	wait()��notify()��notifyAll() 
 *      	wait()ִ�к�,�������ͬ��״̬,�ͻ��ͷ���
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020��9��25������12:50:43
 */

class MyThread3 extends Thread{
	public void run() {
		for(int i=0;i<100;i++) {
			if(i%2==0) {
				try {
					sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+": "+i);
			}
		}
	}
}

public class day1_Thread2 {
	public static void main(String[] args) {
		MyThread3 myThread3 = new MyThread3();
		// startǰ�����������߳� ȡ��
		myThread3.setName("linjing");
		myThread3.start();
		// �� ���߳�ȡ��
		Thread.currentThread().setName("���̣߳�");
		for(int i=0;i<100;i++) {
			if(i%2!=0) {
				System.out.println(Thread.currentThread().getName()+": "+i);
				if(i==19) {
					try {
						myThread3.join();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		System.out.println("---------------------------------"+myThread3.isAlive());
		
	}
}
