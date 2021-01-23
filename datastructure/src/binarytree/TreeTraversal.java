package binarytree;

public class TreeTraversal {

    //对root为根的树进行遍历
    //遍历的对象是树，不是结点
    //虽然我们的形参看起来是结点，但实际上是以该结点为根的树
    //为了结点，我们只进行结点的值的打印
    public static void preTraversal(TreeNode root) {
        if(root != null) {
            //下面的处理，有个前提，这棵树不是空树（根结点存在）
            //1.首先处理根节点
            System.out.printf("%c", root.v);
            //2.按照前序的方式，递归处理该结点的左子树
            preTraversal(root.left);
            //3.按照前序的方式，递归处理该结点的右子树
            preTraversal(root.right);
        }
    }
    public static void preTraversal2(TreeNode root) {
        if(root != null) {
            System.out.printf("%c", root.v);
            System.out.println(" {");
            preTraversal(root.left);
            System.out.println("} {");
            preTraversal(root.right);
            System.out.println("}");
        }
    }

    public static void inTraversal(TreeNode root) {
        if(root != null) {
            //只要传入了结点进来

            //1.中序遍历左子树
            inTraversal(root.left);
            //2.处理根结点
            System.out.printf("%c", root.v);
            //中序遍历右子树
            inTraversal(root.right);
        }
    }

    public static void postTraversal(TreeNode root) {
        if(root != null) {
            postTraversal(root.left);
            postTraversal(root.right);
            System.out.printf("%c", root.v);
        }
    }

    public static void main(String[] args) {
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


        System.out.println("先序遍历：");
        preTraversal(a);
        System.out.println();
        System.out.println("中序遍历：");
        inTraversal(a);
        System.out.println();
        System.out.println("后序遍历：");
        postTraversal(a);

    }
}
