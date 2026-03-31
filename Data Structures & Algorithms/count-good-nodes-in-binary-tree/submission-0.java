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
    
    record Entry(TreeNode curr, int max){}
    public int goodNodes(TreeNode root) {
        int count = 0;
        if(root==null)
            return 0;
        
        Deque<Entry> st = new ArrayDeque<>();
        st.push(new Entry(root, Integer.MIN_VALUE));

        while(!st.isEmpty()){
            Entry e = st.pop();
            if(e.curr.val >=e.max)
                count++;

            int newMax = e.max>=e.curr.val? e.max: e.curr.val;
            if(e.curr.left!=null) st.push(new Entry(e.curr.left, newMax));
            if(e.curr.right!=null) st.push(new Entry(e.curr.right, newMax));
        }

        return count;
    }
}
