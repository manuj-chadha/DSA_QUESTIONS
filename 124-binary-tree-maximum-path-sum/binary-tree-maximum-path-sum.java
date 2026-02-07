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
    int maxValue=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMax(root);
        return maxValue;
    }
    private int findMax(TreeNode root) {
        if(root==null) return 0;
        int left=Math.max(findMax(root.left), 0);
        int right=Math.max(findMax(root.right), 0);
        maxValue=Math.max(maxValue, left+right+root.val);

        return Math.max(root.val+left, root.val+right);
    }
}