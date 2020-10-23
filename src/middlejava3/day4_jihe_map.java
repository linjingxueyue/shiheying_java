package middlejava3;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;


import org.junit.Test;


/**
 * 		1：Map:  存储键值对
 * 			|----- HashMap:	  作为Map的主要实现类，  线程不安全，效率高。 可以存储Null值的key或value。
 * 
 * 				|------ LinkedHashMap:  是HashMap的子类，其可以保证在遍历map元素时候，可以按照添加的顺序进行遍历。
 * 										原因在于： 在原有的HashMap的基础上，对每一存储实例添加了一对指针，指向前一个与
 * 									后一个存储实例。
 * 										对于频繁的遍历操作，此类执行效率高于HashMap
 * 
 * 			|----- TreeMap:				可以针对添加实例的key-value进行排序，实现排序遍历。此时是针对key进行的排序。
 * 										其底层采用红黑树存储。
 * 
 * 			|----- Hashtable:	作为古老实现类，线程安全，效率低。不可以存储Null值的key或value。
 * 
 * 				|---- Propertries:	常用来处理配置文件。key 与 value 都是String类型
 * 	----------------------------------------------------------------------------------------------
 * 
 * 		2：HashMap 与 Hashtable:
 * 				最初在	JDK7 时候，采用 数组+链表 的形式进行存储。
 * 						JDK8时候，采用 数组+链表+红黑树 的形式进行存储。
 * 
 * 		3： Map结构的理解：(存疑， 源码里面对于Entry的存储使用的是entry数组，并不是Set。 
 * 						----- 最新理解1： HashMap内部会有一个Set，collction集合用于统计map中的key与value,
 * 						所以老师才会这么讲，是以这些结构存储。具体见keySet()、values()、entrySet()方法
 * 						----- 最新理解1.2：keySet()、values()、entrySet()的理解以entrySet()举例说明：
 * 						其实就是返回一个Set的子类，该子类内部含有一个迭代器，不断对HashMap的table数组进行迭代 。
 * 						其余的两个方法都是在这个方法的基础上进行进一步的搜索。)
 * 
 * 			Map的key: 	无序、不可重复， 使用set结构进行存储；  
 * 							--- 》 如何避免key重复？ 因此要求key所在的类重写equals()与hashcode()方法。（以HashSet为例进行说明）
 * 			Map的value:  无序，可重复，使用Collection存储。
 * 							---》value所在的类也需要重写 equals()方法
 * 			一个键值对：   key-value 构成一个Entry对象。
 * 			Map中的Entry： 无序、不可重复的，使用Set结构进行存储
 * 
		4： HashMap 的 底层 添加原理：
		 （以 JDK 7中的为例：）
			 这一部分的内容参考HashSet的添加原理。 唯一不同地方如下所示：
			 		当所添加元素key1,与数组位置上的元素key比较哈希值且相等，key1.equals(key)仍然相等时候，
			 	需要时候key1的value值 替换 原来位置上的key的哈希值
			 在不断添加的过程中，默认的扩容方式（超出临界值，且要存放的位置非空）： 扩充为原来容量的2倍，并将原来的数据复制过来。
		 JDK 8 相比较于JDK7 所有的不同：
			1：new HashMap()对象时候，底层没有创建一个长度为16的数组。
			2：JDK 8的底层数组 是： Node[] table;而不是JDK 7中的Entry[] table
			3：首次调用put方法时候，底层才会创建长度为16的数组。
			4： 当数组某一个索引位置上的元素以链表形式存在的数据个数 >8 ，且当前数组长度 > 64时候，此索引位置上的所有数据改为使用红黑树进行存储。
			
		5: LinkedHashMap中关于能够按照添加顺序遍历的源码如下：
				static class Entry<K,V> extends HashMap.Node<K,V> {
        			Entry<K,V> before, after;
        			Entry(int hash, K key, V value, Node<K,V> next) {
            			super(hash, key, value, next);
        			}
    			}
   -------------------------------------------------------------------------------------------------------
    	6： 额外注解：
    		HashSet的add(obj)方法，其实本质调用的也是map的put方法，只是将obj作为map的key存入。
    		此时的value仅仅是一个不可变得常量 PRESENT = new Object();
    		HashSet的 add方法的源码如下：
    				 public boolean add(E e) {
        				return map.put(e, PRESENT)==null;
    				}
 -------------------------------------------------------------------------------------------------------
   		7： map 中的常用方法：
   			Object put(object key,object value):  将指定的key- value 添加入（修改）当前的Map对象当中
   			void putAll(Map m)：			将 m 中所有的key-value存入当期的map对象当中
   			Object remove(object key)：  根据key移除当期map对象对应的键值对。并返回value
   			void clear()			清空当期的map对象
   			---------------
   			Object get(object key):  获取指定key对应的value
   			boolean containskey(object key):  是否包含指定的key
   			boolean containsvalue(object value):是否包含指定的value
   			int size(): 返回当前map中key-value的个数
   			boolean isEmpty(): 判断当前map是否为空
   			boolean equal(object obj): 判断当前map和参数对象obj是否相等
   			-----------------
   			Set krySet(): 返回当前所有key构成的Set集合
   			Collection values():返回当前所有vlaue构成的Collection集合
   			Set entrySet(): 返回所有key-value对构成的集合
   			
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020年10月20日下午11:08:00
 * 
 */
public class day4_jihe_map {
	@Test
	public void test() {
		Map set =new HashMap();
		set.put(null,null);
		System.out.println(set);
		Map set2=new Hashtable();
//		set2.put(null,null);			// --- error 
		new LinkedHashMap();
		new HashSet<>();
	}
	
	@Test
	public void test2() {
		Map map=new HashMap();
		map.put("AA", "123");
		map.put(34, "adasdas");
		map.put("name", "linjing");
		Set set = map.keySet();
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("----------------------------");
		Collection collection = map.values();
		Iterator iterator2 = collection.iterator();
		while(iterator2.hasNext()) {
			System.out.println(iterator2.next());
		}
		System.out.println("----------------------------");
		Set set2 = map.entrySet();
		Iterator iterator3 = set2.iterator();
		while(iterator3.hasNext()) {
			System.out.println(iterator3.next());
		}
	}
}















































































