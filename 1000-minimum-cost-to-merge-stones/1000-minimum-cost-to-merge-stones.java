class Solution {
    static int prefix[];
    static int dp[][];
    public static int mergeStones(int[] stones, int k) {
        int n=stones.length;
        if((n-1)%(k-1)!=0){
            return -1;
        }
        
        prefix=new int[n+1];
        dp=new int[n][n];
        for(int i=0;i<n;i++){
            prefix[i+1]=prefix[i]+stones[i];
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return helper(0,n-1,k);

    }
    static int helper(int i,int j,int k){
        if(i>=j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        int minCost=Integer.MAX_VALUE;
        for(int idx=i;idx<j;idx+=k-1){
            int cost=helper(i,idx,k)+helper(idx+1,j,k);
            minCost=Math.min(minCost,cost);
        }
        if((j-i)%(k-1)==0){
            minCost+=prefix[j+1]-prefix[i];
        }
       
        return dp[i][j]=minCost;
    }
    
}