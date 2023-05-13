package leetcode.easy;

//You are given the heads of two sorted linked lists list1 and list2.
//
//Merge the two lists in a one sorted list.
// The list should be made by splicing together the nodes of the first two lists.
//
//Return the head of the merged linked list.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem21 {

    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        List<Integer> merged = new ArrayList<>();

        ListNode node1 = list1;
        ListNode node2 = list2;

        while (node1 != null) {
            merged.add(node1.val);
            node1 = node1.next;

        }

        while (node2 != null) {
            merged.add(node2.val);
            node2 = node2.next;
        }

        if (merged.isEmpty()) {
            return null;
        }

        Collections.sort(merged);
        ListNode result = new ListNode(merged.get(0));
        ListNode head = null;
        for (Integer integer : merged) {
            ListNode next = new ListNode(integer);
            if (head == null) {
                head = next;
            }
            result.next = next;
            result = result.next;

        }

        return head;

    }

}