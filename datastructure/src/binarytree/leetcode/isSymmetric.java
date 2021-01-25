package binarytree.leetcode;

import binarytree.TreeNode;

public class isSymmetric {
    //对称二叉树
    public boolean isSymmetric(TreeNode root) {
        //1.如果二叉树是空树，则二叉树是镜像对称的
        //2.如果二叉树不是空树，只有它的左右子树互为镜像，才是镜像对称的
        if(root == null) {
            return true;
        }
        return isMirrorTree(root.left, root.right);
    }
    public boolean isMirrorTree(TreeNode p ,TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }

        return p.v == q.v && isMirrorTree(p.left, q.right) && isMirrorTree(p.right, q.left);
    }
}
