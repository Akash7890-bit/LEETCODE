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
    int postOrderIdx=0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer>map=new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        reverse(postorder);
        return build(inorder,postorder,0,inorder.length-1,map);
    }
    private TreeNode build(int[] inorder, int[] postorder,int left,int right,HashMap<Integer,Integer>map){
        if(left>right){
            return null;
        }
        TreeNode node=new TreeNode(postorder[postOrderIdx++]);
        
        int inorderIdx=map.get(node.val);
        node.right=build(inorder,postorder,inorderIdx+1,right,map);
        node.left=build(inorder,postorder,left,inorderIdx-1,map);
       
        return node;

    }
    private void reverse(int[]array){
        if (array == null || array.length <= 1) {
            return;
        }
        
        int start = 0;
        int end = array.length - 1;
        
        while (start < end) {
            // Swap elements using a temporary variable
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            
            // Move pointers closer to the center
            start++;
            end--;
        }
    }
}