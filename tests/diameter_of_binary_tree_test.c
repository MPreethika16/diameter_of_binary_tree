#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

// Internal helper to calculate height
static int height(struct TreeNode* node, int* diameter) {
    if (!node) return 0;
    int left = height(node->left, diameter);
    int right = height(node->right, diameter);
    if (*diameter < left + right) *diameter = left + right;
    return (left > right ? left : right) + 1;
}

int diameterOfBinaryTree(struct TreeNode* root) {
    int diameter = 0;
    height(root, &diameter);
    return diameter;
}

struct TreeNode* newNode(int val) {
    struct TreeNode* node = malloc(sizeof(struct TreeNode));
    node->val = val;
    node->left = NULL;
    node->right = NULL;
    return node;
}

bool testDiameter(struct TreeNode* root, int expected, const char* testName) {
    int result = diameterOfBinaryTree(root);
    printf("Test: %s\n", testName);
    printf("Expected: %d\n", expected);
    printf("Result: %d\n", result);
    bool passed = result == expected;
    printf("Status: %s\n\n", passed ? "PASSED" : "FAILED");
    return passed;
}

int main() {
    int passedCount = 0;
    const int totalTests = 15;

    // 1. Empty Tree
    passedCount += testDiameter(NULL, 0, "Empty Tree");

    // 2. Single Node
    struct TreeNode* t2 = newNode(1);
    passedCount += testDiameter(t2, 0, "Single Node");

    // 3. Left Child Only
    struct TreeNode* t3 = newNode(1);
    t3->left = newNode(2);
    passedCount += testDiameter(t3, 1, "Left Child Only");

    // 4. Right Child Only
    struct TreeNode* t4 = newNode(1);
    t4->right = newNode(2);
    passedCount += testDiameter(t4, 1, "Right Child Only");

    // 5. Balanced Tree
    struct TreeNode* t5 = newNode(1);
    t5->left = newNode(2);
    t5->right = newNode(3);
    passedCount += testDiameter(t5, 2, "Balanced Tree");

    // 6. Left Skewed
    struct TreeNode* t6 = newNode(1);
    t6->left = newNode(2);
    t6->left->left = newNode(3);
    t6->left->left->left = newNode(4);
    passedCount += testDiameter(t6, 3, "Left Skewed");

    // 7. Right Skewed
    struct TreeNode* t7 = newNode(1);
    t7->right = newNode(2);
    t7->right->right = newNode(3);
    t7->right->right->right = newNode(4);
    passedCount += testDiameter(t7, 3, "Right Skewed");

    // 8. Full Binary Tree
    struct TreeNode* t8 = newNode(1);
    t8->left = newNode(2);
    t8->right = newNode(3);
    t8->left->left = newNode(4);
    t8->left->right = newNode(5);
    t8->right->left = newNode(6);
    t8->right->right = newNode(7);
    passedCount += testDiameter(t8, 4, "Full Binary Tree");

    // 9. V-Shape Tree
    struct TreeNode* t9 = newNode(1);
    t9->left = newNode(2);
    t9->left->right = newNode(3);
    passedCount += testDiameter(t9, 2, "V-Shape Tree");

    // 10. Deep Left + Right
    struct TreeNode* t10 = newNode(1);
    t10->left = newNode(2);
    t10->left->left = newNode(4);
    t10->left->left->left = newNode(5);
    t10->right = newNode(3);
    passedCount += testDiameter(t10, 4, "Deep Left + Right");

    // 11. Balanced with Subtree
    struct TreeNode* t11 = newNode(1);
    t11->left = newNode(2);
    t11->left->left = newNode(4);
    t11->left->right = newNode(5);
    t11->left->right->left = newNode(6);
    t11->right = newNode(3);
    passedCount += testDiameter(t11, 4, "Balanced with Subtree");

    // 12. Mixed Random
    struct TreeNode* t12 = newNode(1);
    t12->left = newNode(2);
    t12->left->left = newNode(4);
    t12->left->left->left = newNode(7);
    t12->left->right = newNode(5);
    t12->right = newNode(3);
    t12->right->right = newNode(6);
    passedCount += testDiameter(t12, 5, "Mixed Random");

    // 13. Deep Ends Both
    struct TreeNode* t13 = newNode(1);
    t13->left = newNode(2);
    t13->left->left = newNode(4);
    t13->left->left->left = newNode(7);
    t13->right = newNode(3);
    t13->right->right = newNode(6);
    t13->right->right->right = newNode(8);
    passedCount += testDiameter(t13, 6, "Deep Ends Both");

    // 14. Sparse Tree
    struct TreeNode* t14 = newNode(1);
    t14->left = newNode(2);
    t14->left->right = newNode(4);
    t14->right = newNode(3);
    passedCount += testDiameter(t14, 3, "Sparse Tree");

    // 15. Complex Layout
    struct TreeNode* t15 = newNode(1);
    t15->left = newNode(2);
    t15->left->left = newNode(4);
    t15->left->left->left = newNode(6);
    t15->left->right = newNode(5);
    t15->right = newNode(3);
    t15->right->left = newNode(7);
    t15->right->right = newNode(8);
    t15->right->right->left = newNode(9);
    passedCount += testDiameter(t15, 6, "Complex Layout");

    printf("Total Tests Passed: %d out of %d\n", passedCount, totalTests);
    return 0;
}
