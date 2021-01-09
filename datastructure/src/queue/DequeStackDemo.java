package queue;

import java.util.Deque;
import java.util.LinkedList;

public class DequeStackDemo {
    public static void main(String[] args) {
        Deque<Integer> stack = new LinkedList<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        /*
        4 3 2 1
         */
    }
}
