package helloword;

import java.util.Scanner;

public class helloword {
	/**
	 * 
	 * @Description 
	 * @author linjing 1395876278@qq.com
	 * @date 2020��8��28������12:33:14
	 * @param args
	 */
	public static void main(String[] args) {

		char name = 'w';
		String age = "linjing";
		System.out.println("Hello World" + '-' + age);
		// ���������� ��ʽһ (���õķ�ʽ�Ͳ�д�ˡ�)
		/**
		 * �ô��� ���ö�����ʱ���� �׶ˣ� ֻ��������ֵ�ͣ�������Ӳ������ܳ�����Χ
		 */
		int num1 = 10;
		int num2 = 20;
		num1 = num1 + num2;
		num2 = num1 - num2;
		num1 = num1 - num2;
		System.out.println("num1=" + num1 + "num2=" + num2);
		// ���������ķ�ʽ ��
		/**
		 * ʹ�� ����λ���� �׶ˣ� ֻ���m���ڔ�ֵ�͡�
		 */
		int num3 = 10;
		int num4 = 20;
		int k = num3 ^ num4;
		num4 = k ^ num4;
		num3 = k ^ num3;
		System.out.println("num3=" + num3 + "num4=" + num4);
		// ---------------------------------------------------------------------------
		/**
		 * ʮ����תΪʮ������ �ķ�ʽ 1
		 */
		num1 = 60;
		System.out.println(Integer.toHexString(num1));
		/**
		 * ʮ����תΪʮ������ �ķ�ʽ 2
		 */
		int tmp = 15;
		String str1 = "";
		int tmp2 = num1 & 15;
		str1 = tmp2 > 9 ? (char) (tmp2 - 10 + 'A') + "" : tmp2 + "";
		num1 = num1 >>> 4;
		tmp2 = num1 & 15;
		String str2 = tmp2 > 9 ? (char) (tmp2 - 10 + 'A') + "" : tmp2 + "";
		System.out.println(str2 + str1);
		// ---------------------------------------------------------------------------
		/**
		 * ��δӼ��̻�ȡ���ݣ���Ҫʹ��Scanner��. ע�⣺ �������������Ҫ�����Ͳ�ƥ��ʱ�򣬻ᱨ�쳣��
		 */
		Scanner scanner = new Scanner(System.in);
		// int num = scanner.nextInt();
		// System.out.println(num);
		// ---------------------------------------------------------------------------
		int num = 1;
		for (System.out.println('a'); num <= 3; System.out.println("c"), num++) {
			System.out.println('b');
		}
		//-----------break�����ڲ�ѭ��,���Ի��������ִ��.��Ĭ�Ͻ���������ѭ��
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.println("----");
				break;
//				continue;
			}
			System.out.println("+++++");
		}
		//-----------breakĬ�������ڲ�ѭ��,����ͨ����ǩ��ʽ�����������ѭ��.. continueҲ�����Ƶķ�ʽ
		System.out.println("**********************************");
		label: for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.println("----");
				break label;
			}
			System.out.println("+++++");
		}
	}
}

class person {

}

class person2 {

}