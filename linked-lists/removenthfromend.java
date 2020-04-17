public ListNode removeNthFromEnd(ListNode head, int n) {
    if(n == 0 || head == null) return null;
    if(n == 1 && head.next == null) return null;
    ListNode back = head;
    ListNode front = head;
    while(n-- > 0){
        front = front.next;
    }
    if(front == null) return head.next;
    while(front.next!=null){
        back = back.next;
        front = front.next;
    }
    back.next = back.next.next;
    return head;
}