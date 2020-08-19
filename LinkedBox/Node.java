package 练习.LinkedBox;

public class Node {

    public Node prev;//上一个Node对象
    public int element;//当前数据
    public Node next;//下一个Node对象

    public Node(Node prev,int element,Node next){
        this.prev = prev;
        this.element = element;
        this.next = next;
    }
}
