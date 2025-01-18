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
    int min=Integer.MAX_VALUE;
    TreeNode visitedNode=null;
    public int getMinimumDifference(TreeNode root) {
        getMin(root);
        return min;
    }
    private void getMin(TreeNode root){
        if(root==null){
            return;
        }
        getMin(root.left);
        if(visitedNode!=null){
            min=Math.min(min, Math.abs(visitedNode.val-root.val));
        }
        visitedNode=root;
        getMin(root.right);
    }
}