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
   
    public int sumOfLeftLeaves(TreeNode root) {
        return solve(root, false);
    }

    private int solve(TreeNode curr, boolean isLeft) {
        if (curr == null) {
            return 0;
        }

        if (curr.left == null && curr.right == null && isLeft) {
            return curr.val;
        }

        return solve(curr.left, true) + solve(curr.right, false);
    }
}

