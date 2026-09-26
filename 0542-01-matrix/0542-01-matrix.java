class Solution {
    public int[][] updateMatrix(int[][] mat) {
      int m=mat.length;
      int n=mat[0].length;
      int dist[][]=new int[m][n];
      int []delRow={-1,0,1,0};
      int []deCol={0,1,0,-1};
      Queue<int[]>qu=new LinkedList<>();
      for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(mat[i][j]==0){
                dist[i][j]=0;
                qu.offer(new int[]{i,j});
            }
            else{
                dist[i][j]=-1;
            }
        }
      }

        while(!qu.isEmpty()){
            int []curr=qu.poll();
            int row=curr[0];
            int col=curr[1];
            for(int i=0;i<4;i++){
                int newRow=row+delRow[i];
                int newCol=col+deCol[i];
                if(newRow<m && newRow>=0 && newCol<n && newCol>=0 && dist[newRow][newCol]==-1){

                dist[newRow][newCol]=dist[row][col]+1;
                qu.offer(new int[]{newRow,newCol});
                }
            }
        }
        return dist;
        
    }
    
    

}