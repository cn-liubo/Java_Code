package lesson8;

public class SequencePrintPlus {

    //有三个线程，每个线程只能打印A或B或C
    //要求：同时执行三个线程，按ABC顺序打印，一次打印10次，abc换行abc换行abc
    //考察的知识点：代码设计，多线程通信
    public static void main(String[] args) {
        class T {

        }
        Thread a = new Thread(new Task("A"));
        Thread b = new Thread(new Task("B"));
        Thread c = new Thread(new Task("C"));
        c.start();
        b.start();
        a.start();
    }

    private static class Task implements Runnable {

        private String content;
        private static String[] ARR = {"A", "B", "C"};
        private static int INDEX;

        public Task(String content) {
            this.content = content;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    synchronized (ARR) {
                        while(!content.equals(ARR[INDEX])) {
                            ARR.wait();
                        }
                        System.out.print(content);
                        if(INDEX == ARR.length - 1) {
                            System.out.println();
                        }
                        INDEX = (INDEX + 1) % ARR.length;
                        ARR.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
