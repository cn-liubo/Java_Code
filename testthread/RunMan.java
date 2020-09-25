package testthread;

public class RunMan extends Thread{

    private String name;

    public RunMan(){

    }
    public RunMan(String name){
        this.name = name;
    }


    //重写run方法
    public void run(){
        for(int i = 1; i <= 100; i++){
            System.out.println(this.name+"跑到第"+i+"米啦");
        }
    }


}
