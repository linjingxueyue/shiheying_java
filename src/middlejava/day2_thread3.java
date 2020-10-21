package middlejava;

/**
 * @Description: ����ģʽ������ʽ �������̰߳�ȫ������
 * @author: linjing 1395876278@qq.com
 * @date: 2020��9��25������8:31:04
 * 
 * 		�����ʽ��
 * 			���� ͬ�������� ģʽ��
 * 					public  static  synchronized Window4 createInstance() {
 * 			����synchronized�����ķ�ʽ��
 * 					synchronized (Window4.class) {
 * 					}
 * 		�����ʽ���Ż���
 * 			�����ַ�ʽ��Ч�ʶ��Ƚϵͣ���Ϊ�������ʽ����ģʽ���̰߳�ȫ���⣬Ҳ��ͣ����һ��ʼ����߳�ͬ��ӿ�룬�������ʵ����
 *   	  ʱ�򣬵�ʵ��������ϣ�Ҳ�Ͳ�������ν���̰߳�ȫ���⣬��ʱ��Ū��Щͬ������������飩��ʹ�ó���Ч�ʱ�͡�
 *   		�Ż��ķ�ʽ��ʹ��Ҳ���ǿ�ʼ������ͬ������������飩��ʹ�ã����������ʹ�á�
 */

// ����ʽ
class Window4  {
	private static Window4 instanceWindow4 = null;

	private Window4() {

	}
// ���� ͬ�������� ģʽ��
	//	public  static  synchronized Window4 createInstance() {
	//		if (instanceWindow4 == null) {
	//			instanceWindow4 = new Window4();
	//		}
	//		return instanceWindow4;
	//	}

// ����synchronized�����ķ�ʽ��
	//	public  static   Window4 createInstance() {
	//		synchronized (Window4.class) {
	//			if (instanceWindow4 == null) {
	//				instanceWindow4 = new Window4();
	//			}
	//			return instanceWindow4;
	//		}
	//	}
// �Ż�
	public  static   Window4 createInstance() {
		if(instanceWindow4 == null) {
			synchronized (Window4.class) {
				if (instanceWindow4 == null) {
					instanceWindow4 = new Window4();
				}
			}
		}
		return instanceWindow4;
	}
}

public class day2_thread3 {
	public static void main(String[] args) {

	}
}
