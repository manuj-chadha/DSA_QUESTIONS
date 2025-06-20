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
    int post, in;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        post=postorder.length-1;
        in=inorder.length-1;
        return buildTree(inorder, postorder, Integer.MIN_VALUE);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int stop) {
        if(post<0) return null;

        if(inorder[in]==stop){
            in--;
            return null;
        }
        TreeNode node=new TreeNode(postorder[post--]);
        node.right=buildTree(inorder, postorder, node.val);
        node.left=buildTree(inorder, postorder, stop);
        return node;
    }
}