package test;

public class Plus {
    public static void main(String[] args) {
        ListNode a = new ListNode(7);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(7);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(2);
        ListNode g = new ListNode(7);
        ListNode h = new ListNode(2);
        ListNode i = new ListNode(3);
        ListNode j = new ListNode(4);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        f.next = g;
        g.next = h;
        h.next = i;
        i.next = j;

        Plus p = new Plus();
        ListNode k = p.plusAB(a, b);
        System.out.println(k);
    }

    public ListNode plusAB(ListNode a, ListNode b) {
        if(a == null || b == null)
            return null;

        ListNode curA = a;
        ListNode curB = b;
        ListNode dummy = new ListNode(-1);
        int result = 0;
        while(curA != null || curB != null) {
            result = curA.val + curB.val;
            int temp = 0;
            if(result > 10) {
                result %= 10;

                temp = temp + result / 10;

            } else {

            }

            curA = curA.next;
            curB = curB.next;
        }
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    public ListNode (int val) {
        this.val = val;
    }

}
