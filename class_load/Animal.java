package class_load;

public class Animal {
	public String test="AnimalField";
	public static String testStatic="AnimalStaticField";
	
	public Animal() {
		System.out.println("����Animal��Ĭ���޲����Ĺ��췽��");
	}
	
	
	
	{
		this.test();
		System.out.println("����Animal�е���ͨ�����"+test);
	}
	static{
		Animal.testStatic();
		System.out.println("����Animal�еľ�̬�����"+testStatic);
	}
	
	
	public void test() {
		System.out.println("����Animal���е���ͨ����");
	}
	public static void testStatic() {
		System.out.println("����Animal�еľ�̬����");
	}
}
