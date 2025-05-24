class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def diameterOfBinaryTree(root):
    diameter = 0

    def height(node):
        nonlocal diameter
        if not node: 
            return 0
        left = height(node.left)
        right = height(node.right)
        diameter = max(diameter, left + right)
        return max(left, right) + 1

    height(root)
    return diameter

def testDiameter(root, expected, testName):
    result = diameterOfBinaryTree(root)
    print(f"Test: {testName}")
    print(f"Expected: {expected}")
    print(f"Result: {result}")
    passed = result == expected
    print(f"Status: {'PASSED' if passed else 'FAILED'}\n")
    return passed

def main():
    passedCount = 0
    totalTests = 15

    # 1. Empty Tree
    passedCount += testDiameter(None, 0, "Empty Tree")

    # 2. Single Node
    t2 = TreeNode(1)
    passedCount += testDiameter(t2, 0, "Single Node")

    # 3. Left Child Only
    t3 = TreeNode(1, TreeNode(2))
    passedCount += testDiameter(t3, 1, "Left Child Only")

    # 4. Right Child Only
    t4 = TreeNode(1, None, TreeNode(2))
    passedCount += testDiameter(t4, 1, "Right Child Only")

    # 5. Balanced Tree
    t5 = TreeNode(1, TreeNode(2), TreeNode(3))
    passedCount += testDiameter(t5, 2, "Balanced Tree")

    # 6. Left Skewed
    t6 = TreeNode(1, TreeNode(2, TreeNode(3, TreeNode(4))))
    passedCount += testDiameter(t6, 3, "Left Skewed")

    # 7. Right Skewed
    t7 = TreeNode(1, None, TreeNode(2, None, TreeNode(3, None, TreeNode(4))))
    passedCount += testDiameter(t7, 3, "Right Skewed")

    # 8. Full Binary Tree
    t8 = TreeNode(1,
        TreeNode(2, TreeNode(4), TreeNode(5)),
        TreeNode(3, TreeNode(6), TreeNode(7))
    )
    passedCount += testDiameter(t8, 4, "Full Binary Tree")

    # 9. V-Shape Tree
    t9 = TreeNode(1, TreeNode(2, None, TreeNode(3)))
    passedCount += testDiameter(t9, 2, "V-Shape Tree")

    # 10. Deep Left + Right
    t10 = TreeNode(1,
        TreeNode(2, TreeNode(4, TreeNode(5))),
        TreeNode(3)
    )
    passedCount += testDiameter(t10, 4, "Deep Left + Right")

    # 11. Balanced with Subtree
    t11 = TreeNode(1,
        TreeNode(2, TreeNode(4), TreeNode(5, TreeNode(6))),
        TreeNode(3)
    )
    passedCount += testDiameter(t11, 4, "Balanced with Subtree")

    # 12. Mixed Random
    t12 = TreeNode(1,
        TreeNode(2,
            TreeNode(4, TreeNode(7)),
            TreeNode(5)
        ),
        TreeNode(3, None, TreeNode(6))
    )
    passedCount += testDiameter(t12, 5, "Mixed Random")

    # 13. Deep Ends Both
    t13 = TreeNode(1,
        TreeNode(2, TreeNode(4, TreeNode(7))),
        TreeNode(3, None, TreeNode(6, None, TreeNode(8)))
    )
    passedCount += testDiameter(t13, 6, "Deep Ends Both")

    # 14. Sparse Tree
    t14 = TreeNode(1,
        TreeNode(2, None, TreeNode(4)),
        TreeNode(3)
    )
    passedCount += testDiameter(t14, 3, "Sparse Tree")

    # 15. Complex Layout
    t15 = TreeNode(1,
        TreeNode(2,
            TreeNode(4, TreeNode(6)),
            TreeNode(5)
        ),
        TreeNode(3,
            TreeNode(7),
            TreeNode(8, TreeNode(9))
        )
    )
    passedCount += testDiameter(t15, 6, "Complex Layout")

    print(f"Total Tests Passed: {passedCount} out of {totalTests}")

if __name__ == "__main__":
    main()
