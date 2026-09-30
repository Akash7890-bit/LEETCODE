class Solution {
    public int orangesRotting(int[][] grid) {
       if(grid.length==0 || grid==null){
        return -1;
       } 
       int delRow[]={-1,0,1,0};
       int delCol[]={0,1,0,-1};
       int m=grid.length;
       int n=grid[0].length;
       int time[][]=new int[m][n];
       for(int i=0;i<m;i++){
        Arrays.fill(time[i],Integer.MAX_VALUE);
       }
       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(grid[i][j]==2){
                dfs(grid,m,n,i,j,0,time,delRow,delCol);
            }
        }
       }
       int maxTime=0;
       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(grid[i][j]==1){
                if(time[i][j]==Integer.MAX_VALUE){
                    return -1;
                }
                maxTime=Math.max(maxTime,time[i][j]);
            }
        }
       }
       return maxTime;
    }
    void dfs(int[][] grid,int m,int n,int i,int j,int currTime,int [][]time,int []delRow,int delCol[]){
        time[i][j]=currTime;
        for(int k=0;k<4;k++){
            int nRow=i+delRow[k];
            int nCol=j+delCol[k];

            if(nRow<m && nRow>=0 && nCol<n && nCol>=0 && grid[nRow][nCol]==1 && currTime+1<time[nRow][nCol]){
                dfs(grid,m,n,nRow,nCol,currTime+1,time,delRow,delCol);
            }
        }
    }
}