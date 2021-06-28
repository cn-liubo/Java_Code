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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) {
            queue.offer(root);
        }
        int count = 1;
        while(!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            count++;
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if(count % 2 != 0) tmp.addFirst(node.val);
                else tmp.addLast(node.val);
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }
}
```

