package middlejava2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

import org.junit.Test;
/**
 * 		LocalDate LocalTime  LocalDateTime �������ʹ�ñȽ�
 * 		
 * 		˵��: 
 * 			LocalDateTime�õıȽ϶�	
 * 
 * 		DateTimeFormatter: ��ʽ�������������ʱ��
 * 			������ǰ��ѧϰ��SimpleDateFormat
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020��10��11������3:43:30
 */
public class day3_jdk8_date {
	@Test
	public void test() {
		// now :  ��ȡ��ǰ������\ʱ��\����ʱ��
		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDate);
		System.out.println(localTime);
		System.out.println(localDateTime);
		System.out.println("*********************************");
		// of: ����ָ����������ʱ����, ��û��ƫ����
		LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10,5,15,23,32);
		System.out.println(localDateTime1);
		// getxxx
		System.out.println(localDateTime1.getDayOfMonth());
		System.out.println(localDateTime1.getMonthValue());
		
		// withxxx: ����ʱ��.  �����˲��ɱ���
		LocalDateTime withDayOfMonth = localDateTime1.withDayOfMonth(10);
		System.out.println(localDateTime1);
		System.out.println(withDayOfMonth);
		
		// plusxxx ��minusxxx ���.�൱��calendar�����add
		LocalDateTime plusMonths = localDateTime1.plusMonths(2);
		System.out.println(plusMonths);
	}
	
	@Test
	public void test2() {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		LocalDateTime localDate = LocalDateTime.now();
		String format = dateTimeFormatter.format(localDate);
		System.out.println(format);
		// ����
		String str = "2020-10-11 05:37:36";
		TemporalAccessor parse = dateTimeFormatter.parse(str);
		System.out.println(parse);
	}
}











