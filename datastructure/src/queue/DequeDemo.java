package queue;

import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();

        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(4);
        deque.add(5);
        deque.add(6);

        //1 2 3 4 5 6
        System.out.println(deque.removeLast());//6
        System.out.println(deque.removeLast());//5
        System.out.println(deque.removeFirst());//1
        System.out.println(deque);//2 3 4


/*      deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addFirst(4);
        deque.addLast(5);
        deque.addLast(6);
        deque.addLast(7);

        //4 3 2 1 5 6 7
        while(!deque.isEmpty()) {
            if(!deque.isEmpty()) {
                System.out.println(deque.getFirst());
            }
            if(!deque.isEmpty()) {
                System.out.println(deque.removeFirst());
            }
            if(!deque.isEmpty()) {
                System.out.println(deque.getLast());
            }
            if(!deque.isEmpty()) {
                System.out.println(deque.removeLast());
            }
        }
        /*
        4 4 7 7 3 3 6 6 2 2 5 5 1 1
         /*
*/
    }
}
