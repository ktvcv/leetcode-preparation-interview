package leetcode.medium;

import leetcode.easy.Binary_Tree_Inorder_Traversal_94;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    @Override
    public String toString() {
        return "Node{" +
            "val=" + val +
//            ", left=" + left +
//            ", right=" + right +
            ", next=" + next +
            '}';
    }
};

class Solution {
    public static Node connect(Node root) {
        if(root == null) return null;
        Node left = root.left;
        Node right = root.right;
        System.out.println("left " + left);
        System.out.println("right " + right);
        while(left != null){
            left.next = right;
            left = left.right;
            right = right.left;
            System.out.println("left " + left);
            System.out.println("right " + right);
        }
        System.out.println("left " + left);
        System.out.println("right " + right);
        connect(root.left);
        connect(root.right);
        return root;
    }

//    public static Node connectRight(Node node) {
//        if (node.left == null) {
//            return node;
//        }
//        Node left = connectRight(node.left);
//        System.out.println("Left: " + left);
//        Node right = connectRight(node.right);
//        System.out.println("Right: " + right);
//        left.next = right;
//
//        return node;
//    }
}

public class _116PopulatingNextRightPointersinEachNode {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.left = node2;
        node1.right = node3;

        Solution.connect(node1);

        System.out.println(inorderTraversal(node1));
    }

    public static List<Node> inorderTraversal(Node root) {

        final List<Node> integers = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        addInorder(root, integers);

        return integers;
    }

    static void addInorder(Node node, List<Node> integers) {
        if (node == null)
            return;
        integers.add(new Node(node.val, node.left, node.right, node.next));
        addInorder(node.left, integers);


        // Now recur on right child
        addInorder(node.right, integers);
    }

}
