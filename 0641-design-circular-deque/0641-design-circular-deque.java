class MyCircularDeque {
    private int arr[];
    private int front;
    private int rear;
    private int currSize;
    private int cap;
    public MyCircularDeque(int k) {
        arr=new int[k];
        front=0;
        rear=0;
        currSize=0;
        cap=k;
    }
    
    public boolean insertFront(int value) {
        if(currSize==cap){
            return false;
        }
        if(currSize==0){
            front=0;
            rear=0;
        }
        else{
            front=(front-1+cap)%cap;
        }
        arr[front]=value;
        currSize++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(currSize==cap){
            return false;
        }
        if(currSize==0){
            front=0;
            rear=0;
        }
        else{
            rear=(rear+1)%cap;
        }
        arr[rear]=value;
        currSize++;
        return true;
    }
    
    public boolean deleteFront() {
       if(currSize==0){
        return false;
       } 
       front=(front+1)%cap;
       currSize--;
       return true;
    }
    
    public boolean deleteLast() {
        if(currSize==0){
        return false;
       } 
       rear=(rear-1+cap)%cap;
       currSize--;
       return true;
    }
    
    public int getFront() {
        if(currSize==0){
        return -1;
       } 
       return arr[front];
    }
    
    public int getRear() {
         if(currSize==0){
        return -1;
       } 
       return arr[rear];
    }
    
    public boolean isEmpty() {
        return currSize==0;
    }
    
    public boolean isFull() {
        return currSize==cap;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */