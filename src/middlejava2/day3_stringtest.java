package middlejava2;

import java.util.Arrays;

import org.junit.Test;



/**
 * String 字符串的理解： 
 * 1： public final class String implements java.io.Serializable,
 * Comparable<String>, CharSequence, Constable, ConstantDesc {} String 声明为
 * final,不可以被继承。且实现了 Serializable（可序列化） 接口 。 实现了 Comparable（可比较大小）接口
 *  2： String* 内部定义了 final char[] value 型数组.表明该数组是一个常量，赋值后不能更改。具有不可变性。
 * 
 * 3: 不变性的理解： 通过字面量方式给String类型变量赋值时候，此时字符串值声明再字符串常量池当中。 字符串的常量池中不会存储相同的字符串。
 * 当对字符串重新赋值时候，需要重新在常量池当中创建新的字面量。并不会改变原有的字面量。原因在于final描述符
 * 当对现有字符串进行连接操作时候，也是重新在变量池当中创建新的字面量，不更改以前的
 * 当调用String的replace方法修改内部指定的字符或字符串时候，也是重新在变量池当中创建新的字面量，不更改以前的
 * 
 * 4：String 对象的创建：
 * 
 * 5：String str1 = "abc" 与 String str2 = new String("abc")的区别：
 * 
 * 6: String str2 = new String("abc") 方式创建对象，在内存中创建了几个对象： 两个： 1个是 堆空间中的 new
 * 结构，一个是常量池中的字面量数据"abc"。
 * 
 * 7：常量与常量的拼接结构在常量池。且常量池中不会存在相同内容的常量 
 * 
 * 8：只要其中有一个变量，其拼接字符串就是在堆空间开辟，相当于new String 
 * 
 * 9: 如果拼接的结果调用intern() 方法，返回值就在常量池当中
 * 
 * 10: String 常用算法练习
 * @Description:
 * @author: linjing 1395876278@qq.com
 * @date: 2020年9月28日下午11:08:14
 */
public class day3_stringtest {
	// String 不可变性
	@Test
	public void test1() {
		String s1 = "abc"; // 字面量
		String s2 = "abc";
		String s3 = "abc";
		System.out.println(s1 == s2); // true
		s1 = "hello";
		System.out.println(s1 + " " + s2); // hello abc
		s3 += "---linjing";
		// 打印s2发现不变，说明在字符串后面追加字符串时候，并不会更改当前字面量，而是重新创建
		System.out.println(s2); // abc
		String s4 = "abc";
		String s5 = "abc";
		String s6 = s4.replace('b', '-');
		System.out.println(s4 + "  " + s5 + " " + s6);
		System.out.println("_________________________________________");
		s1 = "123456789";
		System.out.println(s1.substring(0,9));
	}

	// String 实例化的方式
	@Test
	public void test2() {
		// 通过字面量方式创建 -------> 此时s1与s2的数据 指向方法区的常量池中数据的地址值
		String s1 = "abc";
		String s2 = "abc";
		// 通过 new 的方式 ---------> 此时s3 与s4 保存的地址指向堆空间中的对象的地址值
		String s3 = new String("abc");
		String s4 = new String("abc");

		System.out.println(s1 == s2); // true
		System.out.println(s1 == s3); // false
		System.out.println(s1 == s4); // false
		System.out.println(s4 == s3); // false
	}

	@Test
	public void test3() {
		String s1 = "hello";
		String s2 = "world";
		String s3 = "hello" + "world";
		String s4 = s1 + "world";
		String s5 = s1 + s2;
		String s6 = (s1 + s2).intern();
		System.out.println(s3 == s4); // false
		System.out.println(s3 == s5); // false
		System.out.println(s4 == s5); // false
		System.out.println(s3 == s6); // true
	}

	@Test
	public void test4() {
		String s1 = "abc中国";
		byte[] b1 = s1.getBytes();
		System.out.println(Arrays.toString(b1));
	}

	// 一些关于字符串的算法练习： 指定字符串反转、指定部分在字符串中出现的次数、获取两个字符串的最大相同子串
	@Test
	public void test5() {
		// 将字符串的指定部分进行反转
		String s1 = "abcdefg";
		s1 = reverse(s1, 0, 4);
		System.out.println(s1);
		s1 = "abcdefg";
		String s2 = reverse2(s1, 0, 4);
		System.out.println(s2);
		s1 = "abcdefg";
		String s3 = reverse3(s1, 0, 4);
		System.out.println(s3);
		System.out.println("**********************************************************");
		s1 = "abcdefgaberfabsdsfabdfsfgwerab";
		int countnumber = getcount(s1, "ab");
		System.out.println(countnumber);
		System.out.println("**********************************************************");
		s1 = "abcedeerweabcdefdasda123456weqweqwe";
		s2 = "asdasdabcdefgdasdqweqweq123456eqsda54484";
		System.out.println(getstr(s1, s2));
	}

	// 将字符串的指定部分进行反转 ------ 辅助函数
	// 方式1 ： 转换为char[] 数组
	public String reverse(String s1, int startindex, int endindex) {

		char[] charArray = s1.toCharArray();
		for (int i = startindex, j = endindex; i < j; i++, j--) {
			char tmp = charArray[i];
			charArray[i] = charArray[j];
			charArray[j] = tmp;
		}
		s1 = String.valueOf(charArray);
		return s1;
	}

	// 方式2 ： 使用拼接的方式。
	public String reverse2(String s1, int startindex, int endindex) {
		String str_first = s1.substring(0, startindex);
		for (int i = endindex; i >= startindex; i--) {
			str_first += s1.charAt(i);
		}
		str_first += s1.substring(endindex + 1);
		return str_first;
	}

	// 方式3： 使用stringBuffer在方法2 的基础上优化.（优化的方面在于：String字符串每次都会重新创建，而stringBuffer是可变的）
	public String reverse3(String s1, int startindex, int endindex) {
		StringBuffer stringBuffer = new StringBuffer(s1.length());
		stringBuffer.append(s1.substring(0, startindex));
		for (int i = endindex; i >= startindex; i--) {
			stringBuffer.append(s1.charAt(i));

		}
		stringBuffer.append(s1.substring(endindex + 1));

		return new String(stringBuffer);
	}

	/**
	 * 
	 * @Description: 指定部分在字符串中出现的次数 ------ 辅助函数
	 * @date: 2020年10月10日下午10:02:24
	 * @param s1  : 主字符串
	 * @param obj ： 指定需要查找的字符串
	 * @return
	 */
	public int getcount(String s1, String obj) {
		int count = 0;
		int index = 0;
		int len = obj.length();
		for (;;) {
			index = s1.indexOf(obj, index);
			if (index == -1) {
				break;
			}
			index += len;
			count++;
		}

		return count;
	}

	/**
	 * 
	 * @Description: 获取两个字符串的最大相同子串
	 * @author: linjing 1395876278@qq.com
	 * @date: 2020年10月10日下午10:12:34
	 * @param s1 ： 字符串1
	 * @param s2 ： 字符串2
	 * @return
	 */
	public String getstr(String s1, String s2) {
		// 寻找两个字符串的长度最小值
		String small_str = s1.length() < s2.length() ? s1 : s2;
		String large_str = small_str == s1 ? s2 : s1;
		String str = "";
		int len = small_str.length();
		for (int i = 0; i < len; i++) {
			for (int x = 0, y = len - i; y <= len; x++, y++) {
				String subString = small_str.substring(x,y);
				if (large_str.contains(subString)) {
					str +=subString+",";
					
				}
			}
			// 这一步骤的作用在于仅仅获取头一次捕获最大子串时候，那一轮的所有匹配情况
			if(str.length() !=0) {
				return str;
			}

		}
		return str;
	}
}
