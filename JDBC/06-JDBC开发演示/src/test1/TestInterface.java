package test1;

public interface TestInterface {
    String name = "";
    void run();
    void setName();

    default int walk(){

        return 0;
    }

}
