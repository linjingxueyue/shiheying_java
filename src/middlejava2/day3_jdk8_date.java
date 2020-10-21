package middlejava2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

import org.junit.Test;
/**
 * 		LocalDate LocalTime  LocalDateTime 三个类的使用比较
 * 		
 * 		说明: 
 * 			LocalDateTime用的比较多	
 * 
 * 		DateTimeFormatter: 格式化或解析日期与时间
 * 			类似于前面学习的SimpleDateFormat
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020年10月11日下午3:43:30
 */
public class day3_jdk8_date {
	@Test
	public void test() {
		// now :  获取当前的日期\时间\日期时间
		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDate);
		System.out.println(localTime);
		System.out.println(localDateTime);
		System.out.println("*********************************");
		// of: 设置指定的年月日时分秒, 且没有偏移量
		LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10,5,15,23,32);
		System.out.println(localDateTime1);
		// getxxx
		System.out.println(localDateTime1.getDayOfMonth());
		System.out.println(localDateTime1.getMonthValue());
		
		// withxxx: 设置时间.  体现了不可变性
		LocalDateTime withDayOfMonth = localDateTime1.withDayOfMonth(10);
		System.out.println(localDateTime1);
		System.out.println(withDayOfMonth);
		
		// plusxxx 与minusxxx 添加.相当于calendar里面的add
		LocalDateTime plusMonths = localDateTime1.plusMonths(2);
		System.out.println(plusMonths);
	}
	
	@Test
	public void test2() {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		LocalDateTime localDate = LocalDateTime.now();
		String format = dateTimeFormatter.format(localDate);
		System.out.println(format);
		// 解析
		String str = "2020-10-11 05:37:36";
		TemporalAccessor parse = dateTimeFormatter.parse(str);
		System.out.println(parse);
	}
}











