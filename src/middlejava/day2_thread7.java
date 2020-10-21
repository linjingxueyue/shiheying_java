package middlejava;

/**
 * @Description: �̵߳�ͨ�� ----- ������ �� ����������
 * @author: linjing 1395876278@qq.com
 * @date: 2020��9��25������8:31:04
 * ------------------------------------- ----------------------------------------------
 *  �����ߣ�Productor������Ʒ������Ա��Clerk�����������ߣ�Customer���ӵ�Ա��ȡ�߲�Ʒ����Աһ��ֻ�ܳ��й̶������Ĳ�Ʒ�����磺20����
 *  �����������ͼ��������Ĳ�Ʒ����Ա�ͻ����������ͣһ�¡���������п�λ�Ų�Ʒʱ����֪ͨ�����߽����������������û�в�Ʒ�ˣ�
 *  ��Ա�ͻ�������ߵ�һ�£���������в�Ʒ�ˣ���֪ͨ������ȡ�߲�Ʒ��
 *  
 *  �������⣺
 *  	�Ƿ��ж��̣߳� �������̡߳��������̣߳�
 *  	�Ƿ��й������ݣ� �ǣ���Ա�����Ʒ������
 *  	��ν���̰߳�ȫ���⣺ ʹ��ͬ�����ƣ������ַ���
 *      �Ƿ��漰�߳�ͨ�ţ� wait�� notify
 */
class Clerk{
	private int productNum = 0;

	public synchronized void  produceProduct() {
			if(productNum <20) {
				productNum ++;
				System.out.println(Thread.currentThread().getName()+" :��ʼ������ "+productNum+" ����Ʒ");
				notify();
			}else {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}

	public synchronized void consumeProduct() {
			if(productNum >0) {
				System.out.println(Thread.currentThread().getName()+" :��ʼ���ѵ� "+productNum+" ����Ʒ");
				productNum --;
				notify();
			}else {
				// �ȴ�
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
}
// ������
class Productor implements Runnable {
	private Clerk clerk;
	public Productor(Clerk clerk) {
		this.clerk = clerk;
	}
	public void run() {
		System.out.println(Thread.currentThread().getName()+ "��ʼ������Ʒ�� ");
		while(true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			clerk.produceProduct();
		}
	};
}

// ������
class Customer implements Runnable{
	private Clerk clerk;
	public Customer(Clerk clerk) {
		this.clerk = clerk;
	}
	public void run() {
		System.out.println(Thread.currentThread().getName()+ "��ʼ���Ѳ�Ʒ�� ");
		while(true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			clerk.consumeProduct();
		}
	};
}

// main ���� 
public class day2_thread7 {
	public static void main(String[] args) {
		Clerk clerk = new Clerk();
		Productor p1 = new Productor(clerk);
		Customer c1 = new Customer(clerk);
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(c1);
		t1.start();
		t2.start();
		
	}
}
