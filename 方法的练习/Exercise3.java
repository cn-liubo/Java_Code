package exercise;

public class Exercise3 {
	public static void main(String[] args) {
		int[] a= {1,2,3,4,5,6,7};
		for(int i=0;i<(a.length)/2;i++) {
			int x=a[i];
			a[i]=a[(a.length-1)-i];
			a[(a.length-1)-i]=x;
		}
		for(int v:a) {
			System.out.println(v);
		}
	}
}
