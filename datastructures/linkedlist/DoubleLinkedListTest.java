package linkedlist;

public class DoubleLinkedListTest {
    public static void main(String[] args) {
        //先创建结点
        Node2 node1 = new Node2(1,"宋江","及时雨");
        Node2 node2 = new Node2(2,"卢俊义","玉麒麟");
        Node2 node3 = new Node2(3,"吴用","智多星");
        Node2 node4 = new Node2(4,"林冲","豹子头");

        //创建一个双向链表
        DoubleLinkedList list = new DoubleLinkedList();
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        list.print();
        //修改
        Node2 newNode = new Node2(4, "公孙胜" ,"入云龙");
        list.updata(newNode);
        System.out.println("修改后的双向链表：");
        list.print();
        //删除
        list.delete(3);
        System.out.println("删除后的链表：");
        list.print();
    }
}

//创建一个双向链表的类
class DoubleLinkedList {
    //西安初始化一个头结点，头结点不要动，不存放具体的数据
    private Node2 head = new Node2(0, "" , "");

    //返回头结点
    public Node2 getHead() {
        return this.head;
    }

    //添加结点到双向链表
    public void add(Node2 node){
        Node2 temp = head;
        while(true) {
            if(temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        //当退出while循环式，temp就指向了链表的最后
        //形成双向链表
        temp.next = node;
        node.per = temp;
    }

    //修改一个结点的内容
//修改结点的信息，根据no编号来修改，即no编号不能改
    //根据node的no来修改即可
    public void updata(Node2 node) {
        //判断是否为空
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的结点，可以看到双向链表的结点内容的修改和单项链表一样
        //只是结点的类型改变
        Node2 temp = head.next;
        boolean flag = false;//表示是否找到该结点
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

    //从双向链表中删除一个结点
    //说明：1.对于双向链表，我们可以直接找到要删除的这个结点
    //      2.找到了，自我删除即可
    public void delete(int no) {
        //判断当前链表是否为空
        if(head.next == null) {
            System.out.println("链表为空，不能删除");
            return;
        }
        Node2 temp = head.next;//辅助变量（指针）
        boolean flag = false;//表示是否找到待删除的结点
        while(true) {
            if(temp == null) {
                break;
            }
            if(temp.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag) {//找到了
            temp.per.next = temp.next;
            //这里的代码有问题？
            //如果是最后一个结点，就不需要执行下面这句话 temp.next = null;
            if(temp.next != null) {
                temp.next.per = temp.per;
            }else{
                System.out.printf("要删除的%d结点不存在", no);
            }
        }
    }

    //遍历双向链表
    public void print() {
        //判断链表是否为空
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }
        Node2 temp = head.next;
        while(true) {
            if(temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

//定义Node2，每个Node2对象就是一个结点
class Node2 {
    public int no;
    public String name;
    public String nickName;
    public Node2 next;//指向下一个结点，默认为null
    public Node2 per;//指向前一个结点，默认为null

    public Node2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }
    //重写toString()

    @Override
    public String toString() {
        return "Node2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
