package 集合;

import java.util.TreeSet;

public class TestTreeSet {

    public static void main(String[] args) {

        TreeSet<String> stringTreeSetSet = new TreeSet<>();
        stringTreeSetSet.add(new String("小小"));
        stringTreeSetSet.add(new String("小小"));
        stringTreeSetSet.add(new String("小小"));
        stringTreeSetSet.add(new String("小小"));
        stringTreeSetSet.add(new String("小小"));
        System.out.println(stringTreeSetSet.size());//1  set家族如有相同的对象，拒接存入
        System.out.println(stringTreeSetSet);//集合本身有自己的排布顺序

        TreeSet<Person> personTreeSetSet = new TreeSet<>();
        personTreeSetSet.add(new Person("小小",1));
        personTreeSetSet.add(new Person("小小",2));
        personTreeSetSet.add(new Person("小小",3));
        personTreeSetSet.add(new Person("小小",4));
        personTreeSetSet.add(new Person("小小",5));
        System.out.println(personTreeSetSet.size());//1
        System.out.println(personTreeSetSet);
        //出现ClassCastException-->造型异常
    }
}
