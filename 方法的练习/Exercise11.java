package exercise;

import java.util.Scanner;

public class Exercise11 {
	public String isExist(int[] array,int element) {
		//ѭ����ʽ��Ѱ�Ƿ����
		String result="�Բ�����Ҫ��ֵ��������û��";
		for(int i=0;i<array.length;i++) {
			if(array[i]==element) {
				result="��ϲ������Ҫ��ֵ��������";
				break;
			}
		}
		return result; 
	}
	
	
//	public void find() {
//	Scanner input=new Scanner(System.in);
//	int a = input.nextInt();
//	int[] b= {1,2,3,8,5478,4774,585};
//	for(int i=0;i<=b.length;i++) {
//		if(a==b[i]) {
//			System.out.println("��������"+a+"���Ԫ��");
//		}
//		else {
//			System.out.println("������û��"+a+"���Ԫ��");
//		}
//	}
//}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Exercise11 e=new Exercise11();
		
		int[] x=new int[] {1,2,3,4,5,6,7,8,9};
		String result=e.isExist(x,4);
		System.out.println(result);
		
		
//		System.out.println("������һ������");
//		e.find();
	}
 
}
