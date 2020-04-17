public Node copyRandomList(Node head) {
    // copy list
    Node curr = head;
    Node forw = null;
    while(curr != null){
        forw = curr.next;
        Node copy = new Node(curr.val);
        curr.next=copy;
        copy.next=forw;
        curr=forw;
    }

    // point random pointers
    curr = head;
    while(curr != null){
        if(curr.random != null)
            curr.next.random = curr.random.next;
        curr = curr.next.next;
    }

    // extract list
    curr = head;
    Node nhead = new Node(-1);
    Node ncurr = nhead;
    while(curr != null){
        forw = curr.next.next;
        Node copy = curr.next;
        ncurr.next = copy;
        ncurr = copy;
        curr.next = forw;
        curr=forw;
    }

    return nhead.next;

}