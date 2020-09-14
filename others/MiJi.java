package liubo;

import java.util.Scanner;

public class MiJi {
	public static void main(String[] args) {
//		Scanner input=new Scanner(System.in);
//		System.out.println("请输入数组的元素：");
//		int i=input.nextInt();
		int[] a=new int[] {1,2,3};
		for(int v:a) {
			System.out.print(v);
		}
		int i=2,j=0;
		while(j<a.length) {
			 int s=i+(i*j);
			j++;
		}
		int[][] b=new int[s][];
		
	}
}
