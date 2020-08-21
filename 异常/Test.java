package 异常;

public class Test {

    //设计一个方法 来测试自定义异常
    public void testMyException() throws MyException{
        System.out.println("测试自定义方法的异常执行啦");
        if(3>2){//  若满足某个条件
            throw new MyException("说明一下异常的具体问题");
        }
    }
    public static void main(String[] args){
        //System.out.println(10/0);
        Test t = new Test();
        try {
            t.testMyException();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
