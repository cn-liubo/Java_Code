package liubo;
import java.util.*;

//public interface project13{
//	int year=2008;
//	int age();
//	void output();
//}
public class project13 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] dbarry=new double[100];
		int[] intarry=new int[100];
		for(int i=0;i<dbarry.length;i++)
		{
			dbarry[i]=Math.random()*100;
			
		System.out.println(dbarry[i]+"ceil:"+Math.ceil(dbarry[i])+",floor:"+Math.floor(dbarry[i]));
		}
	}

}
