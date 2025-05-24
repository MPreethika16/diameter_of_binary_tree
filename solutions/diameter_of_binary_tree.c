#include <stdio.h>
#include <stdlib.h>

struct TreeNode {
    int val;
    struct TreeNode* left;
    struct TreeNode* right; 
};

// Helper function to calculate the height and update the diameter
int height(struct TreeNode* node, int* diameter) {
    if (!node) return 0;

    int leftHeight = height(node->left, diameter);
    int rightHeight = height(node->right, diameter);

    int pathLength = leftHeight + rightHeight;
    if (pathLength > *diameter) {
        *diameter = pathLength;
    }

    return (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
}

// Main function to calculate the diameter
int diameterOfBinaryTree(struct TreeNode* root) {
    int diameter = 0;
    height(root, &diameter);
    return diameter;
}

// Utility to create new TreeNode
struct TreeNode* newNode(int val) {
    struct TreeNode* node = malloc(sizeof(struct TreeNode));
    node->val = val;
    node->left = NULL;
    node->right = NULL;
    return node;
}
