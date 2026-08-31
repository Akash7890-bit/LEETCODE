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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       
        List<List<Integer>>ans=new ArrayList<>();
         if(root==null){
            return ans;
        }
        Queue<TreeNode>qu=new LinkedList<>();
        boolean leftToRight=true;
        qu.offer(root);
        while(!qu.isEmpty()){
            List<Integer>level=new ArrayList<>();
            int size=qu.size();
            for(int i=0;i<size;i++){
                TreeNode node=qu.poll();
                level.add(node.val);
                if(node.left!=null){
                    qu.offer(node.left);
                }
                if(node.right!=null){
                    qu.offer(node.right);
                }
            }
            if(!leftToRight){
                Collections.reverse(level);
            }
            ans.add(level);
            leftToRight=!leftToRight;
        }
        return ans;
    }
}