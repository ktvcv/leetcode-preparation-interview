package leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TimerTask;

public class _145BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {

        if (root == null){
            return Collections.emptyList();
        }

        List<Integer> nodes = new ArrayList<>();

        postOrder(root, nodes);

        return nodes;

    }

    public void postOrder(TreeNode node, List<Integer> nodes){
        if (node == null){
            return;
        }
        postOrder(node.left, nodes);
        postOrder(node.right, nodes);

        nodes.add(node.val);

    }
}
