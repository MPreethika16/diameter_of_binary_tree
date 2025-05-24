#include <iostream>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

// Helper function to calculate height and update diameter
int height(TreeNode* node, int& diameter) {
    if (!node) return 0;
    int left = height(node->left, diameter);
    int right = height(node->right, diameter);
    diameter = max(diameter, left + right);
    return max(left, right) + 1;
}

int diameterOfBinaryTree(TreeNode* root) {
    int diameter = 0;
    height(root, diameter);
    return diameter;
}

bool testDiameter(TreeNode* root, int expected, const string& testName) {
    int result = diameterOfBinaryTree(root);
    cout << "Test: " << testName << "\nExpected: " << expected << "\nResult: " << result << "\n";
    bool passed = (result == expected);
    cout << "Status: " << (passed ? "PASSED" : "FAILED") << "\n\n";
    return passed;
}

int main() {
    int passedCount = 0;
    const int totalTests = 15;

    // 1. Empty Tree
    passedCount += testDiameter(nullptr, 0, "Empty Tree");

    // 2. Single Node
    TreeNode* t2 = new TreeNode(1);
    passedCount += testDiameter(t2, 0, "Single Node");

    // 3. Left Child Only
    TreeNode* t3 = new TreeNode(1);
    t3->left = new TreeNode(2);
    passedCount += testDiameter(t3, 1, "Left Child Only");

    // 4. Right Child Only
    TreeNode* t4 = new TreeNode(1);
    t4->right = new TreeNode(2);
    passedCount += testDiameter(t4, 1, "Right Child Only");

    // 5. Balanced Tree
    TreeNode* t5 = new TreeNode(1);
    t5->left = new TreeNode(2);
    t5->right = new TreeNode(3);
    passedCount += testDiameter(t5, 2, "Balanced Tree");

    // 6. Left Skewed
    TreeNode* t6 = new TreeNode(1);
    t6->left = new TreeNode(2);
    t6->left->left = new TreeNode(3);
    t6->left->left->left = new TreeNode(4);
    passedCount += testDiameter(t6, 3, "Left Skewed");

    // 7. Right Skewed
    TreeNode* t7 = new TreeNode(1);
    t7->right = new TreeNode(2);
    t7->right->right = new TreeNode(3);
    t7->right->right->right = new TreeNode(4);
    passedCount += testDiameter(t7, 3, "Right Skewed");

    // 8. Full Binary Tree
    TreeNode* t8 = new TreeNode(1);
    t8->left = new TreeNode(2);
    t8->right = new TreeNode(3);
    t8->left->left = new TreeNode(4);
    t8->left->right = new TreeNode(5);
    t8->right->left = new TreeNode(6);
    t8->right->right = new TreeNode(7);
    passedCount += testDiameter(t8, 4, "Full Binary Tree");

    // 9. V-Shape Tree
    TreeNode* t9 = new TreeNode(1);
    t9->left = new TreeNode(2);
    t9->left->right = new TreeNode(3);
    passedCount += testDiameter(t9, 2, "V-Shape Tree");

    // 10. Deep Left + Right
    TreeNode* t10 = new TreeNode(1);
    t10->left = new TreeNode(2);
    t10->left->left = new TreeNode(4);
    t10->left->left->left = new TreeNode(5);
    t10->right = new TreeNode(3);
    passedCount += testDiameter(t10, 4, "Deep Left + Right");

    // 11. Balanced with Subtree
    TreeNode* t11 = new TreeNode(1);
    t11->left = new TreeNode(2);
    t11->left->left = new TreeNode(4);
    t11->left->right = new TreeNode(5);
    t11->left->right->left = new TreeNode(6);
    t11->right = new TreeNode(3);
    passedCount += testDiameter(t11, 4, "Balanced with Subtree");

    // 12. Mixed Random
    TreeNode* t12 = new TreeNode(1);
    t12->left = new TreeNode(2);
    t12->left->left = new TreeNode(4);
    t12->left->left->left = new TreeNode(7);
    t12->left->right = new TreeNode(5);
    t12->right = new TreeNode(3);
    t12->right->right = new TreeNode(6);
    passedCount += testDiameter(t12, 5, "Mixed Random");

    // 13. Deep Ends Both
    TreeNode* t13 = new TreeNode(1);
    t13->left = new TreeNode(2);
    t13->left->left = new TreeNode(4);
    t13->left->left->left = new TreeNode(7);
    t13->right = new TreeNode(3);
    t13->right->right = new TreeNode(6);
    t13->right->right->right = new TreeNode(8);
    passedCount += testDiameter(t13, 6, "Deep Ends Both");

    // 14. Sparse Tree
    TreeNode* t14 = new TreeNode(1);
    t14->left = new TreeNode(2);
    t14->left->right = new TreeNode(4);
    t14->right = new TreeNode(3);
    passedCount += testDiameter(t14, 3, "Sparse Tree");

    // 15. Complex Layout
    TreeNode* t15 = new TreeNode(1);
    t15->left = new TreeNode(2);
    t15->left->left = new TreeNode(4);
    t15->left->left->left = new TreeNode(6);
    t15->left->right = new TreeNode(5);
    t15->right = new TreeNode(3);
    t15->right->left = new TreeNode(7);
    t15->right->right = new TreeNode(8);
    t15->right->right->left = new TreeNode(9);
    passedCount += testDiameter(t15, 6, "Complex Layout");

    cout << "Total Tests Passed: " << passedCount << " out of " << totalTests << "\n";

    return 0;
}
