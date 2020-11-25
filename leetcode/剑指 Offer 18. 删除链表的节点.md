```java

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if(head == null) {
            return null;
        }
        if(head.val == val) {
            head = head.next;
        }
        ListNode prev = head;
        ListNode cur = head.next;
        while(cur != null) {
            if(cur.val == val) {
                prev.next = cur.next;
                break;
            }
            prev = cur;
            cur = cur.next;
        }
        return head;
    }
}
​```
```

