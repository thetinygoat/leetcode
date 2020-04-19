public ListNode mergeKLists(ListNode[] lists) {
    if(lists.length == 0) return null;
    return mergeKLists_(lists, 0, lists.length-1);
}
public ListNode mergeKLists_(ListNode[] lists, int si, int ei){
    if(si == ei) return lists[si];
    if(si+1 == ei) return mergeSorted(lists[si],lists[ei]);
    int mid = (si + ei) >> 1;
    ListNode left = mergeKLists_(lists, si, mid);
    ListNode right = mergeKLists_(lists, mid+1, ei);
    return mergeSorted(left, right);
}

public ListNode mergeSorted(ListNode h1, ListNode h2){
    if(h1 == null) return h2;
    else if(h2 == null) return h1;
    ListNode nhead = new ListNode(-1);
    ListNode ncurr = nhead;
    while(h1 != null && h2 != null){
        if(h1.val <= h2.val){
            ncurr.next = h1;
            ncurr = h1;
            h1 = h1.next;
        }else{
            ncurr.next = h2;
            ncurr = h2;
            h2 = h2.next;
        }
    }

    if(h1 != null) ncurr.next = h1;
    else if(h2 != null) ncurr.next = h2;
    return nhead.next;
}