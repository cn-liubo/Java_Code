package linkedlist;

import java.util.Stack;

public class Exercise {
 
    //从尾到头打印单链表 [要求方式1：反向遍历 。 方式2：Stack栈]
    //Stack栈
    public static void reversePrint(Node head) {
        if(head.next == null) {
            return;//空链表
        }
        //创建一个栈，将各个结点压入栈
        Stack<Node> stack = new Stack<Node>();
        Node cur = head.next;
        //将链表的所有结点压入栈
        while(cur != null) {
            stack.push(cur);
            cur = cur.next;//cur后移，这样就可以压入下一个结点
        }
        //将栈中的结点进行打印，pop出栈
        while(stack.size() > 0) {
            System.out.println(stack.pop());//stack的特点是先进后出
        }
    }


    //单链表的反转
    public static void reverseList(Node head) {
        //如果当前链表为空，或只有一个节点，无需反转，直接返回
        if(head.next == null || head.next.next == null) {
            return;
        }
        //定义一个辅助的指针(变量)，帮助遍历原来的链表
        Node cur = head.next;
        Node next = null;//指向当前结点(cur)的下一个结点
        Node reverseHead = new Node(0,"","");
        //遍历原来的链表，每遍历一个结点，就将其取出，并放在新的链表reverseHead的最前端
        while(cur != null) {
            next = cur.next;//先暂时保存当前结点的下一个结点，因为后面需要使用
            cur.next = reverseHead.next;//将cur的下一个结点指向新的链表最前端
            reverseHead.next = cur;//将cur连接到新的链表上
            cur = next;//让cur后移
        }
        //将head.next指向reverseHead.next，实现单链表的反转
        head.next = reverseHead.next;
    }


    //查找单链表中的倒数第k个结点
    /*
        思路：
            1.编写一个方法，接收head结点，同时接收一个index
            2.index表示倒数第index个结点
            3.先把链表从头到尾遍历，得到链表的长度
            4.得到size后，从链表的第一个开始遍历(size-index)个，就可以得到
            5.如果找到了，则返回该节点，否则返回null
     */
    public static Node findLastIndexNode(Node head, int index){
        //判断如果链表为空，返回null
        if(head.next == null){
            return null;//没有找到
        }
        //第一次遍历得到链表的长度(结点个数)
        int size = getLength(head);
        //第二次遍历，size-index位置，就是倒数的第k个结点
        //先做一个index的校验
        if(index <= 0 || index > size){
            return null;
        }
        //定义一个辅助变量,
        Node cur = head.next;
        for(int i = 0; i < size - index; i++){
            cur = cur.next;
        }
        return cur;
    }


    //求单链表中有效节点的个数
    //获取到单链表的结点个数(如果带头结点的链表，不统计头结点)
    /**
     *
     * @param head 链表的头街点
     * @return 返回的就是有效结点的个数
     */
    public static int getLength(Node head) {
        if(head.next == null){//空链表
            return 0;
        }
        int length = 0;
        //定义一个辅助的变量，这里没有统计头结点
        Node cur = head.next;
        while(cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }
}
