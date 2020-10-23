package middlejava3;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;


import org.junit.Test;


/**
 * 		1��Map:  �洢��ֵ��
 * 			|----- HashMap:	  ��ΪMap����Ҫʵ���࣬  �̲߳���ȫ��Ч�ʸߡ� ���Դ洢Nullֵ��key��value��
 * 
 * 				|------ LinkedHashMap:  ��HashMap�����࣬����Ա�֤�ڱ���mapԪ��ʱ�򣬿��԰�����ӵ�˳����б�����
 * 										ԭ�����ڣ� ��ԭ�е�HashMap�Ļ����ϣ���ÿһ�洢ʵ�������һ��ָ�룬ָ��ǰһ����
 * 									��һ���洢ʵ����
 * 										����Ƶ���ı�������������ִ��Ч�ʸ���HashMap
 * 
 * 			|----- TreeMap:				����������ʵ����key-value��������ʵ�������������ʱ�����key���е�����
 * 										��ײ���ú�����洢��
 * 
 * 			|----- Hashtable:	��Ϊ����ʵ���࣬�̰߳�ȫ��Ч�ʵ͡������Դ洢Nullֵ��key��value��
 * 
 * 				|---- Propertries:	���������������ļ���key �� value ����String����
 * 	----------------------------------------------------------------------------------------------
 * 
 * 		2��HashMap �� Hashtable:
 * 				�����	JDK7 ʱ�򣬲��� ����+���� ����ʽ���д洢��
 * 						JDK8ʱ�򣬲��� ����+����+����� ����ʽ���д洢��
 * 
 * 		3�� Map�ṹ����⣺(���ɣ� Դ���������Entry�Ĵ洢ʹ�õ���entry���飬������Set�� 
 * 						----- �������1�� HashMap�ڲ�����һ��Set��collction��������ͳ��map�е�key��value,
 * 						������ʦ�Ż���ô����������Щ�ṹ�洢�������keySet()��values()��entrySet()����
 * 						----- �������1.2��keySet()��values()��entrySet()�������entrySet()����˵����
 * 						��ʵ���Ƿ���һ��Set�����࣬�������ڲ�����һ�������������϶�HashMap��table������е��� ��
 * 						���������������������������Ļ����Ͻ��н�һ����������)
 * 
 * 			Map��key: 	���򡢲����ظ��� ʹ��set�ṹ���д洢��  
 * 							--- �� ��α���key�ظ��� ���Ҫ��key���ڵ�����дequals()��hashcode()����������HashSetΪ������˵����
 * 			Map��value:  ���򣬿��ظ���ʹ��Collection�洢��
 * 							---��value���ڵ���Ҳ��Ҫ��д equals()����
 * 			һ����ֵ�ԣ�   key-value ����һ��Entry����
 * 			Map�е�Entry�� ���򡢲����ظ��ģ�ʹ��Set�ṹ���д洢
 * 
		4�� HashMap �� �ײ� ���ԭ��
		 ���� JDK 7�е�Ϊ������
			 ��һ���ֵ����ݲο�HashSet�����ԭ�� Ψһ��ͬ�ط�������ʾ��
			 		�������Ԫ��key1,������λ���ϵ�Ԫ��key�ȽϹ�ϣֵ����ȣ�key1.equals(key)��Ȼ���ʱ��
			 	��Ҫʱ��key1��valueֵ �滻 ԭ��λ���ϵ�key�Ĺ�ϣֵ
			 �ڲ�����ӵĹ����У�Ĭ�ϵ����ݷ�ʽ�������ٽ�ֵ����Ҫ��ŵ�λ�÷ǿգ��� ����Ϊԭ��������2��������ԭ�������ݸ��ƹ�����
		 JDK 8 ��Ƚ���JDK7 ���еĲ�ͬ��
			1��new HashMap()����ʱ�򣬵ײ�û�д���һ������Ϊ16�����顣
			2��JDK 8�ĵײ����� �ǣ� Node[] table;������JDK 7�е�Entry[] table
			3���״ε���put����ʱ�򣬵ײ�Żᴴ������Ϊ16�����顣
			4�� ������ĳһ������λ���ϵ�Ԫ����������ʽ���ڵ����ݸ��� >8 ���ҵ�ǰ���鳤�� > 64ʱ�򣬴�����λ���ϵ��������ݸ�Ϊʹ�ú�������д洢��
			
		5: LinkedHashMap�й����ܹ��������˳�������Դ�����£�
				static class Entry<K,V> extends HashMap.Node<K,V> {
        			Entry<K,V> before, after;
        			Entry(int hash, K key, V value, Node<K,V> next) {
            			super(hash, key, value, next);
        			}
    			}
   -------------------------------------------------------------------------------------------------------
    	6�� ����ע�⣺
    		HashSet��add(obj)��������ʵ���ʵ��õ�Ҳ��map��put������ֻ�ǽ�obj��Ϊmap��key���롣
    		��ʱ��value������һ�����ɱ�ó��� PRESENT = new Object();
    		HashSet�� add������Դ�����£�
    				 public boolean add(E e) {
        				return map.put(e, PRESENT)==null;
    				}
 -------------------------------------------------------------------------------------------------------
   		7�� map �еĳ��÷�����
   			Object put(object key,object value):  ��ָ����key- value ����루�޸ģ���ǰ��Map������
   			void putAll(Map m)��			�� m �����е�key-value���뵱�ڵ�map������
   			Object remove(object key)��  ����key�Ƴ�����map�����Ӧ�ļ�ֵ�ԡ�������value
   			void clear()			��յ��ڵ�map����
   			---------------
   			Object get(object key):  ��ȡָ��key��Ӧ��value
   			boolean containskey(object key):  �Ƿ����ָ����key
   			boolean containsvalue(object value):�Ƿ����ָ����value
   			int size(): ���ص�ǰmap��key-value�ĸ���
   			boolean isEmpty(): �жϵ�ǰmap�Ƿ�Ϊ��
   			boolean equal(object obj): �жϵ�ǰmap�Ͳ�������obj�Ƿ����
   			-----------------
   			Set krySet(): ���ص�ǰ����key���ɵ�Set����
   			Collection values():���ص�ǰ����vlaue���ɵ�Collection����
   			Set entrySet(): ��������key-value�Թ��ɵļ���
   			
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020��10��20������11:08:00
 * 
 */
public class day4_jihe_map {
	@Test
	public void test() {
		Map set =new HashMap();
		set.put(null,null);
		System.out.println(set);
		Map set2=new Hashtable();
//		set2.put(null,null);			// --- error 
		new LinkedHashMap();
		new HashSet<>();
	}
	
	@Test
	public void test2() {
		Map map=new HashMap();
		map.put("AA", "123");
		map.put(34, "adasdas");
		map.put("name", "linjing");
		Set set = map.keySet();
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("----------------------------");
		Collection collection = map.values();
		Iterator iterator2 = collection.iterator();
		while(iterator2.hasNext()) {
			System.out.println(iterator2.next());
		}
		System.out.println("----------------------------");
		Set set2 = map.entrySet();
		Iterator iterator3 = set2.iterator();
		while(iterator3.hasNext()) {
			System.out.println(iterator3.next());
		}
	}
}















































































