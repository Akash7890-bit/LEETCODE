class MyLinkedList {
    Node head;
    class Node{
        int val;
        Node next;
        public Node(int val){
            this.val=val;
            this.next=null;
        }
    }

    public MyLinkedList() {
        head=null;
    }
    
    public int get(int index) {
        if(head==null){
            return -1;
        }
        if(index==0){
            return head.val;
        }
        int count=0;
       Node curr=head;
       while(curr!=null && count<index){
        curr=curr.next;
        count++;

        }
        if(curr==null){
            return -1;
        }
        return curr.val;
    }
    
    public void addAtHead(int val) {
        Node curr=new Node(val);
        if(head==null){
            head=curr;
        }
        else{
            curr.next=head;
            head=curr;
        }
    }
    
    public void addAtTail(int val) {
        Node temp=new Node(val);
        if(head==null){
            head=temp;
        }
        else{
        Node curr=head;
        while(curr.next!=null){
            curr=curr.next;
            
        }
        curr.next=temp;
        }
    }
    
    public void addAtIndex(int index, int val) {
       Node temp=new Node(val);
       if(index==0){
         addAtHead(val);
         return;
       }
   
       int count=0;
       Node curr=head;
       while(curr!=null && count<index-1){
        curr=curr.next;
        count++;

        }
        if(curr==null){
            return;
        }
        temp.next=curr.next;
        curr.next=temp;
        
       
    }
    
    public void deleteAtIndex(int index) {
        if(head==null){
            return;
        }
        if(index==0){
            head=head.next;
            return;
        }
         int count=0;
       Node curr=head;
       while(curr!=null && count<index-1){
        curr=curr.next;
        count++;

        }
        if(curr==null || curr.next==null){
            return;
        }

        curr.next=curr.next.next;

    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */