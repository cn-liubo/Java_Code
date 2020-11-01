package serviceImpl;

import service.Engine;

public class SuvEngine implements Engine {
    @Override
    public void run() {
        System.out.println("高扭矩，大输出");
    }
}
