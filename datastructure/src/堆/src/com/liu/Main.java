package com.liu;

import com.liu.heap.BinaryHeap;
import com.liu.printer.BinaryTrees;
import org.junit.Test;

import java.util.Comparator;

public class Main {
    @Test
    public void test1() {
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        heap.add(68);
        heap.add(72);
        heap.add(43);
        heap.add(50);
        heap.add(38);
        heap.add(10);
        heap.add(90);
        heap.add(65);
        BinaryTrees.println(heap);

//        com.liu.heap.remove();
//        BinaryTrees.println(com.liu.heap);

        System.out.println(heap.replace(70));
        BinaryTrees.println(heap);
    }

    @Test
    public void test2() {
        Integer[] data = {88, 44, 53, 41, 16, 6, 70, 18, 85, 98, 81, 23, 36, 43, 37};
        BinaryHeap<Integer> heap = new BinaryHeap<>(data);

        BinaryTrees.println(heap);
    }

    @Test
    public void test3() {
        Integer[] data = {88, 44, 53, 41, 16, 6, 70, 18, 85, 98, 81, 23, 36, 43, 37};
        BinaryHeap<Integer> heap = new BinaryHeap<>(data, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        BinaryTrees.println(heap);
    }

    @Test
    public void test4() {
        Integer[] data = {51, 30, 39, 92, 74, 25, 16, 93,
                91, 19, 54, 47, 73, 62, 76, 63, 35, 18,
                90, 6, 65, 49, 3, 26, 61, 21, 48};
//        BinaryHeap<Integer> com.liu.heap = new BinaryHeap<>((o1, o2) -> o2 - o1);
        BinaryHeap<Integer> heap = new BinaryHeap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int k = 5;
        for(int i = 0; i < data.length; i++) {
            if(heap.size() < k) {//前k个数添加到小根堆
               heap.add(data[i]);
            } else if(data[i] > heap.get()) {//如果是第k+1个数，并且大于堆顶元素
                heap.replace(data[i]);
            }
        }

        BinaryTrees.println(heap);
    }
}
