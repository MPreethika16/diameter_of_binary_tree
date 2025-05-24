
#include <iostream>
#include <string>
#include "../solutions/diameter_of_binary_tree.cpp"  // Include actual logic and TreeNode

// Helper function
TreeNode* newNode(int val) {
    return new TreeNode(val);
}

// Test function
bool testDiameter(Solution& sol, TreeNode* root, int expected, const std::string& testName) {
    int result = sol.diameterOfBinaryTree(root);
    std::cout << "Test: " << testName << "\nExpected: " << expected << "\nResult: " << result << "\n";
    bool passed = (result == expected);
    std::cout << "Status: " << (passed ? "PASSED" : "FAILED") << "\n\n";
    return passed;
}

int main() {
    Solution sol;
    int passedCount = 0;
    const int totalTests = 15;

    // Your test cases (as-is)
    // ...

    // 1. Empty Tree
    passedCount += testDiameter(sol, nullptr, 0, "Empty Tree");

    // 2. Single Node
    TreeNode* t2 = newNode(1);
    passedCount += testDiameter(sol, t2, 0, "Single Node");

    // 3. Left Child Only
    TreeNode* t3 = newNode(1);
    t3->left = newNode(2);
    passedCount += testDiameter(sol, t3, 1, "Left Child Only");

    // 4. Right Child Only
    TreeNode* t4 = newNode(1);
    t4->right = newNode(2);
    passedCount += testDiameter(sol, t4, 1, "Right Child Only");

    // 5. Balanced Tree
    TreeNode* t5 = newNode(1);
    t5->left = newNode(2);
    t5->right = newNode(3);
    passedCount += testDiameter(sol, t5, 2, "Balanced Tree");

    // 6. Left Skewed
    TreeNode* t6 = newNode(1);
    t6->left = newNode(2);
    t6->left->left = newNode(3);
    t6->left->left->left = newNode(4);
    passedCount += testDiameter(sol, t6, 3, "Left Skewed");

    // 7. Right Skewed
    TreeNode* t7 = newNode(1);
    t7->right = newNode(2);
    t7->right->right = newNode(3);
    t7->right->right->right = newNode(4);
    passedCount += testDiameter(sol, t7, 3, "Right Skewed");

    // 8. Full Binary Tree
    TreeNode* t8 = newNode(1);
    t8->left = newNode(2);
    t8->right = newNode(3);
    t8->left->left = newNode(4);
    t8->left->right = newNode(5);
    t8->right->left = newNode(6);
    t8->right->right = newNode(7);
    passedCount += testDiameter(sol, t8, 4, "Full Binary Tree");

    // 9. V-Shape Tree
    TreeNode* t9 = newNode(1);
    t9->left = newNode(2);
    t9->left->right = newNode(3);
    passedCount += testDiameter(sol, t9, 2, "V-Shape Tree");

    // 10. Deep Left + Right
    TreeNode* t10 = newNode(1);
    t10->left = newNode(2);
    t10->left->left = newNode(4);
    t10->left->left->left = newNode(5);
    t10->right = newNode(3);
    passedCount += testDiameter(sol, t10, 4, "Deep Left + Right");

    // 11. Balanced with Subtree
    TreeNode* t11 = newNode(1);
    t11->left = newNode(2);
    t11->left->left = newNode(4);
    t11->left->right = newNode(5);
    t11->left->right->left = newNode(6);
    t11->right = newNode(3);
    passedCount += testDiameter(sol, t11, 4, "Balanced with Subtree");

    // 12. Mixed Random
    TreeNode* t12 = newNode(1);
    t12->left = newNode(2);
    t12->left->left = newNode(4);
    t12->left->left->left = newNode(7);
    t12->left->right = newNode(5);
    t12->right = newNode(3);
    t12->right->right = newNode(6);
    passedCount += testDiameter(sol, t12, 5, "Mixed Random");

    // 13. Deep Ends Both
    TreeNode* t13 = newNode(1);
    t13->left = newNode(2);
    t13->left->left = newNode(4);
    t13->left->left->left = newNode(7);
    t13->right = newNode(3);
    t13->right->right = newNode(6);
    t13->right->right->right = newNode(8);
    passedCount += testDiameter(sol, t13, 6, "Deep Ends Both");

    // 14. Sparse Tree
    TreeNode* t14 = newNode(1);
    t14->left = newNode(2);
    t14->left->right = newNode(4);
    t14->right = newNode(3);
    passedCount += testDiameter(sol, t14, 3, "Sparse Tree");

    // 15. Complex Layout
    TreeNode* t15 = newNode(1);
    t15->left = newNode(2);
    t15->left->left = newNode(4);
    t15->left->left->left = newNode(6);
    t15->left->right = newNode(5);
    t15->right = newNode(3);
    t15->right->left = newNode(7);
    t15->right->right = newNode(8);
    t15->right->right->left = newNode(9);
    passedCount += testDiameter(sol, t15, 6, "Complex Layout");

    std::cout << "Total Tests Passed: " << passedCount << " out of " << totalTests << "\n";
    return 0;
}
