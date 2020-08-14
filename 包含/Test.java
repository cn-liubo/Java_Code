package 包含;

public class Test {
    //聚合关系
    public static void main(String[] args){
        Car car = new Car("宝马","Z4","宝石蓝",new Wheel("米其林",400,"酷黑"));

//        car.brand = "宝马";
//        car.type = "Z4";
//        car.color = "宝石蓝色";
//        car.wheel = new Wheel();
//        car.wheel.brand = "米其林";
//        car.wheel.size = 400;
//        car.wheel.color = "酷黑";
        car.showCar();//展示汽车
    }
}
