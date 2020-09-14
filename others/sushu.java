package liubo;

public class sushu {
	//函数：判断一个数是素数
	//输入一个数
	//输出：true/false
	
	static boolean isprime(int number) {
		for(int i=2;i<number;i++) {
			if(number%i==0) {
				return false;
			}
		}
		return true;
		//return false;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			for(int i=1;i<=100;i++) {
				if(isprime(i)==true) {
					System.out.println(i+"是素数");
				}
			}
	}
}
