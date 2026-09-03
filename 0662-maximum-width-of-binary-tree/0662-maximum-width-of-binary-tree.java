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
    class pair{
        TreeNode node;
        long idx;
        pair(TreeNode node,long idx){
            this.node=node;
            this.idx=idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<pair>qu=new LinkedList<>();
        int maxWidth=0;
        qu.offer(new pair(root,0));
        while(!qu.isEmpty()){
            int size=qu.size();
            long first=qu.peek().idx;
            long last=first;
            for(int i=0;i<size;i++){
                pair curr=qu.poll();
                last=curr.idx;
                if(curr.node.left!=null){
                    qu.offer(new pair(curr.node.left,2*curr.idx));
                }
                if(curr.node.right!=null){
                    qu.offer(new pair(curr.node.right,2*curr.idx+1));
                }



            }
            maxWidth=Math.max(maxWidth,(int)(last-first+1));
        }
        return maxWidth;
    }
}