/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // compare both trees at the current node of `tree`
            // if the are equal
                // return true
            // otherwise
                // if `tree` still has children
                    // re-rerun the alogirthm at the child nodes

        if (subRoot == null) {
            return true;
        }
    
        if (root == null) {
            return false;
        } 

        if (root.val == subRoot.val && isSameTree(root, subRoot)) {
            // we're at a node in the tree that shares the same value as the root of the subtree
            // meaning, that node could potentially have the same structure as the subtree
            // so what should we do?
            // compare the sub elements
           return true;

        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }

    public boolean isSameTree (TreeNode root_t1, TreeNode root_t2) {
        
        if (root_t1 == null || root_t2 == null) {
            return root_t1 == null && root_t2 == null;
        }

        if (root_t1.val != root_t2.val) {
            return false;
        }

        return isSameTree(root_t1.left, root_t2.left) && isSameTree(root_t1.right, root_t2.right);
    }
}

/*
A subtree of a binary tree `tree` is a tree that consists of a node
in `tree` and all of this node's descendants. 

sub                 tree
 2                   1 < 
4 5                2   3
                  4 5
sub != tree

sub                 tree
 2                   1 
4 5               2<   3
                 4 5
sub == tree

a tree can only be compared by comparing the values at every node manually
essentially, for two tree to be identical, they need to have the same children
how do we know if two trees have the same children?

e.g.

sub                 tree
 2                   2 
4 5                4  5

are identical

sub                 tree
 2                   2 
4 5                4  5
                  6
are NOT

- they need to have the same height
- they need to have the same elements

*/
