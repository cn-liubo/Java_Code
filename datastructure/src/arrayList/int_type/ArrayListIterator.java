package arrayList.int_type;

public class ArrayListIterator implements Iterator{
    //对一个顺序表做迭代，关键是—控制下标
    private ArrayList list;//我们要迭代（遍历）的顺序表
    private int index;//我们现在在顺序表的哪个位置

    public ArrayListIterator(ArrayList list) {
        this.list = list;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    //作用：1.返回迭代器当前所在位置的元素  2.让迭代器走到下一个位置
    @Override
    public Integer next() {
        return list.get(index++);
    }

    @Override
    public void remove() {

    }
}
