package middlejava3;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;

/**
 * 	1：集合 之 list 接口 的学习:
 * 		  
 * 		  list接口可以分为ArrayList、LinkList、Vector三种。
 * 
 * 		  ArrayList： 作为List接口的主要实现类。执行效率高。线程不安全。 底层使用Object[] elementData 进行存储.
 * 
 * 		  LinkList：   对于频繁的插入与删除操作,使用此类时候效率比ArrayList效率高。 底层使用 双向链表 进行存储.
 * 			
 * 		   Vector：   作为List接口的古老实现类（很早就有）。 线程安全. 底层使用Object[] elementData 进行存储.
 * 
 *   2： ArrayList、LinkList、Vector三者的异同：
 *   		同： 三者都实现了List接口,存储数据的特点相同:有序、可重复。
 *   		不： 见上面
 * 
 * 	 3: ArrayList 的源码分析. (JDK7 与 JDK8 下面的源码不同)
 * 			JDK7:
 * 				new ArrayList()创建时候直接创建容量是默认是长度10的数组,
 * 				add(obj)过程中超出后,默认扩容到原数组的1.5倍。
 * 
 * 			    结论:
 * 				  开发过程中,建议使用带参构造器,尽量避免创建过程中进行扩容.
 * 			JDK8:
 * 				new ArrayList()创建时候,首先创建一个实际长度为0的数组{},当第一次进行add()操作时候,
 * 				再创建一个容量为10的数组.
 * 
 * 	        总结:
 * 				JDK7中的对象创建过程像单列模式中的恶汉式,JDK8中的对象创建过程像单例模式中的懒汉式,延时了数组创建,节省了内存.
 * 
 * 	 4: LinkList 的 源码分析:
 * 			内部维护了一个Node内部类,用以实现双向链表
 * 
 *   5: Vector 的源码分析.
 * 			创建实例对象时候,默认容量长度为10,当扩容时候,直接就是原数组长度的2倍.
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020年10月19日下午11:04:20
 */
public class day4_jihe_test3 {
	@Test
	public void test() {
		int[] a = {};
		
		System.out.println(a.length);
		
//		LinkedList<E>
	}
}
