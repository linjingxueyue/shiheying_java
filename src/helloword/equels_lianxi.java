package helloword;

import java.io.PrintStream;

/**
 *  == �� equles������ 
 *  	1�� == �����
 *  		����ʹ���ٻ����������ͱ����������������ͱ�������
 *  			 �����������ͣ�			(�Ƚ�������������������Ƿ����) �� ����Ҫ ��������һ�£����Զ�������������
 *  			 �����������ͣ�			�Ƚϵ�ֵַ�Ƿ����
 *  	2��equels()������ʹ�ã�
 *  			 ֻ�������������������͡�
 *  				Object�У�����equels()��������ʹ�õ��� == ���бȽϡ�
 *  				����String��Date��File�Ȱ�װ�඼��д��Object���е�equels()��������ʱ
 *  		���Ǹ��ݸ�����д���equels()�������бȽ�
 *  --------------------------------------------------------------------
 *  	3. tostring()�ı���
 *  		�����ǵ���һ�������tostring()����ʱ����������������ĵ�ֵַ
 *     �ȼ���ֱ����������������á�
 *     		java��������ڴ��ַ��һ��������ڴ��ַ����hashcode�����һ��ֵ����������ʵ��ֵַ
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020��9��16������10:46:26
 */
public class equels_lianxi {
	public static void main(String[] args) {
		int a = 10;
		int b = 10;
		float c = 10.0f;
		char d = 'A';
		int e = 65;
		System.out.println(a==b);
		System.out.println(a==c);
		System.out.println(d==e);
		System.out.println("-------------------------------------");
		equels_lianxi e1 = new equels_lianxi();
		System.out.println(e1);
		System.out.println(e1.toString());
		String name=new String("asdasd");
		name.toString();
		System.out.println( PrintStream.class);
		System.out.println(name);
		String nameString = "adss";
		nameString = null;
		System.out.println(nameString);
		equels_lianxi e1 = new equels_lianxi();
		e1 = null;
		System.out.println(e1);
	}
}
