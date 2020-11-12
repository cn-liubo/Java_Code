package test;

import entity.Car;
import service.Engine;
import serviceImpl.SportEngine;
import serviceImpl.SuvEngine;

public class TestMain {

    public static void main(String[] args) {

//        //用户需要具有越野特征的汽车
//        Engine engine = new SuvEngine();

        //用户需求变更，需要得到一辆具有运动特征的汽车
        Engine engine = new SportEngine();
        Car car = new Car(engine);
        car.run();
    }
}
