package com.liu;

import com.liu.queue.PriorityQueue;
import org.junit.Test;

public class Main {
    @Test
    public void test1() {
        PriorityQueue<Person> queue = new PriorityQueue<>();
        queue.enQueue(new Person("Jack", 2));
        queue.enQueue(new Person("Rose", 10));
        queue.enQueue(new Person("Jack", 5));
        queue.enQueue(new Person("James", 15));

        while(!queue.isEmpty()) {
            System.out.println(queue.deQueue());
        }
    }

    @Test
    public void test2() {
        int[] arr = {2,1,8,3,5,4,6,7};
        for(int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = 0;
            for(j = i - 1; j >= 0; j--) {
                if(arr[j] > key) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
        }

//        for(int i = 0; i < arr.length - 1; i++) {
//            boolean flag = true;
//            for(int j = 0;j < arr.length - 1 - i; j++) {
//                if(arr[j] > arr[j + 1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                    flag = false;
//                }
//            }
//            if(flag) break;
//        }

        for(int n : arr) {
            System.out.print(n + " ");
        }
    }
}
