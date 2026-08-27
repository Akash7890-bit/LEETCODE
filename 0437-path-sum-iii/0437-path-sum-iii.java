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
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return 0;
        }
        dfs(root,(long)targetSum);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        return ans;
       
    }
    public void dfs(TreeNode node,long target){
        if(node==null){
            return;

        }
        
        if(target==node.val){
            ans++;
            
            
        }
        dfs(node.left,target-node.val);
        dfs(node.right,target-node.val);
        
        
    }
}