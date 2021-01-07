package list;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Person p1 = new Person(1, "刘");
        Person p2 = new Person(1, "王");
        List list = new ArrayList();
        list.add(p1);

        System.out.println(p1.equals(p2));
        System.out.println(list.contains(p2));
        System.out.println(list.indexOf(p2));

    }
}

class Person {
    int id;
    String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(obj == this) {
            return true;
        }
        if(obj instanceof Person) {
            Person p = (Person) obj;
            return this.id == p.id;
        }
        return false;
    }
}