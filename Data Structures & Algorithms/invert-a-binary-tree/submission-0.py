# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if root == None:
            return root
        temp = root.left
        root.left = root.right
        root.right = temp
        self.invertTree(root.left)
        self.invertTree(root.right)
        return root

"""

root: TreeNode {
  val: 1,
  left: TreeNode {
    val: 2,
    left: TreeNode { val: 4, left: null, right: null },
    right: TreeNode { val: 5, left: null, right: null }
  },
  right: TreeNode {
    val: 3,
    left: TreeNode { val: 6, left: null, right: null },
    right: TreeNode { val: 7, left: null, right: null }
  }
}

"""