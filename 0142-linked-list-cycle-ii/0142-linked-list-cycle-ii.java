/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast=new ListNode();
        ListNode slow=new ListNode();
        fast=head;
        slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                ListNode newNode=new ListNode();
                newNode=head;
                while(slow!=newNode){
                    newNode=newNode.next;
                    slow=slow.next;
                }
                return newNode;
            }
        }
        return null;
    }
}