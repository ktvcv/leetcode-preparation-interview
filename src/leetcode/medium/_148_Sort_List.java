package leetcode.medium;

//Given the head of a linked list,
// return the list after sorting it in ascending order.

import leetcode.easy.ListNode;

public class _148_Sort_List {

    public ListNode sortList(ListNode head) {

//        ListNode newNode = null;
//
//        while (true) {
//            //find minimum
//            ListNode temp = head;
//            while (temp.next != null) {
//                    if (temp.val < temp.next.val) {
//                        temp = temp.next;
//                    }
//
//            }
//
//            if (temp != head){
//
//            }
//            if (newNode == null){
//                newNode = temp;
//            }
//
//        }

        //so one element is always sorted
        if (head == null || head.next == null) {
            return head;
        }


        ListNode slow = head, fast = head;
        // search the middle to divide in the halves
        // when fast/fast.next = null, we reach the middle with slow
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode middle = slow.next;

        //??
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(middle);

        return merge(left, right);

    }

    // 7 6 3 1 2 9
    // 7,6,3  1,2,9 // call 1
    // 7 6,3  1 2,9
    // merge(7, null) = 7
    // merge(6,3) = 3,6
    // merge(7, 3) = 3,6,7
    // merge(3, 1) = 1,2,3,6,7,9
    public static ListNode merge(ListNode left, ListNode right) {

        // to return a head luke a reference to a head
        ListNode dummy = new ListNode(0);

        ListNode current = dummy;

        //add to list one by one
        while (left != null && right != null) {
            if (left.val > right.val) {
                current = right;
                right = right.next;
            } else {
                current = left;
                left = left.next;
            }

            current = current.next;
        }

        // the difference between number of nodes could be only one
        if (left != null) {
            current.next = left;
        } else {
            current.next = right;
        }

        return dummy.next;
    }
}
