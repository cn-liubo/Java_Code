package arrayList.int_type;

import java.util.Arrays;

//实现java.util.ArrayList
public class ArrayList implements List{

    private int[] array;//顺序表内部的数组
    private int size;//顺序表内部的元素的个数

    public ArrayList() {
        //初始容量是10个
        array = new int[10];
        //初始的元素个数是10个
        size = 0;
    }
    public ArrayList(List other) {
        array = new int[other.size()];
        for (int i = 0; i < other.size(); i++) {
            array[i] = other.get(i);
            size = other.size();
        }
    }

    //不需要扩容时，时间复杂度是O(1)
    //需要扩容时，时间复杂度是O(n)
    //由于扩容的情况比较少见，所以这个方法的时间复杂度一般是 O(1)
    @Override
    public boolean add(Integer e) {
        if(array.length == size) {
            //现在已经满了，需要扩容了
            ensureCapacity(array.length * 2);
        }
        array[size++] = e;

        return true;
    }

    //调用完这个方法后，保证容量一定是 >= capacity
    //时间复杂度O(n)
    public void ensureCapacity(int capacity) {
        //检查是否需要扩容
        if(array.length >= capacity) {
            return;
        }

        //定义新的数组
        int[] newArray = new int[capacity];
        //进行搬家，从array数组中搬到newArray数组中
        for(int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    @Override
    public void add(int index, Integer e) {
        //合法的下标：[0 ，size]
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("不合法的下标" + index);
        }
        if(array.length == size) {
            ensureCapacity(array.length * 2);
        }

        //要把index及之后的所有元素，全部向后搬移
       /* for(int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }*/
        for(int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = e;
        size++;
    }

    @Override
    public Integer remove(int index) {
        //合法的下标：[0, size - 1]
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("不合法的下标" + index);
        }

        int e = array[index];
        //从后往前删
        //[index + 1, size - 1]的元素，搬移到[index, size - 2]的下标处
        for(int i = index + 1; i <= size - 1; i++) {
            array[i - 1] = array[i];
        }
        size--;
        return e;
    }

    @Override
    public boolean remove(Integer element) {
        int index = indexOf(element);
        if(index != -1) {
            remove(index);
            return true;
        } else {
            return false;
        }
        /*for(int i = 0; i < size; i++) {
            remove(i);
            return true;
        }
        return false;*/
    }

    @Override
    public Integer get(int index) {
        //合法的下标：[0, size - 1]
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("不合法的下标" + index);
        }
        return array[index];
    }

    @Override
    public Integer set(int index, Integer e) {

        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("不合法的下标" + index);
        }
        Integer old = array[index];
        array[index] = e;
        return old;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        // -1 暂时代表无效值
        Arrays.fill(array, -1);
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
        for(int i = 0; i < size; i++) {
            if(array[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer e) {
        for(int i = size - 1; i >= 0; i--) {
            if(array[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for(int i = 0; i < size; i++) {
            sb.append(array[i]);
            if(i != size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public Iterator iterator() {
        //返回一个Iterator接口的实现类给类的对象
        return new ArrayListIterator(this);
    }


}
