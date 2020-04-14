public void reorderList(ListNode head) {
    if(head == null || head.next == null) return;
    
    ListNode mid = mid(head);
    ListNode h2 = mid.next;
    mid.next = null;

    h2 = reverse(h2);

    while(head != null && h2 != null){
        ListNode f1 = head.next;
        ListNode f2 = h2.next;
        head.next = h2;
        h2.next = f1;

        head = f1;
        h2 = f2;
    }
}

// special mid
public ListNode mid(ListNode node){
    ListNode slow = node;
    ListNode fast = node;

    while(fast != null && fast.next != null && fast.next.next != null){
        slow = slow.next;
        fast = fast.next.next;
    }

    return slow;
}

public ListNode reverse(ListNode node){
    ListNode prev = null;
    while(node != null){
        ListNode forw = node.next;
        node.next = prev;

        prev=node;
        node = forw;
    }

    return prev;
}