package liubo;

public class project8 {
	public static void main(String[] args) {
//		//�ַ�����
//		String s1="java";
//		String s2="java";
//		
//		//��̬����
//		String s3=new String("java");
//		String s4=new String("java");
//		//==�ж��Ƿ�Ϊͬһ������ ����ַ
//		System.out.println("s1==s2"+(s1==s2));
//		System.out.println("s1==s3"+(s1==s3));
//		//equals�Ƚϵ��Ƕ��������
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
