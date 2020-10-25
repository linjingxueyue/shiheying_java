package middlejava4;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * 		File 类的学习：
 * 			1： File 类的一个对象，代表一个文件或文件目录
 * 
 * 			2：File  类声明在 java.io 包下
 * 
 * 			3： File类的方法学习
 * 					File 类的创建
 * 					File 类的常用方法  --- 获取属性
 * 					File 获取文件目录的两个方法
 * 					File 的方法  ---- 判断xxx的方法。
 * 					File 的方法  ---  创建 文件/文件目录 功能、删除文件或文件目录
 * 			
 * 			4： File类中涉及到关于文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法。 并未涉及到写入或读取文件
 * 				内容的操作。如果需要读取或写入文件内容，则必须使用IO流来完成。		
 * 			5: 后续File类的对象常常会作为参数传递到流的构造器中，用于指明读取或写入的”终点“
 * @Description: 
 * @author: linjing 1395876278@qq.com
 * @date: 2020年10月23日下午10:48:27
 */
public class d01_file_test {
	
	// File 类的创建
	@Test
	public void test() {
		
		// 1: 创建方式1  new File(String pathname)
		File file = new File("f01.txt");
		System.out.println(file);

		// 创建方式2 new File(String parentpath,String childpath)		------ 指定一个文件目录
		File file2 = new File("D:\\wyzxw\\eclipse-workspace\\helloword\\src", "middlejava4");
		System.out.println(file2);

		// 创建方式3 new File(File parent,String childpath)
		File file3 = new File(file2, "f01.txt");
		System.out.println(file3);
		
	}
	
	// File 类的常用方法  --- 获取属性
	@Test
	public void test2() {
		File file = new File("f01.txt");
		File file2 = new File("D:\\wyzxw\\eclipse-workspace\\helloword\\f01.txt");
		
		// 绝对路径
		System.out.println(file.getAbsolutePath());
		// 获取路径
		System.out.println(file.getPath());
		// 文件名字
		System.out.println(file.getName());
		
		// 获取上层文件目录路径
		System.out.println(file.getParent());
		// 最近一次修改日期
		System.out.println(file.lastModified());
		// 文件长度
		System.out.println(file.length());
		System.out.println("----------------------------------------------------------");
		System.out.println(file2.getAbsolutePath());
		// 获取路径
		System.out.println(file2.getPath());
		// 文件名字
		System.out.println(file2.getName());
		
		// 获取上层文件目录路径
		System.out.println(file2.getParent());
		// 最近一次修改日期
		System.out.println(file2.lastModified());
		// 文件长度
		System.out.println(file2.length());
	}
	
	// File 获取文件目录的两个方法
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
	
	// File 的方法  ---- 判断xxx的方法
	@Test
	public void test4() {	
		File file = new File("f01.txt");
		//  判断是否是文件目录
		System.out.println(file.isDirectory());
		// 判断是否是文件
		System.out.println(file.isFile());
		// 判断是否存在
		System.out.println(file.exists());
		// 判断是否可读
		System.out.println(file.canRead());
		// 判断是否可写
		System.out.println(file.canWrite());
		// 判断是否隐藏
		System.out.println(file.isHidden());
	}
	
	// File 的方法  ---  创建 文件/文件目录 功能、删除文件或文件目录
	
		@Test
	public void test5() throws IOException {
		File file = new File("hi.txt");
		if(!file.exists()) {
			file.createNewFile();				//  创建文件。 若文件存在，则不创建并返回flase	
			System.out.println("创建成功");
		}else {
			file.delete();						// 删除文件或者文件夹。 注意：要删除的文件夹下不能含有别的文件，否则删除失败
			System.out.println("删除成功");
		}
		
		// ---------------------------------------- 文件目录的创建 ----------------------------------------------------
		File file2 = new File("D:\\wyzxw\\eclipse-workspace\\helloword\\io");
		Boolean flageBoolean = file2.mkdir();					// 创建文件夹。如果该目录的上层目录不存在，则创建失败
		if (flageBoolean) {
			System.out.println("mkdir 文件夹创建成功");
		}else {
			System.out.println("mkdir 文件夹创建失败");
		}
		File file3 = new File("D:\\wyzxw\\eclipse-workspace\\helloword\\io2\\io3");
		flageBoolean = file3.mkdirs();						// 创建文件夹。如果该目录的上层目录不存在，则mkdirs 一并帮我们创建
		if (flageBoolean) {	
			System.out.println("mkdirs 文件夹创建成功");
		}else {
			System.out.println("mkdirs 文件夹创建失败");
		}
	}
}
 




























































