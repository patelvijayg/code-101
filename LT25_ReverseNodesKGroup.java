public class LT25_ReverseNodesKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        //basecase#1 check if head is null
        if( head ==null ) return head;
        //basecase#2 if length of list is smaller then k then return head
        ListNode dummy=head;
        int len=0;
        while(dummy != null){
            len++;
            dummy=dummy.next;
        }
        if(len<k) return head;

        //actual work.. first reverse the k element
        ListNode curr=head, next=null, prev=null;
        int count=0;
        while(curr!=null && count<k){
            count++;
            next = curr.next;
            curr.next = prev;
            prev=curr;
            curr = next;
        }

        //after above loop head is pointing to last element of group
        //and next is pointing first element of next group
        if( count==k && next != null){
            head.next = reverseKGroup(next,k);
        }

        return prev;
    }
}
