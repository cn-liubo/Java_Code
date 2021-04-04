package threaddemo;

import java.util.concurrent.*;

/*
    使用实现Callable接口的方式，创建多线程

 */
public class TestCallable implements Callable<Boolean> {

    private String url;//网络图片地址
    private String name;//保存的文件名

    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception {
//        WEbDownloader wEbDownloader = new WebDownloader();
//        wEbDownloader.downloader(url, name);
        System.out.println("下载了文件名：" + name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String url = "";
        String name = "";
        TestCallable t1 = new TestCallable(url, name);
        TestCallable t2 = new TestCallable(url, name);
        TestCallable t3 = new TestCallable(url, name);

        //创建执行服务
        ExecutorService service = Executors.newFixedThreadPool(3);

        //提交执行
        Future<Boolean> r1 = service.submit(t1);
        Future<Boolean> r2 = service.submit(t2);
        Future<Boolean> r3 = service.submit(t3);

        //获取结果
        boolean b1 = r1.get();
        boolean b2 = r2.get();
        boolean b3 = r3.get();

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);

        //关闭服务
        service.shutdownNow();
    }
}
