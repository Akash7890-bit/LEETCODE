class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
       
      int m=grid.length;
      int n=grid[0].length;
      Queue<int []>qu=new LinkedList<>();
        if(grid[0][0]!=0 || grid[m-1][n-1]!=0){
            return -1;
        }
        if(n==1){
            return 1;
        }
        
      int delRow[]={-1,-1,-1,0,0,1,1,1};
      int delCol[]={-1,0,1,-1,1,-1,0,1};
      qu.offer(new int[]{0,0,1});
      grid[0][0]=1;

      while(!qu.isEmpty()){
        int[]curr=qu.poll();
        
        int row=curr[0];
        int col=curr[1];
        int dist=curr[2];
        if(row==m-1 && col==n-1){
            return dist;
        }
        for(int i=0;i<8;i++){
            int nRow=row+delRow[i];
            int nCol=col+delCol[i];

            if(nRow<m && nRow>=0 && nCol<n && nCol>=0 && grid[nRow][nCol]==0){
                grid[nRow][nCol]=1;
                qu.offer(new int[]{nRow,nCol,dist+1});
            }
        }
      }
      return -1; 
     
    }
}