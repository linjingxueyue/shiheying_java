package helloword;

import java.util.Scanner;

public class helloword {
	/**
	 * 
	 * @Description 
	 * @author linjing 1395876278@qq.com
	 * @date 2020年8月28日上午12:33:14
	 * @param args
	 */
	public static void main(String[] args) {

		char name = 'w';
		String age = "linjing";
		System.out.println("Hello World" + '-' + age);
		// 交换变量的 方式一 (常用的方式就不写了。)
		/**
		 * 好处： 不用定义临时变量 弊端： 只能用于数值型，并且相加操作可能超出范围
		 */
		int num1 = 10;
		int num2 = 20;
		num1 = num1 + num2;
		num2 = num1 - num2;
		num1 = num1 - num2;
		System.out.println("num1=" + num1 + "num2=" + num2);
		// 交换变量的方式 二
		/**
		 * 使用 异或的位操作 弊端： 只能適用于數值型。
		 */
		int num3 = 10;
		int num4 = 20;
		int k = num3 ^ num4;
		num4 = k ^ num4;
		num3 = k ^ num3;
		System.out.println("num3=" + num3 + "num4=" + num4);
		// ---------------------------------------------------------------------------
		/**
		 * 十进制转为十六进制 的方式 1
		 */
		num1 = 60;
		System.out.println(Integer.toHexString(num1));
		/**
		 * 十进制转为十六进制 的方式 2
		 */
		int tmp = 15;
		String str1 = "";
		int tmp2 = num1 & 15;
		str1 = tmp2 > 9 ? (char) (tmp2 - 10 + 'A') + "" : tmp2 + "";
		num1 = num1 >>> 4;
		tmp2 = num1 & 15;
		String str2 = tmp2 > 9 ? (char) (tmp2 - 10 + 'A') + "" : tmp2 + "";
		System.out.println(str2 + str1);
		// ---------------------------------------------------------------------------
		/**
		 * 如何从键盘获取数据，需要使用Scanner类. 注意： 如果输入类型与要求类型不匹配时候，会报异常。
		 */
		Scanner scanner = new Scanner(System.in);
		// int num = scanner.nextInt();
		// System.out.println(num);
		// ---------------------------------------------------------------------------
		int num = 1;
		for (System.out.println('a'); num <= 3; System.out.println("c"), num++) {
			System.out.println('b');
		}
		//-----------break跳出内层循环,但仍会继续向下执行.且默认结束的是内循环
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.println("----");
				break;
//				continue;
			}
			System.out.println("+++++");
		}
		//-----------break默认跳出内层循环,但是通过标签方式可以跳出外层循环.. continue也是类似的方式
		System.out.println("**********************************");
		label: for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.println("----");
				break label;
			}
			System.out.println("+++++");
		}
	}
}

class person {

}

class person2 {

}