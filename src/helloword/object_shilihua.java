package helloword;
/**
 *  a:�����ʵ����ȫ���̣�
 *  	��ͨ������Ĺ����������������ʱ��һ����ֱ�ӻ��ӵĵ��ø��๹������ֱ��������java.lang.object��
 *    �пղι�����Ϊֹ������Ϊ���ع����еĸ���Ľṹ�����Բſ��Կ����ڴ����и���ṹ���������ſ��Խ��е��á�
 *    
 *   b: ������������У���Ȼ�����˸���Ĺ�����������ʼ���ն�ֻ������һ�����󡣼���new����
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020��9��11������8:10:54
 */

class father{
	String nameString = "linjing";
	public father(String nameString) {
		this.nameString = nameString;
		// TODO Auto-generated constructor stub
	}
	
}
public class object_shilihua extends father {
	public object_shilihua(String name) {
		super(name);
	}
	public void test(int... a ) {
		System.out.println(a);
	}
//	public void test(int[] a ) {
//		System.out.println(a);
//	}
	public static void main(String[] args) {
		object_shilihua o1 = new object_shilihua("linsda");
		System.out.println("asdadasda");
		o1.test(1,2,3,4);
	}
}
