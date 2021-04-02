package lesson6;

public class SignalTest {

    public static void main(String[] args) throws InterruptedException {
        //竞争class对象锁
        synchronized (SignalTest.class) {
            //当前线程释放对象锁
//            SignalTest.class.wait();
            //通过调用同一个对象的wait()阻塞的线程（唤醒）。唤醒后竞争对象锁
            SignalTest.class.notify();
        }//释放对象锁
    }
}
