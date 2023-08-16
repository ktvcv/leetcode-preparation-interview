package leetcode.easy;

public class _234PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {

        ListNode middle = head;
        ListNode last = head;
        ListNode start = head;

        while (last != null && last.next != null) {
            middle = middle.next;
            last = last.next.next;
        }

        if (last != null) { // odd nodes: let right half smaller
            middle = middle.next;
        }

        // reverse

        ListNode temp = null;

        while (middle != null) {
            ListNode next = middle.next;
            next.next = temp;
            temp = middle;
            middle = next;
        }

        while (temp != null) {
            if (temp.val != start.val) {
                return false;
            }

            temp = temp.next;
            start = start.next;
        }


        return false;

    }
}
