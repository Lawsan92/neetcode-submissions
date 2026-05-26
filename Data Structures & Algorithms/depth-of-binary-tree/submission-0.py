# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        # GOAL: record depth of branch

        # DFS: keep drilling down until reaching a leaf
        # we need to compare depth of the branches

        # base case: leaf node OR empty tree
        if root == None:
            return 0
        # recurse case: if there are still leaf nodes, keep drilling down, increment depth on the way back up
        # compare depths, return the branch with the greater depth
        return max(1 + self.maxDepth(root.left), 1 + self.maxDepth(root.right))
