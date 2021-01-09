package queue.leetcode;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack1;//存放入栈的元素
    private Stack<Integer> stack2;//存放入栈中最小的元素
    /** initialize your data structure here. */
    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
        if(stack2.isEmpty()) {
            stack2.push(x);
        } else {
            int temp = stack2.peek();
            if(x < temp) {
                stack2.push(x);
            } else {
                stack2.push(temp);
            }
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}
