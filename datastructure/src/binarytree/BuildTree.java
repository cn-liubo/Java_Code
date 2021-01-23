package binarytree;

public class BuildTree {
    public static TreeNode buildTree1() {
        //先构造结点
        TreeNode a = new TreeNode('A');
        TreeNode b = new TreeNode('B');
        TreeNode c = new TreeNode('C');
        TreeNode d = new TreeNode('D');
        TreeNode e = new TreeNode('E');
        TreeNode f = new TreeNode('F');
        TreeNode g = new TreeNode('G');
        TreeNode h = new TreeNode('H');
        TreeNode i = new TreeNode('I');
        TreeNode j = new TreeNode('J');
        //把结点之间的关系，按照图连接起来
        a.left = b;
        a.right = c;

        b.left = d;
        b.right = null;

        c.left = e;
        c.right = f;

        d.left = null;
        d.right = g;

        e.left = null;
        e.right = null;

        f.left = h;
        f.right = i;

        g.left = j;
        g.right = null;

        h.left = null;
        h.right = null;

        i.left = null;
        i.right = null;

        j.left = null;
        j.right = null;

        return a;
    }

    public static TreeNode buildTree2() {
        TreeNode a = new TreeNode('A');
        TreeNode b = new TreeNode('B');
        TreeNode c = new TreeNode('C');
        TreeNode d = new TreeNode('D');

        a.left = b;
        a.right = c;
        b.left = d;

        return a;
    }
    public static TreeNode buildTree3() {
        TreeNode a = new TreeNode('A');
        TreeNode b = new TreeNode('B');
        TreeNode c = new TreeNode('C');

        a.left = b;
        a.right = c;

        return a;
    }

    public static TreeNode2 buildTree4() {
        TreeNode2 a = new TreeNode2('A');
        TreeNode2 b = new TreeNode2('B');
        TreeNode2 c = new TreeNode2('C');
        TreeNode2 d = new TreeNode2('D');
        TreeNode2 e = new TreeNode2('E');
        TreeNode2 f = new TreeNode2('F');
        TreeNode2 g = new TreeNode2('G');
        TreeNode2 h = new TreeNode2('H');
        TreeNode2 i = new TreeNode2('I');

        a.left = b;
        a.right = c;
        b.left = d;
        c.left = e;
        c.right = f;
        d.left = g;
        d.right = h;
        e.right = i;

        return a;
    }

}
