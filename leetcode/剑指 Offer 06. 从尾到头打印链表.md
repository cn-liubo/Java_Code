```java

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 import java.util.Stack;

class Solution {
    public int[] reversePrint(ListNode head) {
        ListNode cur = head;
        Stack<ListNode> stack = new Stack<>();
        while(cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        int[] arr = new int[stack.size()];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop().val;
        }
        return arr;
    }
}
​```
```

