package middlejava3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;





/**
 * 	 JAVA�еļ���: Collection �� Map:
 * 		Collection �ӿ�: ��������,�����˴�ȡһ�����ķ����ļ���
 * 			List: Ԫ������,���ظ��ļ��ϣ�
 * 			Set : Ԫ������,�����ظ��ļ��ϣ�.
 * 			.... 
 * 
 * 		Map �ӿ�:
 * 			˫������,�� key-value ��ʽ�洢
 * 
 * ------------------------------------------------------------------------
 * 	     ��collection�ӿڵ�ʵ�ֶ���(List�ӿڶ����Լ�Set�ӿ��г���TreeSet���ӽӿ�)�����obj����ʱ��,Ҫ��obj��������дequals����.
 * 	��Ϊcollectionʵ�����ڵ����ڲ���contains(obj2) �����ǵ��õ�obj2.equals(obj).
 * ����д�Ļ�,��Ĭ�ϵ���Object�ڲ���equals����,Ҳ����ʹ��"==="�����ж�
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020��10��15������11:21:42
 * 
 */
public class day4_jihe_test {
public static void main(String[] args) {
//	Arrays arrays = new Arrays();
	int [] a = new int[4];
	a[0]=1;
	a[1]=2;
	a[2]=3;
	a[3]=4;
	@SuppressWarnings("deprecation")
	Object a2 =new Boolean(false);
	System.out.println(String.valueOf(a2));
	
	Person4 a3 = new Person4("linjing",44);
	System.out.println(a3);
	System.out.println("_----------------------------------------------------");
	
	Collection collection =new ArrayList();
	collection.contains(123);
	
	@SuppressWarnings("rawtypes")
//	Collection collection2 = Arrays.asList(1,2,3,4,5,6);
	Collection collection2 = Arrays.asList(new String[] {"aa","vv","bb"});
	@SuppressWarnings("rawtypes")
	Collection collection3 = Arrays.asList(new Integer[] {1,2,3});
	System.out.println(collection2);
	System.out.println(collection3);
}
}
class Person4{
	String nameString;
	int age;
	public Person4() {
		// TODO Auto-generated constructor stub
	}
	public Person4(String nameString, int age) {
		super();
		this.nameString = nameString;
		this.age = age;
	}
	
}
