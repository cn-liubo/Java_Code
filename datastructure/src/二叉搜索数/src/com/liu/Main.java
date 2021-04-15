package com.liu;

import com.liu.printer.BinaryTrees;
import org.junit.Test;

import java.util.Comparator;

public class Main {
    @Test
    public void test1() {
        Integer[] date = new Integer[]{7, 4, 9, 2, 5, 8, 11, 3, 12, 1};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for(int i = 0; i < date.length; i++) {
            bst.add(date[i]);
        }

        BinarySearchTree<Person> bst2 = new BinarySearchTree<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.getAge() - o1.getAge();
            };
        });
        bst2.add(new Person(12));
        bst2.add(new Person(15));

        BinarySearchTree<Person> bst3 = new BinarySearchTree<>();
        bst3.add(new Person(12));
        bst3.add(new Person(15));

        BinaryTrees.println(bst);

//        System.out.println(bst);
        System.out.println(bst.height1());
        System.out.println(bst.isComplete());

    }

    @Test
    public void test2() {
        BinarySearchTree<Person> bst1 = new BinarySearchTree<>();
        Integer[] date = new Integer[]{7, 4, 9, 2, 5, 8, 11, 3, 12, 1};

        for(int i = 0; i < date.length; i++) {
            bst1.add(new Person(date[i]));
        }
//        BinaryTrees.println(bst1);

        BinarySearchTree<Person> bst2 = new BinarySearchTree<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.getAge() - o1.getAge();
            };
        });
        for(int i = 0; i < date.length; i++) {
            bst2.add(new Person(date[i]));
        }
        BinaryTrees.println(bst2);

    }

    @Test
    public void test3() {
        Integer[] data = new Integer[]{7, 4, 9, 2, 5};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }

        BinaryTrees.println(bst);
    }

    @Test
    public void test4() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Integer[] date = new Integer[]{7, 4, 9, 2, 5, 8, 11, 3, 12, 1};

        for(int i = 0; i < date.length; i++) {
            bst.add(date[i]);
        }

        BinaryTrees.println(bst);

        bst.remove(7);
        BinaryTrees.println(bst);

    }
}
