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
    public boolean isBalanced(TreeNode root) {
        return dfs(root)[0] == 1;
    }
    private int[] dfs(TreeNode root){
        if (root == null){
            return new int[]{1,0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        boolean balanced = (left[0] == 1 && right[0] == 1) &&
                            (Math.abs(left[1] - right[1]) <= 1);
        int height = 1 + Math.max(left[1],right[1]);

        return new int[]{balanced ? 1 : 0,height};
    } 
}
//we recursively perform a dfs on the left and right nodes
// both trees are balanced (index 0 in the arrays) if the absolute difference between the two is less than one
// balanced is assigned to if both left and right are balanced already along with the above condition
// the height is incremented by 1 to whatever height
// we return an array with index 0 being 1 for balanced and index 1 being the height 
