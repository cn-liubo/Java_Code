package liubo;

public class order {
	
	public static void main(String[] args) {
		int[] a= {10,-9,9,22,87,-2,872,-234};
		int i = 0;
		int j = 0;
		int max=a[0];
		int min=a[0];
		for(int t=0;t<a.length;t++) {
			//大的
			if(a[t]>max) {
				max=a[t];
				i=t;
			}
			//小的
			if(a[t]<min) {
				min=a[t];
				j=t;
			}
		}
		System.out.println("max="+max+",at:"+i);
		System.out.println("min="+min+",at:"+j);
	}
}
