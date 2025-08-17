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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int level=0;
        while(!queue.isEmpty()){
            ArrayList<TreeNode> list=new ArrayList<>();
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode element=queue.poll();
                if(level % 2==1) list.add(element);
                if(element.left!=null) queue.add(element.left);
                if(element.right!=null) queue.add(element.right);
            }
            if(level%2==1){
                int i=0;
                int j=list.size()-1;
                while(i<j){
                    int temp=list.get(i).val;
                    list.get(i).val=list.get(j).val;
                    list.get(j).val=temp;
                    i++;
                    j--;
                }
            }
            level++;
        }
        return root;
    }
}