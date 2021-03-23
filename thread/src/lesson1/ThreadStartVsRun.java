package lesson1;

public class ThreadStartVsRun {
    //只有主线程，子线程没了
    //这个线程没有启动，而是由main线程调用run()方法
    //start()表示在main方法里申请运行某一个线程，运行完不会操作阻塞，马上走，由系统决定执行run()中的代码
    //run()表示在main方法中调用run()的普通方法，直接执行run()方法中的代码
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                }
            }
        }).run();
        /**
         * main线程直接调用Thread对象的run方法，会直接在main线程运行Thread对象的run()-->传入的runnable对象的.run()
         * 结果：main线程直接运行 while(true)
         * 对比：通过start()调用的区别
         */
    }
}
