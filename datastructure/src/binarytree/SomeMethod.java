package binarytree;

/*
    1.空树的情况
    2.非空树
        2.1先从根找起，找到了直接返回
        2.2否则，去左子树找，找到了直接返回
        2.3否则，再去右子树找
 */
public class SomeMethod {

    private static int size;//这里定义的n是静态变量，作用域是看大括号（整个类期间有效）

    /*
        求一棵二叉树有多少个结点
     */
    //返回root为根的树中，有多少个结点
    public static int sumTreeNodeSize(TreeNode root) {
        //int n = 0;
        size = 0;//每次计数之前，先把n归零

        preOrder(root);
        return size;
    }

    //树的结点个数 = 根结点的个数 + 左子树的结点个数 + 右子树的结点个数
    public static int sumTreeNodeSize2(TreeNode root) {
        //root可能有两种情况：
        //1.root != null    root指向了某个结点
        //2.root == null    root没有指向任意结点
        //我们下面的代码中，已经假设了根节点的个数一定树1了

        if (root == null) {
            //root == null代表root没有指向任何结点
            //由于root是一棵树的根，所以根不存在
            //意味着这棵树中一个结点都没有
            //空树
            return 0;
        } else {
            int rootNodeSize = 1;
            int leftSubTreeNodeSize = sumTreeNodeSize2(root.left);
            int rightSubTreeNodeSize = sumTreeNodeSize2(root.right);

            return rootNodeSize + leftSubTreeNodeSize + rightSubTreeNodeSize;
        }
    }

    private static void preOrder(TreeNode root) {
        //1.一个树的结点（root != null） 2.没有结点（root == null）
        //只需要关注情况1
        if(root != null) {
            //处理根的时候不打印，而是n++
            size++;
            preOrder(root.left);
            preOrder(root.right);
        }
    }


    private static int leafSize;

    /*
        求一棵二叉树有多少个叶子结点
     */
    public static int sumTreeLeafNodeSize(TreeNode root) {

        //注意，每次计算叶子结点之前，都必须归零
        leafSize = 0;

        //使用先序遍历方式，经过每一个结点
        preOrder2(root);
        return leafSize;
    }

    public static int sumTreeLeafNodeSize2(TreeNode root) {
        if(root == null) {
            //对于一颗空树，求叶子结点
            //所以，结果是0
            return 0;
        } else if(root.left == null && root.right == null) {
            //root进一步代表的是一棵树
            //以root为根的一棵树
            //root这棵树的根没有左孩子并且没有右孩子


            //对于一颗只有一个结点的树，求叶子结点的个数
            //所以，结果是1
            return 1;
        } else {
            //至少一个以上的结点
            //整棵树的叶子结点个数 = 左子树的叶子结点个数 + 右子树的叶子结点个数
            int leftSubTreeLeafSize = sumTreeLeafNodeSize2(root.left);
            int rightSubTreeLeafSize = sumTreeLeafNodeSize2(root.right);
            return leftSubTreeLeafSize + rightSubTreeLeafSize;
        }
    }

    public static void preOrder2(TreeNode root) {
        if(root != null) {
            //根
            //这个位置，，才是每个结点都会经过的代码
            //所以在这个位置，对root结点进行遍历，单纯的把root看成结点
            if(root.left == null && root.right == null) {
                leafSize++;
            }
            preOrder2(root.left);
            preOrder2(root.right);
        }
    }


    /*
        求一棵二叉树的第k层有多少个结点
     */
    public static int sumKLevelNodeSize(TreeNode root, int k) {
        if(root == null) {
            //1.root代表空树
            return 0;
        } else if(k == 1) {
            //2.root不是空树，但k == 1
            return 1;
        } else {
            //3.其他情况
            int leftSubTreeK_1 = sumKLevelNodeSize(root.left, k - 1);
            int rightSubTreeK_1 = sumKLevelNodeSize(root.right, k - 1);

            return leftSubTreeK_1 + rightSubTreeK_1;
        }

    }


    /*
        求一颗二叉树的高度
     */
    public static int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        } else if(root.left == null && root.right == null){
            return 1;
        } else {
            int leftSubTreeHeight = getHeight(root.left);
            int rightSubTreeHeight = getHeight(root.right);

            return Math.max(leftSubTreeHeight, rightSubTreeHeight) + 1;
        }
    }


    /*
        求一棵二叉树是否有v这个值，找到了返回true；没找到返回false
     */
    public static boolean contains1(TreeNode root, int v) {
        if(root == null) {
            //空树
            return false;
        } else {
            if(root.v == v) {
                //根里找到了
                //没必要再去左右子树找了
                return true;
            } else {
                //根里没找到
                boolean leftSubTreeContains = contains1(root.left, v);
                if(leftSubTreeContains == true) {
                    //左子树里找到了
                    //没必要去右子树中找了
                    return true;
                } else {
                    //左子树里没找到
                    boolean rightSubTreeContains = contains1(root.right, v);
                    if(rightSubTreeContains == true) {
                        //右子树里找到了
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
    }
    public static boolean contains2(TreeNode root, int v) {
        if(root == null) {
            return false;
        }

        //因为上面的条件直接return，什么都不写，也等同于else
        if(root.v == v) {
            return true;
        }

        boolean left = contains2(root.left, v);
        if(left) {
            return true;
        }

        return contains2(root.right, v);
    }


    /*
        求一棵二叉树是否有v这个值，找到了返会包含v的结点；没找到返回null
     */
    public static TreeNode contains3(TreeNode root, int v) {
        if(root == null) {
            //返回没有找到
            return null;
        }

        if(root.v == v) {
            return root;//返回根结点
        }

        TreeNode leftContains = contains3(root.left, v);
        //如何根据leftContains判断是否找到了v
        if(leftContains != null) {
            //在root为根的树的左子树中，找到了v
            return leftContains;
        }

        //左子树中没有找到
        return contains3(root.right, v);
    }


    /*
        在一颗二叉树中，找node是不是树上的结点
     */
    public static boolean contains4(TreeNode root, TreeNode node) {
        if(root == null) {
            return false;
        }

        if(root == node) {
            return true;
        }

        boolean leftContains = contains4(root.left, node);
        if(leftContains == true) {
            return true;
        }

        return contains4(root.right, node);
    }

    public static void main(String[] args) {
        TreeNode root = BuildTree.buildTree1();
        int sum = sumTreeNodeSize(root);
        System.out.println("树的结点个数：" + sum);
        int sum2 = sumTreeNodeSize2(root);
        System.out.println(sum2);

        int count = sumTreeLeafNodeSize(root);
        System.out.println("树的叶子结点个数：" + count);
        int count2 = sumTreeLeafNodeSize2(root);
        System.out.println(count2);

        System.out.println("第1层结点个数：" + sumKLevelNodeSize(root, 1));
        System.out.println("第2层结点个数：" + sumKLevelNodeSize(root, 2));
        System.out.println("第3层结点个数：" + sumKLevelNodeSize(root, 3));
        System.out.println("第4层结点个数：" + sumKLevelNodeSize(root, 4));
        System.out.println("第5层结点个数：" + sumKLevelNodeSize(root, 5));
        System.out.println("第6层结点个数：" + sumKLevelNodeSize(root, 6));
        System.out.println("第7层结点个数：" + sumKLevelNodeSize(root, 7));

        System.out.println("树的高度是：" + getHeight(root));

        System.out.println(contains2(null, 'A'));//false
        System.out.println(contains2(new TreeNode('A'), 'A'));//true
        System.out.println(contains2(new TreeNode('A'), 'Z'));//false
        System.out.println(contains2(root, 'A'));//true
        System.out.println(contains2(root, 'G'));//true
        System.out.println(contains2(root, 'F'));//true
        System.out.println(contains2(root, 'Z'));//false

        TreeNode a = contains3(root, 'A');
        System.out.println(a);
        System.out.printf("%c\n", a.v);

        TreeNode root1 = BuildTree.buildTree1();
        System.out.println(contains4(root, root));//true
        TreeNode b = new TreeNode('A');
        System.out.println(contains4(root, b));//false


    }
}
