package middlejava3;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

// 子类 可以赋 给 父类。 父类不可以赋给 子类


/**
 * 		泛型通配符的使用
 * 
 * 			1：通配符“？”。
 * 				 其不能进行add(）增加null值以外的数据。 但是针对有限制条件的泛型，当为 super限制时候，是可以加入 super限制的类型及其子类
 * 				可以正常的读取数据。
 * 				 eg: List<?> 是 List<String> 与 List<Object>等各种泛型的父类.
 * 
 * 			2：有限制条件的通配符：
 * 				 上限extends:使用时候指定的类型必须是继承某个类，或者实现某个接口。即	<=
 * 				 下限super:使用时候指定的类型不能小于操作的类。即	>=
 * 				    	eg:  <? extends Number>	: 只允许泛型为Number及Number子类的调用。
 * 					    	 <? super Number>	: 只允许泛型为Number及Number父类的调用。
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










