package linkedlist;

import static linkedlist.Exercise.*;

public class SingleLinkedListTest {
/*
    public static void main(String[] args) {
        //先创建结点
        Node node1 = new Node(1,"宋江","及时雨");
        Node node2 = new Node(2,"卢俊义","玉麒麟");
        Node node3 = new Node(3,"吴用","智多星");
        Node node4 = new Node(4,"林冲","豹子头");

        //创建链表
        SingleLinkedList list = new SingleLinkedList();
        //加入
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);

        //加入按照编号的顺序
//        list.addByOrder(node2);
//        list.addByOrder(node4);
//        list.addByOrder(node3);
//        list.addByOrder(node1);

        System.out.println("原来的链表：");
        list.print();

        //从尾到头打印单链表-没有改变链表的本身结构
        System.out.println("逆序打印单链表：");
        reversePrint(list.getHead());


        */
/*
        //单链表的反转
        System.out.println("反转之后的链表");
        reverseList(list.getHead());
        list.print();*//*


        */
/*
        //测试修改结点的代码
        Node newNode = new Node(2,"小卢","小玉");
        list.updata(newNode);

        System.out.println("修改后的链表：");
        //显示
        list.print();
        System.out.println("---------------");
        //删除一个节点
        list.delete(1);
        list.print();


        //求单链表中有效节点的个数
        System.out.println("有效的结点个数" + getLength(list.getHead()));//3

        //查找单链表中的倒数第k个结点
        Node result = findLastIndexNode(list.getHead(), 1);
        System.out.println( result);*//*


    }
*/

    public static void main(String[] args) {
        SingleLinkedList list1 = new SingleLinkedList();
        SingleLinkedList list2 = new SingleLinkedList();

        Node node1 = new Node(1,"宋江", "及时雨");
        Node node2 = new Node(2,"卢俊义", "玉麒麟");
        Node node3 = new Node(3,"吴用", "智多星");
        Node node4 = new Node(7,"公孙胜", "入云龙");
        Node node5 = new Node(8,"关胜", "大刀");
        Node node6 = new Node(9,"林冲", "豹子头");
        Node node7 = new Node(10,"秦明", "霹雳火");
        Node node8 = new Node(24,"花荣", "小李广");

        list1.add(node1);
        list1.add(node2);
        list1.add(node5);
        list1.add(node7);
        list1.add(node8);
        list2.add(node3);
        list2.add(node4);
        list2.add(node6);
        list1.print();
        System.out.println("-------------");
        list2.print();

        SingleLinkedList list = mergeList(list1, list2);
//        while(list.getHead().next != null) {
//            Node head = list.getHead();
//            System.out.println(head.no);
//            head = head.next;
//        }
        list.print();
    }

}

//定义SingleLinkedList管理我们的英雄
class SingleLinkedList {
    //初始化一个头结点，头结点不要动,不存放具体的数据
    private Node head = new Node(0,"","");

    public Node getHead() {
        return head;
    }

    //添加结点到单链表
    /*
        思路，当不考虑编号顺序时
        1.找到当前链表的最后结点
        2.将最后这个结点的next指向新的结点
     */
    public void add(Node node) {
        //因为head结点不能动，因此我们需要一个辅助指针
        Node temp = head;
        //遍历链表，找到最后
        while(true) {
            //找到链表的最后
            if(temp.next == null) {
                break;
            }
            //如果没有找到最后,就将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        temp.next = node;
    }

    //根据排名英雄插入到指定位置
    //如果有这个排名，则添加失败，并给出提示
    public void addByOrder(Node node) {
        //因为头结点不能动，因此仍然通过一个辅助指针(变量)来帮助找到添加的位置
        //因为单链表，因此我们找的temp是位于添加位置的前一个结点，否则插入不了
        Node temp = head;
        boolean flag = false;//表示添加的编号是否存在，默认为false
        while(true) {
            if(temp.next == null){//说明temp已经在链表的最后
                break;
            }
            if(temp.next.no  > node.no){//位置找到了，就在temp的后面插入
                break;
            }else if(temp.next.no == node.no){//希望添加的Node的编号已然存在
                flag = true;//编号存在
                break;
            }
            temp = temp.next;//后移
        }
        //判断flag的值
        if(flag) {//不能添加，说明编号存在
            System.out.printf("准备插入的英雄的编号 %d 已经存在，不能加入\n", node.no);
        }else {
            //插入到链表中，temp的后面
            node.next = temp.next;
            temp.next = node;
        }
    }
    //修改结点的信息，根据no编号来修改，即no编号不能改
    //根据node的no来修改即可
    public void updata(Node node) {
        //判断是否为空
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的结点，根据no编号
        //定义一个辅助变量
        Node temp = head.next;
        boolean  flag = false;//表示是否找到该结点
        while(true) {
            if(temp == null) {
                break;//已经遍历完该链表
            }
            if(temp.no == node.no) {
                //找到了
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag来判断是否找到要修改的结点
        if(flag) {
            temp.name = node.name;
            temp.nickName = node.nickName;
        }else {//没有找到
            System.out.printf("没有找到编号%d的结点，不能修改\n",node.no);
        }
    }

    //删除结点
    //思路：head不能动，因此需要一个temp辅助结点找到待删除的结点的前一个结点
    //说明在比较是，是temp.next.no和需要删除的结点的no比较
    public void delete(int no) {
        Node temp = head;
        boolean flag = false;//表示是否找到待删除结点的前一个结点
        while(true) {
            if(temp.next == null) {//已经到链表的最后
                break;
            }
            if(temp.next.no == no){
                //找到了待删除结点的前一个结点temp
                flag = true;
                break;
            }
            temp = temp.next;//temp后移，遍历
        }
        //判断flag
        if(flag) {//找到了
            //可以删除
            temp.next = temp.next.next;
        }else{
            System.out.printf("要删除的%d结点不存在",no);
        }
    }

    //显示链表(遍历)
    public void print() {
        //判断链表是否为空
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头结点不能动，我们需要一个辅助变量来遍历
        Node temp = head.next;
        while(true) {
            //判断是否到链表最后
            if(temp == null) {
                break;
            }
            //输出结点的信息
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }
    }
}

//定义一个Node，每一个Node对象就是一个结点
class Node {
    public int no;
    public String name;
    public String nickName;
    public Node next;//指向下一个结点

    //构造方法
    public Node(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    //为了显示方便，重写toString()

    @Override
    public String toString() {
        return "Node[" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\''+
                ']';
    }
}
