public class Solution{
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        diameter = Math.max(diameter, leftHeight + rightHeight);

        return Math.max(leftHeight, rightHeight) + 1;
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
