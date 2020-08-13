package 属性和方法;

public class Test2 {
    public int changeNum(int x){//将void变为int类型的
        System.out.println("方法执行开始："+x);//1
        x = 10;
        System.out.println("方法执行最终："+x);//10
        return x;//返回值  将x临时的变量空间内的值（值或引用）返回出来
    }

    public void changeArray(int[] x){
        System.out.println("方法执行开始："+x[0]);//1
        x[0] = 10;
        System.out.println("方法执行最终："+x[0]);//10
    }
    //每一个类中不是必须包含主方法的
    //主方法不属于任何一个类，主方法主语虚拟机
    public static void main(String[] args){
        //创建一个对象--前提 有一个类模型
        //加载类模板的过程
        Test2 t = new Test2();//堆内存中开辟空间
        int a = 1;
        a = t.changeNum(1);//需要一个int的条件  int x = a;
        //调用方法  让方法执行一遍
        //1.方法存在哪里？ 堆内存的对象空间内
        //2.方法在哪里执行？  栈内存中开辟一块临时的方法执行空间
        System.out.println("方法执行完毕，main方法中a的值："+a);//1
        // 临时开辟的执行changeNum方法的空间就没了   a的值没有改变只是被用了

        System.out.println("++++++++++++++++++++++++++++++++++++++");
        //加载类模板的过程
        int[] b = new int[]{1,2,3};
        t.changeArray(b);
        //方法存在堆内存的对象空间里 方法执行在栈内存中的临时空间里
        //调用方法值将b的值传递给了x  int[] x = b; 传递过来的就是一个引用
        System.out.println("方法执行完毕，main方法中b数组的第一个值："+b[0]);//10

        /**形参和实参
         * 形参可以理解为是方法执行时的临时变量空间 x
         * 实参可以理解为是方法调用时传递进去的参数 a
         *方法调用时会将实参的内容传递给形参
         * 如果内容是基本类型  传递的是值           形参改变  实参不变
         * 如果内容是引用类型  传递的是引用(地址)   形参改变  实参跟着改变
         */
    }
}

