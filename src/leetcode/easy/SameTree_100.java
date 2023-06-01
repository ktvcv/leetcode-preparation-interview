package leetcode.easy;

import java.util.Objects;

public class SameTree_100 {

    //Given the roots of two binary trees p and q,
    // write a function to check if they are the same or not.
    //
    //Two binary trees are considered the same
    // if they are structurally identical,
    // and the nodes have the same value.

    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            return compareLeft(p,q);
        }

        boolean compareLeft(TreeNode p, TreeNode q) {
            if (p == null && q == null){
                return true;
            }
            if (p == null){
                return false;
            }
            if (q == null){
                return false;
            }
            return isEqual(p, q) && compareLeft(p.left, q.left)
                && compareLeft(p.right, q.right);
        }


        boolean isEqual(TreeNode p, TreeNode q) {
            return
                Objects.equals(p.val, q.val);
        }
    }
}
