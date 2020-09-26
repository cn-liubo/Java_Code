package 练习.stack;

public class Test {

    public static void main(String[] args) {
        MyStack ms = new MyStack(10);
        ms.push(new Object());
        ms.push(new Object());
        ms.push(new Object());
        ms.push(new Object());
        ms.push(new Object());
        ms.print();

        ms.pop();
        ms.print();

//        ms.push(1);
//        ms.push(2);
//        ms.push(3);
//        ms.push(4);
//        ms.push(5);
//        ms.print();
//
//        ms.pop();
//        ms.print();
    }
}
