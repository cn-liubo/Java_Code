package exercise;


public class Exercise12 {
	public void combine() {
		int[] a= {1,2,3,4};
		int[] b= {5,6,7,8,9};
		int[] c=new int[a.length+b.length];
		for(int i=0;i<c.length;i++) {
			if(i<a.length) {
				c[i]=a[i];
			}
			else {
				c[i]=b[i-a.length];
			}
		}
		for(int u:c){
			System.out.println(u);
		}
	}
	public static void main(String[] args) {
		Exercise12 e=new Exercise12();
		e.combine();
	}
}
