package binarytree.leetcode;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;

    TreeNode (char val) {
        this.val = val;
    }
}

public class Solution {
    /**
     * 构建二叉树
     * @param in  传入的带空结点的前序遍历序列
     * @param out 是一个空的list
     * @return    构建好的一颗二叉树的根结点
     */
    public static TreeNode buildTree(List<Character> in, List<Character> out) {
        if(in.isEmpty()) {
            //没有序列，只能是空树
            return null;
        }

        //in不是空的
        char rootValue = in.remove(0);
        if(rootValue == '#') {
            //剩下的就是in去除第一个元素
            //in由于调用了remove，已经把第一个元素（下标为0的）取出了
            out.addAll(in);

            //遇到#一定是空树
        }

        //rootValue一定不是#，构建不同的结点和以该结点为根的树
        TreeNode root = new TreeNode(rootValue);

        //构建root的左子树
        //这里的in由于刚才调用过in.remove(0)了，所以已经不包括第一个元素了
        List<Character> rightOut = new ArrayList<>();
        TreeNode left = buildTree(in, rightOut);

        //构建root的右子树
        //这里的rightOut就是构建右子树用的序列
        //构建右子树剩下的序列就是构建整棵树剩下的序列
        TreeNode right = buildTree(rightOut, out);

        root.left = left;
        root.right = right;

        return root;
    }

    /*public static void main(String[] args) {
        System.out.println("is"+ 100 + 5);
        System.out.println(100 + 5 +"is");
        System.out.println("is"+ (100 + 5));
    }*/
}
