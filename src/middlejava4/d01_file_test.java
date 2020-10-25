package middlejava4;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * 		File ���ѧϰ��
 * 			1�� File ���һ�����󣬴���һ���ļ����ļ�Ŀ¼
 * 
 * 			2��File  �������� java.io ����
 * 
 * 			3�� File��ķ���ѧϰ
 * 					File ��Ĵ���
 * 					File ��ĳ��÷���  --- ��ȡ����
 * 					File ��ȡ�ļ�Ŀ¼����������
 * 					File �ķ���  ---- �ж�xxx�ķ�����
 * 					File �ķ���  ---  ���� �ļ�/�ļ�Ŀ¼ ���ܡ�ɾ���ļ����ļ�Ŀ¼
 * 			
 * 			4�� File�����漰�������ļ����ļ�Ŀ¼�Ĵ�����ɾ�������������޸�ʱ�䡢�ļ���С�ȷ����� ��δ�漰��д����ȡ�ļ�
 * 				���ݵĲ����������Ҫ��ȡ��д���ļ����ݣ������ʹ��IO������ɡ�		
 * 			5: ����File��Ķ��󳣳�����Ϊ�������ݵ����Ĺ������У�����ָ����ȡ��д��ġ��յ㡰
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020��10��23������10:48:27
 */
public class d01_file_test {
	
	// File ��Ĵ���
	@Test
	public void test() {
		
		// 1: ������ʽ1  new File(String pathname)
		File file = new File("f01.txt");
		System.out.println(file);

		// ������ʽ2 new File(String parentpath,String childpath)		------ ָ��һ���ļ�Ŀ¼
		File file2 = new File("D:\\wyzxw\\eclipse-workspace\\helloword\\src", "middlejava4");
		System.out.println(file2);

		// ������ʽ3 new File(File parent,String childpath)
		File file3 = new File(file2, "f01.txt");
		System.out.println(file3);
		
	}
	
	// File ��ĳ��÷���  --- ��ȡ����
	@Test
	public void test2() {
		File file = new File("f01.txt");
		File file2 = new File("D:\\wyzxw\\eclipse-workspace\\helloword\\f01.txt");
		
		// ����·��
		System.out.println(file.getAbsolutePath());
		// ��ȡ·��
		System.out.println(file.getPath());
		// �ļ�����
		System.out.println(file.getName());
		
		// ��ȡ�ϲ��ļ�Ŀ¼·��
		System.out.println(file.getParent());
		// ���һ���޸�����
		System.out.println(file.lastModified());
		// �ļ�����
		System.out.println(file.length());
		System.out.println("----------------------------------------------------------");
		System.out.println(file2.getAbsolutePath());
		// ��ȡ·��
		System.out.println(file2.getPath());
		// �ļ�����
		System.out.println(file2.getName());
		
		// ��ȡ�ϲ��ļ�Ŀ¼·��
		System.out.println(file2.getParent());
		// ���һ���޸�����
		System.out.println(file2.lastModified());
		// �ļ�����
		System.out.println(file2.length());
	}
	
	// File ��ȡ�ļ�Ŀ¼����������
	@Test
	public void test3() {
		File file = new File("D:\\wyzxw\\eclipse-workspace\\helloword");
		String[] list = file.list();
		for( String str:list) {
			System.out.println(str);
		}
		System.out.println("----------------------------------------------------------");
		File[] listFiles = file.listFiles();
		for( File str:listFiles) {
			System.out.println(str.getName());
		}
	}
	
	// File �ķ���  ---- �ж�xxx�ķ���
	@Test
	public void test4() {	
		File file = new File("f01.txt");
		//  �ж��Ƿ����ļ�Ŀ¼
		System.out.println(file.isDirectory());
		// �ж��Ƿ����ļ�
		System.out.println(file.isFile());
		// �ж��Ƿ����
		System.out.println(file.exists());
		// �ж��Ƿ�ɶ�
		System.out.println(file.canRead());
		// �ж��Ƿ��д
		System.out.println(file.canWrite());
		// �ж��Ƿ�����
		System.out.println(file.isHidden());
	}
	
	// File �ķ���  ---  ���� �ļ�/�ļ�Ŀ¼ ���ܡ�ɾ���ļ����ļ�Ŀ¼
	
		@Test
	public void test5() throws IOException {
		File file = new File("hi.txt");
		if(!file.exists()) {
			file.createNewFile();				//  �����ļ��� ���ļ����ڣ��򲻴���������flase	
			System.out.println("�����ɹ�");
		}else {
			file.delete();						// ɾ���ļ������ļ��С� ע�⣺Ҫɾ�����ļ����²��ܺ��б���ļ�������ɾ��ʧ��
			System.out.println("ɾ���ɹ�");
		}
		
		// ---------------------------------------- �ļ�Ŀ¼�Ĵ��� ----------------------------------------------------
		File file2 = new File("D:\\wyzxw\\eclipse-workspace\\helloword\\io");
		Boolean flageBoolean = file2.mkdir();					// �����ļ��С������Ŀ¼���ϲ�Ŀ¼�����ڣ��򴴽�ʧ��
		if (flageBoolean) {
			System.out.println("mkdir �ļ��д����ɹ�");
		}else {
			System.out.println("mkdir �ļ��д���ʧ��");
		}
		File file3 = new File("D:\\wyzxw\\eclipse-workspace\\helloword\\io2\\io3");
		flageBoolean = file3.mkdirs();						// �����ļ��С������Ŀ¼���ϲ�Ŀ¼�����ڣ���mkdirs һ�������Ǵ���
		if (flageBoolean) {	
			System.out.println("mkdirs �ļ��д����ɹ�");
		}else {
			System.out.println("mkdirs �ļ��д���ʧ��");
		}
	}
}
 




























































