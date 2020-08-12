package 练习;

import java.util.Scanner;

public class Calculator {

    //设计一个方法    加法运算    是否提供条件？ 两个元素      是否需要结果？  计算结果
    public float add(float a,float b){
        return a+b;
    }
    //设计一个方法    减法运算
    public float substact(float a,float b){
        return a-b;
    }
    //设计一个方法    乘法运算
    public float multiply(float a,float b){
        return  a*b;
    }
    //设计一个方法    除法运算
    public float divide(float a,float b){
        return a/b;
    }


    //设计一个方法  控制计算器计算的流程
    public void calculate(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入第一个数字：");
        String one = input.nextLine();
        float a = Float.parseFloat(one);//可能会产生NumberFormatException
        //需要一个死循环    while(){}     for(;;){}
        over:while(true) {
            System.out.println("请输入符号：");
            String symbol = input.nextLine();//注意nextLine();
            if(symbol.equals("=")){
                System.out.println("运行完毕！");
                break;
            }
            if(!(symbol.equals("+"))||(symbol.equals("-"))||(symbol.equals("*"))||(symbol.equals("/"))){
                System.out.println("输入的符号有误！");
                continue;
            }
            System.out.println("请输入第二个数字：");
            String two = input.nextLine();
            //    String--->float      Float

            float b = Float.parseFloat(two);
            switch (symbol) {
                case "+":
                    a = this.add(a, b);//第一次运行的结果应该存起来 当做第二次开始的a数字
                    break;
                case "-":
                    a = this.substact(a, b);
                    break;
                case "*":
                    a = this.multiply(a, b);
                    break;
                case "/":
                    a = this.divide(a, b);
                    break;
//                case "=":
//                    System.out.println("运行完毕!");
//                    break over;//循环标记     有一点瑕疵
            }
            System.out.println(a);
        }
    }
    public static void main(String[] args){
        Calculator c = new Calculator();
        c.calculate();
    }
}
