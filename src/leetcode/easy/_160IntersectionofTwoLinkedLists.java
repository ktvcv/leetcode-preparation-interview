package leetcode.easy;

public class _160IntersectionofTwoLinkedLists {

    //Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
    // If the two linked lists have no intersection at all, return null.
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode a = headA;
        ListNode b = headB;

        while (a != b){
            //in case of different length
            // 1 - if one is not null, second is null then go to 2 iter
            // because we reach null
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
