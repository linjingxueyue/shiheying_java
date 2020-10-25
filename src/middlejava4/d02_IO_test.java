package middlejava4;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;

/**
 * 	IO�������:
 * 		1: �������ݵ�λ��ͬ��Ϊ:�ֽ������ַ���
 * 		2������������������ͬ��Ϊ���������������
 * 		3���������Ľ�ɫ��ͬ��Ϊ���ڵ���(��Ե��Ǿ����ļ�)��������(��Ե��ǽڵ���)
 * 		
 * 					��������ࣩ      �ֽ���				�ַ���
 * 					  ������		inputStream				Reader
 * 					  �����		OutputStream			Writer
 * 		
 * 		5: ������ϵ�ṹ:
 * 				 �������					    �ļ���(�ڵ�����һ��)  		    ������(��������һ��)
 * 				inputStream					FileInputStream					BufferedInputStream
 * 				OutputStream				FileOutputStream				BufferedOutputStream
 * 				  Reader					FileReader			      	      BufferedReader
 *				  Writer					FileWriter                        BufferedWriter
 *----------------------------------------  �������ַ��� ---------------------------------------------------------------
 *		6: test()��test2() ��ȡ���Է������ܽ�:
 *			1: read()���������.
 *			2: �쳣�Ĵ���,Ϊ�˱�֤����Դһ������ִ�йرղ���,��Ҫʹ��try-catch-finally����д������.��
 *			3: fr = new FileReader(file); �����������ĺ���,����file�ļ�һ����Ӳ���д��ڵ��ļ�,����ļ�������,����׳��쳣
 *		
 *		7: write() д�����Է������ܽ�:
 *			1: �������,��Ӧ��File���Բ�����.���������,������Ĺ�����,���Զ��������ļ�.
 *											 �������,����ݲ��������ǽ��и��ǻ���׷��
 *------------------------------------------------  ������ �ֽ��� --> test4()   --------------------------------------------------------
 *		8:  �����ı��ļ���ʹ���ַ������� ��.txt��.c��.cpp��.java ��
 *			���ڷ��ı��ļ���ʹ���ֽ����ļ���(.jpg��.mp3��.doc��.ppt)
 *
 *		9:  �����ı��ļ��ĸ��� ����ʹ���ַ���Ҳ����ʹ���ֽ���
 *			���ڷ��ı��ļ��ĸ��ƣ�ֻ��ʹ���ֽ���
 *	--------------------------------------------    �����ǻ����� --> test5()   ------------------------------------------------------------	
 *		10: ���������ã� ������Ķ�дЧ�� ��
 *		
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020��10��25������7:38:23
 */
public class d02_IO_test {
	
	// �����ַ�����ʹ��
	@Test
	public void test()  {
		
		// 2: �ṩ�������
		FileReader fr = null;
		try {
			// 1: ��ȡ�ļ����ݵ�������,�����������̨
			File file = new File("f01.txt");
			System.out.println(file.getAbsolutePath());
			fr = new FileReader(file);
			
			// 3: read() ���ݵĶ������. ���ض����һ���ַ�.��������ļ�ĩβ�ͷ���-1
			int data = fr.read();
			while(data !=-1) {
				System.out.print((char)data+"---");
				data = fr.read();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// 4: ���Ĺر�
			try {		
				fr.close();			// �����Ǳ��� fr = new FileReader(file); ��һ�г���,ֱ�ӵ���fr.close()����
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	// �� �������� read() ������������: ʹ��read()�����ط���
	@Test
	public void test2() {

		// 2: �ṩ�������
		FileReader fr = null;
		try {
			// 1: ��ȡ�ļ����ݵ�������,�����������̨
			File file = new File("f01.txt");
			System.out.println(file.getAbsolutePath());
			fr = new FileReader(file);
			
			// 3: read(cbuf) ���ݵĶ������. һ�ζ���cbuf���鳤�ȵ��ַ�.����ֵ��ʾ�ôζ�ȡ���ַ�������-1(����ĩβ����-1)
			char[] cbuf = new char[5];
			int data = fr.read(cbuf);
			while(data !=-1) {
				char[] copyOfRange = Arrays.copyOfRange(cbuf, 0, data);
				System.out.print(String.valueOf(copyOfRange));
				data = fr.read(cbuf);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// 4: ���Ĺر�
			try {		
				fr.close();					// �����Ǳ��� fr = new FileReader(file); ��һ�г���,ֱ�ӵ���fr.close()����
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//   �� �ڴ���д�����ݵ�Ӳ�̵��ļ�
	@Test
	public void test3() throws IOException {
		// 1: �ṩFile��Ķ���,����ָ��д�������ļ�
		File file = new File("f01.txt");
		// 2: �ṩFileWriter�Ķ���,�������ݵ�д��
		FileWriter fw = new FileWriter(file,false);
		// 3: д������
		fw.write("i have a dream\n ");
		fw.write("you  have a dream ");

		// 4:���Ĺر�
		fw.close();
		
	}

	// �ֽ����� ��ȡ�� д�� 
	@SuppressWarnings("resource")
	@Test
	public void test4() {
	// 2: �ṩ�������
		FileInputStream fr = null;
		FileOutputStream fw  = null;
			try {
				// 1: ��ȡ�ļ����ݵ�������,�����������̨
				File file = new File("lena.jpg");
				File file2 = new File("lena2.jpg");
				System.out.println(file.getAbsolutePath());
				fr = new FileInputStream(file);
				fw = new FileOutputStream(file2);
				// 3: read(cbuf) ���ݵĶ������. һ�ζ���cbuf���鳤�ȵ��ַ�.����ֵ��ʾ�ôζ�ȡ���ַ�������-1(����ĩβ����-1)
				byte[] cbuf = new byte[5];
				int len =0;
				while((len=fr.read(cbuf)) !=-1) {
					fw.write(cbuf, 0, len);
					 
				}
				System.out.println("ͼƬ����ɹ�");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				// 4: ���Ĺر�
				try {		
					fr.close();					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {		
					fw.close();					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}

	// �������� ����. �� ʵ�ַ��ı��ļ��ĸ���Ϊ��˵�������ܹ��������Ч��
	@Test
	public void test5() throws IOException {
		// 3�� ���������
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			// 1: ���ļ�
			File srcFile = new File("lena.jpg");
			File destFile = new File("lena3.jpg");
			
			// 2�� ��������ڵ��� ����ȡ��д�룩
			FileInputStream fis = new FileInputStream(srcFile);
			FileOutputStream fos = new FileOutputStream(destFile);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			
			// 4: ��ȡ�� д��Ĺ���
			byte[] buffer = new byte[5];
			int len;
			while((len=bis.read(buffer))!=-1) {
				bos.write(buffer, 0, len);
			}
			System.out.println("ͼƬ���Ƴɹ�");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			// 5: ��Դ�رգ� �ȹر���������ٹر��ڲ���. (���ǹر��������ʱ�򣬻��Զ��ر��ڲ���)
			try {
				bis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
	}
}






































