package lesson4;

public class SynchronizedTest2 {

    private static int COUNT;

    public synchronized static void decrement() {
        COUNT--;
    }

    //对当前类对象进行加锁，线程间同步互斥
    public synchronized static void increment() {
        COUNT++;
        decrement();
    }

    //使用不同的对象加锁，没有同步互斥的作用：并发和并行
//    public  static void increment() {
//        synchronized (new SynchronizedTest2()) {
//            COUNT++;
//        }
//    }

    //对this对象加锁
//    public synchronized void increment() {
//        COUNT++;
//    }

    public static void main(String[] args) throws InterruptedException {
        Class clazz = SynchronizedTest2.class;
        SynchronizedTest2 st = new SynchronizedTest2();

        //尽量同时启动，不让new Thread耗时影响
        Thread[] threads = new Thread[20];
        for(int i = 0; i < 19; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j = 0; j < 1000; j++) {
//                        synchronized (clazz) {
//                            COUNT++;
//                        }
                        increment();//静态同步方法调用
//                        st.increment();//实例同步方法调用
//                        synchronized (st) {
//                            COUNT++;
//                        }
                    }
                }
            });
        }

        for (int i = 0; i < 1; i++) {
            threads[19 + i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        increment();//静态同步方法调用
//                        st.increment();
//                        synchronized (st) {
//                            COUNT++;
//                        }
                    }
                }
            });
        }

        for(Thread thread : threads) {
            if(thread != null) {
                thread.start();
            }
        }

        //让main线程阻塞等待所有的20个子线程执行完毕
        for(Thread thread : threads) {
            if(thread != null) {
                thread.join();
            }
        }

        System.out.println(COUNT);
    }
}
