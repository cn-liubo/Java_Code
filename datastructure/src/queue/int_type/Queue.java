package queue.int_type;

import java.util.NoSuchElementException;

//队列
public interface Queue {

    //这组方法通过特殊的返回值，通知错误

    //插入元素 true成功  false失败（例如容量满了）
    boolean offer(Integer e);
    //返回队首元素，但不删除
    //返回null，表示队列是空的
    Integer peek();
    //返回并删除元素
    //返回null，表示队列是空的
    Integer poll();


    //这组方法通过抛出异常，通知错误

    //插入元素  true成功
    default boolean add(Integer e) {
        if(offer(e) == false) {
            throw new IllegalStateException();
        }
        return true;
    }
    //返回队首元素，但不删除
    default Integer element() {
        Integer e = peek();
        if(e == null) {
            throw new NoSuchElementException();
        }
        return e;
    }
    //返回并删除队首元素
    default Integer remove() {
        Integer e = poll();
        if(e == null) {
            throw new NoSuchElementException();
        }
        return e;
    }

}
