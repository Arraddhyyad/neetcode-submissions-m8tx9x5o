/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    PriorityQueue<TreeNode> que = new PriorityQueue<>((a,b)->b.val - a.val);

    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return 0;
        dfs(root, k);
        return que.peek().val;
    }

    public void dfs(TreeNode root, int k){
        if (root == null) return;
        que.offer(root);

        if(que.size()>k)
            que.poll();

        dfs(root.left, k);
        dfs(root.right, k);
    }
}
