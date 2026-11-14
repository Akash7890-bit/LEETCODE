class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n=nums.size();
       
        
        
        int minSum=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
           int sum=0;
           for(int j=i;j<n;j++){
            sum+=nums.get(j);
            if((j-i+1)>=l && (j-i+1)<=r && sum>0){
                minSum=Math.min(minSum,sum);
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