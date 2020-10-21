package middlejava3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.junit.Test;

/**
 * 		����Ԫ�صĵ�����iterator :
 * 			�����õ���������: hasNext() �� Next()
 * 			ɾ������: remove();
 * 				���iterator ��δ����next() �� ����һ�ε���next()������������ε���remove()����,�ͻᱨ��
 * 
 * 		foreach() ��ʹ��:
 * 			JDK5.0 ������foreach ���ڱ�������������			
 * 
 * 
 * 
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020��10��15������11:21:42
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
		System.out.println("*********************  ����������ʹ�� ***********************");
		@SuppressWarnings("rawtypes")
		Iterator iterator = collection.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("*********************  remove()������ʹ�� ***********************");
		iterator = collection.iterator();
		iterator.next();
		iterator.remove();
		System.out.println(collection);
		
	}
	/**
	 * 	foreach��ʹ��
	 * @Description: 
	 * @author: linjing 1395876278@qq.com
	 * @date: 2020��10��19������10:35:09
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
		// for(������Ԫ�ص����� �ֲ�����: ���϶���)
		for (Object item : collection) {
			System.out.println(item);
		}
	}
}

















