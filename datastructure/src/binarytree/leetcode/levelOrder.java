package binarytree.leetcode;

import binarytree.BuildTree;
import binarytree.TreeNode;
import binarytree.TreeNode2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrder {

    static class NL {
        TreeNode node;
        int level;
        NL (TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Queue<NL> queue = new LinkedList<>();
        queue.add(new NL(root, 0));

        while(!queue.isEmpty()) {
            NL n = queue.remove();
            TreeNode node = n.node;
            int level = n.level;

            //控制放到那个内侧的List以及是否需要新创建内侧List
            if(level == list.size()) {
                //需要在List中新增加一个List
                list.add(new ArrayList<>());
            }

            List<Integer> innerList = list.get(level);
            innerList.add(node.v);

            //继续层序遍历
            if(node.left != null) {
                queue.add(new NL(node.left, level + 1));
            }
            if(node.right != null) {
                queue.add(new NL(node.right, level + 1));
            }
        }
        return list;
    }


    /*//此题的准备
    //带层级的层序遍历
    static class NL {
        TreeNode2 node;
        int level;
        NL(TreeNode2 node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    public static void levelOrderWithLevel(TreeNode2 root) {
        if(root == null) {
            return;
        }
        Queue<NL> queue = new LinkedList<>();
        queue.add(new NL(root, 1));

        while(!queue.isEmpty()) {
            NL nl = queue.remove();
            TreeNode2 node = nl.node;
            int level = nl.level;

            System.out.println(level);
            System.out.println(node.val);

            if(node.left != null) {
                queue.add(new NL(node.left, level + 1));
            }
            if(node.right != null ) {
                queue.add(new NL(node.right, level + 1));
            }
        }
    }
    public static void main(String[] args) {
        TreeNode2 root = BuildTree.buildTree4();

        System.out.println("=================================");
        levelOrderWithLevel(root);
    }*/

}
