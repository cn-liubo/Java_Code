package linkedList;

class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
}
//不带头结点的单链表
public class MyLinkedList {

    public Node head;//标识单链表的头结点

    //头插法
    public void addFirst(int data) {
        Node node = new Node(data);
        /*if(this.head == null) {
            this.head = node;
        }else {
            node.next = this.head;
            this.head = node;
        }*/
        node.next = this.head;
        this.head = node;
    }

    //尾插法
    public void addLast(int data) {
        Node node = new Node(data);
        if(this.head == null) {
            this.head = node;
        }else {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    //任意位置插入，第一个数据节点为0号下标
    public void addIndex(int index, int data) {
        if(!checkIndex(index)) {//checkIndex(index) == false
            return;
        }
        if(index == 0) {
            this.addFirst(data);
            return;
        }
        if(index == getLength()) {
            this.addLast(data);
            return;
        }

        Node cur = searchPrev(index);//cur此时保存的就是index-1位置的节点的引用
        Node node = new Node(data);
        node.next = cur.next;
        cur.next = node;

    }
    public boolean checkIndex(int index) {
        if(index < 0 || index > getLength()) {
            System.out.println("下标不合法");
            return false;
        }
        return true;
    }
    //查找index-1的位置，找到返回引用
    public Node searchPrev(int index) {
        Node cur = this.head;
        int count = 0;
        while(count < index - 1) {
            cur = cur.next;
            count++;
        }
        return cur;
    }
    public int getLength() {
        int count = 0;
        Node cur = this.head;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        if(this.head == null) {
            return;
        }
        //头节点是删除的节点
        if(this.head.data == key) {
            head = head.next;
            return;
        }
        Node cur = searchPrevNode(key);
        Node del = cur.next;
        if(cur == null) {
            System.out.println("没有你要删除的数字！");
            return;
        }
        cur.next = del.next;
        //cur.next = cur.next.next;
    }
    public Node searchPrevNode(int key) {
        Node cur = this.head;
        while(cur.next != null) {
            if(cur.next.data == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    public boolean contains(int key) {
        Node cur = this.head;
        while(cur != null) {
            if(cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    public void removeAllKey(int key) {
        if(this.head == null) {
            return;
        }
        Node prev = this.head;
        Node cur = this.head.next;

        while(cur != null) {
            if(cur.data == key) {
                prev.next = cur.next;
                cur = cur.next;
            }else {
                prev = cur;
                cur = cur.next;
            }
        }
        if(this.head.data == key) {
            this.head = this.head.next;
        }
    }

    public void display() {
        Node cur = this.head;
        while(cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void clear() {
        this.head = null;
    }

    public Node reverseList() {
        Node newHead = null;//新链表的头结点
        Node prev = null;//当前需要反转的结点的前驱
        Node cur = this.head;//当前需要反转的结点

        while (cur != null) {
            Node curNext = cur.next;
            if(curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }
    public void display2(Node newHead) {
        Node cur = newHead;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
