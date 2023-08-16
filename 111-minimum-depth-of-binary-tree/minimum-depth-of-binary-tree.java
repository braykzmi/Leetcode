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
    public int minDepth(TreeNode root) {

        // simple case depth 0 & 1
        if (root == null) {
            return 0;
        }
        
        if (root.left == null && root.right == null) {
            return 1;
        }
        
        // recursive search bst algo
        int minDepth = Integer.MAX_VALUE;
        
        // right search case
        if (root.left != null) {
            minDepth = Math.min(minDepth, minDepth(root.left));
        }
        
        // left search case
        if (root.right != null) {
            minDepth = Math.min(minDepth, minDepth(root.right));
        }
        
        return minDepth + 1;
    }
}

