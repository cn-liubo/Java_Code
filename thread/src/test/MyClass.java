package test;

public class MyClass {
    public synchronized void main () {
        System.out.println("main");
    }

    public static void main(String[] args) {
        MyClass m = new MyClass();
    }

}