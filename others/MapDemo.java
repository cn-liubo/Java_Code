package liubo;

import java.util.*;

public class MapDemo {
	class student
	{
		String name;
		String id;
		student(String name,String id)
		{
			this.name=name;
			this.id=id;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map map=new HashMap();
//		map.put("1","wangjing");
//		map.put("2","liubo");
//		map.put("3","lvling");
		student s1=new student("BJH","18060207101");
		student s2=new student("OJH","18060207102");
		student s3=new student("YJH","18060207103");
		student s4=new student("BH","18060207104");
		
		map.put(1, s1);
		map.put(2, s2);
		map.put(3, s3);
		map.put(4, s4);
		
		for(Object key:map.keySet())
				{
					System.out.println(key+"->"+map.get(key));
				}
	}
}
