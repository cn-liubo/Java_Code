package binarytree.leetcode;

/*
    搜索树：二叉树中的任意结点，要求左子树中的所有值 < 根的值，并且右子树中的所有值 > 根的值
    中序遍历是有序
 */
public class Convert {

    private TreeNode head;//链表的头结点
    private TreeNode last;//链表的最后一个结点

    //纯链表尾插的代码（双向链表） 创建新节点
    //left-->prev right-->next
    private void add(TreeNode node) {
        TreeNode newNode = new TreeNode(node.val);

        if(last == null) {
            head = last = newNode;
        } else {
            last.right = newNode;
        }
        newNode.left = last;
        last = newNode;
    }

    //纯链表尾插的代码（双向链表） 不创建新节点
    //可以动node的left，不能动node的right，为什么？
    private void add2(TreeNode node) {
        if(last == null) {
            head = node;
        } else {
            last.right = node;
        }
        node.left = last;
        last = node;
    }

    private void inOrder(TreeNode node) {
        if(node != null) {
            inOrder(node.left);
            add(node);//这里的调用add，保证（1.每个结点都会调用一次，2.调用次序一定是有序的）
            inOrder(node.right);
        }
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        head = last = null;
        inOrder(pRootOfTree);
        return head;
    }
}
