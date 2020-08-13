package exercise;

public class Exerxise2 {
	public static void main(String[] args) {
		/*
		int[] a= {1,2,3,4};
		int[] b= {5,6,7,8};
		//int[] c=new int[4];
		int x;
		for(int i=0;i<4;i++) {
			//c[i]=a[i];
			x=a[i];
			a[i]=b[i];
			b[i]=x;
			//b[i]=c[i];
		}
		for(int u:a) {
			System.out.println(u);
		}
		for(int v:b) {
			System.out.println(v);
		}*/
		int[] a= {1,2,3,4,9,0};
		int[] b= {5,6,7,8};
		int[] temp=a;
		a=b;
		b=temp;
		for(int u:a) {
			System.out.println(u);
		}
		System.out.println("+++++++++++");
		for(int v:b) {
			System.out.println(v);
		}
	}
}
