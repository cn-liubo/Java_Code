package liubo;

import java.util.*;

public class project14 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		//把用户输入问题“吗”，“？”，给予回复
		String str=scanner.next();
		
		while(str!="exit") {
			
			if(str.contains("姓名"))
			{
				str="别问我是谁";
			}
			if(str.contains("发货"))
			{
				str="为您快速发货";
			}
			if(str.contains("在吗"))
			{
				str="在的，亲";
			}
//			//方式1
//			if(str.contains("退出"))
//			{
//				break;
//			}
			System.out.println(str);
			str=scanner.next();
		}
	}
}
