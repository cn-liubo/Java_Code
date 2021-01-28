package sort;

import java.util.Arrays;
import java.util.Random;

public class InsertSort {
    /*
    插入排序
        时间复杂度：
        最好：O(n)     有序
        最坏：O(n^2)   逆序
        平均：O(n^2)
        空间复杂度：O(1)
        稳定性：稳定
     */
    public static void insertSort(long[] array) {
        //数据一共有array.length个
        //所以，子操作需要执行多少次
        for (int i = 0; i < array.length - 1; i++) {
            //有序 [0, i]
            //无序 [i + 1 , array.length)
            //抓出来的数是[i + 1]

            long key = array[i + 1];

            //一次在有序区间进行比较 [i, 0]
            int j = 0;
            for(j = i; j >= 0; j--) {
                // [j] 就是需要和 key 进行比较的数
                if(key < array[j]) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = key;
        }
    }

    /*
        测试四种情况：
            1.随机生成的乱序数
            2.已经有序
            3.已经逆序
            4.完全相等
            5.测试不同规模的数据
     */
    public static long[] build1() {
        Random random = new Random(20210127);
        long[] array = new long[20];
        for(int i = 0; i < 20; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }
    public static long[] build2() {
        long[] array = build1();
        Arrays.sort(array);
        return array;
    }
    public static long[] build3() {
        long[] array = build2();
        for(int i = 0; i < array.length / 2; i++) {
            long t = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = t;
        }
        return array;
    }
    public static long[] build4() {
        long[] array = new long[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = 10;
        }
        return array;
    }
    public static void main(String[] args) {
        long[] a1 = build4();
        System.out.println(Arrays.toString(a1));
        insertSort(a1);
        System.out.println(Arrays.toString(a1));

    }
}
