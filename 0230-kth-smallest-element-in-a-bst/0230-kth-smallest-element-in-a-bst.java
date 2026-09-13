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
    int count=0;
    int result=0;
    public int kthSmallest(TreeNode root, int k) {
       
        element(root,k);
        return result;
    }
    void element(TreeNode node,int k){
        if(node==null){
            return;
        }
        
        element(node.left,k);
        count++;
        if(count==k){
            result=node.val;
            return;
        }
        if(count>k){
            return;
        }
        element(node.right,k);
        if(count==k){
            return;
        }
        

    }
}