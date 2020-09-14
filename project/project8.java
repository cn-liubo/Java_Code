package liubo;

public class project8 {
	public static void main(String[] args) {
//		//字符常量
//		String s1="java";
//		String s2="java";
//		
//		//动态创建
//		String s3=new String("java");
//		String s4=new String("java");
//		//==判断是否为同一个引用 即地址
//		System.out.println("s1==s2"+(s1==s2));
//		System.out.println("s1==s3"+(s1==s3));
//		//equals比较的是对象的内容
//		System.out.println("s1 equals s2"+(s1.equals(s2)));
//		System.out.println("s1 equals s3"+(s1.contentEquals(s3)));
//		String s5="hello,java,hello,python";
//		System.out.println("s5 length ="+s5.length());
//		System.out.println(s5.substring(4));
//		System.out.println(s5.substring(4,15));
//		System.out.println(s5.charAt(15));
//		for(int i=0;i<s5.length();i++) {
//			//System.out.println(s5.charAt(i));
//			
//			if('o'==s5.charAt(i)) {
//				System.out.println("t");
//			}
//			else {
//				System.out.println(s5.charAt(i));
//			}
//			System.out.println(" ");
//		}
		String s6="bz";
		byte result[]=s6.getBytes();
		for(int i=0;i<s6.length();i++) {
			System.out.println(result[i]+" ");
		}
	}
}
