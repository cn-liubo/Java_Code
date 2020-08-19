package 练习.LinkedBox;

public class LinkedBox implements Box{

    //创建属性  双链表
    private Node first;//记录首节点
    private Node last;//记录尾结点
    private int size;//记录有效元素的个数

    //设计一个方法 将元素添加在新的Node里 挂在链表的尾端
    private void linkLast(int element){
        //获取链表的尾结点
        Node l = last;
        //创建一个新的Node对象 将新数据包装起来
        Node newNode = new Node(l,element,null);
        //将新节点对象设置为尾结点
        last = newNode;
        //严谨的判断
        if(l == null){//如果原来尾结点没有对象 证明这个链表没有使用过
            first = newNode;
        }else{//原来用过 刚才已经将新的结点连接在last之后
            l.next = newNode;
        }
        //有效元素个数增加一个
        size++;
    }
    //设计一个方法 来检测index是否合法
    private void rangeCheck(int index){
        if(index < 0 || index >= size){
            throw new BoxIndexOutOfBoundsException("Index:"+index+",Size:"+size);
        }
    }
    //设计一个方法 找寻给定index位置的Node对象
    private Node node(int index){
        Node targetNode;//用来存储找到的当前那个目标
        //判断index范围是在前半部分还是后半部分
        if(index < (size >> 1)){//在前半部分 从前往后找寻
            targetNode = first;
            for(int i = 0; i < index; i++){
                targetNode = targetNode.next;
            }
        }else{//在后半部分 从后往前找寻
            targetNode = last;
            for(int i = size-1; i > index; i--){
                targetNode = targetNode.prev;
            }
        }
        return targetNode;
    }
    //设计一个方法 将给定Node节点对象删除并且保留数据
    private int unlink(Node targetNode){
        //获取当面Node的element信息
        int oldValue = targetNode.element;
        //找当前Node的前一个
        Node prev = targetNode.prev;
        //找当前Node的下一个
        Node next = targetNode.next;
        //删除节点对象
        if(prev == null){//当前Node就是第一个
            first = next;
        }else{
            prev.next = next;
            targetNode.prev = null;
        }
        if(next == null){//当前Node就是最后一个
            last = prev;
        }else{
            next.prev = prev;
            targetNode.next = null;
        }
        //让有效元素减少一个
        size--;
        return oldValue;
    }


    @Override
    public boolean add(int element) {
        //将element存入一个新的Node对象里 添加至链表的尾端
        this.linkLast(element);
        //告知添加成功
        return true;
    }

    @Override
    public int get(int index) {
        //检测index是否合法
        this.rangeCheck(index);
        //找寻index对应位置的那个Node对象 将对象中的数据取出来
        Node targetNode = this.node(index);
        //返回找到的Node对象内的数据
        return targetNode.element;
    }

    @Override
    public int remove(int index) {
        //检测index返回是否合法
        this.rangeCheck(index);
        //找到index位置的Node
        Node targetNode = this.node(index);
        //删除当前的目标节点
        int oldValue = this.unlink(targetNode);
        return oldValue;
    }

    @Override
    public int size() {
        return size;
    }
}
