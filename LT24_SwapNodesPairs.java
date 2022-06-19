public class LT24_SwapNodesPairs {

    public ListNode swapPairs(ListNode head) {
        if( head ==null || head.next ==null) return head;

        ListNode dummy = new ListNode(0,head);
        ListNode curr = dummy;

        while(curr.next != null && curr.next.next !=null){
            ListNode first = curr.next;
            ListNode second = curr.next.next;
            ListNode third = second.next;  //this can be null but we need to take this link

            //link first to third
            first.next = third;
            //link second next pointer to first
            second.next = first;
            //NOTE: we must need to set curr.next to second pointer because our dummy node needs it.
            curr.next =second;
            //place curr at first node so we can use this node for next 2 nodes
            curr = first;
        }


        return dummy.next;
    }
}
