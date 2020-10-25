package middlejava3;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

// ���� ���Ը� �� ���ࡣ ���಻���Ը��� ����


/**
 * 		����ͨ�����ʹ��
 * 
 * 			1��ͨ�����������
 * 				 �䲻�ܽ���add(������nullֵ��������ݡ� ������������������ķ��ͣ���Ϊ super����ʱ���ǿ��Լ��� super���Ƶ����ͼ�������
 * 				���������Ķ�ȡ���ݡ�
 * 				 eg: List<?> �� List<String> �� List<Object>�ȸ��ַ��͵ĸ���.
 * 
 * 			2��������������ͨ�����
 * 				 ����extends:ʹ��ʱ��ָ�������ͱ����Ǽ̳�ĳ���࣬����ʵ��ĳ���ӿڡ���	<=
 * 				 ����super:ʹ��ʱ��ָ�������Ͳ���С�ڲ������ࡣ��	>=
 * 				    	eg:  <? extends Number>	: ֻ������ΪNumber��Number����ĵ��á�
 * 					    	 <? super Number>	: ֻ������ΪNumber��Number����ĵ��á�
 * 		
 * @author PC
 *
 */
public class day4_fanxing_test2 {
	@Test
	public void test() {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		ArrayList<String> arrayList2 = new ArrayList<String>();
		ArrayList<?> arrayList3 = new ArrayList<>();
		arrayList3 = arrayList;
		arrayList3 = arrayList2;
			
	}
	
	
	@Test
	public void test2() {
		List<? extends Father> list1 = null;
		List<? super Father> list2 = null;
		List<Father> list3 = null;
		List<son_lin> list4 = null;
		List<Object> list5 = null;
		//-----------------------------------------------------
		list1 = list3;
		list1 = list4;
//		list1 = list5;	  // error : cannot convert from List<Object> to List<? extends Father>
		list2 = list3;
//		list2 = list4;	 // error :	Type mismatch: cannot convert from List<son_lin> to List<? super Father>
		list2 = list5;
	}
}
// ------------------------------------------------------------------------------------------------------

class Father{
	
}
class son_lin extends Father{ 
	
}










