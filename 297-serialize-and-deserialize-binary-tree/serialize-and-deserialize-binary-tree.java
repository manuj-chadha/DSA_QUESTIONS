/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public String serialize(TreeNode node){
        StringBuilder sb=new StringBuilder("");

        helper(node, sb);
        return sb.toString();
    }

    private void helper(TreeNode root, StringBuilder sb) {
        if(root==null){

            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        helper(root.left, sb);
        helper(root.right, sb);
    }
    public TreeNode deserialize(String string) {
        String[] str=string.split(",");
        int[] index={0};
        TreeNode node=deserializeH(str, index);
        return node;
    }

    private TreeNode deserializeH(String[] str, int[] length) {
        if(length[0]>=str.length || str[length[0]].equals("null")){
            length[0]++;
            return null;
        }
        TreeNode node=new TreeNode(Integer.parseInt(str[length[0]++]));
        node.left=deserializeH(str, length);
        node.right=deserializeH(str, length);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));