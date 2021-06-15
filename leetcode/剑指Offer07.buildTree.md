```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int[] preorder;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return recursive(0, 0, inorder.length - 1);
    }

    public TreeNode recursive(int root, int left, int right) {
        if(left > right) return null;

        TreeNode node = new TreeNode(preorder[root]);
        int idx = map.get(preorder[root]);

        node.left = recursive(root + 1, left, idx - 1);
        node.right = recursive(idx - left + root + 1, idx + 1, right);
        return node;
    }
}
```

