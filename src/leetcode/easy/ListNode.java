package leetcode.easy;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void main(String[] args) {
        final ListNode l1 = new ListNode(1);
        final ListNode l2 = new ListNode(2);

        final ListNode l3 = new ListNode(3);

        l1.next = l2;
        l2.next = l3;

        ListNode reverse = reverse(l1);
        System.out.println( "" + reverse.val + " " + reverse.next);

    }

    public static ListNode reverse(ListNode input) {
         ListNode head = input;
         ListNode prev = null;

        while (true) {
            ListNode next = head.next;//B
            head.next = prev;//prev to A null
            prev = head;
            head = next;//B

            if (head == null){
                break;
            }

        }

        return prev;
    }

}
