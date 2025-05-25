public class Test {

    // TreeNode class (used by both the solution and the test)
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    // Helper method to run a single test
    private static boolean testDiameter(TreeNode root, int expected, String testName) {
        Solution sol = new Solution();  // uses external Solution class
        int result = sol.diameterOfBinaryTree(root);
        System.out.println("Test: " + testName);
        System.out.println("Expected: " + expected);
        System.out.println("Result: " + result);
        boolean passed = result == expected;
        System.out.println("Status: " + (passed ? "PASSED" : "FAILED"));
        System.out.println();
        return passed;
    }

    // Main method with 15 test cases
    public static void main(String[] args) {
        int passedCount = 0;
        final int totalTests = 15;

        // 1. Empty Tree
        passedCount += testDiameter(null, 0, "Empty Tree") ? 1 : 0;

        // 2. Single Node
        TreeNode t2 = new TreeNode(1);
        passedCount += testDiameter(t2, 0, "Single Node") ? 1 : 0;

        // 3. Left Child Only
        TreeNode t3 = new TreeNode(1);
        t3.left = new TreeNode(2);
        passedCount += testDiameter(t3, 1, "Left Child Only") ? 1 : 0;

        // 4. Right Child Only
        TreeNode t4 = new TreeNode(1);
        t4.right = new TreeNode(2);
        passedCount += testDiameter(t4, 1, "Right Child Only") ? 1 : 0;

        // 5. Balanced Tree
        TreeNode t5 = new TreeNode(1);
        t5.left = new TreeNode(2);
        t5.right = new TreeNode(3);
        passedCount += testDiameter(t5, 2, "Balanced Tree") ? 1 : 0;

        // 6. Left Skewed
        TreeNode t6 = new TreeNode(1);
        t6.left = new TreeNode(2);
        t6.left.left = new TreeNode(3);
        t6.left.left.left = new TreeNode(4);
        passedCount += testDiameter(t6, 3, "Left Skewed") ? 1 : 0;

        // 7. Right Skewed
        TreeNode t7 = new TreeNode(1);
        t7.right = new TreeNode(2);
        t7.right.right = new TreeNode(3);
        t7.right.right.right = new TreeNode(4);
        passedCount += testDiameter(t7, 3, "Right Skewed") ? 1 : 0;

        // 8. Full Binary Tree
        TreeNode t8 = new TreeNode(1);
        t8.left = new TreeNode(2);
        t8.right = new TreeNode(3);
        t8.left.left = new TreeNode(4);
        t8.left.right = new TreeNode(5);
        t8.right.left = new TreeNode(6);
        t8.right.right = new TreeNode(7);
        passedCount += testDiameter(t8, 4, "Full Binary Tree") ? 1 : 0;

        // 9. V-Shape Tree
        TreeNode t9 = new TreeNode(1);
        t9.left = new TreeNode(2);
        t9.left.right = new TreeNode(3);
        passedCount += testDiameter(t9, 2, "V-Shape Tree") ? 1 : 0;

        // 10. Deep Left + Right
        TreeNode t10 = new TreeNode(1);
        t10.left = new TreeNode(2);
        t10.left.left = new TreeNode(4);
        t10.left.left.left = new TreeNode(5);
        t10.right = new TreeNode(3);
        passedCount += testDiameter(t10, 4, "Deep Left + Right") ? 1 : 0;

        // 11. Balanced with Subtree
        TreeNode t11 = new TreeNode(1);
        t11.left = new TreeNode(2);
        t11.left.left = new TreeNode(4);
        t11.left.right = new TreeNode(5);
        t11.left.right.left = new TreeNode(6);
        t11.right = new TreeNode(3);
        passedCount += testDiameter(t11, 4, "Balanced with Subtree") ? 1 : 0;

        // 12. Mixed Random
        TreeNode t12 = new TreeNode(1);
        t12.left = new TreeNode(2);
        t12.left.left = new TreeNode(4);
        t12.left.left.left = new TreeNode(7);
        t12.left.right = new TreeNode(5);
        t12.right = new TreeNode(3);
        t12.right.right = new TreeNode(6);
        passedCount += testDiameter(t12, 5, "Mixed Random") ? 1 : 0;

        // 13. Deep Ends Both
        TreeNode t13 = new TreeNode(1);
        t13.left = new TreeNode(2);
        t13.left.left = new TreeNode(4);
        t13.left.left.left = new TreeNode(7);
        t13.right = new TreeNode(3);
        t13.right.right = new TreeNode(6);
        t13.right.right.right = new TreeNode(8);
        passedCount += testDiameter(t13, 6, "Deep Ends Both") ? 1 : 0;

        // 14. Sparse Tree
        TreeNode t14 = new TreeNode(1);
        t14.left = new TreeNode(2);
        t14.left.right = new TreeNode(4);
        t14.right = new TreeNode(3);
        passedCount += testDiameter(t14, 3, "Sparse Tree") ? 1 : 0;

        // 15. Complex Layout
        TreeNode t15 = new TreeNode(1);
        t15.left = new TreeNode(2);
        t15.left.left = new TreeNode(4);
        t15.left.left.left = new TreeNode(6);
        t15.left.right = new TreeNode(5);
        t15.right = new TreeNode(3);
        t15.right.left = new TreeNode(7);
        t15.right.right = new TreeNode(8);
        t15.right.right.left = new TreeNode(9);
        passedCount += testDiameter(t15, 6, "Complex Layout") ? 1 : 0;

        // Final result
        System.out.println("Total Tests Passed: " + passedCount + " out of " + totalTests);
    }
}
