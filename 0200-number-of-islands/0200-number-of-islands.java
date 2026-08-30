class Solution {
    public int numIslands(char[][] grid) {
        int ans=0;
       int m=grid.length;
       int n=grid[0].length;
       boolean vis[][]=new boolean[m][n];
       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(vis[i][j]==false && grid[i][j]=='1'){
                dfs(i,j,m,n,vis,grid);
                ans++;
            }
        }
       }
       return ans;

    }
    void dfs(int i,int j,int m,int n,boolean vis[][],char grid[][]){
        if(i<0 || j<0 || i>=m ||j>=n|| vis[i][j]==true || grid[i][j]=='0'){
            return;
        }
        vis[i][j]=true;
        dfs(i-1,j,m,n,vis,grid);
        dfs(i+1,j,m,n,vis,grid);
        dfs(i,j+1,m,n,vis,grid);
        dfs(i,j-1,m,n,vis,grid);
    }
}