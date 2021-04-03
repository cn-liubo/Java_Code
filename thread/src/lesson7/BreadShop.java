package lesson7;

public class BreadShop {

    public static int COUNT;

    public static class Consumer implements Runnable {
        private String name;

        public Consumer(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                while(true) {
                    synchronized (BreadShop.class) {
                        if(COUNT == 0) {
                            BreadShop.class.wait();
                        } else {
                            System.out.printf("消费者 %s消费了1个产品\n", name);
                            COUNT--;
                            BreadShop.class.notifyAll();
                            Thread.sleep(500);
                        }
                    }
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Producer implements Runnable {
        private String name;

        public Producer(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                while(true) {
                    synchronized (BreadShop.class) {
                        if(COUNT + 3 > 100) {
                            BreadShop.class.wait();
                        } else {
                            System.out.printf("生产者 %s 生产了3个产品\n", name);
                            COUNT += 3;
                            BreadShop.class.notifyAll();
                            Thread.sleep(500);
                        }
                    }
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread[] consumers = new Thread[20];
        for (int i = 0; i < 20; i++) {
            consumers[i] = new Thread(new Consumer(String.valueOf(i)));
        }
        Thread[] producers = new Thread[20];
        for (int i = 0; i < 20; i++) {
            producers[i] = new Thread(new Producer(String.valueOf(i)));
        }

        for (int i = 0; i < 20; i++) {
            consumers[i].start();
        }
        for (int i = 0; i < 20; i++) {
            producers[i].start();
        }
    }
}
