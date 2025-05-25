public class Test {

    public static boolean testDiameter(Solution.TreeNode root, int expected, String testName) {
        Solution sol = new Solution();
        int result = sol.diameterOfBinaryTree(root);
        System.out.println("Test: " + testName);
        System.out.println("Expected: " + expected);
        System.out.println("Result: " + result);
        boolean passed = result == expected;
        System.out.println("Status: " + (passed ? "PASSED" : "FAILED"));
        System.out.println();
        return passed;
    }

    public static void main(String[] args) {
        int passedCount = 0;
        final int totalTests = 15;

        passedCount += testDiameter(null, 0, "Empty Tree") ? 1 : 0;

        Solution.TreeNode t2 = new Solution.TreeNode(1);
        passedCount += testDiameter(t2, 0, "Single Node") ? 1 : 0;

        Solution.TreeNode t3 = new Solution.TreeNode(1);
        t3.left = new Solution.TreeNode(2);
        passedCount += testDiameter(t3, 1, "Left Child Only") ? 1 : 0;

        Solution.TreeNode t4 = new Solution.TreeNode(1);
        t4.right = new Solution.TreeNode(2);
        passedCount += testDiameter(t4, 1, "Right Child Only") ? 1 : 0;

        Solution.TreeNode t5 = new Solution.TreeNode(1);
        t5.left = new Solution.TreeNode(2);
        t5.right = new Solution.TreeNode(3);
        passedCount += testDiameter(t5, 2, "Balanced Tree") ? 1 : 0;

        Solution.TreeNode t6 = new Solution.TreeNode(1);
        t6.left = new Solution.TreeNode(2);
        t6.left.left = new Solution.TreeNode(3);
        t6.left.left.left = new Solution.TreeNode(4);
        passedCount += testDiameter(t6, 3, "Left Skewed") ? 1 : 0;

        Solution.TreeNode t7 = new Solution.TreeNode(1);
        t7.right = new Solution.TreeNode(2);
        t7.right.right = new Solution.TreeNode(3);
        t7.right.right.right = new Solution.TreeNode(4);
        passedCount += testDiameter(t7, 3, "Right Skewed") ? 1 : 0;

        Solution.TreeNode t8 = new Solution.TreeNode(1);
        t8.left = new Solution.TreeNode(2);
        t8.right = new Solution.TreeNode(3);
        t8.left.left = new Solution.TreeNode(4);
        t8.left.right = new Solution.TreeNode(5);
        t8.right.left = new Solution.TreeNode(6);
        t8.right.right = new Solution.TreeNode(7);
        passedCount += testDiameter(t8, 4, "Full Binary Tree") ? 1 : 0;

        Solution.TreeNode t9 = new Solution.TreeNode(1);
        t9.left = new Solution.TreeNode(2);
        t9.left.right = new Solution.TreeNode(3);
        passedCount += testDiameter(t9, 2, "V-Shape Tree") ? 1 : 0;

        Solution.TreeNode t10 = new Solution.TreeNode(1);
        t10.left = new Solution.TreeNode(2);
        t10.left.left = new Solution.TreeNode(4);
        t10.left.left.left = new Solution.TreeNode(5);
        t10.right = new Solution.TreeNode(3);
        passedCount += testDiameter(t10, 4, "Deep Left + Right") ? 1 : 0;

        Solution.TreeNode t11 = new Solution.TreeNode(1);
        t11.left = new Solution.TreeNode(2);
        t11.left.left = new Solution.TreeNode(4);
        t11.left.right = new Solution.TreeNode(5);
        t11.left.right.left = new Solution.TreeNode(6);
        t11.right = new Solution.TreeNode(3);
        passedCount += testDiameter(t11, 4, "Balanced with Subtree") ? 1 : 0;

        Solution.TreeNode t12 = new Solution.TreeNode(1);
        t12.left = new Solution.TreeNode(2);
        t12.left.left = new Solution.TreeNode(4);
        t12.left.left.left = new Solution.TreeNode(7);
        t12.left.right = new Solution.TreeNode(5);
        t12.right = new Solution.TreeNode(3);
        t12.right.right = new Solution.TreeNode(6);
        passedCount += testDiameter(t12, 5, "Mixed Random") ? 1 : 0;

        Solution.TreeNode t13 = new Solution.TreeNode(1);
        t13.left = new Solution.TreeNode(2);
        t13.left.left = new Solution.TreeNode(4);
        t13.left.left.left = new Solution.TreeNode(7);
        t13.right = new Solution.TreeNode(3);
        t13.right.right = new Solution.TreeNode(6);
        t13.right.right.right = new Solution.TreeNode(8);
        passedCount += testDiameter(t13, 6, "Deep Ends Both") ? 1 : 0;

        Solution.TreeNode t14 = new Solution.TreeNode(1);
        t14.left = new Solution.TreeNode(2);
        t14.left.right = new Solution.TreeNode(4);
        t14.right = new Solution.TreeNode(3);
        passedCount += testDiameter(t14, 3, "Sparse Tree") ? 1 : 0;

        Solution.TreeNode t15 = new Solution.TreeNode(1);
        t15.left = new Solution.TreeNode(2);
        t15.left.left = new Solution.TreeNode(4);
        t15.left.left.left = new Solution.TreeNode(6);
        t15.left.right = new Solution.TreeNode(5);
        t15.right = new Solution.TreeNode(3);
        t15.right.left = new Solution.TreeNode(7);
        t15.right.right = new Solution.TreeNode(8);
        t15.right.right.left = new Solution.TreeNode(9);
        passedCount += testDiameter(t15, 6, "Complex Layout") ? 1 : 0;

        System.out.println("Total Tests Passed: " + passedCount + " out of " + totalTests);
    }
}
