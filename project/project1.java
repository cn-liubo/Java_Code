package liubo;

public class project1 {
	public static void main(String[] args) {
		/*	int ageOFStudent=5;
			double scoreDFStudent=80.0;
			char levelOFStudent='B';
			System.out.println("年级\t 得分\t 等级");
			System.out.println(ageOFStudent+"\t"+scoreDFStudent+"\t"+levelOFStudent+"\t");
			System.out.println("欢迎学习JAVA语言!");
		
			byte a=64,b;
			int i;
			i=a<<2;
			b=(byte)(a<<2);
			System.out.println("Original value of a:"+a);
			System.out.println("i and b:"+i+""+b);
			
		int sum=0,i;
		for(i=0;i<=100;i++)
			sum+=i;
		System.out.println("sum="+sum);
		*/
			long sum=0;
			int i,j=1;
			for(i=1;i<=100;i++)
			{
				j=j*i;
				sum=sum+j;
				
			}
			System.out.println("sum="+sum);
	}	
		

}
