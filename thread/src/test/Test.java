package test;

public class Test {

    private static int x = 100;
    public static void main(String args[ ]){
        String str = "祝你考出好成绩！";
        System.out.println(str.length());
        char s = '\u0639';
        Test hs1 = new Test();
        hs1.x++;
        Test hs2 = new Test();
        hs2.x++;
        hs1=new Test();
        hs1.x++;
        Test.x--;
        System.out.println( "x=" +x);
    }
//    public static int aMethod(int i) throws Exception {
//        try {
//            return i / 10;
//        } catch (Exception ex) {
//            throw new Exception("exception in a Method");
//        } finally {
//            System.out.printf("finally");
//        }
//    }
//
//    public static void main(String[] args) {
//        String a = "hello";
//        try {
//            aMethod(0);
//        } catch (Exception ex) {
//            System.out.printf("exception in main");
//        }
//        System.out.printf("finished");
//    }
}




