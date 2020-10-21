package middlejava2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;



/**
 *   JDK 8 之前的日期API测试：
 *      1：System类中的currentTimeMillis();
 *      2: java.util.Date 与 java.sql.Date
 *      3: SimpleDateFormat
 *      4: calendar
 *    
 *    SimpleDateFormat:
 *    	 1:	Date类的API不易国际化，大部分已经被弃用了，java.text.SimpleDateFormat类
 *  	 是一个不与语言环境有关的方式来格式化和解析日期的具体类。
 *       它允许进行格式化： 日期->文本、解析：文本->日期
 *       
 *       2: 两个操作：
 *       	格式化： 日期->文本
 *       	解析：	 文本->日期
 *       
 *       3: SimpleDateFormat 的实例化：
 *       		new SimpleDateFormat(); 使用默认构造器，解析文本时候，必须按照固定的格式，不够灵活.
 *       		new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 按照指定的格式进行格式化与解析.
 *       
 *     calendar 类
 *        calendar是一个抽象类,主要用于完成日期字段之间的相互操作的功能.
 *        获取calendar实例的方法:
 *        	 1: calendar.getinstance() 方法
 *           2: 调用它的子类 GregorianCalendar的构造器
 *           
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020年10月11日下午1:00:41
 */
public class day3_date {
	/**
	 * 
	 * @Description:  SimpleDateFormat 类的使用
	 * @author: linjing 1395876278@qq.com
	 * @date: 2020年10月11日下午1:30:26
	 * @throws ParseException
	 */
	@Test
	public void test1() throws ParseException {
		// 格式化： 日期->文本
		SimpleDateFormat sdf = new SimpleDateFormat();
		Date date = new Date();
		System.out.println(date);
		String format = sdf.format(date);
		System.out.println(format);
		
		//	解析：	 文本->日期
		String str = "2020/10/11 下午1:08";
		Date date1 = sdf.parse(str);
		System.out.println(date1);
		System.out.println("-------------------------");
		
		// 格式化： 日期->文本    (不使用默认的构造器) 
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String format1 = sdf1.format(date);
		System.out.println(format1);
		// 解析：	 文本->日期  (字符串要符合构造器参数指定的格式)
		str = "2020-10-11 01:17:26";
		 date1 = sdf1.parse(str);
		System.out.println(date1);
	}
	
	/**
	 *	 calendar  类的使用
	 */
	@Test
	public void test2() {
		// 1: 实例化
		Calendar calendar = Calendar.getInstance();
		// 使用这种方式实例化 实际上还是调用了子类的new 方法
		System.out.println(calendar.getClass());
		
		// 2: 常用方法  get\add\set\gettime\settime
		
		// get 获取 今天是这个月的第几天
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
		
		// gettime   日历类 --> date
		Date date = calendar.getTime();
		System.out.println(date);
		
		// settime    date --> 日历类
		Date date2 = new Date();
		calendar.setTime(date2);
		i = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(i);
	}
}











