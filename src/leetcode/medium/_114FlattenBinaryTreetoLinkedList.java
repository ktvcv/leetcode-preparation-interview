package leetcode.medium;


import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _114FlattenBinaryTreetoLinkedList {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode left1 = new TreeNode(6);
        TreeNode right1 = new TreeNode(3);
        TreeNode right2 = new TreeNode(4);
        TreeNode right3 = new TreeNode(7);

        root.left= left;
        left.left=left1;
        root.right=right1;
        right1.right=right2;
        right2.left = right3;

        flatten(root);

    }
    public static void flatten(TreeNode root) {
        if(root == null)
            return;

        helper(root).right = null;
    }

    //рекурсивно пройти левое поддерево до конца
    public static TreeNode helper(TreeNode root)           // return tail
    {
        TreeNode tailNode = root;
        TreeNode lefttNode  = root.left;
        TreeNode rightNode  = root.right;

        if(lefttNode != null)
        {
            tailNode = helper(lefttNode);
            root.left = null;
            root.right = lefttNode;
            System.out.println("root " + root);
            System.out.println("tail " + tailNode);
            System.out.println("last left " + lefttNode);
            System.out.println("root right now " + root.right);
        }

        if(rightNode != null)
        {
            System.out.println("tail " + tailNode);
            tailNode.right = rightNode;
            System.out.println("root right attached to" + rightNode);
            tailNode = helper(rightNode);
        }

        return tailNode;
    }
    }

