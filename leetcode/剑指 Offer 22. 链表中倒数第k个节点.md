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
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(k <= 0 || head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (k - 1 > 0) {
            if(fast.next != null) {
                fast = fast.next;
                k--;
            }else {
                System.out.println("k值过大");
                return null;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
​```
```

