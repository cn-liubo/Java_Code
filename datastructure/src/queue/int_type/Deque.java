package queue.int_type;

import java.util.NoSuchElementException;

//双向队列
public interface Deque extends Queue {
    //这组方法，通过特殊返回值值报告错误
    boolean offerFirst(Integer e);
    Integer peekFirst();
    Integer pollFirst();

    boolean offerLast(Integer e);
    Integer peekLast();
    Integer pollLast();


    //这组方法，通过异常报告报错
    default void addFirst(Integer e) {
        if(offerFirst(e) == false) {
            throw new IllegalStateException();
        }
    }
    default Integer getFirst() {
        Integer e = peekFirst();
        if(e == null) {
            throw new NoSuchElementException();
        }
        return e;
    }
    default Integer removeFirst() {
        Integer e = pollFirst();
        if(e == null) {
            throw new NoSuchElementException();
        }
        return e;
    }
    default void addLast(Integer e) {
        if(offerLast(e) == false) {
            throw new IllegalStateException();
        }
    }
    default Integer getLast() {
        Integer e = peekLast();
        if(e == null) {
            throw new NoSuchElementException();
        }
        return e;
    }
    default Integer removeLast() {
        Integer e = pollLast();
        if(e == null) {
            throw new NoSuchElementException();
        }
        return e;
    }

    //这组方法，继承自Queue
    //特殊值
    default boolean offer(Integer e) {
        return offerLast(e);
    }
    default Integer peek() {
        return peekFirst();
    }
    default Integer poll() {
        return pollFirst();
    }

    //下面这组方法为栈的形态准备，还包括上面的peek方法
    default void push(Integer e) {
        addFirst(e);
    }
    default Integer pop() {
        return removeFirst();
    }

}
