/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashSet<TreeNode>set=new HashSet<>();
    HashMap<TreeNode,TreeNode>map=new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        buildNodes(root,null);
        
        Queue<TreeNode>queue=new LinkedList<>();
        ArrayList<Integer>ans=new ArrayList<>();
        queue.offer(target);
        set.add(target);
        int distance=0;
    while(!queue.isEmpty()){
        if(distance==k){
            break;
        }
        int size=queue.size();
        for(int i=0;i<size;i++){

        TreeNode curr=queue.poll();
        
        if(curr.left!=null && set.add(curr.left)){
            queue.offer(curr.left);
        }
        if(curr.right!=null && set.add(curr.right)){
            queue.offer(curr.right);
        }
        if(map.get(curr)!=null && set.add(map.get(curr))){
            queue.offer(map.get(curr));
        }
        }
        distance++;

    }
    while(!queue.isEmpty()){
         ans.add(queue.poll().val);
    }
    return ans;

}
    private void buildNodes(TreeNode root,TreeNode par){
        if(root==null){
            return;
        }
        map.put(root,par);
        buildNodes(root.left,root);
        buildNodes(root.right,root);
    }
}