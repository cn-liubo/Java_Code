package queue.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public boolean isValid(String s) {
        //1.准备好一个Character类型的栈
        Deque<Character> stack = new LinkedList<>();

        //2.遍历s的每一个字符
        char[] charArray = s.toCharArray();
        for(char c : charArray) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    //因为没有break，所以无论是哪个，都会执行
                    stack.push(c);
                    break;
                default: {
                    //一定是右括号
                    if(stack.isEmpty()) {
                        //右括号多了
                        return false;
                    }

                    //否则取出栈顶元素
                    char top = stack.pop();
                    //进行左右括号的比较
                    if(!compareBracket(top, c)) {
                        //左右括号不匹配
                        return false;
                    }
                }
            }
        }
        if(stack.isEmpty()) {
            return true;
        } else {
            //左括号多了
            return false;
        }
    }
    private boolean compareBracket(char left, char right) {
        if(left == '(' && right == ')') {
            return true;
        }
        if(left == '[' && left == ']') {
            return true;
        }
        if(left == '{' && right == '}') {
            return true;
        }
        //除了上面三种情况之外的所有情况，都是不匹配
        return false;
    }
}
