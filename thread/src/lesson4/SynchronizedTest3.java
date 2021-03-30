package lesson4;

public class SynchronizedTest3 {

    /**
     * 有一个教室，座位有50个，同时有三个老师安排同学的座位，每个老师安排100个同学到这个教室。模拟使用多线程实现：
     * 座位编号1-50、0=49，三个线程同时启动来安排同学
     * 同学可以循环操作来安排，知道座位安排满
     */

    public static int COUNT = 50;

    public static void main(String[] args) {

        Thread[] threads = new Thread[3];
        for(int i = 0; i < 3; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(COUNT > 0) {
                        synchronized (SynchronizedTest3.class) {
                            System.out.println(Thread.currentThread().getName() + "安排学生坐在" + COUNT +"号位置");
                            COUNT--;
                        }
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }, "老师" + i);
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }
}
