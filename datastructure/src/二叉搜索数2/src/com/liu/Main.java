package com.liu;

import com.liu.printer.BinaryTrees;
import com.liu.tree.BST;
import org.junit.Test;

public class Main {
    @Test
    public void test1() {
        BST<Integer> bst = new BST<>();
        Integer[] date = new Integer[]{7, 4, 9, 2, 5, 8, 11, 3, 12, 1};

        for(int i = 0; i < date.length; i++) {
            bst.add(date[i]);
        }

        BinaryTrees.println(bst);

        bst.remove(7);
        BinaryTrees.println(bst);

    }
}
