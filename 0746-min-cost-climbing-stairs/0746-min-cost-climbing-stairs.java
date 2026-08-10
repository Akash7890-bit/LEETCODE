class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        if(n==1){
            return 0;
        }
   
        int prev1=0;
        int prev2=0;
        int res=0;
        for(int i=2;i<=n;i++){
           res =Math.min(prev2+cost[i-1],prev1+cost[i-2]);
           prev1=prev2;
           prev2=res;
        }
        return res;
    }
}