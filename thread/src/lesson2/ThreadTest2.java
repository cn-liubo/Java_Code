package lesson2;

public class ThreadTest2 {

    public static void main(String[] args) {
//        //main主线程和子线程同时执行
//        for(int i = 0; i < 20; i++) {
//            final int n = i;
//            //new Thread操作，稍微有点耗时
//            Thread t = new Thread(new Runnable(){
//                @Override
//                public void run() {//内部类使用外部的变量，必须是final修饰
//                    System.out.println(n);
//                }
//            });
//            t.start();
//        }
//        System.out.println("Ok");


        Thread[] threads = new Thread[20];
        for(int i = 0; i < 20; i++) {
            final int n = i;
            //new Thread操作，稍微有点耗时
            threads[i] = new Thread(new Runnable(){
                @Override
                public void run() {//内部类使用外部的变量，必须是final修饰
                    System.out.println(n);
                }
            });
        }
        for(Thread t : threads) {
            t.start();
        }

        System.out.println("Ok");
    }
}
