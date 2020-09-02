package 集合;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class TestHashMap {

    public static void main(String[] args) {

        //创建一个HashMap对象
        HashMap<Integer,String> hashMap = new HashMap<>();
        //将一些key-value的映射关系存入集合
        hashMap.put(2,"bbb");
        hashMap.put(5,"eee");
        hashMap.put(6,"aaa");//key不同  value与1相同
        hashMap.put(4,"ddd");
        hashMap.put(3,"ccc");
        hashMap.put(5,"xxx");//key相同  value与之前的5不同
        hashMap.put(1,"aaa");
//        System.out.println(hashMap);// {1=aaa, 2=bbb, 3=ccc, 4=ddd, 5=xxx, 6=aaa}
//        hashMap.remove(3);
//        System.out.println(hashMap);

        hashMap.putIfAbsent(2,"yyy");//如果存在2,就不覆盖；如果不存在，就添加
        System.out.println(hashMap);
        System.out.println(hashMap.getOrDefault(10,"1000"));

        //遍历
//        //获取hashMap的全部key
//        Set<Integer> keys = hashMap.keySet();
//        //通过迭代器遍历keys
//        Iterator<Integer> it= keys.iterator();
//        while(it.hasNext()){
//            Integer key = it.next();
//            String value = hashMap.get(key);
//            System.out.println(key+"--"+value);
//        }
        Set<Entry<Integer,String>> entrys = hashMap.entrySet();//获取集合中全部的entry对象
        Iterator<Entry<Integer,String>> it = entrys.iterator();
        while(it.hasNext()){
            Entry<Integer,String> entry = it.next();//entry key value
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key+"--"+value);
        }



    }
}
