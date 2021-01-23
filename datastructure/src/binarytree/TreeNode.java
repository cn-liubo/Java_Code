package binarytree;

public class TreeNode {

    public int v;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return String.format("%c", v);
    }
}
