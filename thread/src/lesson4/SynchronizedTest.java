package lesson4;

public class SynchronizedTest {

    private static int COUNT;

    public static void increment() {
        COUNT++;
    }

    public static void main(String[] args) throws InterruptedException {
        Class clazz = SynchronizedTest.class;

        //尽量同时启动，不让new Thread耗时影响
        Thread[] threads = new Thread[20];
        for(int i = 0; i < 19; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j = 0; j < 1000; j++) {
                        synchronized (clazz) {
                            COUNT++;
                        }
                    }
                }
            });
        }



//        for(int i = 0; i < 1; i++) {
//            threads[19 + i] = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    for(int j = 0; j < 1000; j++) {
//                        COUNT++;
//                    }
//                }
//            });
//        }
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
