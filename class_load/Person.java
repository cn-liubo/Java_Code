package class_load;

public class Person extends Animal{
	public String test="PersonField";
	public static String testStatic="PersonStaticField";
	
	public Person() {
		//super();//默认调用父类无参数的构造方法
		System.out.println("我是Person中默认无参数的构造方法");
	}
	
	
	{
		this.testPerson();
		System.out.println("我是Person中的普通代码块"+test);
	}
	static{
		Person.testStatic();
		System.out.println("我是Person中的静态代码块"+testStatic);
	}
	
	
	public void testPerson() {
		System.out.println("我是Person类中的普通方法");
	}
	public static void testStatic() {
		System.out.println("我是Person中的静态方法");
	}
}
