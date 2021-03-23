package lesson1;

public class ThreadLook5 {

    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                //某个线程抛出异常，如果抛到run()方法，整个线程直接终止，但是不会影响其他线程
                //线程中，处理异常的方式：线程对象.setUncaughtExceptionHandler() 或者 自己在run()方法中捕获异常并处理
                for(int i = 0; i < 10000; i++) {
                    if(i == 20)
                        throw new RuntimeException();
                    System.out.println(i);
                }
            }
        };
        t.start();
        while(true) {

        }
    }
}
