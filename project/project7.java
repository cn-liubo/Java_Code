package liubo;

public class project7 {
	public static void main(String[] args) {
		/*int a[]=new int[4];
		System.out.println("a[4]="+a[3]);
		byte btArray[]= {97,98,99,100,101,102,103};
		String s1=new String(btArray);
		System.out.println(""+s1);
		String s2=new String(btArray,0,7);
		System.out.println(""+s2);
		char cArray[]= {'吾','儿','奉','先','何','在','？','王','a'};
		String s3=new  String(cArray);
		System.out.println(""+s3);
		String s4=new  String(cArray,4,3);
		System.out.println(""+s4);
		System.out.println("s1 equals s2?"+s1.equals(s2));
		System.out.println("s1 compare s3?"+s1.compareTo(s2));*/
		String s1=new String("java");
		String s2=new String("java");
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
		System.out.println(s1.compareTo(s2));
		String s3=new String("java");
		String s4=new String("java");
		System.out.println(s3==s4);
		System.out.println(s3.equals(s3));
		System.out.println(s3.compareTo(s4));
	}
}
