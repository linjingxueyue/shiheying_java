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
 * 	IO流的理解:
 * 		1: 按照数据单位不同分为:字节流、字符流
 * 		2：按照数据流的流向不同分为：输入流、输出流
 * 		3：按照流的角色不同分为：节点流(针对的是具体文件)、处理流(针对的是节点流)
 * 		
 * 					（抽象基类）      字节流				字符流
 * 					  输入流		inputStream				Reader
 * 					  输出流		OutputStream			Writer
 * 		
 * 		5: 流的体系结构:
 * 				 抽象基类					    文件流(节点流的一种)  		    缓冲流(处理流的一种)
 * 				inputStream					FileInputStream					BufferedInputStream
 * 				OutputStream				FileOutputStream				BufferedOutputStream
 * 				  Reader					FileReader			      	      BufferedReader
 *				  Writer					FileWriter                        BufferedWriter
 *----------------------------------------  以下是字符流 ---------------------------------------------------------------
 *		6: test()与test2() 读取测试方法的总结:
 *			1: read()方法的理解.
 *			2: 异常的处理,为了保证流资源一定可以执行关闭操作,需要使用try-catch-finally块进行代码包裹.。
 *			3: fr = new FileReader(file); 创建输入流的函数,其中file文件一定是硬盘中存在的文件,如果文件不存在,则会抛出异常
 *		
 *		7: write() 写出测试方法的总结:
 *			1: 输出操作,对应的File可以不存在.如果不存在,在输出的过程中,会自动创建此文件.
 *											 如果存在,则根据参数决定是进行覆盖还是追加
 *------------------------------------------------  以下是 字节流 --> test4()   --------------------------------------------------------
 *		8:  对于文本文件，使用字符流处理。 （.txt，.c，.cpp，.java ）
 *			对于非文本文件，使用字节流文件。(.jpg，.mp3，.doc，.ppt)
 *
 *		9:  对于文本文件的复制 可以使用字符流也可以使用字节流
 *			对于非文本文件的复制，只能使用字节流
 *	--------------------------------------------    以下是缓冲流 --> test5()   ------------------------------------------------------------	
 *		10: 缓冲流作用： 提高流的读写效率 。
 *		
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020年10月25日下午7:38:23
 */
public class d02_IO_test {
	
	// 输入字符流的使用
	@Test
	public void test()  {
		
		// 2: 提供具体的流
		FileReader fr = null;
		try {
			// 1: 读取文件内容到程序中,并输出到控制台
			File file = new File("f01.txt");
			System.out.println(file.getAbsolutePath());
			fr = new FileReader(file);
			
			// 3: read() 数据的读入过程. 返回读入的一个字符.如果到达文件末尾就返回-1
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
			// 4: 流的关闭
			try {		
				fr.close();			// 这里是避免 fr = new FileReader(file); 这一行出差,直接导致fr.close()报错
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	// 对 输入流的 read() 方法操作升级: 使用read()的重载方法
	@Test
	public void test2() {

		// 2: 提供具体的流
		FileReader fr = null;
		try {
			// 1: 读取文件内容到程序中,并输出到控制台
			File file = new File("f01.txt");
			System.out.println(file.getAbsolutePath());
			fr = new FileReader(file);
			
			// 3: read(cbuf) 数据的读入过程. 一次读入cbuf数组长度的字符.返回值表示该次读取的字符个数或-1(流的末尾返回-1)
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
			// 4: 流的关闭
			try {		
				fr.close();					// 这里是避免 fr = new FileReader(file); 这一行出差,直接导致fr.close()报错
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//   从 内存中写出数据到硬盘的文件
	@Test
	public void test3() throws IOException {
		// 1: 提供File类的对象,用于指明写出到的文件
		File file = new File("f01.txt");
		// 2: 提供FileWriter的对象,用于数据的写出
		FileWriter fw = new FileWriter(file,false);
		// 3: 写出操作
		fw.write("i have a dream\n ");
		fw.write("you  have a dream ");

		// 4:流的关闭
		fw.close();
		
	}

	// 字节流的 读取与 写入 
	@SuppressWarnings("resource")
	@Test
	public void test4() {
	// 2: 提供具体的流
		FileInputStream fr = null;
		FileOutputStream fw  = null;
			try {
				// 1: 读取文件内容到程序中,并输出到控制台
				File file = new File("lena.jpg");
				File file2 = new File("lena2.jpg");
				System.out.println(file.getAbsolutePath());
				fr = new FileInputStream(file);
				fw = new FileOutputStream(file2);
				// 3: read(cbuf) 数据的读入过程. 一次读入cbuf数组长度的字符.返回值表示该次读取的字符个数或-1(流的末尾返回-1)
				byte[] cbuf = new byte[5];
				int len =0;
				while((len=fr.read(cbuf)) !=-1) {
					fw.write(cbuf, 0, len);
					 
				}
				System.out.println("图片处理成功");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				// 4: 流的关闭
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

	// 缓冲流的 操作. 以 实现非文本文件的复制为例说明，其能够提高流的效率
	@Test
	public void test5() throws IOException {
		// 3： 造出缓冲流
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			// 1: 造文件
			File srcFile = new File("lena.jpg");
			File destFile = new File("lena3.jpg");
			
			// 2： 造出两个节点流 （读取与写入）
			FileInputStream fis = new FileInputStream(srcFile);
			FileOutputStream fos = new FileOutputStream(destFile);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			
			// 4: 读取与 写入的过程
			byte[] buffer = new byte[5];
			int len;
			while((len=bis.read(buffer))!=-1) {
				bos.write(buffer, 0, len);
			}
			System.out.println("图片复制成功");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			// 5: 资源关闭： 先关闭外层流，再关闭内层流. (但是关闭外层流的时候，会自动关闭内层流)
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






































