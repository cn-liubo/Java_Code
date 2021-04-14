```java
public class TreeNode {
	int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
```



```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> fatherMap = new HashMap<>();//当前结点，其父结点
        fatherMap.put(root, root);
        process(root, fatherMap);
        Set<TreeNode> set = new HashSet<>();
        TreeNode cur = p;
        while(cur != fatherMap.get(cur)) {
            set.add(cur);
            cur = fatherMap.get(cur);
        }
        set.add(root);

        cur = q;
        while(cur != fatherMap.get(cur)) {
            if(set.contains(cur)) {
                return cur;
            }
            cur = fatherMap.get(cur);
        }
        return root;
    }

    public void process(TreeNode root, Map<TreeNode, TreeNode> fatherMap) {
        if(root == null) {
            return;
        }
        fatherMap.put(root.left, root);
        fatherMap.put(root.right, root);

        process(root.left, fatherMap);
        process(root.right, fatherMap);
    }
}
```



```java
class Solution {
    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(root == null || root == p || root == q) {
            return root;
        }

        Node left = lowestAncestor1(root.left, p, q);
        Node right = lowestAncestor1(root.right, p, q);
        if(left != null && right != null) {
            return root;
        }
        //左右两棵树，并不都有返回值
        return left != null ? left : right;
	}
}
```

