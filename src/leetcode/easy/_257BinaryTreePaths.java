package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class _257BinaryTreePaths {

    List<String> strings = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        build(root, "");

        return strings;
    }

    private void build(TreeNode node, String st){
        if (node == null){
            return;
        }
       if (node.right == null && node.left == null){
           st += node.val;
           strings.add(st);
           return;
       }
        st += node.val + "->";
        build(node.right, st);
        build(node.left, st);

    }
}
