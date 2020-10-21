package helloword;

import java.util.Scanner;

/**
 * 		sc.hasNext()可以理解为把我们输入的值存到了sc当中而sc.next()可以理解为从sc中取值，
 * 	取值后将标识符后移（可以理解为：取完值后这个值就不在了），
 *  如果sc中没有值了，它也会要求输入一个值（前面说了它们两都可以输入）。
 *  https://blog.csdn.net/yongbutingxide/article/details/83583869
 *  
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020年9月9日下午8:33:34
 */

public class scanner {
	public static void main(String[] args) {
		Scanner sc = new java.util.Scanner(System.in);
		System.out.println("------->  "+sc.hasNext()+" ---> "+sc.next());
	}
}
