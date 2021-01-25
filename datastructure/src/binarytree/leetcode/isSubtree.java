package binarytree.leetcode;

import binarytree.TreeNode;

public class isSubtree {

    //另一个树的子树
    /*
        在以s为根的树中，查找t这个结点（只要结点的值相等即可，不要求是同一个结点）
        如果没找到，说明以s为根的这棵树中没有以t为根的子树
        如果找到了，检查以找到的这个结点为根的树是否和t树相等，如果不相等，继续找
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return search(s, t);
    }
    public boolean search(TreeNode root, TreeNode t) {
        if(root == null) {
            return false;
        }

//        if(root.v == t.v) {
//            if(isSameTree(root, t)) {
//                return true;
//            }
//        }

        if(isSameTree(root, t)) {
            return true;
        }

        if(search(root.left, t)) {
            return true;
        }
        return search(root.right, t);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        return p.v == q.v && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
