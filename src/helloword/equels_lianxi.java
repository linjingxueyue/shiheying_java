package helloword;

import java.io.PrintStream;

/**
 *  == 与 equles的区别 
 *  	1： == 运算符
 *  		可以使用再基本数据类型变量与引用数据类型变量当中
 *  			 基本数据类型：			(比较两个变量保存的数据是否相等) 。 不需要 数据类型一致，会自动进行类型提升
 *  			 引用数据类型：			比较地址值是否相等
 *  	2：equels()方法的使用：
 *  			 只能适用于引用数据类型。
 *  				Object中：对于equels()方法本质使用的是 == 进行比较。
 *  				对于String、Date、File等包装类都重写了Object类中的equels()方法，此时
 *  		就是根据各自重写后的equels()方法进行比较
 *  --------------------------------------------------------------------
 *  	3. tostring()的本质
 *  		当我们调用一个对象的tostring()方法时候，输出的是这个对象的地址值
 *     等价于直接输出这个对象的引用。
 *     		java中输出的内存地址是一个虚拟的内存地址，是hashcode算出的一个值，隐藏了真实地址值
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020年9月16日下午10:46:26
 */
public class equels_lianxi {
	public static void main(String[] args) {
		int a = 10;
		int b = 10;
		float c = 10.0f;
		char d = 'A';
		int e = 65;
		System.out.println(a==b);
		System.out.println(a==c);
		System.out.println(d==e);
		System.out.println("-------------------------------------");
		equels_lianxi e1 = new equels_lianxi();
		System.out.println(e1);
		System.out.println(e1.toString());
		String name=new String("asdasd");
		name.toString();
		System.out.println( PrintStream.class);
		System.out.println(name);
		String nameString = "adss";
		nameString = null;
		System.out.println(nameString);
		equels_lianxi e1 = new equels_lianxi();
		e1 = null;
		System.out.println(e1);
	}
}
