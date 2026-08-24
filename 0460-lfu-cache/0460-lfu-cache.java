class LFUCache {
    class Node{
        int key;
        int value;
        int freq;
        Node next;
        Node prev;
            Node(int key,int val){
                this.key=key;
                this.value=val;
                this.freq=1;
            }
    }
    class DLL{
        Node head;
        Node tail;
        int size;
            DLL(){
                head=new Node(0,0);
                tail=new Node(0,0);
                head.next=tail;
                tail.prev=head;
                size=0;
            }
        void addFirst(Node node){
            node.next=head.next;
            node.prev=head;
            head.next.prev=node;
            head.next=node;
           
            size++;
        }
        void removeNode(Node node){
            node.prev.next=node.next;
            node.next.prev=node.prev;
            size--;
        }
        Node removeLast(){
            if(size==0){
                return null;
            }
            Node node=tail.prev;
            removeNode(node);
            return node;
        }
    }
    private int limit;
    private int size=0;
    private int minFreq=0;
    HashMap<Integer,Node>map=new HashMap<>();
    HashMap<Integer,DLL>fMap=new HashMap<>();

   
    
    


    public LFUCache(int capacity) {
        this.limit=capacity;
        

    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node=map.get(key);
        increaseFreq(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(limit==0){
            return ;
        }
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.value=value;
            increaseFreq(node);
           
            return;
        }
        if(size==limit){
            DLL toRemove=fMap.get(minFreq);
            Node lastNode=toRemove.removeLast();
            
            map.remove(lastNode.key);
            size--;
        }
        Node newNode=new Node(key,value);
        map.put(key,newNode);
        fMap.computeIfAbsent(1,k-> new DLL()).addFirst(newNode);
        minFreq=1;
        size++;


    }
     private void increaseFreq(Node node){
        int currfreq=node.freq;
        DLL currList=fMap.get(currfreq);
        currList.removeNode(node);
        if(currfreq==minFreq && currList.size==0){
            minFreq++;
        }
        node.freq++;
        fMap.computeIfAbsent(node.freq,k-> new DLL()).addFirst(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */