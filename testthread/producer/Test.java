package testthread.producer;

public class Test {
    public static void main(String[] args) {
        Warehouse house = new Warehouse();//里面有一个ArrayList线程非安全
        Producer p = new Producer(house);
        //设置线程的优先级别1-10
        p.setPriority(10);
        Comsumer c1 = new Comsumer(house);
        Comsumer c2 = new Comsumer(house);

        p.start();
        c1.start();
        c2.start();
    }
}
