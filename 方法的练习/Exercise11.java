package exercise;

import java.util.Scanner;

public class Exercise11 {
	public String isExist(int[] array,int element) {
		//循环方式找寻是否存在
		String result="对不起，您要的值在数组中没有";
		for(int i=0;i<array.length;i++) {
			if(array[i]==element) {
				result="恭喜您，您要的值在数组中";
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
//			System.out.println("数组中有"+a+"这个元素");
//		}
//		else {
//			System.out.println("数组中没有"+a+"这个元素");
//		}
//	}
//}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Exercise11 e=new Exercise11();
		
		int[] x=new int[] {1,2,3,4,5,6,7,8,9};
		String result=e.isExist(x,4);
		System.out.println(result);
		
		
//		System.out.println("请输入一个数：");
//		e.find();
	}
 
}
