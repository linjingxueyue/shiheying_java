package middlejava3;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

/**
 * 		a:ö����� ���:
 * 			1: ��Ķ���ֻ�����޸�,ȷ����.���ǳƴ���Ϊö����.
 * 
 * 			2: ������һ�鳣��ʱ��,ǿ�ҽ���ʹ��ö����
 * 
 * 			3: ����ö����ķ�ʽ:
 * 				��ʽһ: JDK 5.0 ǰ: �Զ���ķ�ʽ
 * 				��ʽ��: JDK5.0��, ʹ��enmu�ؼ���  ----->  ʹ�� enum ������ö����,Ĭ�ϼ̳���java.lang.Enum��
 * 
 * 		 b: ע�͵����
 * 				1: @SuppressWarnings��ʹ��
 * 
 * 				2: ����Զ���ע��
 * 					 ���� @S uppressWarnings���ж���
 * 					 1: ע������Ϊ: @interface
 * 					 2: �ڲ������Ա:ͨ����value��ʾ
 * 					 3: ָ����Ա��Ĭ��ֵ,ʹ��default��ʾ
 * 					 4: ����Զ���ע��û�г�Ա,������һ����ʶ����
 * 					�����ע���Աʱ��,��ʹ��ע��ʱ��,��Ҫָ����Ա��ֵ.
 * 					�Զ���ע��ͨ����ָ�� Retention�� Target.
 * 
 * 				3: JDK �е�����Ԫע��:    Ԫ����: ���������ݽ������ε�����
 * 
 * 						Ԫע��������������Annotation����.(��������ע���ע��)
 * 						�ֱ���: (�����ֵ��÷�,�����uppressWarnings��Դ����,����Ϊ������ѧϰ)
 * 
 * 							 Retention: 	����ָ��Annotation����������:SOURCE \ CLASS(Ĭ��) \ RUNTIME.
 * 											ֻ������ΪRUNTIME��ע��,�ſɽ��з���
 * 							 Target��		����ָ�������ε�Annotaition������������Щ����Ԫ��
 * 					-------------------- ����Ƶ�ʵ� --------		
 * 							 Documented: 	 ��ʾ�����ε�ע���ڱ�javadoc����ʱ��,���Ա�������.Ĭ���ǲ�����
 * 							 Inherited:		 �������ε�Annotation�����м̳���.���ĳ����ʹ���˱������ε�ע��,
 * 											  ���������ཫ�Զ����и�ע��.	
 * 				4: ͨ�� ���� ����ȡע����Ϣ		
 * 					  �� main ������������ʹ������
 * 				
 * 				5: JDK8 �� ����ע���������:
 * 						1: ���ظ�ע��:  @Repeatable
 * 																	.
 * 						2: ����ע��
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020��10��12������12:39:30
 */
public class day4_enum_test {
	public static void main(String[] args) {
		
		System.out.println(Season.SPRING);
		
		
		// ʹ�� enum ������ö����,Ĭ�ϼ̳���java.lang.Enum��
		System.out.println(Season1.SPRING);
		Season1 [] valueSeason1s = Season1.values();
		for(int i=0;i<valueSeason1s.length;i++) {
			System.out.println(valueSeason1s[i]);
		}
		@SuppressWarnings("unused")
		int name = 10;
		
		// rawtypes ��ʾʹ��ԭ������,�������һ������
		@SuppressWarnings({ "rawtypes", "unused" })
		ArrayList list = new ArrayList();
//		------- -------------------------------------------
		System.out.println("------- ----------- @Inherited �̳��Ե���� --------------------------------");
		@SuppressWarnings(value = {  "rawtypes" })
		Class clzz = son.class;
		Annotation[] annotations = clzz.getAnnotations();
		for(int i=0;i<annotations.length;i++) {
			System.out.println(annotations[i]);
		}
	}
}

/**
 * 	�Զ����ö����
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020��10��12������12:56:47
 */

class Season{
	// 1:���� �������. ��Ҫ private �� final ����
	private final String seasonname;
	private final String SeasonDesc ;
	
	// 2: ˽�л���Ĺ�����,������������Ը�ֵ
	private Season(String seasonname,String SeasonDesc) {
		this.SeasonDesc = SeasonDesc;
		this.seasonname = seasonname;
	}
	
	// 3: �ṩ��ǰ��Ķ������
	public static final Season SPRING= new Season("����","��ů����");
	public static final Season SUMMER= new Season("����","��");
	public static final Season AUTUM= new Season("����","�ջ�");
	public static final Season WINTER= new Season("����","��");
	
	// 4:��������

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
 *  	ʹ��enum ������ö����
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020��10��12������1:10:32
 */
enum Season1 implements info{
	

	// 1: �ṩ��ǰö����Ķ���,���������� ","���
	 SPRING("����","��ů����"){
		 public void show() {
				// TODO Auto-generated method stub
				
			}
	 },
	 SUMMER("����","��"){
		 public void show() {
				// TODO Auto-generated method stub
				
			}
	 },
	 AUTUM("����","�ջ�"){
		 public void show() {
				// TODO Auto-generated method stub
				
			}
	 },
	 WINTER("����","��"){
		 public void show() {
				// TODO Auto-generated method stub
				
			}
	 };
	
	
	// 2:���� �������. ��Ҫ private �� final ����
	private final String seasonname;
	private final String SeasonDesc ;
	
	// 3: ˽�л���Ĺ�����,������������Ը�ֵ
	private Season1(String seasonname,String SeasonDesc) {
		this.SeasonDesc = SeasonDesc;
		this.seasonname = seasonname;
	}
	
	
	// 4:��������

	public String getSeasonname() {
		return seasonname;
	}
	public String getSeasonDesc() {
		return SeasonDesc;
	}
}

/**
 * 		�Զ���ע���ʹ�þ���
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020��10��15������9:36:30
 */
@myAnnotation({"name","linjing"})
class Person{
	
}

@myAnnotation2
class Person2{
	
}

//  ��̳�@myAnnotation2��ע��
class son extends Person2{
	
}





