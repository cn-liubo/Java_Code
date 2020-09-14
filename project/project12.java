package liubo;

public class project12 {
	public static void main(String[] args) {
//		String s1="java";
//		String s2=s1+"hello";
//		String s3="javahello";
//		String s4="java"+"hello";
//		System.out.println(s2);
//		System.out.println(s3);
//		System.out.println(s4);
//		System.out.println(""+(s3==s2));
//		System.out.println(""+(s3==s4));
//		System.out.println(""+(s2==s4));
		StringBuffer s1=new StringBuffer();
		StringBuffer s2=new StringBuffer(126);
		StringBuffer s3=new StringBuffer("wang,wang,wang,wang");
//		System.out.println("s1.length="+s1.length());
//		System.out.println("s1.Capacity="+s1.capacity());
//		System.out.println("s2.length="+s2.length());
//		System.out.println("s2.Capacity="+s2.capacity());
		
		
		System.out.println("s3.length="+s3.length());
		System.out.println("s3.Capacity="+s3.capacity());
		
		
		s3.append("hello,hello,hello,hello,hello");
		System.out.println(""+s3.length());
		System.out.println(""+s3.capacity());
		
		
	}
}
