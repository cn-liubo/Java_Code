package test;

public abstract class Main {
    public static void main(String[] args) {
        A a = new B();
        a.a();
        a.b();
        ((B)a).d();
    }
}
class A {
    public void a() {
        System.out.println("a");
    }
    public void b() {
        System.out.println("b");
    }
}
class B extends A {
    public void a() {
        System.out.println("b.a");
    }
    public void c() {
        System.out.println("c");
    }
    public void d() {
        System.out.println("d");
    }
}