package exercise;

public class Exercise5 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {1,2,3};
		int[] b= {4,5};
		int[] c=new int[a.length+b.length];
		for(int i=0;i<c.length;i++) {
			if(i<a.length) {
				c[i]=a[i];
			}
			else {
				c[i]=b[i-a.length];
			}
		}
		/*
		for(int i=0;i<a.length;i++) {
			c[i]=a[i];
		}
		for(int j=0;j<b.length;j++) {
			c[a.length+j]=b[j];
		}*/
		
		for(int u:c){
			System.out.println(u);
		}
	}
}
