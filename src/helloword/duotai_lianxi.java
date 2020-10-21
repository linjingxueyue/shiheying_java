package helloword;
class Base1{
	public void add(int a,int...arr) {
		System.out.println("base1");
	}
}
class Sub extends Base1{
	public void add(int a,int[]arr) {
		System.out.println("sub1");
	}
}
public class duotai_lianxi {	
	public static void main(String[] args) {
		Base1 base1 = new Sub();
		base1.add(1,2,3);
		Sub sub=(Sub)base1;
		int [] a= new int[] {1,2,3};
//		sub.add(1,1,2);
	}
}
