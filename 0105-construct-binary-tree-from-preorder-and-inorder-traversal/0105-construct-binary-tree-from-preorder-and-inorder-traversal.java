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
    HashMap<Integer,Integer>map=new HashMap<>();
        int pIndex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(preorder,0,inorder.length-1);
    }
    private TreeNode build(int[]preOrder,int left,int right){
        if(left>right){
            return null;
        }
        TreeNode root=new TreeNode(preOrder[pIndex++]);
        int inIndex=map.get(root.val);
        root.left=build(preOrder,left,inIndex-1);
        root.right=build(preOrder,inIndex+1,right);
        return root;
    }
}