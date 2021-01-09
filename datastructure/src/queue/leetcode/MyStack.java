package queue.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = queue.size();
        for(int i = 0; i < size - 1; i++) {
            Integer e = queue.remove();
            queue.add(e);
        }

        return queue.remove();
    }

    /** Get the top element. */
    public int top() {
        int size = queue.size();
        for(int i = 0; i < size; i++) {
            Integer e = queue.remove();
            queue.add(e);
        }
        Integer temp = queue.remove();
        queue.add(temp);
        return temp;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
