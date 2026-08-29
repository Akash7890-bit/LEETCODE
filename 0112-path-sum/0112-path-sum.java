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
    int ans=0;
    public boolean hasPathSum(TreeNode root, int targetSum) {
      dfs(root,targetSum); 
      if(ans==1){
        return true;
      } 
      else{
        return false;
      }
    }
    public void dfs(TreeNode node,int target){
        if(node==null){
            
            return;
        }
        if(node.left==null && node.right==null){
            if(node.val==target){
                ans=1;
            }
        }
        dfs(node.left,target-node.val);
        dfs(node.right,target-node.val);


    }
}