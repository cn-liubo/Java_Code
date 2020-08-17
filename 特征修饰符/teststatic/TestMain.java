package 特征修饰符.teststatic;

import java.util.Scanner;

public class TestMain {
    public static void main(String[] args){
        BookStore bs = new BookStore();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入图书的金额");
        Float price = input.nextFloat();
        System.out.println("请输入您的身份");
        int identity = input.nextInt();
        bs.buyBook(price,identity);
    }
}
