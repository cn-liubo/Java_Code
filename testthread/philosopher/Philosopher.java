package testthread.philosopher;

public class Philosopher extends Thread{

    private String name;
    private Chopstick left;
    private Chopstick right;
    private long time;

    public Philosopher(String name, Chopstick left, Chopstick right, long time){
        this.name = name;
        this.left = left;
        this.right = right;
        this.time = time;
    }

    public void run(){

        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (left) {
            System.out.println(this.name + "拿起了左手边的" + this.left.getNum() + "筷子");
            synchronized (right){
                System.out.println(this.name + "拿起了右手边的" + this.right.getNum() + "筷子");
                System.out.println(this.name + "开始狼吞虎咽的吃起来");
            }
        }

    }
}
