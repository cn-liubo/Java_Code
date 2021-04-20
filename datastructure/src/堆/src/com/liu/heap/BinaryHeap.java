package com.liu.heap;

import com.liu.printer.BinaryTreeInfo;

import java.util.Comparator;

public class BinaryHeap<E> extends AbstractHeap<E> implements BinaryTreeInfo {
    private E[] elements;

    public BinaryHeap(E[] elements, Comparator<E> comparator) {
        super(comparator);

        if(elements == null || elements.length == 0) {
            this.elements = (E[]) new Object[10];
        } else {
            size = elements.length;
            int capacity = Math.max(elements.length, 10);
            this.elements = (E[]) new Object[capacity];
            for (int i = 0; i < elements.length; i++) {
                this.elements[i] = elements[i];
            }
            heapify();
        }
    }

    public BinaryHeap(E[] elements) {
        this(elements, null);
    }

    public BinaryHeap() {
        this(null, null);
    }

    public BinaryHeap(Comparator<E> comparator) {
        this(null, comparator);
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public void add(E element) {
        elementNotNullCheck(element);
        ensureCapacity(size + 1);
        elements[size++] = element;
        shiftUp(size - 1);
    }

    @Override
    public E get() {
        emptyCheck();
        return elements[0];
    }

    @Override
    public E remove() {
        emptyCheck();

        int lastIndex = --size;
        E root = elements[0];
        elements[0] = elements[lastIndex];
        elements[lastIndex] = null;

        shiftDown(0);
        return root;
    }

    @Override
    public E replace(E element) {
        elementNotNullCheck(element);

        E root = null;
        if (size == 0) {
            elements[0] = element;
            size++;
        } else {
            root = elements[0];
            elements[0] = element;
            shiftDown(0);
        }
        return root;
    }

    //批量建堆
    public void heapify() {
        //自上而下的上滤
//        for (int i = 1; i < size; i++) {
//            shiftUp(i);
//        }

        //自下而上的上率
        for (int i = (size >> 1) - 1; i >= 0; i--) {
            shiftDown(i);
        }
    }

    private void shiftUp(int index) {
//        E e = elements[index];
////        while(index > 0) {
////            int pIndex = (index - 1) >> 1;
////            E p = elements[pIndex];
////            if(compare(e, p) <= 0) return;
////
////            //交换index、pIndex位置的内容
////            E temp = elements[index];
////            elements[index] = elements[pIndex];
////            elements[pIndex] = temp;
////
////            //重新赋值index
////            index = pIndex;
////        }

        E element = elements[index];
        while(index > 0) {
            int parentIndex = (index - 1) >> 1;
            E parent = elements[parentIndex];
            if(compare(element, parent) <= 0) break;

            //将父元素存储在index位置
            elements[index] = parent;

            //重新赋值index
            index = parentIndex;
        }
        elements[index] = element;
    }

    private void shiftDown(int index) {
        E element = elements[index];
        int half = size >> 1;
        //第一个叶子结点的索引 == 非叶子结点的数量
        //index < 第一个叶子结点的索引
        //必须保证index位置是非叶子结点
        while(index < half) {
            //index的结点有两种情况
            //1.只有左子结点
            //2.同时有左右子结点

            //默认为左子结点的索引跟它进行比较
            int childIndex = (index << 1) + 1;
            E child = elements[childIndex];

            //右子结点
            int rightIndex = childIndex + 1;

            //选出左右子结点最大的那个
            if(rightIndex < size && compare(elements[rightIndex], child) > 0) {
//                childIndex = rightIndex;
//                child = elements[rightIndex];

                child = elements[childIndex = rightIndex];
            }

            if(compare(element, child) >= 0) break;

            //将子结点存放到index位置
            elements[index] = child;
            //重新设置index
            index = childIndex;
        }
        elements[index] = element;
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if(oldCapacity >= capacity) return;

        //新容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElement = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElement[i] = elements[i];
        }
        elements = newElement;
//        System.out.println(oldCapacity + "扩容为" + newCapacity);
    }

    private void emptyCheck() {
        if(size == 0) {
            throw new IndexOutOfBoundsException("Heap is empty!");
        }
    }

    private void elementNotNullCheck(E element) {
        if(element == null) {
            throw new IllegalArgumentException("element must no be null!");
        }
    }

    @Override
    public java.lang.Object root() {
        return 0;
    }

    @Override
    public java.lang.Object left(Object node) {
        Integer index = ((Integer) node << 1) + 1;
        return index >= size ? null : index;
    }

    @Override
    public java.lang.Object right(Object node) {
        Integer index = ((Integer) node << 1) + 2;
        return index >= size ? null : index;
    }

    @Override
    public java.lang.Object string(Object node) {
        return elements[(Integer) node];
    }
}