package liubo;

class MySuperMath extends MyMath
{
	MySuperMath()
	{
		
	}
	double getSquare(double num)
	{
		return num*num;
	}
	int divide(int num1,int num2)
	{
		if(num2==0) {
			return 0;
		}
		else {
			return num1/num2;
		}
	}
}
public class MyMath {
	
	//default 
	MyMath()
	{
		
	}
	int add(int num1,int num2) 
	{
		return num1+num2;
	}
	double add(double num1,double num2)
	{
		return num1+num2;
	}
	int surtraction(int num1,int num2) 
	{
		return num1-num2;
	}int multipy(int num1,int num2) 
	{
		return num1*num2;
	}int divide(int num1,int num2) 
	{
		return num1/num2;
	}
	public static void main(String[] args) {
		MyMath math1=new MyMath();
		math1.add(10,20);
		System.out.println("10+20="+math1.add(10, 20));
	/*	MyMath math2=new MyMath();
		math2.surtraction(10,20);
		System.out.println("10*20="+Math.surtraction(10, 20));
		*/
		MySuperMath math2=new MySuperMath();
		System.out.println("10*10="+math2.getSquare(10.0));	
		System.out.println("10/0="+math2.divide(10,0));	
	}
}
