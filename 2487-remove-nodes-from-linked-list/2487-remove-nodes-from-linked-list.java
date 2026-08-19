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
    public ListNode removeNodes(ListNode head) {
        ArrayList<Integer>nums=new ArrayList<>();
        ListNode dummy=new ListNode(0);
        Stack<Integer>stack=new Stack<>();
        ListNode curr=head;
        while(curr!=null){
            nums.add(curr.val);
            curr=curr.next;
        }
        int n=nums.size();
       
        stack.push(nums.get(n-1));
        for(int i=n-2;i>=0;i--){
            if(nums.get(i)>=stack.peek()){
                stack.push(nums.get(i));
            }
        }
        ListNode current=dummy;
        while(!stack.isEmpty()){
        current.next=new ListNode(stack.pop());
        current=current.next;
        }
        return dummy.next;

    }
}