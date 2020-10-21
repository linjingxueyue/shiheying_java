package middlejava3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;





/**
 * 	 JAVA中的集合: Collection 与 Map:
 * 		Collection 接口: 单列数据,定义了存取一组对象的方法的集合
 * 			List: 元素有序,可重复的集合；
 * 			Set : 元素无序,不可重复的集合；.
 * 			.... 
 * 
 * 		Map 接口:
 * 			双列数据,以 key-value 形式存储
 * 
 * ------------------------------------------------------------------------
 * 	     向collection接口的实现对象(List接口对象，以及Set接口中除了TreeSet的子接口)中添加obj对象时候,要求obj所在类重写equals方法.
 * 	因为collection实例所在的类内部的contains(obj2) 方法是调用的obj2.equals(obj).
 * 不重写的话,会默认调用Object内部的equals方法,也就是使用"==="进行判断
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020年10月15日下午11:21:42
 * 
 */
public class day4_jihe_test {
public static void main(String[] args) {
//	Arrays arrays = new Arrays();
	int [] a = new int[4];
	a[0]=1;
	a[1]=2;
	a[2]=3;
	a[3]=4;
	@SuppressWarnings("deprecation")
	Object a2 =new Boolean(false);
	System.out.println(String.valueOf(a2));
	
	Person4 a3 = new Person4("linjing",44);
	System.out.println(a3);
	System.out.println("_----------------------------------------------------");
	
	Collection collection =new ArrayList();
	collection.contains(123);
	
	@SuppressWarnings("rawtypes")
//	Collection collection2 = Arrays.asList(1,2,3,4,5,6);
	Collection collection2 = Arrays.asList(new String[] {"aa","vv","bb"});
	@SuppressWarnings("rawtypes")
	Collection collection3 = Arrays.asList(new Integer[] {1,2,3});
	System.out.println(collection2);
	System.out.println(collection3);
}
}
class Person4{
	String nameString;
	int age;
	public Person4() {
		// TODO Auto-generated constructor stub
	}
	public Person4(String nameString, int age) {
		super();
		this.nameString = nameString;
		this.age = age;
	}
	
}
