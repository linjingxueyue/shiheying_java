package middlejava2;

import java.util.Date;

import org.junit.Test;

/**
 *  关于 StringBuffer与StringBuilder的使用
 *  
 *  	1: String、StringBuffer、StringBuilder的异同：
 *         相同点： 底层使用char[] 数组存储。
 *         不同点：
 *  		  String： 		  不可变的字符序列。 
 *  		  StringBuffer：  可变的字符序列。  线程安全的、但是效率低。（内部方法都是同步方法）
 *  		  StringBuilder： 可变的字符序列。  线程不安全，效率高。
 *  
 *  	2: 为什么他们两个是可变的？  ----- 源码分析
 *  			
 *  			
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020年10月9日下午11:48:41
 */
public class day3_stringbuffertest {
	@Test
	public void test1() {
		StringBuffer s1 = new StringBuffer("abc");
		s1.setCharAt(0, 'm');
		System.out.println(s1);
		s1.append("d111111111111111111111111111111111111111111111111ef");
		System.out.println(s1);
	
	}
	@Test
	public void test2() {
		Date date1 = new Date();
		System.out.println(date1+"----"+date1.toString());
		System.out.println(date1.getTime()+"-----"+System.currentTimeMillis());
		Date date2 = new Date(1602305976371L);
		System.out.println(date2);
	}
}
