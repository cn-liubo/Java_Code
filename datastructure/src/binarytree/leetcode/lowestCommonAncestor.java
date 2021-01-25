package binarytree.leetcode;

public class lowestCommonAncestor {

    /**
     * 二叉树的最近公共祖先
     *
     * 1.两个结点都出现在左子树中，分别去左右子树找
     * 2.两个结点都出现在右子树中，分别去左右子树找
     * 3.一个在左子树，一个在右子树，只能自己是最近的公共祖先
     * 4.一个是根，一个在子树中，只能自己是最近的公共祖先
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q) {
            //其中一个结点就是该树的根
            //另一个结点必然在子树中
            //最近的公共祖先只能是根
            return root;
        }

        boolean pInLeft = search(root.left, p);
        boolean qInLeft = search(root.left, q);

        if(pInLeft && qInLeft) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if(!pInLeft && ! qInLeft) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }

    private boolean search(TreeNode root, TreeNode t) {
        if(root == null) {
            return false;
        }

        if(root == t) {
            return true;
        }
        if(search(root.left, t)) {
            return true;
        }
        return search(root.left, t);
    }
}
