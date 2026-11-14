class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n=nums.size();
        
       
        
        
        int minSum=Integer.MAX_VALUE;
        for(int i=l;i<=r;i++){
          int sum=0;
          int left=0;
          for(int right=0;right<n;right++){
            sum+=nums.get(right);
            if(right-left+1==i){
                if(sum>0){
                    minSum=Math.min(minSum,sum);
                }
                sum-=nums.get(left);
                left++;
            }
          }
        }
        if( minSum==Integer.MAX_VALUE){
            return -1;
        }
        else{
            return minSum;
        }
    }
}