package helloword;
/**
 *  JAVA中的单元测试JUint：
 *  	类中单元测试的方法：
 *  		方法权限是public
 *  		没有返回值
 *  		此类提供公共的无参构造器
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020年9月17日上午8:11:18
 */

import org.junit.Test;

public class danyuantest {
	@Test
	public void test() {
		System.out.println("--------");
	}
	@Test
	public void test2() {
		System.out.println("-1111111111111111-------");
		Integer in1 = Integer.valueOf(12);
		System.out.println(in1.toString());
		System.out.println(in1);
		
	}
	@Test
	public void test3() {
		boolean flage = true;
//		String c1 = flage ? "asdsd" : 18;
	}
}
