package middlejava;
/*
 * 
 线程的操作：
 * 	目录结构：
			day1_Thread：采用继承 Thread类的方式
			day1_Thread2：介绍Thread线程的 各种常用方法
			day1_Thread3：采用 实现Runnable接口的方式
 * 			day2_thread1：线程的安全问题的介绍、同步代码块的书写
 * 			day2_thread2：线程安全问题--同步方法的书写
 * 			day2_thread3：懒汉式单例模式--线程安全问题的解决
 * 			day2_thread4：死锁问题 的演示
 * 			day2_thread5：使用 Lock 锁的方式 解决线程的安全问题.---- Lock 使用的演示、synchronized 与 Lock 的异同
 * 			day2_thread6：线程通信的例子   --------- 使用两个线程交替打印1 到 100、sleep()与wait()的异同
 * 			day2_thread7：线程通信的应用 ------ 生产者 与 消费者问题
 * 			day2_thread8: 新增的创建线程的方式 ---- Callable方式
 * 			day2_thread9: 新增的创建线程的方式 ---- 使用线程池
 * 
 * 
 *  总结：
 *  	释放锁的操作：
 *  		1： 当前线程的同步方法、同步代码块执行结束
 *  		2： 当前线程的同步代码块或同步方法中遇到break,return种植了该代码块
 *  		3： 出现异常Exception
 *  		4:  当前线程的同步代码块或同步方法内部调用了wait()
 *  
 *      不释放锁的操作：
 *      	1： 程序调用了sleep()、yield()方法就释放当前cpu执行权，但是不释放锁资源
 *      	2   线程执行同步代码块时候，其他线程调用了该线程的suspend()方法，将该线程
 *        挂起。但该线程并不会释放锁。（应尽量避免使用suspend和resume()来控制线程）
 * */	
