package middlejava3;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

/**
 * 		a:枚举类的 理解:
 * 			1: 类的对象只有有限个,确定的.我们称此类为枚举类.
 * 
 * 			2: 当定义一组常量时候,强烈建议使用枚举类
 * 
 * 			3: 定义枚举类的方式:
 * 				方式一: JDK 5.0 前: 自定义的方式
 * 				方式二: JDK5.0后, 使用enmu关键字  ----->  使用 enum 创建的枚举类,默认继承于java.lang.Enum类
 * 
 * 		 b: 注释的理解
 * 				1: @SuppressWarnings的使用
 * 
 * 				2: 如何自定义注解
 * 					 参照 @S uppressWarnings进行定义
 * 					 1: 注解声明为: @interface
 * 					 2: 内部定义成员:通常用value表示
 * 					 3: 指定成员的默认值,使用default表示
 * 					 4: 如果自定义注解没有成员,表明是一个标识作用
 * 					如果有注解成员时候,在使用注解时候,需要指明成员的值.
 * 					自定义注解通常会指明 Retention与 Target.
 * 
 * 				3: JDK 中的四种元注解:    元数据: 对现有数据进行修饰的数据
 * 
 * 						元注解用于修饰其他Annotation定义.(修饰其他注解的注解)
 * 						分别是: (这四种的用法,都点进uppressWarnings的源码中,以其为例进行学习)
 * 
 * 							 Retention: 	用于指明Annotation的生命周期:SOURCE \ CLASS(默认) \ RUNTIME.
 * 											只有声明为RUNTIME的注解,才可进行反射
 * 							 Target、		用于指定被修饰的Annotaition能用于修饰哪些程序元素
 * 					-------------------- 出现频率低 --------		
 * 							 Documented: 	 表示所修饰的注解在被javadoc解析时候,可以保留下来.默认是不保留
 * 							 Inherited:		 被其修饰的Annotation将具有继承性.如果某个类使用了被其修饰的注解,
 * 											  则该类的子类将自动具有该注解.	
 * 				4: 通过 反射 来获取注解信息		
 * 					  见 main 函数里面具体的使用例子
 * 				
 * 				5: JDK8 中 关于注解的新特性:
 * 						1: 可重复注解:  @Repeatable
 * 																	.
 * 						2: 类型注解
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020年10月12日上午12:39:30
 */
public class day4_enum_test {
	public static void main(String[] args) {
		
		System.out.println(Season.SPRING);
		
		
		// 使用 enum 创建的枚举类,默认继承于java.lang.Enum类
		System.out.println(Season1.SPRING);
		Season1 [] valueSeason1s = Season1.values();
		for(int i=0;i<valueSeason1s.length;i++) {
			System.out.println(valueSeason1s[i]);
		}
		@SuppressWarnings("unused")
		int name = 10;
		
		// rawtypes 表示使用原生类型,这里的是一个泛型
		@SuppressWarnings({ "rawtypes", "unused" })
		ArrayList list = new ArrayList();
//		------- -------------------------------------------
		System.out.println("------- ----------- @Inherited 继承性的理解 --------------------------------");
		@SuppressWarnings(value = {  "rawtypes" })
		Class clzz = son.class;
		Annotation[] annotations = clzz.getAnnotations();
		for(int i=0;i<annotations.length;i++) {
			System.out.println(annotations[i]);
		}
	}
}

/**
 * 	自定义的枚举类
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020年10月12日上午12:56:47
 */

class Season{
	// 1:声明 类的属性. 需要 private 与 final 修饰
	private final String seasonname;
	private final String SeasonDesc ;
	
	// 2: 私有化类的构造器,并给对象的属性赋值
	private Season(String seasonname,String SeasonDesc) {
		this.SeasonDesc = SeasonDesc;
		this.seasonname = seasonname;
	}
	
	// 3: 提供当前类的多个对象
	public static final Season SPRING= new Season("春天","春暖花开");
	public static final Season SUMMER= new Season("夏天","热");
	public static final Season AUTUM= new Season("秋天","收货");
	public static final Season WINTER= new Season("冬天","冷");
	
	// 4:其他诉求

	public String getSeasonname() {
		return seasonname;
	}
	public String getSeasonDesc() {
		return SeasonDesc;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.seasonname;
	}
}
interface info{
	 void show();
}
/**
 *  	使用enum 来创建枚举类
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020年10月12日上午1:10:32
 */
enum Season1 implements info{
	

	// 1: 提供当前枚举类的对象,多个对象间用 ","间隔
	 SPRING("春天","春暖花开"){
		 public void show() {
				// TODO Auto-generated method stub
				
			}
	 },
	 SUMMER("夏天","热"){
		 public void show() {
				// TODO Auto-generated method stub
				
			}
	 },
	 AUTUM("秋天","收货"){
		 public void show() {
				// TODO Auto-generated method stub
				
			}
	 },
	 WINTER("冬天","冷"){
		 public void show() {
				// TODO Auto-generated method stub
				
			}
	 };
	
	
	// 2:声明 类的属性. 需要 private 与 final 修饰
	private final String seasonname;
	private final String SeasonDesc ;
	
	// 3: 私有化类的构造器,并给对象的属性赋值
	private Season1(String seasonname,String SeasonDesc) {
		this.SeasonDesc = SeasonDesc;
		this.seasonname = seasonname;
	}
	
	
	// 4:其他诉求

	public String getSeasonname() {
		return seasonname;
	}
	public String getSeasonDesc() {
		return SeasonDesc;
	}
}

/**
 * 		自定义注解的使用举例
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020年10月15日下午9:36:30
 */
@myAnnotation({"name","linjing"})
class Person{
	
}

@myAnnotation2
class Person2{
	
}

//  会继承@myAnnotation2的注解
class son extends Person2{
	
}





