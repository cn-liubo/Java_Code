package arrayList.int_type;

public interface List {
    boolean add(Integer e);
    void add(int index, Integer e);

    Integer remove(int index);//根据下标删除
    boolean remove(Integer element);//根据元素删除

    Integer get(int index);
    Integer set(int index, Integer e);

    int size();
    void clear();
    boolean isEmpty();

    boolean contains(Integer e);
    int indexOf(Integer e);
    int lastIndexOf(Integer e);

    Iterator iterator();

}
