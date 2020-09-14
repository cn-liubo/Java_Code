package liubo;

import java.util.Random;

public class project11 {
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
	int d=(int)(Math.random()*50+51); 
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
