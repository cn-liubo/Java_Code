package queue.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class MyQueue {

    private Deque<Integer> stack1;//准备出栈
    private Deque<Integer> stack2;//准备入栈

    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack2.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack1.isEmpty()) {
            while(!stack2.isEmpty()) {
                Integer e = stack2.pop();
                stack1.push(e);
            }
        }

        return stack1.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(stack1.isEmpty()) {
            while(!stack2.isEmpty()) {
                Integer e = stack2.pop();
                stack1.push(e);
            }
        }

        return stack1.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
