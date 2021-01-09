package queue.int_type;

public class LinkedList implements Deque{

    private static class Node {
        private Integer v;
        Node previous;
        Node next;

        Node(Integer x) {
            this.v = x;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    @Override
    public boolean offerFirst(Integer e) {
        Node node = new Node(e);
        if(size == 0) {
            head = tail = node;
        } else {
            node.next = head;
            head.previous = node;
            head = node;
        }
        size++;
        return true;
    }

    @Override
    public Integer peekFirst() {
        if(size == 0) {
            return null;
        }
        return head.v;
    }

    @Override
    public Integer pollFirst() {
        if(size == 0) {
            return null;
        }

        Integer e = head.v;
        head = head.next;
        if(head != null) {
            head.previous = null;
        } else {
            tail = null;
        }
        size--;
        return e;
    }

    @Override
    public boolean offerLast(Integer e) {
        Node node = new Node(e);

        if(size == 0) {
            head = tail = node;
        } else {
            node.previous = tail;
            tail.next = node;
            tail = node;
        }
        size++;
        return true;
    }

    @Override
    public Integer peekLast() {
        if(size == 0) {
            return null;
        }
        return tail.v;
    }

    @Override
    public Integer pollLast() {
        if(size == 0) {
            return null;
        }

        Integer e = tail.v;
        tail = tail.previous;
        if(tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;
        return e;
    }
}
