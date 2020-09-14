package liubo;
import java.util.*;
public class project15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int a=scanner.nextInt();
		int b=scanner.nextInt();
		int c=scanner.nextInt();
		System.out.println("请输入成绩：数学："+a+"  物理："+b+"  英语："+c);
		int sum,average;
		sum=a+b+c;
		average=sum/3;
		System.out.println("总成绩："+sum+"    平均成绩："+average);
	}

}
