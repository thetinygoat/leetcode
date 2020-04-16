public static ListNode detectCycle(ListNode head){
    if(head == null || head.next == null) return null;
    ListNode slow = head.next;
    ListNode fast = head.next.next;
    while(fast != null && fast.next != null && slow != fast){
        slow = slow.next;
        fast = fast.next.next;
    }

    if(slow != fast){ 
        return null;
    };
    slow = head;
    while(slow != fast){
        slow = slow.next;
        fast = fast.next;
    }
    return slow;
}
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if(headA == null || headB == null) return null;
    ListNode tail = null;
    ListNode curr = headA;
    while(curr != null){
        tail = curr;
        curr = curr.next;
    }

    tail.next = headB;
    ListNode res = detectCycle(headA);
    tail.next = null; // restore ll structure
    return res;
}