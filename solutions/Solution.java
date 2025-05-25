public class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        return 0; // stub - no actual solution
    }
} 

// TreeNode class definition
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() { val = 0; left = null; right = null; }
    TreeNode(int x) { val = x; left = null; right = null; }
    TreeNode(int x, TreeNode left, TreeNode right) { this.val = x; this.left = left; this.right = right; }
}
