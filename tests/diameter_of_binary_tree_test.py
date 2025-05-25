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
    assert result == expected, f"FAILED: {testName} - Expected {expected}, got {result}"
    print("Status: PASSED\n")

def testStub():
    # This test will fail if the solution is stubbed (e.g., always returns 0)
    root = TreeNode(1, TreeNode(2), TreeNode(3))
    result = diameterOfBinaryTree(root)
    assert result != 0, "Solution appears to be missing or stubbed (returns 0 for non-trivial tree)"

def main():
    totalTests = 16  # including stub test
    passedCount = 0

    try:
        testStub()
        passedCount += 1

        # 1. Empty Tree
        testDiameter(None, 0, "Empty Tree")
        passedCount += 1

        # 2. Single Node
        t2 = TreeNode(1)
        testDiameter(t2, 0, "Single Node")
        passedCount += 1

        # 3. Left Child Only
        t3 = TreeNode(1, TreeNode(2))
        testDiameter(t3, 1, "Left Child Only")
        passedCount += 1

        # 4. Right Child Only
        t4 = TreeNode(1, None, TreeNode(2))
        testDiameter(t4, 1, "Right Child Only")
        passedCount += 1

        # 5. Balanced Tree
        t5 = TreeNode(1, TreeNode(2), TreeNode(3))
        testDiameter(t5, 2, "Balanced Tree")
        passedCount += 1

        # 6. Left Skewed
        t6 = TreeNode(1, TreeNode(2, TreeNode(3, TreeNode(4))))
        testDiameter(t6, 3, "Left Skewed")
        passedCount += 1

        # 7. Right Skewed
        t7 = TreeNode(1, None, TreeNode(2, None, TreeNode(3, None, TreeNode(4))))
        testDiameter(t7, 3, "Right Skewed")
        passedCount += 1

        # 8. Full Binary Tree
        t8 = TreeNode(1,
            TreeNode(2, TreeNode(4), TreeNode(5)),
            TreeNode(3, TreeNode(6), TreeNode(7))
        )
        testDiameter(t8, 4, "Full Binary Tree")
        passedCount += 1

        # 9. V-Shape Tree
        t9 = TreeNode(1, TreeNode(2, None, TreeNode(3)))
        testDiameter(t9, 2, "V-Shape Tree")
        passedCount += 1

        # 10. Deep Left + Right
        t10 = TreeNode(1,
            TreeNode(2, TreeNode(4, TreeNode(5))),
            TreeNode(3)
        )
        testDiameter(t10, 4, "Deep Left + Right")
        passedCount += 1

        # 11. Balanced with Subtree
        t11 = TreeNode(1,
            TreeNode(2, TreeNode(4), TreeNode(5, TreeNode(6))),
            TreeNode(3)
        )
        testDiameter(t11, 4, "Balanced with Subtree")
        passedCount += 1

        # 12. Mixed Random
        t12 = TreeNode(1,
            TreeNode(2,
                TreeNode(4, TreeNode(7)),
                TreeNode(5)
            ),
            TreeNode(3, None, TreeNode(6))
        )
        testDiameter(t12, 5, "Mixed Random")
        passedCount += 1

        # 13. Deep Ends Both
        t13 = TreeNode(1,
            TreeNode(2, TreeNode(4, TreeNode(7))),
            TreeNode(3, None, TreeNode(6, None, TreeNode(8)))
        )
        testDiameter(t13, 6, "Deep Ends Both")
        passedCount += 1

        # 14. Sparse Tree
        t14 = TreeNode(1,
            TreeNode(2, None, TreeNode(4)),
            TreeNode(3)
        )
        testDiameter(t14, 3, "Sparse Tree")
        passedCount += 1

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
        testDiameter(t15, 6, "Complex Layout")
        passedCount += 1

    except AssertionError as e:
        print(str(e))
        print(f"Total Tests Passed: {passedCount} out of {totalTests}")
        exit(1)  # Fail the CI

    print(f"Total Tests Passed: {passedCount} out of {totalTests}")

if __name__ == "__main__":
    main()
