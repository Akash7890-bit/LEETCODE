/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==1){
            return head;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prevGroup1=dummy;
        while(true){
            ListNode curr=prevGroup1.next;
            ListNode kth=prevGroup1;
            for(int i=0;i<k&&kth!=null;i++){
                kth=kth.next;
            }
            if(kth==null){
                break;
            }
            ListNode startGroup2=kth.next;
            ListNode prev=startGroup2;
            while(curr!=startGroup2){
                ListNode next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            ListNode temp=prevGroup1.next;
            prevGroup1.next=kth;
            prevGroup1=temp;

        }
        return dummy.next;


    }
}