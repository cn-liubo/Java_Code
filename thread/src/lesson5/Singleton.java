package lesson5;

class Singleton {
    private static volatile Singleton INSTANCE = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                if(INSTANCE == null)
                    INSTANCE = new Singleton();//非原子性的new操作
            }
        }
        return INSTANCE;
    }

}
