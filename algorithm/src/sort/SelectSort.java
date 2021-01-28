package sort;

import java.util.Arrays;
import java.util.Random;

public class SelectSort {
    /*
    选择排序
        时间复杂度：
        最好：O(n^2)   有序
        最坏：O(n^2)   逆序
        平均：O(n^2)
        空间复杂度：O(1)
        稳定性：不稳定
     */
    public static void selectSort(long[] array) {
        //需要多少次选择的过程
        for(int i = 0; i < array.length - 1; i++) {
            //无序区间：[0, array.length - i)
            //有序区间：[array.length - i, array.length]
            int maxIndex = 0;
            for (int j = 1; j < array.length - i; j++) {
                if(array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }
            //期望maxIndex指向无序区间的最大的数的下标
            long t = array[array.length - 1 - i];
            array[array.length - 1 - i] = array[maxIndex];
            array[maxIndex] = t;
        }
    }
    //选择排序的变形，一次循环将最大和最小的排号
    public static void selectSort1(long[] array) {

    }

    public static long[] build1() {
        Random random = new Random(20210127);
        long[] array = new long[10];
        for(int i = 0; i < 10; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    public static void main(String[] args) {
        long[] a1 = build1();
        System.out.println(Arrays.toString(a1));
        selectSort(a1);
        System.out.println(Arrays.toString(a1));
    }
}
