package leetcode.easy;

//Given the root of a binary tree,
// check whether it is a mirror of itself
// (i.e., symmetric around its center).

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;

public class Symmetric_Tree_101 {

    public boolean isSymmetric(TreeNode root) {
       return symmetrical(root,root);
    }

    boolean symmetrical(TreeNode p, TreeNode q) {

        if (p == null && q == null){
            return true;
        }
        if (p == null){
            return false;
        }
        if (q == null){
            return false;
        }
        return isEqual(p, q) && symmetrical(p.left, q.right)
            && symmetrical(p.right, q.left);
    }


    boolean isEqual(TreeNode p, TreeNode q) {
        return
            Objects.equals(p.val, q.val);
    }
}

