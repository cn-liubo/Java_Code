package queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    /*
    add <=> offer
    element <=> peek
    remove <=> poll
    异常      null
     */
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        /*
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");
        queue.offer("D");

        System.out.println(queue.peek());//A
        System.out.println(queue.peek());//A
        System.out.println(queue.poll());//A
        System.out.println(queue.peek());//B
        */

        queue.add("A");
        queue.add("B");
        queue.add("C");
        queue.add("D");

        System.out.println(queue.element());//A
        System.out.println(queue.element());//A
        System.out.println(queue.remove());//B
        System.out.println(queue.remove());//B
        System.out.println(queue);//C,D
    }
}
