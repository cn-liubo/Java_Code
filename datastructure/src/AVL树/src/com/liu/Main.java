package com.liu;

import com.liu.printer.BinaryTrees;
import com.liu.tree.AVLTree;
import org.junit.Test;

import java.util.Arrays;

public class Main {
    @Test
    public void test1() {
        AVLTree<Integer> avl = new AVLTree<>();
        Integer[] date = new Integer[]{85, 19, 69, 3, 7, 99, 95, 2, 1, 70, 44, 58, 11, 21, 14, 93, 57, 4, 56};

        for(int i = 0; i < date.length; i++) {
            avl.add(date[i]);
        }

        BinaryTrees.println(avl);

    }

    @Test
    public void test2() {
        AVLTree<Integer> avl = new AVLTree<>();
        Integer[] date = new Integer[]{85, 19, 69, 3, 7, 99, 95};

        for(int i = 0; i < date.length; i++) {
            avl.add(date[i]);
//            System.out.println("[" + date[i] + "]");
//            BinaryTrees.println(avl);
//            System.out.println("---------------------------");
        }

        BinaryTrees.println(avl);
        avl.remove(69);
        BinaryTrees.println(avl);

    }

    @Test
    public void test3() {
        System.out.println(1 << 30);
        String s = "We are happy.";
        String[] str = s.split(" ");
        System.out.println(Arrays.toString(str));
    }
}
