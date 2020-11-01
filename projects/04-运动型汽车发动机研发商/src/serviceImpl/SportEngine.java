package serviceImpl;

import service.Engine;

public class SportEngine implements Engine {

    @Override
    public void run() {
        System.out.println("0-100加速时间只需4秒");
    }

}
