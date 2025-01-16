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
    int sum=0;
    public int sumNumbers(TreeNode root) {
        sumNumbers(root, 0);
        return sum;
    }
    private void sumNumbers(TreeNode root, int num){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            sum+=num*10+root.val;
            return;
        }
        num=num*10+root.val;
        sumNumbers(root.left, num);
        sumNumbers(root.right, num);
    }
}