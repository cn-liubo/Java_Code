package 练习;

public class Demo1 {
    //交换两个数组a{1,2,3,4},b{5,6,7,8}

    //设计一个方法 用来交换两个数组的元素
    //方法本身是否需要参数及返回值
    public int[][] changeTwoArray(int[] a,int[] b){

        //方式一 将两个数组内的元素对应位置交换
//        for(int i = 0; i < a.length; i++){
//            int x = a[i];
//            a[i] = b[i];
//            b[i] = x;
//        }
        //方式一的设计问题在于
        //用循环的方式挨个交换数组内的元素 性能较慢
        //交换数组的时候需要保证两个数组的长度一致

        //方式二 将两个数组的地址引用直接互换
        int[] temp = a;
        a = b;
        b = temp;
        int[][] result = {a, b};
        return result;

    }

    public static void main(String[] args){
        //创建一个对象
        Demo1 d = new Demo1();
        //创建两个数组
        int[] x = {1,2,3,4};
        int[] y = {5,6,7,8};
        //调用demo中的changeTwoArray方法
        int[][] value = d.changeTwoArray(x,y);
        x = value[0];
        y = value[1];
        for(int v:x){
            System.out.println(v);
        }
        System.out.println("--------------");
        for(int v:y){
            System.out.println(v);
        }
    }
}
