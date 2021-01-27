package binarytree.leetcode;

public class tree2str {
    /**
     * 根据二叉树创建字符串
     * 省略括号的情况：
     *    1.如果之后一个结点   3()()-->3
     *    2.有左子树没有右子树 2(4)()-->2(4)
     *    3.没有左子树有右子树 2()(4)-->2()(4)
     */

    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        preOrder(sb, t);
        return sb.toString();
    }

    private void preOrder(StringBuilder sb, TreeNode node) {
        if(node != null) {
            sb.append(node.val);
            if(node.left == null && node.right == null) {
                return;
            } else if(node.left != null && node.right == null) {
                sb.append("(");
                preOrder(sb, node.left);
                sb.append(")");
            } else {

                sb.append("(");
                preOrder(sb, node.left);
                sb.append(")");

                sb.append("(");
                preOrder(sb, node.right);
                sb.append(")");
            }
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);

        /*n1.left = n2;
        n1.right = n3;
        n2.left = n4;*/

        n1.left = n2;
        n1.right = n3;
        n2.right = n4;

        tree2str t = new tree2str();
        System.out.println(t.tree2str(n1));
    }
}
