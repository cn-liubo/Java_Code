package liubo;

import java.util.Scanner;

public class project2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner scanner=new Scanner(System.in);
	System.out.print("����������");
	int input=scanner.nextInt();
	int remain=input%2;
	if(remain==1)
		System.out.println(input+"Ϊ����");
	else
		System.out.println(input+"Ϊż��");
	}
}
