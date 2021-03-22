package lesson1;

/**
 * 对Java进程来说，至少有一个非守护线程还没有终止，进程就不会结束
 * 假如剩下的都是守护线程，那这个进程已经完了
 */
public class ThreadLook2 {

    //守护线程：不是守护线程的，只要有一个非守护线程还没有结束掉，那么整个进程也结束不了
    //一个Java进程至少要有一个非守护线程存在，整个进程才不会结束
    public static void main(String[] args) {
        //第一种创建线程的方式：使用Thread类，重写run()
        Thread t = new Thread("main中的子线程"){
            @Override
            public void run() {
                while (true) {

                }
            }
        };
//        t.setDaemon(true);//设置守护线程
        //线程要启动，必须启动start()——告诉系统调度本线程
        t.start();
        System.out.println(t.getId());//不是进程的PID，这里叫线程；ID是JVM虚拟机提供的管理线程的标识
        System.out.println(t.getName());
        System.out.println(t.getPriority());
        System.out.println(t.getState());
        System.out.println(t.isAlive());
        System.out.println(t.isDaemon());
        System.out.println(t.isInterrupted());
    }
}
