package queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo1 {
    public static void main(String[] args) {
        //First In First Out FIFO
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);

//        System.out.println(queue.element());//1
//        System.out.println(queue.element());//1
//        System.out.println(queue.element());//1

        System.out.println(queue.remove());//1
        System.out.println(queue.remove());//2
        System.out.println(queue.remove());//3

        System.out.println(queue.remove());

    }
}
