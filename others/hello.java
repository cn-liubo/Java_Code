package liubo;

public class hello {
	/*public static void main(String args[]) {
		int ageOFStudent=5;
		double scoreOFStudent=80.0;
		char levelOFStudent='B';
		System.out.println("年级\t 得分\t 等级");
		System.out.println(ageOFStudent+"\t"+scoreOFStudent+"\t"+levelOFStudent+"\t");
		System.out.println("欢迎学习JAVA语言");
		*/
		public static void main(String[] args)
		{
			int[] arr=new int[5];
			arr(arr);
		}
		public static void arr(int arr[]) {
				for(int i=0;i<arr.length;i++) {
				math m=new math();
				 m.print();
			}
		}
}
	class math{
		int d=(int)(Math.random()*100+1); 
		
		public int Math() {
			if (d<=50) {
				d=d+50;
				return d;
			}else {
				d=d;
			return d;
			}
		} 
		public void print() {
			Math();
			System.out.println(d);
			
		}
	}
	


