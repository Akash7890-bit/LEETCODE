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
     int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
      
      dfs(root);
      return max;
        
         

    }
    int dfs(TreeNode node){
        if(node==null){
            return 0;
        }
        int L=Math.max(0,dfs(node.left));
        int R=Math.max(0,dfs(node.right));
        int currPath=Math.max(node.val,node.val+L+R);
        max=Math.max(max,currPath);
        return node.val+Math.max(L,R);
    }
}