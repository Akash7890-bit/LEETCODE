class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int [m][n];
        return countPath(m-1,n-1,dp);
    }

    private int countPath(int r,int c,int dp[][]){
        if(r==0||c==0){
            return 1;
        }
        if(dp[r][c]!=0){
            return dp[r][c];
        }
        dp[r][c]=countPath(r-1,c,dp)+countPath(r,c-1,dp);
        return dp[r][c];
    }
    
}