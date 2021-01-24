package binarytree;

import java.util.ArrayList;
import java.util.List;

public class Solution {

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

    //相同的树
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }

        return p.v == q.v && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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

    //对称二叉树
    public boolean isSymmetric(TreeNode root) {
        //1.如果二叉树是空树，则二叉树是镜像对称的
        //2.如果二叉树不是空树，知有它的左右子树互为镜像，才是镜像对称的
        if(root == null) {
            return true;
        }
        return isMirrorTree(root.left, root.right);
    }


    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        return p.v == q.v && isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right);
    }
    public boolean search(TreeNode root, TreeNode t) {
        if(root == null) {
            return false;
        }
        /*if(root.v == t.v) {
            if(isSameTree(root, t)) {
                return true;
            }
        }*/
        if(isSameTree(root, t)) {
            return true;
        }
        if(search(root.left, t)) {
            return true;
        }
        return search(root.right, t);
    }
    //另一个树的子树
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return search(s, t);
    }

    public static void main(String[] args) {
        TreeNode root = BuildTree.buildTree1();

        Solution solution = new Solution();
        System.out.println(solution.preorderTraversal(root));


        TreeNode p = BuildTree.buildTree2();
        TreeNode q = BuildTree.buildTree3();

        System.out.println(solution.isSameTree(p, q));

    }

}

