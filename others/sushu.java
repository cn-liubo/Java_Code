package liubo;

public class sushu {
	//�������ж�һ����������
	//����һ����
	//�����true/false
	
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
					System.out.println(i+"������");
				}
			}
	}
}
