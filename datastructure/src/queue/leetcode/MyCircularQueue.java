package queue.leetcode;

public class MyCircularQueue {

    private final int[] array;
    private int size;
    private int frontIndex;
    private int rearIndex;

    //循环队列的数组容量是k
    public MyCircularQueue(int k) {
        array = new int[k];
        size = 0;
        frontIndex = 0;
        rearIndex = 0;
    }

    //把value插入循环队列尾部
    //成功true  失败（容量满了）false
    public boolean enQueue(int value) {
        if(size == array.length) {
            return false;
        }

        array[rearIndex] = value;
        size++;
        rearIndex++;
        if(rearIndex == array.length) {
            rearIndex = 0;//让rearIndex指向0索引
        }
        //rearIndex = (rearIndex + 1) % array.length;
        return true;
    }

    //从循环队列队首删除一个元素
    //成功true  失败（队列为空）false
    public boolean deQueue() {
        if(size == 0) {
            return false;
        }

        size--;
        frontIndex++;
        if(frontIndex == array.length) {
            frontIndex = 0;//让frontIndex指向0索引
        }
        return false;
    }

    //返回队首元素
    //如果队列为空，返回-1
    public int Front() {
        if(size == 0) {
            return -1;
        }

        return array[frontIndex];
    }

    //返回队尾元素
    //如果队列为空，返回-1
    public int Rear() {
        if(size == 0) {
            return -1;
        }

        int index = rearIndex - 1;
        if(index == -1) {//如果rearIndex指向0索引
            index = array.length - 1;
        }
        return array[index];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }
}
