public class Test {
    public static boolean allPassed = true;

    public static void main(String[] args) {
        runTests();
        if (!allPassed) {
            System.out.println("\nSome tests failed.");
            System.exit(1);
        } else {
            System.out.println("\nAll tests passed.");
            System.exit(0);
        }
    }

    static void runTests() {
        // 1. Empty Tree
        testDiameter(null, 0, "Empty Tree");

        // 2. Single Node
        testDiameter(new Solution.TreeNode(1), 0, "Single Node");

        // 3. Left Child Only
        Solution.TreeNode t3 = new Solution.TreeNode(1);
        t3.left = new Solution.TreeNode(2);
        testDiameter(t3, 1, "Left Child Only");

        // 4. Right Child Only
        Solution.TreeNode t4 = new Solution.TreeNode(1);
        t4.right = new Solution.TreeNode(2);
        testDiameter(t4, 1, "Right Child Only");

        // 5. Balanced Tree
        Solution.TreeNode t5 = new Solution.TreeNode(1);
        t5.left = new Solution.TreeNode(2);
        t5.right = new Solution.TreeNode(3);
        testDiameter(t5, 2, "Balanced Tree");

        // 6. Left Skewed
        Solution.TreeNode t6 = new Solution.TreeNode(1);
        t6.left = new Solution.TreeNode(2);
        t6.left.left = new Solution.TreeNode(3);
        testDiameter(t6, 2, "Left Skewed");

        // 7. Right Skewed
        Solution.TreeNode t7 = new Solution.TreeNode(1);
        t7.right = new Solution.TreeNode(2);
        t7.right.right = new Solution.TreeNode(3);
        testDiameter(t7, 2, "Right Skewed");

        // 8. Full Binary Tree (3 levels)
        Solution.TreeNode t8 = new Solution.TreeNode(1);
        t8.left = new Solution.TreeNode(2);
        t8.right = new Solution.TreeNode(3);
        t8.left.left = new Solution.TreeNode(4);
        t8.left.right = new Solution.TreeNode(5);
        t8.right.left = new Solution.TreeNode(6);
        t8.right.right = new Solution.TreeNode(7);
        testDiameter(t8, 4, "Full Binary Tree");

        // 9. V-Shape Tree
        Solution.TreeNode t9 = new Solution.TreeNode(1);
        t9.left = new Solution.TreeNode(2);
        t9.right = new Solution.TreeNode(3);
        t9.left.left = new Solution.TreeNode(4);
        testDiameter(t9, 3, "V-Shape Tree");

        // 10. Deep Left + Right
        Solution.TreeNode t10 = new Solution.TreeNode(1);
        t10.left = new Solution.TreeNode(2);
        t10.left.left = new Solution.TreeNode(3);
        t10.left.left.left = new Solution.TreeNode(4);
        t10.right = new Solution.TreeNode(5);
        testDiameter(t10, 4, "Deep Left + Right");

        // 11. Balanced with Subtree
        Solution.TreeNode t11 = new Solution.TreeNode(1);
        t11.left = new Solution.TreeNode(2);
        t11.left.left = new Solution.TreeNode(4);
        t11.left.right = new Solution.TreeNode(5);
        t11.right = new Solution.TreeNode(3);
        testDiameter(t11, 3, "Balanced with Subtree");

        // 12. Mixed Random
        Solution.TreeNode t12 = new Solution.TreeNode(1);
        t12.left = new Solution.TreeNode(2);
        t12.left.right = new Solution.TreeNode(5);
        t12.right = new Solution.TreeNode(3);
        t12.right.right = new Solution.TreeNode(6);
        testDiameter(t12, 4, "Mixed Random");

        // 13. Deep Ends Both
        Solution.TreeNode t13 = new Solution.TreeNode(1);
        t13.left = new Solution.TreeNode(2);
        t13.left.left = new Solution.TreeNode(4);
        t13.left.left.left = new Solution.TreeNode(7);
        t13.right = new Solution.TreeNode(3);
        t13.right.right = new Solution.TreeNode(6);
        t13.right.right.right = new Solution.TreeNode(8);
        testDiameter(t13, 6, "Deep Ends Both");

        // 14. Sparse Tree
        Solution.TreeNode t14 = new Solution.TreeNode(1);
        t14.left = new Solution.TreeNode(2);
        t14.left.right = new Solution.TreeNode(4);
        t14.right = new Solution.TreeNode(3);
        testDiameter(t14, 3, "Sparse Tree");

        // 15. Complex Layout
        Solution.TreeNode t15 = new Solution.TreeNode(1);
        t15.left = new Solution.TreeNode(2);
        t15.left.left = new Solution.TreeNode(4);
        t15.left.left.left = new Solution.TreeNode(6);
        t15.left.right = new Solution.TreeNode(5);
        t15.right = new Solution.TreeNode(3);
        t15.right.left = new Solution.TreeNode(7);
        t15.right.right = new Solution.TreeNode(8);
        t15.right.right.left = new Solution.TreeNode(9);
        testDiameter(t15, 6, "Complex Layout");
    }

    public static boolean testDiameter(Solution.TreeNode root, int expected, String testName) {
        Solution sol = new Solution();
        int result = sol.diameterOfBinaryTree(root);

        System.out.println("Test: " + testName);
        System.out.println("Expected: " + expected);
        System.out.println("Result: " + result);

        if (result == expected) {
            System.out.println("Status: PASSED\n");
            return true;
        } else {
            System.out.println("Status: FAILED\n");
            allPassed = false;
            return false;
        }
    }
}
