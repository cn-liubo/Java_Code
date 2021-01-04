package arrayList.genericity_type;

import java.util.*;

public class ArrayList<E> implements List<E> {
    private E[] array;
    private int size;

    public ArrayList() {
        //无法直接定义泛型数组，所以只能定义Object类型的数组，然后强转
        array = (E[]) new Object[10];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] a = new Object[size];
        for(int i = 0; i < size; i++) {
            a[i] = array[i];
        }
        return a;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if(a.length < size) {
            //创建一个数组直接返回
            T[] newArray = (T[]) new Object[size];
            for(int i = 0; i < size; i++) {
                newArray[i] = (T) array[i];
            }
            return newArray;
        } else if(a.length == size) {
            //把元素放入并返回
            for(int i = 0; i < size; i++) {
                a[i] = (T) array[i];
            }
            return a;
        } else {
            //把元素放入并返回
            //把超过的第一个位置设置成null
            for(int i = 0; i < size; i++) {
                a[i] = (T) array[i];
            }
            a[size] = null;
            return a;
        }
    }

    @Override
    public boolean add(E e) {
        //没有考虑扩容
        array[size++] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int i = indexOf(o);
        if(i == -1) {
            return false;
        } else {
            remove(i);
            return true;
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        //如果是基本类型，数组中的元素是否要清除成无效值其实都无所谓
        //如果是引用类型，必须把数组中的元素修改为null
        //这样才不会内存泄漏
        Arrays.fill(array, null);
        size = 0;
    }

    @Override
    public E get(int index) {
        //判断下标
        return array[index];
    }

    @Override
    public E set(int index, E element) {
        //判断下标
        E e = array[index];
        array[index] = element;
        return e;
    }

    @Override
    public void add(int index, E element) {
        return;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        //泛型中，引用类型的处理
        for(int i = 0; i < size; i++) {
            if(o == null) {
                if(array[i] == o) {
                    return i;
                }
            } else {
                //平时Array List的contains/indexOf等，都会调用元素的equals方法
                if(o.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
