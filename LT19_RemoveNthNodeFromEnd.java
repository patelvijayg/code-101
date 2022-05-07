public class LT19_RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //take dummy node and move right till n position and
        //after that you can start move left,right both till right reaches null
        //now you are at n-1 position and you can link next.next
        ListNode dummy = new ListNode(0,head);
        ListNode left = dummy;
        ListNode right = head;

        while(n>0){
            n--;
            right=right.next;
        }

        while(right!=null){
            right=right.next;
            left=left.next;
        }
        left.next=left.next.next;

        return dummy.next;
    }
}
