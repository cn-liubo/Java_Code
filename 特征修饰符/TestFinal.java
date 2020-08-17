package 特征修饰符;

public class TestFinal {

    private final String name = "";
    public void testNum(final int a){

    }
    public static void main(String[] args){
        TestFinal tf = new TestFinal();
        tf.testNum(1);
        tf.testNum(10);

//        final int a = 1;
//        a = 10;

//        final int a;//声明变量   在栈内存开辟空间
//        a = 1;//赋值     在常量区取得一个常量   复制一份存入a空间
//        a = 10;//改变变量的值

//        final int[] x = new int[]{1,2,3};
//        x = new int[5];
//        x[0] = 10;
//        x[0] = 100;
    }
}

