package helloword;
/**
 *  a:对象的实例化全过程：
 *  	当通过子类的构造器创建子类对象时候，一定会直接或间接的调用父类构造器，直到调用了java.lang.object类
 *    中空参构造器为止。正因为加载过所有的父类的结构，所以才可以看到内存中有父类结构，子类对象才可以进行调用。
 *    
 *   b: 创建子类过程中，虽然调用了父类的构造器，当自始至终都只创造了一个对象。即：new对象。
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020年9月11日上午8:10:54
 */

class father{
	String nameString = "linjing";
	public father(String nameString) {
		this.nameString = nameString;
		// TODO Auto-generated constructor stub
	}
	
}
public class object_shilihua extends father {
	public object_shilihua(String name) {
		super(name);
	}
	public void test(int... a ) {
		System.out.println(a);
	}
//	public void test(int[] a ) {
//		System.out.println(a);
//	}
	public static void main(String[] args) {
		object_shilihua o1 = new object_shilihua("linsda");
		System.out.println("asdadasda");
		o1.test(1,2,3,4);
	}
}
