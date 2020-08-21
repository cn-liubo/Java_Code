package 异常;

public class TestException {
    //设计一个方法
    public String testException() throws NullPointerException,StringIndexOutOfBoundsException{
        String str = null;
        try {
            str.length();
        }catch(Exception e){
            System.out.println("捕获了异常");
        }

//        try {
//            System.out.println("try开始执行");
//            String str = null;
//            //str.length();//NullPointerException
//            System.out.println("try执行完毕");
//            return "try中的返回值";//事先约定好 返回值
//        }catch (NullPointerException e) {
//            //e.printStackTrace();//打印输出异常的名字
//            System.out.println("捕获到了空指针异常");
//        }finally {
//            System.out.println("finally块执行啦");
//        }
        return "最终的返回结果";
    }

    public static void main(String[] args){
        TestException te = new TestException();
        try{
            te.testException();
        }catch(Exception e){
            System.out.println("捕获了异常");
        }


//        String result = new TestException().testException();
//        System.out.println(result);

//        System.out.println("程序最早开始执行");
//        try {
//            System.out.println("try开始");
//            //String str = null;
//            String str = "abc";
//            str.length();//NullPointerException
//            str.charAt(10);//StringIndexOutOfBoundsException
//            System.out.println("try完毕");
//        }catch (NullPointerException e){
//            System.out.println("捕获到了空指针异常");
//        }catch(StringIndexOutOfBoundsException e){
//            System.out.println("捕获到了字符串越界异常");
//        }
//        System.out.println("产生异常之后的所有程序");
    }
}

