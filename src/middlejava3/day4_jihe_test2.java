package middlejava3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.junit.Test;

/**
 * 		集合元素的迭代器iterator :
 * 			遍历用的两个方法: hasNext() 与 Next()
 * 			删除操作: remove();
 * 				如果iterator 还未调用next() 或 在上一次调用next()方法后连续多次调用remove()方法,就会报错
 * 
 * 		foreach() 的使用:
 * 			JDK5.0 新增了foreach 用于遍历集合与数组			
 * 
 * 
 * 
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020年10月15日下午11:21:42
 * 
 */
public class day4_jihe_test2 {
	@Test
	public void test() {
		@SuppressWarnings("rawtypes")
		Collection  collection =new ArrayList();
		collection.add(123);
		collection.add("asd");
		collection.add(458);
		collection.add("linjing");
		collection.add("----");
		collection.add("++++++");
		System.out.println("*********************  遍历方法的使用 ***********************");
		@SuppressWarnings("rawtypes")
		Iterator iterator = collection.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("*********************  remove()方法的使用 ***********************");
		iterator = collection.iterator();
		iterator.next();
		iterator.remove();
		System.out.println(collection);
		
	}
	/**
	 * 	foreach的使用
	 * @Description: 
	 * @author: linjing 1395876278@qq.com
	 * @date: 2020年10月19日下午10:35:09
	 */
	@Test
	public void test2() {
		@SuppressWarnings("rawtypes")
		Collection  collection =new ArrayList();
		collection.add(123);
		collection.add("asd");
		collection.add(458);
		collection.add("linjing");
		collection.add("----");
		collection.add("++++++");
		// for(集合中元素的类型 局部变量: 集合对象)
		for (Object item : collection) {
			System.out.println(item);
		}
	}
}

















