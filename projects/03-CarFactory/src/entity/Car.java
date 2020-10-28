package entity;

import service.Engine;

public class Car {
    private Engine engine;

    public Car() {
    }

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void run(){
        engine.run();
    }
}
