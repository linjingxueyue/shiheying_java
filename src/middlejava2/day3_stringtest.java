package middlejava2;

import java.util.Arrays;

import org.junit.Test;



/**
 * String �ַ�������⣺ 
 * 1�� public final class String implements java.io.Serializable,
 * Comparable<String>, CharSequence, Constable, ConstantDesc {} String ����Ϊ
 * final,�����Ա��̳С���ʵ���� Serializable�������л��� �ӿ� �� ʵ���� Comparable���ɱȽϴ�С���ӿ�
 *  2�� String* �ڲ������� final char[] value ������.������������һ����������ֵ���ܸ��ġ����в��ɱ��ԡ�
 * 
 * 3: �����Ե���⣺ ͨ����������ʽ��String���ͱ�����ֵʱ�򣬴�ʱ�ַ���ֵ�������ַ��������ص��С� �ַ����ĳ������в���洢��ͬ���ַ�����
 * �����ַ������¸�ֵʱ����Ҫ�����ڳ����ص��д����µ���������������ı�ԭ�е���������ԭ������final������
 * ���������ַ����������Ӳ���ʱ��Ҳ�������ڱ����ص��д����µ�����������������ǰ��
 * ������String��replace�����޸��ڲ�ָ�����ַ����ַ���ʱ��Ҳ�������ڱ����ص��д����µ�����������������ǰ��
 * 
 * 4��String ����Ĵ�����
 * 
 * 5��String str1 = "abc" �� String str2 = new String("abc")������
 * 
 * 6: String str2 = new String("abc") ��ʽ�����������ڴ��д����˼������� ������ 1���� �ѿռ��е� new
 * �ṹ��һ���ǳ������е�����������"abc"��
 * 
 * 7�������볣����ƴ�ӽṹ�ڳ����ء��ҳ������в��������ͬ���ݵĳ��� 
 * 
 * 8��ֻҪ������һ����������ƴ���ַ��������ڶѿռ俪�٣��൱��new String 
 * 
 * 9: ���ƴ�ӵĽ������intern() ����������ֵ���ڳ����ص���
 * 
 * 10: String �����㷨��ϰ
 * @Description:
 * @author: linjing 1395876278@qq.com
 * @date: 2020��9��28������11:08:14
 */
public class day3_stringtest {
	// String ���ɱ���
	@Test
	public void test1() {
		String s1 = "abc"; // ������
		String s2 = "abc";
		String s3 = "abc";
		System.out.println(s1 == s2); // true
		s1 = "hello";
		System.out.println(s1 + " " + s2); // hello abc
		s3 += "---linjing";
		// ��ӡs2���ֲ��䣬˵�����ַ�������׷���ַ���ʱ�򣬲�������ĵ�ǰ���������������´���
		System.out.println(s2); // abc
		String s4 = "abc";
		String s5 = "abc";
		String s6 = s4.replace('b', '-');
		System.out.println(s4 + "  " + s5 + " " + s6);
		System.out.println("_________________________________________");
		s1 = "123456789";
		System.out.println(s1.substring(0,9));
	}

	// String ʵ�����ķ�ʽ
	@Test
	public void test2() {
		// ͨ����������ʽ���� -------> ��ʱs1��s2������ ָ�򷽷����ĳ����������ݵĵ�ֵַ
		String s1 = "abc";
		String s2 = "abc";
		// ͨ�� new �ķ�ʽ ---------> ��ʱs3 ��s4 ����ĵ�ַָ��ѿռ��еĶ���ĵ�ֵַ
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
		String s1 = "abc�й�";
		byte[] b1 = s1.getBytes();
		System.out.println(Arrays.toString(b1));
	}

	// һЩ�����ַ������㷨��ϰ�� ָ���ַ�����ת��ָ���������ַ����г��ֵĴ�������ȡ�����ַ����������ͬ�Ӵ�
	@Test
	public void test5() {
		// ���ַ�����ָ�����ֽ��з�ת
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

	// ���ַ�����ָ�����ֽ��з�ת ------ ��������
	// ��ʽ1 �� ת��Ϊchar[] ����
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

	// ��ʽ2 �� ʹ��ƴ�ӵķ�ʽ��
	public String reverse2(String s1, int startindex, int endindex) {
		String str_first = s1.substring(0, startindex);
		for (int i = endindex; i >= startindex; i--) {
			str_first += s1.charAt(i);
		}
		str_first += s1.substring(endindex + 1);
		return str_first;
	}

	// ��ʽ3�� ʹ��stringBuffer�ڷ���2 �Ļ������Ż�.���Ż��ķ������ڣ�String�ַ���ÿ�ζ������´�������stringBuffer�ǿɱ�ģ�
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
	 * @Description: ָ���������ַ����г��ֵĴ��� ------ ��������
	 * @date: 2020��10��10������10:02:24
	 * @param s1  : ���ַ���
	 * @param obj �� ָ����Ҫ���ҵ��ַ���
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
	 * @Description: ��ȡ�����ַ����������ͬ�Ӵ�
	 * @author: linjing 1395876278@qq.com
	 * @date: 2020��10��10������10:12:34
	 * @param s1 �� �ַ���1
	 * @param s2 �� �ַ���2
	 * @return
	 */
	public String getstr(String s1, String s2) {
		// Ѱ�������ַ����ĳ�����Сֵ
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
			// ��һ������������ڽ�����ȡͷһ�β�������Ӵ�ʱ����һ�ֵ�����ƥ�����
			if(str.length() !=0) {
				return str;
			}

		}
		return str;
	}
}
