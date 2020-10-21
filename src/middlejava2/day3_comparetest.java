package middlejava2;
/**
 *  	java 的比较器的学习:
 *  		1: 对于比较对象的大小,可以使用两个接口中的任何一个进行:Comparable 与 Comparator
 *  
 *  		2: Comparable 的使用举例    --------- 自然排序
 *  			   1:像String、包装类等均实现了Comparable接口,重写了compareTo()方法,给出了两个对象比较大小的方式
 *  			   2: 重写compareTo(obj)的规则:
 *  					如果当前对象this大于形参对象obj,则返回正整数.
 *  					如果当前对象this小于形参对象,则返回负整数
 *  					如果当前对象this等于形参对象,则返回0
 *  		       3: 对于自定义类如果需要排序,我们可以让自定义类实现Comparable接口,重写compareTo()方法.
 *  			      在compareTo()方法中指明如何进行排序.
 *  
 *  		3: Comparator 定制排序
 *  			   1: 当元素的类型没有实现Comaprable接口,而又不方便修改代码.或者实现的Comaprable接口的排序
 *  			 规则不符合当前操作的要求时候,我们可以考虑使用Comparator的对象来排序
 *  			   2: 需要重写Compare(o1,02) 方法.
 *  			   3: 重写规则:
 *  					返回0, 则 o1 等于 o2;
 *  					返回正整数, 则 o1 大于 o2
 *  					返回负整数, 则 o1 小于 o2
 *  		
 *  		4: Comparable 与 Comparator 的 區別:
 *  				Comparable 的方式,一旦指定,保證Comparable接口實現類的對象在任何位置上都可以比较大小
 *  				Comparator 的方式, 属于临时性的比较,随时需要随时进行实现该接口
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020年10月11日下午9:00:12
 */

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;


public class day3_comparetest {

	// Comparable 的使用举例
	@Test
	public void test1() {
		String[] arr= {"AA","BB","CC","KK","MM","GG","JJ","DD"};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println("******************************************************");
		Goods[] goods = new Goods[4];
		
		goods[0] = new Goods("联想",6000);
		goods[1] = new Goods("小米",3000);
		goods[2] = new Goods("华为",4000);
		goods[3] = new Goods("apple",7000);
		
		Arrays.sort(goods);
		System.out.println(Arrays.toString(goods));
	}

	// Comparator 的使用举例
	@Test
	public void test2() {
		String[] arr= {"AA","BB","CC","KK","MM","GG","JJ","DD"};
		Arrays.sort(arr,new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				if(o1 instanceof String && o2 instanceof String) {
					String s1 = (String)o1;
					String s2 = (String)o2;
					return -s1.compareTo(s2);
				}
				else {
					throw new RuntimeException();
				}
			}
			
		});
		System.out.println(Arrays.toString(arr));
		System.out.println("******************************************************");
		Goods[] goods = new Goods[4];
				
		goods[0] = new Goods("联想",6000);
		goods[1] = new Goods("小米",3000);
		goods[2] = new Goods("华为",4000);
		goods[3] = new Goods("apple",7000);
		
		Arrays.sort(goods,new Comparator<Goods>() {
			@Override
			public int compare(Goods o1, Goods o2) {
				
				return - Double.compare(o1.getPrice(), o2.getPrice());
			}
		});
		System.out.println(Arrays.toString(goods));
	}
}

/**
 *   商品类, 使其能够比较大小
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020年10月11日下午9:35:06
 */
class Goods implements Comparable{
	private String nameString;
	private double price;
	public Goods() {
		super();
	}
	public Goods(String nameString, double price) {
		super();
		this.nameString = nameString;
		this.price = price;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 *  指明 按照什么方式进行排序
	 */
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if(o instanceof Goods) {
			Goods o2 = (Goods)o;
			return Double.compare(this.price, o2.getPrice());
		}
		else {
			throw new RuntimeException();
		}
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nameString;
	}
}


