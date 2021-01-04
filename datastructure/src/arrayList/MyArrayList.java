package arrayList;

import java.util.Arrays;

public class MyArrayList {
    public int[] elem;
    public int usedSize;

    public MyArrayList() {
        this.elem = new int[10];
        this.usedSize = 0;
    }


    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        if(pos < 0 || pos > usedSize) {
            System.out.println("该位置不合法");
            return;
        }
        if(this.usedSize == this.elem.length) {
            this.elem = Arrays.copyOf(this.elem, 2 * this.elem.length);
        }
        for(int i = this.usedSize - 1; i >= pos; i--) {
            this.elem[i + 1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
    }
    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        if(this.search(toFind) == -1) {
            return false;
        }
        return true;
    }
    // 查找某个元素对应的位置
    public int search(int toFind) {
        for(int i = 0; i < this.usedSize; i++) {
            if(this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }
    // 获取 pos 位置的元素
    public int getPos(int pos) {
        if(pos < 0 || pos > this.usedSize) {
            System.out.println("该位置不合法");
            return -1;
        }
        return this.elem[pos];
    }
    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
        if(pos < 0 || pos > this.usedSize) {
            System.out.println("该位置不合法");
            return;
        }
        this.elem[pos] = value;
    }
    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        int index = this.search(toRemove);
        if(index == -1) {
            System.out.println("没有该数字！");
            return;
        }
        for(int i = index; i < this.usedSize - index; i++) {
            this.elem[i] = this.elem[i + 1];
        }
        this.usedSize--;
    }
    // 获取顺序表长度
    public int size() {
        return this.usedSize;
    }
    // 清空顺序表
    /*
        如果数组中存在的是引用类型，需要将其赋值为null
     */
    public void clear() {
        this.usedSize = 0;
    }
    // 打印顺序表
    public void display() {
        for(int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }
}
