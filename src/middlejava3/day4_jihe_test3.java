package middlejava3;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;

/**
 * 	1������ ֮ list �ӿ� ��ѧϰ:
 * 		  
 * 		  list�ӿڿ��Է�ΪArrayList��LinkList��Vector���֡�
 * 
 * 		  ArrayList�� ��ΪList�ӿڵ���Ҫʵ���ࡣִ��Ч�ʸߡ��̲߳���ȫ�� �ײ�ʹ��Object[] elementData ���д洢.
 * 
 * 		  LinkList��   ����Ƶ���Ĳ�����ɾ������,ʹ�ô���ʱ��Ч�ʱ�ArrayListЧ�ʸߡ� �ײ�ʹ�� ˫������ ���д洢.
 * 			
 * 		   Vector��   ��ΪList�ӿڵĹ���ʵ���ࣨ������У��� �̰߳�ȫ. �ײ�ʹ��Object[] elementData ���д洢.
 * 
 *   2�� ArrayList��LinkList��Vector���ߵ���ͬ��
 *   		ͬ�� ���߶�ʵ����List�ӿ�,�洢���ݵ��ص���ͬ:���򡢿��ظ���
 *   		���� ������
 * 
 * 	 3: ArrayList ��Դ�����. (JDK7 �� JDK8 �����Դ�벻ͬ)
 * 			JDK7:
 * 				new ArrayList()����ʱ��ֱ�Ӵ���������Ĭ���ǳ���10������,
 * 				add(obj)�����г�����,Ĭ�����ݵ�ԭ�����1.5����
 * 
 * 			    ����:
 * 				  ����������,����ʹ�ô��ι�����,�������ⴴ�������н�������.
 * 			JDK8:
 * 				new ArrayList()����ʱ��,���ȴ���һ��ʵ�ʳ���Ϊ0������{},����һ�ν���add()����ʱ��,
 * 				�ٴ���һ������Ϊ10������.
 * 
 * 	        �ܽ�:
 * 				JDK7�еĶ��󴴽���������ģʽ�еĶ�ʽ,JDK8�еĶ��󴴽���������ģʽ�е�����ʽ,��ʱ�����鴴��,��ʡ���ڴ�.
 * 
 * 	 4: LinkList �� Դ�����:
 * 			�ڲ�ά����һ��Node�ڲ���,����ʵ��˫������
 * 
 *   5: Vector ��Դ�����.
 * 			����ʵ������ʱ��,Ĭ����������Ϊ10,������ʱ��,ֱ�Ӿ���ԭ���鳤�ȵ�2��.
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020��10��19������11:04:20
 */
public class day4_jihe_test3 {
	@Test
	public void test() {
		int[] a = {};
		
		System.out.println(a.length);
		
//		LinkedList<E>
	}
}
