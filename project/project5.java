package liubo;

public class project5 {

	public static void main(String[] args) {
		int i;
		for(i=1;i<=20;i++) {
			System.out.println("µÚ"+i+"Ïî£º"+getFValue(i));
		}
	}
	public static int getFValue(int n)
	{
		if(n<=2) {
			return 1;
		}
		else {
			return getFValue(n-1)+getFValue(n-2);
		}
	}
}
