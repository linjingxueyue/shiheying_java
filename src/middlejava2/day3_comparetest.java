package middlejava2;
/**
 *  	java �ıȽ�����ѧϰ:
 *  		1: ���ڱȽ϶���Ĵ�С,����ʹ�������ӿ��е��κ�һ������:Comparable �� Comparator
 *  
 *  		2: Comparable ��ʹ�þ���    --------- ��Ȼ����
 *  			   1:��String����װ��Ⱦ�ʵ����Comparable�ӿ�,��д��compareTo()����,��������������Ƚϴ�С�ķ�ʽ
 *  			   2: ��дcompareTo(obj)�Ĺ���:
 *  					�����ǰ����this�����βζ���obj,�򷵻�������.
 *  					�����ǰ����thisС���βζ���,�򷵻ظ�����
 *  					�����ǰ����this�����βζ���,�򷵻�0
 *  		       3: �����Զ����������Ҫ����,���ǿ������Զ�����ʵ��Comparable�ӿ�,��дcompareTo()����.
 *  			      ��compareTo()������ָ����ν�������.
 *  
 *  		3: Comparator ��������
 *  			   1: ��Ԫ�ص�����û��ʵ��Comaprable�ӿ�,���ֲ������޸Ĵ���.����ʵ�ֵ�Comaprable�ӿڵ�����
 *  			 ���򲻷��ϵ�ǰ������Ҫ��ʱ��,���ǿ��Կ���ʹ��Comparator�Ķ���������
 *  			   2: ��Ҫ��дCompare(o1,02) ����.
 *  			   3: ��д����:
 *  					����0, �� o1 ���� o2;
 *  					����������, �� o1 ���� o2
 *  					���ظ�����, �� o1 С�� o2
 *  		
 *  		4: Comparable �� Comparator �� �^�e:
 *  				Comparable �ķ�ʽ,һ��ָ��,���CComparable�ӿڌ��FČ������κ�λ���϶����ԱȽϴ�С
 *  				Comparator �ķ�ʽ, ������ʱ�ԵıȽ�,��ʱ��Ҫ��ʱ����ʵ�ָýӿ�
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020��10��11������9:00:12
 */

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;


public class day3_comparetest {

	// Comparable ��ʹ�þ���
	@Test
	public void test1() {
		String[] arr= {"AA","BB","CC","KK","MM","GG","JJ","DD"};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println("******************************************************");
		Goods[] goods = new Goods[4];
		
		goods[0] = new Goods("����",6000);
		goods[1] = new Goods("С��",3000);
		goods[2] = new Goods("��Ϊ",4000);
		goods[3] = new Goods("apple",7000);
		
		Arrays.sort(goods);
		System.out.println(Arrays.toString(goods));
	}

	// Comparator ��ʹ�þ���
	@Test
	public void test2() {
		String[] arr= {"AA","BB","CC","KK","MM","GG","JJ","DD"};
		Arrays.sort(arr,new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				if(o1 instanceof String && o2 instanceof String) {
					String s1 = (String)o1;
					String s2 = (String)o2;
					return -s1.compareTo(s2);
				}
				else {
					throw new RuntimeException();
				}
			}
			
		});
		System.out.println(Arrays.toString(arr));
		System.out.println("******************************************************");
		Goods[] goods = new Goods[4];
				
		goods[0] = new Goods("����",6000);
		goods[1] = new Goods("С��",3000);
		goods[2] = new Goods("��Ϊ",4000);
		goods[3] = new Goods("apple",7000);
		
		Arrays.sort(goods,new Comparator<Goods>() {
			@Override
			public int compare(Goods o1, Goods o2) {
				
				return - Double.compare(o1.getPrice(), o2.getPrice());
			}
		});
		System.out.println(Arrays.toString(goods));
	}
}

/**
 *   ��Ʒ��, ʹ���ܹ��Ƚϴ�С
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020��10��11������9:35:06
 */
class Goods implements Comparable{
	private String nameString;
	private double price;
	public Goods() {
		super();
	}
	public Goods(String nameString, double price) {
		super();
		this.nameString = nameString;
		this.price = price;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 *  ָ�� ����ʲô��ʽ��������
	 */
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if(o instanceof Goods) {
			Goods o2 = (Goods)o;
			return Double.compare(this.price, o2.getPrice());
		}
		else {
			throw new RuntimeException();
		}
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nameString;
	}
}


