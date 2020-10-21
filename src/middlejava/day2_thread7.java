package middlejava;

/**
 * @Description: 线程的通信 ----- 生产者 与 消费者问题
 * @author: linjing 1395876278@qq.com
 * @date: 2020年9月25日下午8:31:04
 * ------------------------------------- ----------------------------------------------
 *  生产者（Productor）将产品交给店员（Clerk），而消费者（Customer）从店员处取走产品，店员一次只能持有固定数量的产品（比如：20），
 *  如果生产者试图生产更多的产品，店员就会叫生产者暂停一下。如果店中有空位放产品时候再通知生产者进行生产；如果店中没有产品了，
 *  店员就会叫消费者等一下，如果店中有产品了，再通知消费者取走产品。
 *  
 *  分析问题：
 *  	是否有多线程： 生产者线程、消费者线程；
 *  	是否有共享数据： 是，店员（或产品数量）
 *  	如何解决线程安全问题： 使用同步机制，有三种方法
 *      是否涉及线程通信： wait， notify
 */
class Clerk{
	private int productNum = 0;

	public synchronized void  produceProduct() {
			if(productNum <20) {
				productNum ++;
				System.out.println(Thread.currentThread().getName()+" :开始生产第 "+productNum+" 个产品");
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
				System.out.println(Thread.currentThread().getName()+" :开始消费第 "+productNum+" 个产品");
				productNum --;
				notify();
			}else {
				// 等待
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
}
// 生产者
class Productor implements Runnable {
	private Clerk clerk;
	public Productor(Clerk clerk) {
		this.clerk = clerk;
	}
	public void run() {
		System.out.println(Thread.currentThread().getName()+ "开始生产产品： ");
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

// 消费者
class Customer implements Runnable{
	private Clerk clerk;
	public Customer(Clerk clerk) {
		this.clerk = clerk;
	}
	public void run() {
		System.out.println(Thread.currentThread().getName()+ "开始消费产品： ");
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

// main 函数 
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
