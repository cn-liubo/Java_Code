package velometer;

public class PoliceCar {

    //属性-警车自己的速度
    private int speed;

    //构造方法
    public PoliceCar(){

    }
    public PoliceCar(int speed){
        this.speed = speed;
    }

    //警车追击小汽车 依赖关系
    public void chase(Car car){
        //获取小汽车的速度
        int carSpeed = car.getSpeed();
        //比较两车的速度
        if(this.speed > carSpeed){//可以追到
            System.out.println("警车开始追击");
            int time = 100/(this.speed - carSpeed);
            try {
                Thread.sleep(3000);//编译时异常
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("小样，经过"+time+"秒追到了");
        }else{//追不到
            System.out.println("小汽车飞的太快了，追不到！");
        }
    }
}
