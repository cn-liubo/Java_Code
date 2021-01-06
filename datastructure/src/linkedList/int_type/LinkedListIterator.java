package linkedList.int_type;

public class LinkedListIterator implements Iterator{

    private LinkedList list;
    private Node current;

    public LinkedListIterator(LinkedList list) {
        this.list = list;
        this.current = list.head;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public Integer next() {
        Integer element = current.element;
        current = current.next;
        return element;
    }
}
