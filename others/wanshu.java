package liubo;

public class wanshu {
	public static void main(String[] args) {
		for(int j=0;j<1000;j++)
		{
			int n=j;
			int sum=0;
			for(int i=0;i<n-1;i++)
			{
				if(n%i==0) {
					sum+=i;
				}
			}
			if(sum==n) {
				System.out.println(n+"是一个完数!");
			}
		}
	}
}
