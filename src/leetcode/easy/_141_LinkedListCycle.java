package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class _141_LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        final Map<ListNode, Integer> nodes = new HashMap<>();

        if (head == null || head.next == null){
            return false;
        }

        if (head == head.next){
            return true;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast.next.next != null){

            if (slow == fast){
                return true;
            }

            slow = slow.next;
            fast = fast.next.next;
        }



        return false;

    }
}
