package leetcode.easy;

public class Problem83 {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode start = head;
        ListNode temp;

        while (start != null) {
            temp = start.next;
            while (temp != null && start.val == temp.val) {
                temp = temp.next;
            }
            start.next = temp;
            start = start.next;
        }


        return head;
    }
}
