class LRUCache {
    class Node{
        Node next;
        Node prev;
        int val;
        int key;
        Node(int key,int val){
            this.val=val;
            this.key=key;
        }
    }
    int limit;
    HashMap<Integer,Node>map=new HashMap<>();
    Node head=new Node(-1,-1);
    Node tail=new Node(-1,-1);

    public void addNode(Node newNode){
        Node prevNext=head.next;
        newNode.next=prevNext;
        newNode.prev=head;
        head.next=newNode;
        prevNext.prev=newNode;


    }
    public void delNode(Node newNode){
        Node prevNodehead=newNode.prev;
        Node prevNodeTail=newNode.next;

        prevNodehead.next=prevNodeTail;
        prevNodeTail.prev=prevNodehead;

    }

    public LRUCache(int capacity) {
        limit=capacity;
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node use=map.get(key);
        
        
        delNode(use);
        addNode(use);
        return use.val;
    }
    
    public void put(int key, int value) {
       if(map.containsKey(key)){
            Node use=map.get(key);
           
           
            delNode(use);
       } 
       else{
        if(map.size()==limit){
            Node toRemove=tail.prev;
            map.remove(toRemove.key);
            delNode(toRemove);
        }
       }
       Node toAdd=new Node(key,value);
       map.put(key,toAdd);
       addNode(toAdd);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */