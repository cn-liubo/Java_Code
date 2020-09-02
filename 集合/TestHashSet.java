package 集合;

import java.util.HashSet;
import java.util.Iterator;

public class TestHashSet {

    public static void main(String[] args){
        HashSet<String> stringHashSet = new HashSet<>();
        stringHashSet.add(new String("小小"));
        stringHashSet.add(new String("小小"));
        stringHashSet.add(new String("小小"));
        stringHashSet.add(new String("小小"));
        stringHashSet.add(new String("小小"));
        System.out.println(stringHashSet.size());//1

        HashSet<Person> personHashSetSet = new HashSet<Person>();
        personHashSetSet.add(new Person("小小",1));
        personHashSetSet.add(new Person("小小",2));
        personHashSetSet.add(new Person("小小",3));
        personHashSetSet.add(new Person("小小",4));
        personHashSetSet.add(new Person("小小",5));
        System.out.println(personHashSetSet.size());//5 --> 1
        System.out.println(personHashSetSet);//[{小小--1}]
        //System.out.println(personSet.iterator().next().getTestNum());//1

//        HashSet<String> hashSet = new HashSet<>();
//        hashSet.add("A");
//        hashSet.add("C");
//        hashSet.add("b");
//        hashSet.add("a");
//        hashSet.add("B");
//        hashSet.add("c");
//        //获取一个迭代器对象  通过hashSet集合获取
//        Iterator<String> it = hashSet.iterator();//Iterator接口 多态的效果
//        //判断下一个是否有元素
//        while(it.hasNext()){
//            String value = it.next();
//            System.out.println(value);
//        }
////        for(String v:hashSet){
////            System.out.println(v);
////        }
//        System.out.println(hashSet);
//        hashSet.remove("B");
//        System.out.println(hashSet);
    }
}
