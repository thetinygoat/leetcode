public ListNode rotateRight(ListNode head, int k) {
    if(head == null || head.next == null) return head;
    int size = 0;
    ListNode curr = head;
    ListNode tail = null;

    while(curr != null){
        tail = curr;
        curr = curr.next;
        size++;
    }

     k %= size;
     if(k < 0) k+=size;

     if(k == 0) return head;

     curr = head;
     int ctr = 1;
     int n = size - k;
     while(ctr < n){
         curr = curr.next;
         ctr++;
     }

     tail.next = head;
     head = curr.next;
     curr.next = null;

     return head;
}