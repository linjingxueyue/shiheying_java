package middlejava3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

/**
 * 		Set的学习:  ---------- 该接口没有额外的定义新的方法,使用的都是父类Collection中声明过渡方法
 * 
 * 			0:  特点: 
 * 					无序:		无序性 并不等于 随机性. 以HashSet为例说就是: 
 * 									存储的数据再底层数组中并不是按照数组索引的顺序添加,而是根据数据的哈希值进行添加
 * 								这里的无序性指的是相较于List接口中的实例,其内部的内存地址并不是连续的
 * 								
 * 				    不可重复:	本质仍然是用equals()进行比较,但是在利用之前会先用hashcode()进行地址值比较
 * 								
 * 
 * 			1: set 接口总共可以分为:HashSet、LinkedHashSet、TreeSet 三类.
 * 			
 * 			2:  HashSet :		set接口的主要实现类(常用类). 线程不安全. 可以存储null值. 底层是数组+链表的形式。（这是JDK 7的底层实现）
 * 				LinkedHashSet:  作为HashSet的子类, 遍历其内部数据时候,可以按照添加的顺序进行遍历
 * 				TreeSet:		可以按照添加元素的指定属性进行排序,底层以红黑树进行存储.
 * 
 * 			3:  添加元素a的过程: 以HashSet --- JDK 7 为例:
 * 					1: 计算a的哈希值,并根据该值以某种映射算法,算出其在数组中的具体位置.该位置即为索引
 * 					2: 判断该位置是否已经存在元素,
 * 							如果没有则直接添加成功.																--------- 情况 1
 * 							如果有其他元素b(或以链表形式存在的其他元素),则比较元素a与b的哈希值,
 * 									如果哈希值不相同,则元素a添加成功.											-------------- 情况 2
 * 									哈希值相同时,进而调用a的equals()方法,根据该方法的返回值来进行判读是否添加.  --------- 情况3 
 * 											equals()方法返回true,则元素a添加失败
 * 											equals()方法返回flase,则元素a添加成功
 * 					3： 对于同一位置添加成功的情况，以链表的形式进行存储多个值
 * 			4： 总结：
 * 					1： 向Set中添加的数据，其所在的类必须重写equals()与hashcode()两个方法。
 * 					2： 重写的这两个方法，尽可能的保持一致性。（相等的对象一定具有相同的哈希值）
 * 
 * 			5： LinkHashSet ：
 * 					其实例在添加数据的时候，还给每个数据维护了两个引用，记录此数据的前一个和后一个数据。
 * 				 因此能够在输出时候按照添加顺序进行输出。
 * 					优点：对于频繁的遍历操作，其效率相比较于HashSet来讲，比较高。
 * 
 * 			6: TreeSet: 
 * 				  1: 在进行add()添加元素的时候，因为TreeSet的特性就是可以根据指定属性排序，所以其不能添加不同类型的对象。
 * 				  2: 在添加过程中，并不以hashcode() 、equals()方法作为比较手段，
 * 			 而是以所添加对象的类的compareTo方法或compare()方法作为判断依据。（之所以是两种不同的比较方法，对应两种不同的排序：自然排序于定制排序）
 * 			同时，即使该Treeset实例调用contains()，remove(）等方法时候，也不需要equals()方法，而是需要compare()或compareTo() 
 * 
 * @Description: 		
 * @author: linjing 1395876278@qq.com
 * @date: 2020年10月20日下午1:00:38
 */
public class day4_jihe_test4 {
	// ----------------------- HashSet的 使用 ---------------------------------------------------
	@Test
	public void test() {
		Set set = new HashSet();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add("ABC");
		set.add("678");
		
		
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());		// 输出顺序与添加顺序并不一致
		}
	}
	
	// ----------------------- LinkHashSet的 使用 ---------------------------------------------------
	@Test
	public void test2() {
		Set set = new LinkedHashSet();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add("ABC");
		set.add("678");
	
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());		// 输出顺序与添加顺序一致 . (注： 但是这也不意味这无序性失效)
		}
	}
	// ----------------------- TreeSet的 使用 ---------------------------------------------------
		@Test
		public void test3() {
			Set set = new TreeSet();
			set.add(1 );
			set.add(2);
			set.add(3);
			set.add(0);
			set.add(678);
		
			Iterator iterator = set.iterator();
			while(iterator.hasNext()) {
				System.out.println(iterator.next());		// 输出顺序与添加顺序一致 . (注： 但是这也不意味这无序性失效)
			}
		}
}







