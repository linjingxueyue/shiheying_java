package middlejava2;

import java.util.Date;

import org.junit.Test;

/**
 *  ���� StringBuffer��StringBuilder��ʹ��
 *  
 *  	1: String��StringBuffer��StringBuilder����ͬ��
 *         ��ͬ�㣺 �ײ�ʹ��char[] ����洢��
 *         ��ͬ�㣺
 *  		  String�� 		  ���ɱ���ַ����С� 
 *  		  StringBuffer��  �ɱ���ַ����С�  �̰߳�ȫ�ġ�����Ч�ʵ͡����ڲ���������ͬ��������
 *  		  StringBuilder�� �ɱ���ַ����С�  �̲߳���ȫ��Ч�ʸߡ�
 *  
 *  	2: Ϊʲô���������ǿɱ�ģ�  ----- Դ�����
 *  			
 *  			
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020��10��9������11:48:41
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
