package middlejava2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;



/**
 *   JDK 8 ֮ǰ������API���ԣ�
 *      1��System���е�currentTimeMillis();
 *      2: java.util.Date �� java.sql.Date
 *      3: SimpleDateFormat
 *      4: calendar
 *    
 *    SimpleDateFormat:
 *    	 1:	Date���API���׹��ʻ����󲿷��Ѿ��������ˣ�java.text.SimpleDateFormat��
 *  	 ��һ���������Ի����йصķ�ʽ����ʽ���ͽ������ڵľ����ࡣ
 *       ��������и�ʽ���� ����->�ı����������ı�->����
 *       
 *       2: ����������
 *       	��ʽ���� ����->�ı�
 *       	������	 �ı�->����
 *       
 *       3: SimpleDateFormat ��ʵ������
 *       		new SimpleDateFormat(); ʹ��Ĭ�Ϲ������������ı�ʱ�򣬱��밴�չ̶��ĸ�ʽ���������.
 *       		new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); ����ָ���ĸ�ʽ���и�ʽ�������.
 *       
 *     calendar ��
 *        calendar��һ��������,��Ҫ������������ֶ�֮����໥�����Ĺ���.
 *        ��ȡcalendarʵ���ķ���:
 *        	 1: calendar.getinstance() ����
 *           2: ������������ GregorianCalendar�Ĺ�����
 *           
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020��10��11������1:00:41
 */
public class day3_date {
	/**
	 * 
	 * @Description:  SimpleDateFormat ���ʹ��
	 * @author: linjing 1395876278@qq.com
	 * @date: 2020��10��11������1:30:26
	 * @throws ParseException
	 */
	@Test
	public void test1() throws ParseException {
		// ��ʽ���� ����->�ı�
		SimpleDateFormat sdf = new SimpleDateFormat();
		Date date = new Date();
		System.out.println(date);
		String format = sdf.format(date);
		System.out.println(format);
		
		//	������	 �ı�->����
		String str = "2020/10/11 ����1:08";
		Date date1 = sdf.parse(str);
		System.out.println(date1);
		System.out.println("-------------------------");
		
		// ��ʽ���� ����->�ı�    (��ʹ��Ĭ�ϵĹ�����) 
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String format1 = sdf1.format(date);
		System.out.println(format1);
		// ������	 �ı�->����  (�ַ���Ҫ���Ϲ���������ָ���ĸ�ʽ)
		str = "2020-10-11 01:17:26";
		 date1 = sdf1.parse(str);
		System.out.println(date1);
	}
	
	/**
	 *	 calendar  ���ʹ��
	 */
	@Test
	public void test2() {
		// 1: ʵ����
		Calendar calendar = Calendar.getInstance();
		// ʹ�����ַ�ʽʵ���� ʵ���ϻ��ǵ����������new ����
		System.out.println(calendar.getClass());
		
		// 2: ���÷���  get\add\set\gettime\settime
		
		// get ��ȡ ����������µĵڼ���
		int i = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(i);
		
		// set 
		calendar.set(Calendar.DAY_OF_MONTH, 22);
		i = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(i);
		
		// add 
		calendar.add(Calendar.DAY_OF_MONTH, 3);
		i = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(i);
		
		// gettime   ������ --> date
		Date date = calendar.getTime();
		System.out.println(date);
		
		// settime    date --> ������
		Date date2 = new Date();
		calendar.setTime(date2);
		i = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(i);
	}
}











