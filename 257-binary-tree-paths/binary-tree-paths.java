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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list=new ArrayList<>();
        findPaths(root, list, "");
        return list;
    }
    void findPaths(TreeNode root, List<String> list, String str){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            str+=+root.val;
            list.add(str);
        }
        str+=root.val+ "->";
        findPaths(root.left, list, str);
        findPaths(root.right, list, str);
    }
}