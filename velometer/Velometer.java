package velometer;

public class Velometer {

    //属性-测速器规定好的标准时间
    private int standardTime;

    //构造方法
    public Velometer(){

    }
    public Velometer(int standardTime){
        this.standardTime = standardTime;
    }

    //测速器测量小汽车速度 依赖关系
    public void measureCar(Car car){
        //获取小汽车的速度
        int carSpeed = car.getSpeed();
        //计算小汽车运行时间
        int carTime = 100/carSpeed;
        //比较
        if(this.standardTime <= carTime){//小汽车时间长 跑得慢
            System.out.println("速度正常，请保持行驶");
        }else{//超速
            System.out.println("经过测量，小汽车超速了，警车可以追击");
            //需要警车对象 来做事追车
            //测速器发现小汽车超速 通知小汽车做事 (观察者设计模式)
            PoliceCar pc = new PoliceCar(25);
            pc.chase(car);
        }
    }
}
