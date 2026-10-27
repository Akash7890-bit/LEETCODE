class Solution {
    public int countElements(int[] nums) {
      int min=Integer.MAX_VALUE;
      int max=Integer.MIN_VALUE;
      int count=0;
      for(int i:nums){
        max=Math.max(max,i);
        min=Math.min(min,i);
      }
      for(int i:nums){
        if(i>min && i<max){
            count++;
        }
      }  
      return count;
    }
}