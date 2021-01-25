package binarytree.leetcode;

import binarytree.BuildTree;
import binarytree.TreeNode;

public class isSameTree {
    //相同的树
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }

//        return p.v == q.v && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

        boolean isRootValueEquals = p.v == q.v;
        if(isRootValueEquals == false) {
            return false;
        }
        boolean isLeftSubTreeSame = isSameTree(p.left, q.left);
        if(isLeftSubTreeSame == false) {
            return false;
        }
        boolean isRightSubTreeSame = isSameTree(p.right, p.right);
        return isRootValueEquals && isLeftSubTreeSame && isRightSubTreeSame;
    }

    public static void main(String[] args) {
        TreeNode p = BuildTree.buildTree2();
        TreeNode q = BuildTree.buildTree3();

        isSameTree s = new isSameTree();
        System.out.println(s.isSameTree(p, q));
    }

}
