package exercise;

public class Exercise4 {
	public static void main(String[] args) {
		int[] a= {1,3,5,7,9,0,2,4,6,8};
		int max=a[0],min=a[0];
		for(int i=1;i<a.length;i++) {
			if(max<a[i]) {
				max=a[i];
			}
			else if(min>a[i]){
				min=a[i];
			}
		}
		System.out.println("最大值为:"+max);
		System.out.println("最小值为:"+min);
	}
}
