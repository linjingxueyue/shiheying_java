package middlejava3;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;



/**
 * 	泛型的学习与理解：
 * 		 1： 泛型就是在定义类、接口的时候，通过一个标识表示类中某个属性的类型或者是某个方法的返回值及参数类型。
 * 		 
 * 		 2： 泛型的初步体验： test()方法
 * 
 * 		 3：泛型不同的引用 不可以相互赋值。
 * 
 * 		 4： 异常类不可以声明为泛型类。
 * 
 * 		 5：静态方法中，不可以使用类的泛型
 * 
 * 		6：想要在泛型类中声明一个泛型类型的数组需要用如下方式：
 *  		T【】 arr = new T[]10;			// error 
 * 			T[] arr = (T)new Object[10];	// 但此时需要注意的是，该数组的子元素必须是T类型或者其子类对象
 * 
 * 		7: 泛型方法：   test3()方法
 * 			在方法中出现了泛型结构。泛型方法的泛型参数与类的泛型参数没有任何关系。
 * 			泛型方法 对于 所在的类或者接口 是不是泛型的 无所谓。
 * 			泛型方法可以声明为静态的， 原因：泛型参数是在调用方法时候确定的，并非在实例化类的过程中确定的
 * @author PC
 *
 */
public class day4_fanxing_test {
	@Test
	public void test() {
		// 标准写法
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		// JDK 7.0 的新特性。
//		ArrayList<Integer> arrayList2 = new ArrayList<>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(4);
		// 编译时候进行类型检查
//		arrayList.add("asd");		----------------// error 编译时候就可以发现
		for(Integer a : arrayList) {
			// 避免了强转操作
			int b = a;
			System.out.println(b);
		}
		System.out.println("--------------------------------------------------");
		System.out.println(arrayList);
	}
	
	@Test
	public void test2() {
		// 如果定义了泛型,类实例化时候没有指明类的泛型,则认为此泛型类型是 Object 类型. (建议实例化时候指明类泛型的类型
		order o = new order();
		o.setOrderT("ordert--linsda");
		System.out.println(o);
		// --------------------------------- 子类实例化时候的区别  -----------------------------------------
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
 * 	自定义泛型类
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
	// 泛型方法的举例：
	 public <A> List<A> test_fanxing(A[] arr){
		return null;	
	}
}

/**
 * 		此继承时候，父类指明了泛型的类型，此时子类就不再是泛型类
 * @author PC
 *
 */
class suborder1 extends order<Integer>{
	
}


/**
 * 		此继承时候，父类没有指明泛型的类型，此时子类就还是泛型类
 * @author PC
 *
 */
class suborder2<T> extends order<T>{
	
}













