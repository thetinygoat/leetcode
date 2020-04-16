public ListNode sortList(ListNode head) {
    if(head == null || head.next == null) return head;
    ListNode mid = mid(head);
    ListNode nhead = mid.next;
    mid.next = null;
    return mergeTwoLists(sortList(head), sortList(nhead));
}

public static ListNode mid(ListNode node){
    ListNode slow = node;
    ListNode fast = node;
    while(fast != null && fast.next != null && fast.next.next != null){
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}

public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if(l1 == null) return l2;
    if(l2 == null) return l1;
    ListNode head = new ListNode(-1); // dummy node
    ListNode curr = head;

    while(l1 != null && l2 != null){
        if(l1.val <= l2.val){
            curr.next = l1;
            curr = l1;
            l1 = l1.next;
        }else{
            curr.next = l2;
            curr = l2;
            l2 = l2.next;
        }
    }
    if(l1 != null)
        curr.next = l1;
    else if(l2 != null)
        curr.next = l2;
    return head.next;
}