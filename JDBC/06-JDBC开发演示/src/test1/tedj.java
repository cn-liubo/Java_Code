package test1;

public class tedj {
    public static void main(String[] args) {
        dept d = new dept();
        try {
            d.test1();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            d.test2();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}
