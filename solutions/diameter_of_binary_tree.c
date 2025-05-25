#include <stdlib.h>

// Define the struct here
struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right; 
};
 
// Internal helper function
int height(struct TreeNode* node, int* diameter) {
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
