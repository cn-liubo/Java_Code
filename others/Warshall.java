package liubo;
import java.util.*;
public class Warshall {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int num1;
		int num2;
		
		System.out.print("��������������");
		num1=input.nextInt();
		
		int [][]array=new int[num1][num1];
		System.err.println("������ԭ�����(ÿ������num1"+num1+"�����ֺ�����س���ÿ������֮��ո�)��");
		for(int i=0;i<num1;i++) {
			for(int j=0;j<num1;j++) {
				array[i][j]=input.nextInt();
			}
		}
		
		System.out.println("ԭ����Ϊ��");
		for(int j=0;j<num1;j++) {
			for(int i=0;i<num1;i++) {
				System.out.print(array[j][i]+"  ");
			}
			System.out.println();
		}
		System.out.println("�¾���Ϊ: ");
		for(int i=0;i<num1;i++) {
			for(int j=0;j<num1;j++) {
				if(array[j][i]==1) {
					for(int k=0;k<num1;k++) {
						array[j][k]=array[i][k]+array[j][k];
						if(array[j][k]!=0) {
							array[j][k]=1;
						}
					}
				}
			}
		}
		for(int j=0;j<num1;j++) {
			for(int i=0;i<num1;i++) {
				System.out.print(array[j][i]+"  ");
			}
			System.out.println();
		}
	}

}
