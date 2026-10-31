
class Solution {
    
    public int uniquePaths(int[][] grid) {
     int m=grid.length;
     int n=grid[0].length;
     int dp[]=new int[n];
     int mod=1000000007;
     dp[0]=1;
     for(int i=0;i<m;i++){
        int left=0;
        for(int j=0;j<n;j++){
            if(grid[i][j]==1){
                int temp=left;
                left=dp[j];
                dp[j]=temp;
            }
            else{
                int total=(left+dp[j])%mod;
                left=total;
                dp[j]=total;
            }
        }
     }
     return dp[n-1];
     

    }
    
        
        
}