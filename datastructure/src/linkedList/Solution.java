package linkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {

    //移除链表元素
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return null;
        }
        ListNode prev = head;
        ListNode cur = head.next;

        while(cur != null) {
            if(cur.val == val) {
                prev.next = cur.next;
                cur = cur.next;
            }else {
                prev = cur;
                cur = cur.next;
            }
        }
        if(head.val == val) {
            head = head.next;
        }
        return head;
    }

    //反转链表
    public ListNode reverseList(ListNode head) {

        ListNode newHead = null;//新链表的头结点
        ListNode prev = null;//当前需要反转的结点的前驱
        ListNode cur = head;//当前需要反转的结点

        while (cur != null) {
            ListNode curNext = cur.next;
            if(curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return cur;
    }

    //找到链表的中间结点
    public ListNode middleNode(ListNode head) {
        //if(fast == null || fast.next == null)
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //找到链表中倒数第k个结点
    public ListNode findKthToTail(ListNode head,int k) {
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

    //分割链表
    public ListNode partition(ListNode head, int x) {
        ListNode bs = null;
        ListNode be = null;

        ListNode as = null;
        ListNode ae = null;

        ListNode cur = head;

        while(cur != null) {
            if(cur.val < x) {
                if(bs == null) {
                    //第一次进行插入（尾插）
                    bs = cur;
                    be = cur;
                } else {
                    be.next = cur;
                    be = cur;
                }
            } else {
                if(as == null) {
                    //第一次进行插入（尾插）
                    as = cur;
                    ae = cur;
                } else {
                    ae.next = cur;
                    ae = cur;
                }
            }
            cur = cur.next;
        }

        if(bs == null) {
            return as;
        }
        be.next = as;
        if(as != null) {
            ae.next = null;
        }
        return bs;
    }

    //删除链表中重复的结点
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(-1);
        ListNode temp = newHead;
        ListNode cur = head;

        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
            } else {
                temp.next = cur;
                temp = cur;
                cur = cur.next;
            }
        }
        temp.next = null;
        return newHead.next;
    }

    //回文链表
    public boolean isPalindrome(ListNode head) {
        if(head == null) {
            return true;
        }
        if(head.next == null) {
            return true;
        }
        //1.找到中间结点
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //2.反转
        ListNode cur = slow.next;
        while(cur != null) {
            ListNode curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        //3.判断val是否相同  一个从前往后走，一个从后往前走，直到相遇的时候
        while(head != null) {
            if(head.val != slow.val) {
                return false;
            }
            //偶数个结点
            if(head.next == slow) {
                return true;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    //环形链表
    public boolean hasCycle(ListNode head) {
        /*ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                return true;
            }
        }
        return false;*/

        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                break;
            }
        }
        if(fast == null || fast.next == null) {
            return false;
        }
        return true;
    }

    //环形链表2
    //将一个结点放到入口点，下一个相遇的结点就是入口点
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                break;
            }
        }
        if(fast == null || fast.next == null) {
            //没有环
            return null;
        }
        slow = head;
        while(slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    //相交链表
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null && headB == null) {
            return null;
        }
        ListNode pl = headA;
        ListNode ps = headB;

        int lengthA = 0;
        int lengthB = 0;

        while(pl != null) {
            lengthA++;
            pl = pl.next;
        }
        while(ps != null) {
            lengthB++;
            ps = ps.next;
        }
        pl = headA;
        ps = headB;

        int length = lengthA - lengthB;
        if(length < 0) {
            ps = headA;
            pl = headB;
            length = lengthB - lengthA;

        }

        //保证pl指向的是最长的单链表，ps指向的是最短的单链表
        while(length > 0) {
            length--;
            pl = pl.next;
        }
        //说明pl已经走了差值步
        while (pl != null && ps != null && pl != ps) {
            pl = pl.next;
            ps = ps.next;
        }
        if(pl == ps && pl != null) {
            return pl;
        }
        //说明方法没结束，也就是没有找到相交点
        return null;
    }

    //合并两个有序链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(-1);
        ListNode temp = newHead;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
            } else {
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
            }
        }
        if(l1 != null) {
            //l1剩下的所有数据都是比l2中的数据大
            temp.next = l1;
        }
        if(l2 == null) {
            //l2剩下的所有数据都是比l1中的数据大
            temp.next = l2;
        }
        return newHead.next;
    }
}

