package middlejava3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

/**
 * 		Set��ѧϰ:  ---------- �ýӿ�û�ж���Ķ����µķ���,ʹ�õĶ��Ǹ���Collection���������ɷ���
 * 
 * 			0:  �ص�: 
 * 					����:		������ �������� �����. ��HashSetΪ��˵����: 
 * 									�洢�������ٵײ������в����ǰ�������������˳�����,���Ǹ������ݵĹ�ϣֵ�������
 * 								�����������ָ���������List�ӿ��е�ʵ��,���ڲ����ڴ��ַ������������
 * 								
 * 				    �����ظ�:	������Ȼ����equals()���бȽ�,����������֮ǰ������hashcode()���е�ֵַ�Ƚ�
 * 								
 * 
 * 			1: set �ӿ��ܹ����Է�Ϊ:HashSet��LinkedHashSet��TreeSet ����.
 * 			
 * 			2:  HashSet :		set�ӿڵ���Ҫʵ����(������). �̲߳���ȫ. ���Դ洢nullֵ. �ײ�������+�������ʽ��������JDK 7�ĵײ�ʵ�֣�
 * 				LinkedHashSet:  ��ΪHashSet������, �������ڲ�����ʱ��,���԰�����ӵ�˳����б���
 * 				TreeSet:		���԰������Ԫ�ص�ָ�����Խ�������,�ײ��Ժ�������д洢.
 * 
 * 			3:  ���Ԫ��a�Ĺ���: ��HashSet --- JDK 7 Ϊ��:
 * 					1: ����a�Ĺ�ϣֵ,�����ݸ�ֵ��ĳ��ӳ���㷨,������������еľ���λ��.��λ�ü�Ϊ����
 * 					2: �жϸ�λ���Ƿ��Ѿ�����Ԫ��,
 * 							���û����ֱ����ӳɹ�.																--------- ��� 1
 * 							���������Ԫ��b(����������ʽ���ڵ�����Ԫ��),��Ƚ�Ԫ��a��b�Ĺ�ϣֵ,
 * 									�����ϣֵ����ͬ,��Ԫ��a��ӳɹ�.											-------------- ��� 2
 * 									��ϣֵ��ͬʱ,��������a��equals()����,���ݸ÷����ķ���ֵ�������ж��Ƿ����.  --------- ���3 
 * 											equals()��������true,��Ԫ��a���ʧ��
 * 											equals()��������flase,��Ԫ��a��ӳɹ�
 * 					3�� ����ͬһλ����ӳɹ�����������������ʽ���д洢���ֵ
 * 			4�� �ܽ᣺
 * 					1�� ��Set����ӵ����ݣ������ڵ��������дequals()��hashcode()����������
 * 					2�� ��д�������������������ܵı���һ���ԡ�����ȵĶ���һ��������ͬ�Ĺ�ϣֵ��
 * 
 * 			5�� LinkHashSet ��
 * 					��ʵ����������ݵ�ʱ�򣬻���ÿ������ά�����������ã���¼�����ݵ�ǰһ���ͺ�һ�����ݡ�
 * 				 ����ܹ������ʱ�������˳����������
 * 					�ŵ㣺����Ƶ���ı�����������Ч����Ƚ���HashSet�������Ƚϸߡ�
 * 
 * 			6: TreeSet: 
 * 				  1: �ڽ���add()���Ԫ�ص�ʱ����ΪTreeSet�����Ծ��ǿ��Ը���ָ���������������䲻����Ӳ�ͬ���͵Ķ���
 * 				  2: ����ӹ����У�������hashcode() ��equals()������Ϊ�Ƚ��ֶΣ�
 * 			 ����������Ӷ�������compareTo������compare()������Ϊ�ж����ݡ���֮���������ֲ�ͬ�ıȽϷ�������Ӧ���ֲ�ͬ��������Ȼ�����ڶ�������
 * 			ͬʱ����ʹ��Treesetʵ������contains()��remove(���ȷ���ʱ��Ҳ����Ҫequals()������������Ҫcompare()��compareTo() 
 * 
 * @Description: 		
 * @author: linjing 1395876278@qq.com
 * @date: 2020��10��20������1:00:38
 */
public class day4_jihe_test4 {
	// ----------------------- HashSet�� ʹ�� ---------------------------------------------------
	@Test
	public void test() {
		Set set = new HashSet();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add("ABC");
		set.add("678");
		
		
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());		// ���˳�������˳�򲢲�һ��
		}
	}
	
	// ----------------------- LinkHashSet�� ʹ�� ---------------------------------------------------
	@Test
	public void test2() {
		Set set = new LinkedHashSet();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add("ABC");
		set.add("678");
	
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());		// ���˳�������˳��һ�� . (ע�� ������Ҳ����ζ��������ʧЧ)
		}
	}
	// ----------------------- TreeSet�� ʹ�� ---------------------------------------------------
		@Test
		public void test3() {
			Set set = new TreeSet();
			set.add(1 );
			set.add(2);
			set.add(3);
			set.add(0);
			set.add(678);
		
			Iterator iterator = set.iterator();
			while(iterator.hasNext()) {
				System.out.println(iterator.next());		// ���˳�������˳��һ�� . (ע�� ������Ҳ����ζ��������ʧЧ)
			}
		}
}







