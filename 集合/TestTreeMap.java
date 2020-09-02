package 集合;

import java.util.TreeMap;

public class TestTreeMap {
    public static void main(String[] args) {

        TreeMap<Integer,String> treeMap = new TreeMap<Integer,String>();
        treeMap.put(5,"e");//treeMap集合中的key需要可比较的  key的对象需要实现Comparable接口
        treeMap.put(2,"b");
        treeMap.put(3,"c");
        treeMap.put(7,"g");
        treeMap.put(1,"a");
        treeMap.put(8,"h");
        treeMap.put(9,"i");
        treeMap.put(2,"d");
        treeMap.put(6,"f");
        System.out.println(treeMap);//{1=a, 2=d, 3=c, 5=e, 6=f, 7=g, 8=h, 9=i}
    }
}
