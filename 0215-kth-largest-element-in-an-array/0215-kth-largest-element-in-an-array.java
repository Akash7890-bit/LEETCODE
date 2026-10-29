class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>qu=new PriorityQueue<>();
        for(int i:nums){
          
                qu.add(i);
                if(qu.size()>k){
                    qu.poll();
                }
            
        }
        return qu.poll();
    }
}