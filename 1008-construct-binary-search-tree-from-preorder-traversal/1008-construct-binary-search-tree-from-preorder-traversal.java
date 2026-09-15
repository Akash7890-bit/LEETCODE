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
    int preOrderIdx=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder,Integer.MAX_VALUE);
    }

    TreeNode build(int[] preorder,int upperBound){
        
      if(preOrderIdx==preorder.length || preorder[preOrderIdx]>upperBound){
        return null;
      }
      TreeNode curr=new TreeNode(preorder[preOrderIdx++]);
      curr.left=build(preorder,curr.val);
      curr.right=build(preorder,upperBound);
      return curr;
    }
}