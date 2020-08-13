package exercise;


public class Exercise10 {
	public void change(int... a) {
//		int[] a= {1,2,3,4,5,6,7};
		for(int i=0;i<=a.length/2;i++) {
			int temp=a[i];
			a[i]=a[a.length-1-i];
			a[a.length-1-i]=temp;	
		}
		for(int u:a) {
			System.out.println(u);
		}
		
	}
	public static void main(String[] args) {
		Exercise10 e=new Exercise10();
		int[] b=new int[] {1,2,3,4,5,6,7,8,9};
		e.change(b);
	}
}
