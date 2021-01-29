package sort;

import java.util.Arrays;
import java.util.Random;

public class HeapSort {
    /*
    堆排序
        时间复杂度：
        最好，最坏，平均：O(n*log(n))
        空间复杂度：O(1)
        稳定性：不稳定
     */
    public static void heapSort(long[] array) {
        //1.建大堆
        createHeap(array, array.length);

        //2.进行选择的过程，一共需要array.length - 1组
        for (int i = 0; i < array.length; i++) {
            //无序：[0, array.length - 1)
            long t = array[0];
            array[0] = array[array.length - 1 - i];
            array[array.length - 1 - i] = t;
            //无序：[0, array.length - 1 - i)
            shiftDown(array, array.length - 1 - i, 0);
        }
    }
    //大堆
    public static void shiftDown(long[] array, int size, int index) {
        while (2 * index + 1 < size) {
            //进入循环，说明不是叶子结点
            int maxIndex = 2 * index + 1;
            if(maxIndex + 1 < size && array[maxIndex + 1] > array[maxIndex]) {
                //最大的孩子是右孩子
                maxIndex++;
            }

            if(array[index] >= array[maxIndex]) {
                return;
            }

            long t = array[index];
            array[index] = array[maxIndex];
            array[maxIndex] = t;

            index = maxIndex;
        }
    }
    public static void createHeap(long[] array, int size) {
        for (int i = (size - 2) / 2; i >= 0; i--) {//i的初值是最后一个非叶子结点
            shiftDown(array, size, i);
        }
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
        heapSort(a1);
        System.out.println(Arrays.toString(a1));
    }
}
