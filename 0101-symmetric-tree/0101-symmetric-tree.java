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
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {

        // Both are null
        if (left == null && right == null) {
            return true;
        }

        // One is null, other isn't
        if (left == null || right == null) {
            return false;
        }

        // Values don't match
        if (left.val != right.val) {
            return false;
        }

        // Mirror condition
        return check(left.left, right.right)
            && check(left.right, right.left);
    }
}