package class_load;

public class Person extends Animal{
	public String test="PersonField";
	public static String testStatic="PersonStaticField";
	
	public Person() {
		//super();//Ĭ�ϵ��ø����޲����Ĺ��췽��
		System.out.println("����Person��Ĭ���޲����Ĺ��췽��");
	}
	
	
	{
		this.testPerson();
		System.out.println("����Person�е���ͨ�����"+test);
	}
	static{
		Person.testStatic();
		System.out.println("����Person�еľ�̬�����"+testStatic);
	}
	
	
	public void testPerson() {
		System.out.println("����Person���е���ͨ����");
	}
	public static void testStatic() {
		System.out.println("����Person�еľ�̬����");
	}
}
