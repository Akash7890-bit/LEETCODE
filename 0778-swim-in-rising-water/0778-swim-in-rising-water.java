class pair{
    int row;
    int col;
    int time;
    public pair(int row,int col,int time){
        this.row=row;
        this.col=col;
        this.time=time;
    }
}
class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int []delRow={-1,0,1,0};
        int []delCol={0,1,0,-1};
        
        int dist[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        PriorityQueue<pair>qu=new PriorityQueue<>((a,b)->a.time-b.time);
        qu.offer(new pair(0,0,grid[0][0]));
        while(!qu.isEmpty()){
            pair curr=qu.poll();
            int currRow=curr.row;
            int currCol=curr.col;
            int currTime=curr.time;
            for(int i=0;i<4;i++){
                int nRow=currRow+delRow[i];
                int nCol=currCol+delCol[i];
                if(nRow>=0 && nRow<n && nCol>=0 && nCol<n){
                    int maxTime=Math.max(currTime,grid[nRow][nCol]);
                    if(maxTime<dist[nRow][nCol]){
                        dist[nRow][nCol]=maxTime;
                        qu.offer(new pair(nRow,nCol,maxTime));
                    }
                }
            }
        }
        if(dist[n-1][n-1]!=Integer.MAX_VALUE){
            return dist[n-1][n-1];
        }
        else{
            return 0;
        }
        
    }
}