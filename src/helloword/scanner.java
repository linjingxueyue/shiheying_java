package helloword;

import java.util.Scanner;

/**
 * 		sc.hasNext()�������Ϊ�����������ֵ�浽��sc���ж�sc.next()�������Ϊ��sc��ȡֵ��
 * 	ȡֵ�󽫱�ʶ�����ƣ��������Ϊ��ȡ��ֵ�����ֵ�Ͳ����ˣ���
 *  ���sc��û��ֵ�ˣ���Ҳ��Ҫ������һ��ֵ��ǰ��˵�����������������룩��
 *  https://blog.csdn.net/yongbutingxide/article/details/83583869
 *  
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020��9��9������8:33:34
 */

public class scanner {
	public static void main(String[] args) {
		Scanner sc = new java.util.Scanner(System.in);
		System.out.println("------->  "+sc.hasNext()+" ---> "+sc.next());
	}
}
