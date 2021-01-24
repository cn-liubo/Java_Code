package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeLevelOrder {
    public static void levelOrderTraversal(TreeNode2 root) {
        if(root == null) {
            //对于一颗空树，层序遍历，没有什么可做的
            return;
        }
        //队列的元素时树的结点
        Queue<TreeNode2> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode2 node = queue.remove();//node就是层序遍历时经过的结点，暂时通过打印观察结果
            System.out.println(node.val);

            if(node.left != null) {
                //node有左子结点
                queue.add(node.left);
            }

            if(node.right != null) {
                queue.add(node.right);
            }
        }
    }


    //判断一颗树是不是完全二叉树
    public static boolean isCompleteTree(TreeNode2 root) {
        Queue<TreeNode2> queue = new LinkedList<>();
        queue.add(root);

        while(true) {
            TreeNode2 node = queue.remove();
            if(node == null) {
                //遇到node == null 之前，可能出现queue.isEmpty()的情况吗？
                //不可能
                break;
            }

            //不需要打印
            //直接把左右子结点翻入队列中（不管是不是null）
            queue.add(node.left);
            queue.add(node.right);
        }

        //检查队列中是不是全是null
        //检查的方式，将队列中剩余的元素取出来看一看
        while(!queue.isEmpty()) {
            TreeNode2 node = queue.remove();
            if(node == null) {
                //一个结点为null，不能说明是完全二叉树
            } else {
                //一个结点不为null，可以说明不是完全二叉树
                return false;
            }
        }

        return true;
    }



    public static void main(String[] args) {
        TreeNode2 root = BuildTree.buildTree4();

        levelOrderTraversal(root);
    }
}
