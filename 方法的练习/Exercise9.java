package exercise;

public class Exercise9 {
	public void change() {
		int[] a= {1,2,3,4};
		int[] b= {5,6,7,8};
		int[] temp=a;
		a=b;
		b=temp;
		for(int u:a) {
			System.out.println(u);
		}
		System.out.println("++++++++++++++");
		for(int v:b) {
			System.out.println(v);
		}

	}
	
	public static void main(String[] args) {
		Exercise9 e=new Exercise9();
		e.change();
	}
}
