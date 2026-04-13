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
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }

        TreeNode dummy = root.left; // we make a dummy node just to store one of the child pointers
        root.left = root.right;
        root.right = dummy;// basic swap
        
        invertTree(root.left);// recursive call both roots now that they have been swapped 
        invertTree(root.right);

        return root;
    }
}
