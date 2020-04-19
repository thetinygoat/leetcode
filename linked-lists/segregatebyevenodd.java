public ListNode oddEvenList(ListNode head) {
    ListNode odd = new ListNode(-1);
    ListNode even = new ListNode(-1);
    ListNode oitr = odd;
    ListNode eitr = even;
    while(head != null){
        if(head.val %2 == 0){
            eitr.next = head;
            eitr = eitr.next;
        }
            
        else{
            oitr.next = head;
            oitr = oitr.next;
        }
        head = head.next;
    }   
    eitr.next = null;    
    oitr.next = even.next;
    return odd.next;
   }