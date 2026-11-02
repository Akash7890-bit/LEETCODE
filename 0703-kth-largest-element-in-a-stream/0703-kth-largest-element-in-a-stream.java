class KthLargest {
    private int k;
    private PriorityQueue<Integer>qu;
    public KthLargest(int k, int[] nums) {
    this.k=k;
    qu=new PriorityQueue<>();
      for(int i:nums){
        qu.offer(i);
        if(qu.size()>k){
            qu.poll();
        }
      } 
    }
    
    public int add(int val) {
        qu.offer(val);
         if(qu.size()>k){
            qu.poll();
        }
        return qu.peek();
         
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */