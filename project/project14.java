package liubo;

import java.util.*;

public class project14 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		//���û��������⡰�𡱣�������������ظ�
		String str=scanner.next();
		
		while(str!="exit") {
			
			if(str.contains("����"))
			{
				str="��������˭";
			}
			if(str.contains("����"))
			{
				str="Ϊ�����ٷ���";
			}
			if(str.contains("����"))
			{
				str="�ڵģ���";
			}
//			//��ʽ1
//			if(str.contains("�˳�"))
//			{
//				break;
//			}
			System.out.println(str);
			str=scanner.next();
		}
	}
}
