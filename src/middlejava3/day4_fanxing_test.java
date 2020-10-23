package middlejava3;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;



/**
 * 	���͵�ѧϰ����⣺
 * 		 1�� ���;����ڶ����ࡢ�ӿڵ�ʱ��ͨ��һ����ʶ��ʾ����ĳ�����Ե����ͻ�����ĳ�������ķ���ֵ���������͡�
 * 		 
 * 		 2�� ���͵ĳ������飺 test()����
 * 
 * 		 3�����Ͳ�ͬ������ �������໥��ֵ��
 * 
 * 		 4�� �쳣�಻��������Ϊ�����ࡣ
 * 
 * 		 5����̬�����У�������ʹ����ķ���
 * 
 * 		6����Ҫ�ڷ�����������һ���������͵�������Ҫ�����·�ʽ��
 *  		T���� arr = new T[]10;			// error 
 * 			T[] arr = (T)new Object[10];	// ����ʱ��Ҫע����ǣ����������Ԫ�ر�����T���ͻ������������
 * 
 * 		7: ���ͷ�����   test3()����
 * 			�ڷ����г����˷��ͽṹ�����ͷ����ķ��Ͳ�������ķ��Ͳ���û���κι�ϵ��
 * 			���ͷ��� ���� ���ڵ�����߽ӿ� �ǲ��Ƿ��͵� ����ν��
 * 			���ͷ�����������Ϊ��̬�ģ� ԭ�򣺷��Ͳ������ڵ��÷���ʱ��ȷ���ģ�������ʵ������Ĺ�����ȷ����
 * @author PC
 *
 */
public class day4_fanxing_test {
	@Test
	public void test() {
		// ��׼д��
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		// JDK 7.0 �������ԡ�
//		ArrayList<Integer> arrayList2 = new ArrayList<>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(4);
		// ����ʱ��������ͼ��
//		arrayList.add("asd");		----------------// error ����ʱ��Ϳ��Է���
		for(Integer a : arrayList) {
			// ������ǿת����
			int b = a;
			System.out.println(b);
		}
		System.out.println("--------------------------------------------------");
		System.out.println(arrayList);
	}
	
	@Test
	public void test2() {
		// ��������˷���,��ʵ����ʱ��û��ָ����ķ���,����Ϊ�˷��������� Object ����. (����ʵ����ʱ��ָ���෺�͵�����
		order o = new order();
		o.setOrderT("ordert--linsda");
		System.out.println(o);
		// --------------------------------- ����ʵ����ʱ�������  -----------------------------------------
		suborder1 suborder1 = new suborder1();
		suborder2<String> suborder2 = new suborder2<String>();
	}
	
	@Test
	public void test3() {
		order<String> order = new order<String>();
		Integer [] arr = new Integer[] {1,2,3,4,5};
		List<Integer> test_fanxing = order.test_fanxing(arr);
	}
}
// ------------------------------------------------------------------------------------------------------
/**
 * 	�Զ��巺����
 * @author PC
 *
 */
class order<T>{
	String name;
	int age;
	T orderT;
	public order() {
		super();
	}
	public order(String name, int age, T orderT) {
		super();
		this.name = name;
		this.age = age;
		this.orderT = orderT;
	}
	public T getOrderT() {
		return orderT;
	}
	public void setOrderT(T orderT) {
		this.orderT = orderT;
	}
	@Override
	public String toString() {
		return "order [name=" + name + ", age=" + age + ", orderT=" + orderT + "]";
	}
	// --------------------------------------------------------
	// ���ͷ����ľ�����
	 public <A> List<A> test_fanxing(A[] arr){
		return null;	
	}
}

/**
 * 		�˼̳�ʱ�򣬸���ָ���˷��͵����ͣ���ʱ����Ͳ����Ƿ�����
 * @author PC
 *
 */
class suborder1 extends order<Integer>{
	
}


/**
 * 		�˼̳�ʱ�򣬸���û��ָ�����͵����ͣ���ʱ����ͻ��Ƿ�����
 * @author PC
 *
 */
class suborder2<T> extends order<T>{
	
}













