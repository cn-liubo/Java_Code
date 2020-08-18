package velometer;

public class Test {
    public static void main(String[] args) {
        Car car = new Car(22);//20  22  28
        Velometer v = new Velometer(5);
        v.measureCar(car);

    }
}
