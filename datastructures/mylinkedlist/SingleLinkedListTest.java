package mylinkedlist;

//不带头结点的单链表
public class SingleLinkedListTest {
    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();

        sll.addFirst(21);
        sll.addFirst(22);
        sll.addFirst(23);
        sll.addLast(10);
        sll.addLast(6);
        sll.addLast(1);
        sll.addLast(4);
        sll.addLast(9);
        sll.addLast(11);
        sll.addLast(10);
        System.out.println("链表的长度是：" + sll.size());
        sll.display();
        System.out.println(sll.contains(21));
        sll.remove(11);
        sll.display();
        sll.removeAllKey(10);
        sll.display();

    }
}

class SingleLinkedList implements List{
    private Node head;//标识一个头结点

    //头插法
    @Override
    public void addFirst(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    //尾插法
    @Override
    public void addLast(int data) {
        Node node = new Node(data);
        if(head == null) {
            head = node;
        }else{
            Node temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public boolean checkIndex(int index) {
        if(index == 0 || index > this.size()) {
            System.out.println("下标不合法！");
            return false;
        }
        return true;
    }

    //任意位置插入,第一个数据节点为0号下标
    @Override
    public boolean addIndex(int index, int data) {

        return false;
    }

    //查找是否包含关键字key是否在单链表当中
    @Override
    public boolean contains(int key) {
        Node temp = head;
        while(temp != null){
            if(temp.data == key) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    @Override
    public void remove(int key) {
        if(head == null) {
            return;
        }
        if(head.data == key) {
            head = head.next;
            return;
        }
        Node temp = head;
        boolean flag = false;
        while(temp.next != null) {
            if(temp.next.data == key) {
               flag = true;
               break;
            }
            temp = temp.next;
        }
        if(flag) {//找到了
            Node delNode = temp.next;
            temp.next = delNode.next;
        }else{
            System.out.println("没有你要找的元素");
        }


//        // 头节点是要删除的节点
//        if(head == null) return;
//        if(head.data == key) {
//            head = head.next;
//            return;
//        }
//        Node cul = searchPrevNode(key);
//        if(cul == null) {
//            System.out.println("没有你要删除的数字！");
//            return;
//        }
//        Node del = cul.next; // 所要删除的节点
//        cul.next = del.next;

    }
//    // 找前驱
//    public Node searchPrevNode(int key) {
//        Node cul = head;
//        while (cul.next != null) {
//            if(cul.next.data == key) {
//                return cul;
//            }
//            cul = cul.next;
//        }
//        return null;
//    }

    //删除所有值为key的节点
    @Override
    public void removeAllKey(int key) {
        if(head.next == null) {
            return;
        }
        if(head.data == key){
            head = head.next;
        }
        Node prev = head;
        Node temp = head.next;
        while(temp != null) {
            if(temp.data == key) {
                prev.next = temp.next;
                temp = temp.next;
            }else{
                prev = temp;
                temp = temp.next;
            }
        }
    }

    //得到单链表的长度
    @Override
    public int size() {
        int size = 0;
        Node temp = head;
        while(temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    @Override
    public void display() {
        Node temp = head;
        while(temp != null) {
            System.out.printf("%d ", temp.data);
            temp = temp.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {
        Node temp = head;
        while(temp != null) {
            remove(temp.data);
            temp = temp.next;
        }
    }
}

class Node {
    public int data;
    public Node next;//指向下一个结点
    public Node(int data) {
        this.data = data;
    }
}
