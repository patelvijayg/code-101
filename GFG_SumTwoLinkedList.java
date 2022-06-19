public class GFG_SumTwoLinkedList {

    private static class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    static Node addTwoLists(Node first, Node second){

        Node f = reverse(first);
        Node s = reverse(second);
        Node dummy = new Node(0);
        Node head = dummy;
        int sum=0, carry=0;
        while(f!=null || s !=null || carry>0 ){
            sum=0;
            if(f!=null){
                sum=sum+f.data;
                f=f.next;
            }
            if(s!=null){
                sum=sum+s.data;
                s=s.next;
            }

            sum=sum+carry;
            int val = sum % 10;
            carry = sum / 10;
            Node tmp = new Node(val);
            dummy.next = tmp;
            dummy = dummy.next;
        }
        return reverse(head.next);

    }
    static Node reverse(Node head){
        Node prev = null, next=null, curr=head;
        while(curr !=null){
            next = curr.next;
            curr.next =prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}
