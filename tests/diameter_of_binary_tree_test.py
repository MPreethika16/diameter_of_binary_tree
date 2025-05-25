class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        # You can leave this empty or stub for now
        pass

def testDiameter(root, expected, testName, solution):
    result = solution.diameterOfBinaryTree(root)
    print(f"Test: {testName}")
    print(f"Expected: {expected}")
    print(f"Result: {result}")
    assert result == expected, f"FAILED: {testName} - Expected {expected}, got {result}"
    print("Status: PASSED\n")

def testStub(solution):
    root = TreeNode(1, TreeNode(2), TreeNode(3))
    result = solution.diameterOfBinaryTree(root)
    assert result is not None and result != 0, "Solution appears to be missing or stubbed (returns 0 or None)"

def main():
    totalTests = 16
    passedCount = 0
    solution = Solution()

    try:
        testStub(solution)
        passedCount += 1

        testDiameter(None, 0, "Empty Tree", solution)
        passedCount += 1

        t2 = TreeNode(1)
        testDiameter(t2, 0, "Single Node", solution)
        passedCount += 1

        t3 = TreeNode(1, TreeNode(2))
        testDiameter(t3, 1, "Left Child Only", solution)
        passedCount += 1

        t4 = TreeNode(1, None, TreeNode(2))
        testDiameter(t4, 1, "Right Child Only", solution)
        passedCount += 1

        t5 = TreeNode(1, TreeNode(2), TreeNode(3))
        testDiameter(t5, 2, "Balanced Tree", solution)
        passedCount += 1

        t6 = TreeNode(1, TreeNode(2, TreeNode(3, TreeNode(4))))
        testDiameter(t6, 3, "Left Skewed", solution)
        passedCount += 1

        t7 = TreeNode(1, None, TreeNode(2, None, TreeNode(3, None, TreeNode(4))))
        testDiameter(t7, 3, "Right Skewed", solution)
        passedCount += 1

        t8 = TreeNode(1,
            TreeNode(2, TreeNode(4), TreeNode(5)),
            TreeNode(3, TreeNode(6), TreeNode(7))
        )
        testDiameter(t8, 4, "Full Binary Tree", solution)
        passedCount += 1

        t9 = TreeNode(1, TreeNode(2, None, TreeNode(3)))
        testDiameter(t9, 2, "V-Shape Tree", solution)
        passedCount += 1

        t10 = TreeNode(1,
            TreeNode(2, TreeNode(4, TreeNode(5))),
            TreeNode(3)
        )
        testDiameter(t10, 4, "Deep Left + Right", solution)
        passedCount += 1

        t11 = TreeNode(1,
            TreeNode(2, TreeNode(4), TreeNode(5, TreeNode(6))),
            TreeNode(3)
        )
        testDiameter(t11, 4, "Balanced with Subtree", solution)
        passedCount += 1

        t12 = TreeNode(1,
            TreeNode(2,
                TreeNode(4, TreeNode(7)),
                TreeNode(5)
            ),
            TreeNode(3, None, TreeNode(6))
        )
        testDiameter(t12, 5, "Mixed Random", solution)
        passedCount += 1

        t13 = TreeNode(1,
            TreeNode(2, TreeNode(4, TreeNode(7))),
            TreeNode(3, None, TreeNode(6, None, TreeNode(8)))
        )
        testDiameter(t13, 6, "Deep Ends Both", solution)
        passedCount += 1

        t14 = TreeNode(1,
            TreeNode(2, None, TreeNode(4)),
            TreeNode(3)
        )
        testDiameter(t14, 3, "Sparse Tree", solution)
        passedCount += 1

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
        testDiameter(t15, 6, "Complex Layout", solution)
        passedCount += 1

    except AssertionError as e:
        print(str(e))
        print(f"Total Tests Passed: {passedCount} out of {totalTests}")
        exit(1)

    print(f"Total Tests Passed: {passedCount} out of {totalTests}")

if __name__ == "__main__":
    main()
