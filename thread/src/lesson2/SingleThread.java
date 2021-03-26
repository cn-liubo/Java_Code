package lesson2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 多线程的使用场景？优点？特性？
 * 1.并发并行的执行，来提高性能，效率 ——考虑什么因素会影响多线程的效率？根据哪些因素设计多线程的数量？
 * 2.阻塞代码，让后续代码能够执行，不受阻塞代码的影响
 */
public class SingleThread {

    public static void main(String[] args) {
        //第一种情况：耗时多的任务
        calculate(new ArrayList<>());
        calculate(new ArrayList<>());
        //第二种情况：阻塞任务
        Scanner scanner = new Scanner(System.in);
        print(scanner);
        print(scanner);


    }
    public static int calculate(List<Integer> list) {
        //计算量非常大，假如要执行一次，耗时5s
        return 0;
    }
    public static void print(Scanner scanner) {
        System.out.println(scanner.nextLine());
    }
}
