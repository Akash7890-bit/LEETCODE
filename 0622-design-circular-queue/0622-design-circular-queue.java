class MyCircularQueue {
    int currSize;
    int front;
    int rear;
    int arr[];
    int cap;

    public MyCircularQueue(int k) {
      arr=new int[k];
      front=0;
      rear=-1;
      cap=k;

    }
    
    public boolean enQueue(int value) {
        if(currSize==cap){
            return false;
        }
        rear=(rear+1)%cap;
        arr[rear]=value;
        currSize++;
        return true;
    }
    
    public boolean deQueue() {
        if(currSize==0){
            return false;
        }
        front=(front+1)%cap;
        currSize--;
        return true;
    }
    
    public int Front() {
        if(currSize==0){
            return -1;
        }
        return arr[front];
    }
    
    public int Rear() {
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
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */