package linkedList.int_type;

public class LinkedList implements List{

    public Node head;//指向第一个结点
    public Node last;//指向第二个结点
    public int size;

   @Override
    public boolean add(Integer e) {
        //判断链表中没有结点，哪种判断都可以，等价的
        Node newNode = new Node(e);
        if(size == 0) {// 或 head == null 或 last == null
            this.head = this.last = newNode;
        } else {
            this.last.next = newNode;
            newNode.prev = this.last;
            this.last = newNode;
        }
        this.size++;
        return true;
    }

    @Override
    public void add(int index, Integer e) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("下标越界：" + index);
        }

        Node newNode = new Node(e);
        if(index == size) {
            //尾插
            add(e);
        } else if(index == 0) {
            //头插
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
            size++;
        } else {
            //其他情况
            //找到index - 1所在的位置，进行结点插入
            Node cur;
            if(index - 1 < size / 2) {
                cur = this.head;
                //从head处出发，找到index - 1位置的结点
                for(int i = 0; i < index - 1; i++) {
                    cur = cur.next;
                }
            } else {
                //从last处出发，找到index - 1位置的结点
                cur = last;
                for(int i = 0; i < size - index; i++) {
                    cur = cur.prev;
                }
            }
            //走到这里时，cur执行index - 1位置的下标
            Node next = cur.next;

            newNode.prev = cur;
            newNode.next = next;
            cur.next = newNode;
            next.prev = newNode;
            size++;
        }
    }

    @Override
    public Integer remove(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("下标越界：" + index);
        }

        Integer element;
        if(index == 0) {
            element = head.element;
            //头删
            this.head = this.head.next;
            this.head.prev = null;
            size--;
            if(size == 0) {
                last = null;
            }
        } else if(index == size - 1) {
            element = last.element;
            //尾删
            this.last = this.last.prev;
            this.last.next = null;
            size--;
            if(size == 0) {
                head = null;
            }
        } else {
            //找到index - 1所在的位置，进行结点插入
            Node cur;
            if(index - 1 < size / 2) {
                cur = this.head;
                //从head处出发，找到index - 1位置的结点
                for(int i = 0; i < index - 1; i++) {
                    cur = cur.next;
                }
            } else {
                //从last处出发，找到index - 1位置的结点
                cur = last;
                for(int i = 0; i < size - index; i++) {
                    cur = cur.prev;
                }
            }
            //走到这里时，cur执行index - 1位置的下标
            Node node = cur.next;
            element = node.element;
            cur.next = node.next;
            node.next.prev = cur;
            size--;
        }
        return element;
    }

    @Override
    public boolean remove(Integer element) {
       Node prev = null;
        for(Node cur = head; cur != null; cur = cur.next) {
            if(cur.element.equals(element)) {
                if(prev == null) {
                    remove(0);
                } else {
                    prev.next.next.prev = prev;
                    prev.next = prev.next.next;
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Integer get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("下标越界：" + index);
        }

        Node cur = head;
        for(int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.element;
    }

    @Override
    public Integer set(int index, Integer e) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("下标越界：" + index);
        }

        Node cur = head;
        for(int i = 0; i < index; i++) {
            cur = cur.next;
        }

        Integer element = cur.element;
        cur.element = e;
        return element;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        head = null;
        last = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Integer e) {
        return indexOf(e) != -1;
    }

    @Override
    public int indexOf(Integer e) {
        int index = 0;
        for(Node cur = head; cur != null; cur = cur.next, index++) {
            if(cur.element.equals(e)) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer e) {
        int index = size - 1;
        for(Node cur = last; cur != null; cur = cur.prev, index--) {
            if(cur.element.equals(e)) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator(this);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for(Node cur = head; cur != null; cur = cur.next) {
            sb.append(cur.element);
            if(cur != last) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
