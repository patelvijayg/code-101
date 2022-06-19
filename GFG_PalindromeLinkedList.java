public class GFG_PalindromeLinkedList {
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
    boolean isPalindrome(Node head)
    {   //check boundary condition
        if(head == null || head.next == null ) return true;
        //this will give you mid+1 node whill can be start of second list without reverse.
        //so now we can start reverse from this node.
        Node fast=head, slow=head,first=head;
        while(fast !=null && fast.next != null){
            fast=fast.next.next;
            slow=slow.next;
        }

        Node prev=null;
        while(slow!=null){
            Node next = slow.next;
            slow.next = prev;
            prev=slow;
            slow=next;
        }

        Node second=prev;
        while(first !=null && second != null){
            if(first.data != second.data){
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;
    }
    Node reverse(Node head){
        Node prev=null, curr=head,next=null;

        while(curr!=null){
            next = head.next;
            head.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}
