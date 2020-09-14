package liubo;

import java.util.Scanner;

public class project6 {
	public static void main(String[] args)
	{
		int choice;
		Scanner scanner=new Scanner(System.in);
		do {
			System.out.println("Help on:");
			System.out.println("1.if");
			System.out.println("2.switch");
			System.out.println("3.while");
			System.out.println("4.do-while");
			System.out.println("5.for");
			System.out.println("chose one:");
			choice=scanner.nextInt();
		}while(choice<'1'&&choice>'5');
		System.out.println("\n");
		switch(choice) {
		case 1:
			System.out.println("The if:\n");
			System.out.println("if(condition)statement;");
			System.out.println("else statement;");
			break;
		case 2:
			System.out.println("The switch:\n");
			System.out.println("switch(expression){");
			System.out.println("case constant");
			System.out.println("statement sequebce");
			System.out.println("break;");
			System.out.println("//...");
			System.out.println("}");
			break;
		case 3:
			System.out.println("The while:\n");
			System.out.println("while(condition) statement");
			break;
		case 4:
			System.out.println("The do-while:");
			System.out.println("do{");
			System.out.println("statement:");
			System.out.println("}while(condition)£ª");
			break;
		case 5:
			System.out.println("The for:\n");
			System.out.println("for(init: condition; iteration)");
			System.out.println("statement;");
			break;
			/*
		default:
			System.out.println(" ‰»Î”–ŒÛ!");
			*/
		}
	}
}
