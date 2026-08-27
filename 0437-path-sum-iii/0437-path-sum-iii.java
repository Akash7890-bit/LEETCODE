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
    public int pathSum(TreeNode root, int targetSum) {
        
        Map<Long, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0L, 1);

        int count = dfs(root, targetSum, prefixCount, 0L);
        return count;
    }

    private int dfs(TreeNode root, int targetSum, Map<Long, Integer> prefixCount, long prefixSum){
        if(root == null){
            return 0;
        }

        prefixSum += root.val;
        int count = prefixCount.getOrDefault(prefixSum - targetSum, 0);
        prefixCount.put(prefixSum, prefixCount.getOrDefault(prefixSum, 0) + 1);

        count += dfs(root.left, targetSum, prefixCount, prefixSum);
        count += dfs(root.right, targetSum, prefixCount, prefixSum);

        prefixCount.put(prefixSum, prefixCount.get(prefixSum) - 1);

        return count;
    }
}