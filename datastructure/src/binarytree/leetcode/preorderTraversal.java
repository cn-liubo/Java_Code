package binarytree.leetcode;

import binarytree.BuildTree;
import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class preorderTraversal {

    //二叉树的前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root != null) {
            list.add(root.v);

            //进行左子树的遍历
            List<Integer> leftSubTreeList = preorderTraversal(root.left);
            //把遍历完的结果List中的所有内容，全部插到list中
            list.addAll(leftSubTreeList);

            List<Integer> rightSubTreeList = preorderTraversal(root.right);
            //把遍历完的结果List中的所有内容，全部插到list中
            list.addAll(rightSubTreeList);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = BuildTree.buildTree1();

        preorderTraversal p = new preorderTraversal();
        System.out.println(p.preorderTraversal(root));


    }
}
