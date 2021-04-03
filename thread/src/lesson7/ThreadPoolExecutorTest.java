package lesson7;

import java.util.concurrent.*;

public class ThreadPoolExecutorTest {

    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                5, //核心线程数 ----> 正式员工
                10, //最大线程数 ----> 正式员工 + 临时工
                60,
                TimeUnit.SECONDS, //idle线程的空间时间 ----> 临时工最大存活时间，超过时间就解雇
                new LinkedBlockingQueue<>(), //阻塞队列 ----> 任务存放的地方（快递仓库）
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println(Thread.currentThread().getName() + "开始执行了");
                                //r对象是线程池内部封装过的工作任务类（Worker），会一直循环等待的方式从阻塞队列中取任务来执行
//                                r.run();
                            }
                        });
                    }
                }, //创建线程的工厂类：线程池创建线程时，调用该工厂的方法创建线程 ----> 招聘员工的标准
                new ThreadPoolExecutor.AbortPolicy()
                /*
                    拒绝策略：最大线程数且阻塞队列已满，采取的拒绝策略
                    1.AbortPolicy：直接抛RejectedExecutionException（不提供handle时的默认策略）
                    2.CallerRunsPolicy：谁（某个线程）交给我（线程池）任务，我拒绝执行，由谁自己执行
                    3.DiscardPolicy：交给我的任务，直接丢弃掉
                    4.DiscardOldestPolicy：丢弃阻塞队列中最旧的任务
                 */
        );//线程池创建以后，只要由任务就自动执行

//        for (int i = 0; i < 20; i++) {
//            final int j = i;
//            //线程池执行任务：execute、submit ----> 提交执行一个任务
//            pool.execute(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(j);
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//        }

        //线程池由4个快捷创建方式：（实际工作不使用，作为面试要了解）
        //阿里java开发手册，说明不能直接使用以下方式直接创建线程池
        //实际工作中使用ThreadPoolExecutor，构造参数自己指定
        ExecutorService pool2 = Executors.newSingleThreadExecutor();//创建单线程池
        ExecutorService pool3 = Executors.newCachedThreadPool();//缓存的线程池
        ExecutorService pool5 = Executors.newFixedThreadPool(4);//固定大小的线程池
        ScheduledExecutorService pool4 = Executors.newScheduledThreadPool(4);//计划任务线程池

//        pool4.schedule(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("hello");
//            }
//        }, 2, TimeUnit.SECONDS);
        pool4.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        }, 2, 1, TimeUnit.SECONDS);
    }
}
