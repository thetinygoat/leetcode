public boolean isPalindrome(ListNode head) {
    if(head == null || head.next == null) return true;
        ListNode mid = mid(head);
        ListNode rev = reverse(mid);

        while(rev != null){
            if(head.val != rev.val) return false;

            head = head.next;
            rev = rev.next;
        }

        return true;
}

public ListNode mid(ListNode node){
    ListNode slow = node;
    ListNode fast = node;

    while(fast != null && fast.next != null){
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

        prev = node;
        node = forw;
    }

    return prev;
}