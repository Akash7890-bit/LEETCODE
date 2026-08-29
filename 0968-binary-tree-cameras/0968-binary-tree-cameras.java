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
    public int minCameraCover(TreeNode root) {
        
       int res[]=find(root);
       if(res[0]==0 && res[1]==1){
       ans++;
       }
       return ans;
    }
    public int[]find(TreeNode node){
        if(node==null){
            return new int[]{0,0};
        }
        int []L=find(node.left);
        int R[]=find(node.right);
        if(L[1]==1 || R[1]==1){
            ans++;
            return new int[]{1,0};
        }
        else if(L[0]==0 && R[0]==0){
            return new int[]{0,1};
        }
        else{
            return new int[]{0,0};
        }
    }
}