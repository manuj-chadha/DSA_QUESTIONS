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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1=new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();
        leafTraversal(root1, list1);
        leafTraversal(root2, list2);
        if(list1.size()!=list2.size()) return false;
        for(int i=0;i<list1.size();i++){
            if(!list1.get(i).equals(list2.get(i))) return false;
        }
        return true;
    }
    private void leafTraversal(TreeNode node, ArrayList<Integer> list){
        if(node==null) return;
        if(node.left==null && node.right==null){
            list.add(node.val);
            return;
        }
        leafTraversal(node.left, list);
        leafTraversal(node.right, list);
    }
}