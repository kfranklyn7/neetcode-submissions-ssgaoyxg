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
    public int goodNodes(TreeNode root) {                                                                                                 
        return goodNode(root,root.val);// return a dfs based recursive function
    }
    private int goodNode(TreeNode root,int maxSeen){
        if (root == null){// null nodes aren't considered
            return 0;
        }
            int result = 1;// by default, the result is 1
            if (maxSeen > root.val){// if this is a bad node, result is zero
                result = 0;
            }
            maxSeen = Math.max(root.val,maxSeen);// reassign max
            result += goodNode(root.left,maxSeen);
            result += goodNode(root.right,maxSeen);
            return result;
        
    }
}
