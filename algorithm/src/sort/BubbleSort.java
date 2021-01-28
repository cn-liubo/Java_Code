package sort;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    /*
    冒泡排序
        时间复杂度：
        最好：O(n)     有序
        最坏：O(n^2)   逆序
        平均：O(n^2)
        空间复杂度：O(1)
        稳定性：稳定
     */
    public static void bubbleSort(long[] array) {
        //需要多少次冒泡过程
        for (int i = 0; i < array.length - 1; i++) {
            //无序：[0, array.length - i)
            //有序：[array.length - i, array.length]
            //进行冒泡过程
            for(int j = 0; j < array.length - i - 1; j++) {
                if(array[j] > array[j + 1]) {//若 > 改为 >= ，则不稳定了
                    long t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                }
            }
        }
    }

    //优化之后
    public static void bubbleSort1(long[] array) {
        //需要多少次冒泡过程
        for (int i = 0; i < array.length - 1; i++) {
            //无序：[0, array.length - i)
            //有序：[array.length - i, array.length]

            //每次冒泡之前，假设数组已经有序
            boolean isSorted = true;

            //进行冒泡过程
            for(int j = 0; j < array.length - i - 1; j++) {
                if(array[j] > array[j + 1]) {
                    long t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;

                    isSorted = false;
                }
            }
            if(isSorted) {
                break;
            }
        }
    }

    public static long[] build1() {
        Random random = new Random(20210127);
        long[] array = new long[20];
        for(int i = 0; i < 20; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    public static void main(String[] args) {
        long[] a1 = build1();
        System.out.println(Arrays.toString(a1));
        bubbleSort(a1);
        System.out.println(Arrays.toString(a1));
    }
}
