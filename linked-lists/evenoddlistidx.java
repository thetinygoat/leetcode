public ListNode oddEvenList(ListNode head) {
 ListNode odd = new ListNode(-1);
 ListNode even = new ListNode(-1);
 ListNode oitr = odd;
 ListNode eitr = even;
 while(head != null){
     oitr.next = head;
     eitr.next = head.next;
     oitr = oitr.next;
     eitr = eitr.next;
     head = head.next;
     if(head != null) head = head.next;
     else break;
 }       
 oitr.next = even.next;
 return odd.next;
}