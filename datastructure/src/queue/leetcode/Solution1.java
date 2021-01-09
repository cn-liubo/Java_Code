package queue.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
public class Solution1 {
    //优先考虑代码正确，其次在考虑效率问题（尤其是时间复杂度）
    private List<Integer> arrayToList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }
    public boolean IsPopOrder(int [] pushed,int [] popped) {

        List<Integer> pushList = arrayToList(pushed);
        List<Integer> popList = arrayToList(popped);
        Stack<Integer> stack = new Stack<>();

        //数组不能通过length判断，通过几个下标判断
        //所以建议使用List
        //while（只要popped还没有空）
        while(!popList.isEmpty()) {
            //取出第一个元素
            Integer p = popList.remove(0);

            while(stack.isEmpty() || !stack.peek().equals(p)) {
                if(pushList.isEmpty()) {
                    return false;
                }

                //取出的第一个元素
                Integer q = pushList.remove(0);
                //压入栈中
                stack.push(q);
            }
            //弹出栈顶元素
            stack.pop();
        }
        return true;
    }

    public boolean IsPopOrder2(int [] pushed,int [] popped) {

        List<Integer> pushList = arrayToList(pushed);
        List<Integer> popList = arrayToList(popped);
        Stack<Integer> stack = new Stack<>();

        //数组不能通过length判断，通过几个下标判断
        //所以建议使用List
        //while（只要popped还没有空）
        while(!popList.isEmpty()) {
            //取出第一个元素
            Integer p = popList.remove(0);

            while(stack.isEmpty() || !stack.peek().equals(p)) {//stack.peek().intValue() != p
                if(pushList.isEmpty()) {
                    return false;
                }

                //取出的第一个元素
                Integer q = pushList.remove(0);
                //压入栈中
                stack.push(q);
            }
            //弹出栈顶元素
            stack.pop();
        }
        return true;
    }
}
