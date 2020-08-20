package 练习;

import java.util.Scanner;

public class TestOne {

    public static boolean Queryextence(int one, int two, int three){
        switch (one){
            case 1:
                System.out.println();
                break;
            case 2:

                break;
            default:
                System.out.println(-1);

        }
        return true;
    }
    public static void main(String[] args){
        System.out.println("请输入数据：");
        Scanner sca = new Scanner(System.in);
        int n = sca.nextInt();
        int one = 0;
        int two = 0;
        int three = 0;
        for(int i = 1;i <= n;i++){
            one = sca.nextInt();
            two = sca.nextInt();
            three = sca.nextInt();
        }
        boolean result = Queryextence(one,two,three);
        System.out.println(result);
    }
}
