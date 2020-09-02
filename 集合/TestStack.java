package 集合;

import java.util.Stack;

public class TestStack {

    public static void main(String[] args) {

        Stack<String> stack = new Stack<String>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        System.out.println(stack);//[a, b, c]
        System.out.println(stack.peek());//c
        System.out.println(stack);
        System.out.println(stack.search("b"));//2  不是索引，是第几个
    }
}
