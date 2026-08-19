/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
      Node curr=head;
      while(curr!=null){
        Node newNode=new Node(curr.val);
        newNode.next=curr.next;
        curr.next=newNode;
        curr=newNode.next;
      }
      Node curr1=head;
      while(curr1!=null ){
        if(curr1.random!=null){
        curr1.next.random=curr1.random.next;
       
        }
         curr1=curr1.next.next;
      }
        curr=head;
       Node head2=head.next;
       Node curr2=head2;
       while(curr!=null){
        curr.next=curr2.next;
        curr=curr.next;
        if(curr!=null){
            curr2.next=curr.next;
            curr2=curr2.next;
        }
    }
    return head2;

    }
}