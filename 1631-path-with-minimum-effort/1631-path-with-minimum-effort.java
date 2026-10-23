class pair{
    int row;
    int col;
    int effort;
    public pair(int row,int col,int effort){
        this.row=row;
        this.col=col;
        this.effort=effort;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        int []delRow={-1,0,1,0};
        int []delCol={0,1,0,-1};
        int m=heights.length;
        int n=heights[0].length;
        int dist[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        PriorityQueue<pair>qu=new PriorityQueue<>((a,b)->a.effort-b.effort);
        qu.offer(new pair(0,0,0));
        while(!qu.isEmpty()){
            pair curr=qu.poll();
            int currRow=curr.row;
            int currCol=curr.col;
            int currEffort=curr.effort;
            for(int i=0;i<4;i++){
                int nRow=currRow+delRow[i];
                int nCol=currCol+delCol[i];
                if(nRow>=0 && nRow<m && nCol>=0 && nCol<n){
                    int newEffort=Math.max(currEffort,Math.abs(heights[currRow][currCol]-heights[nRow][nCol]));
                    if(newEffort<dist[nRow][nCol]){
                        dist[nRow][nCol]=newEffort;
                        qu.offer(new pair(nRow,nCol,newEffort));
                    }
                }
            }


        }
        if(dist[m-1][n-1]==Integer.MAX_VALUE){
            return 0;
        }
        else{
            return dist[m-1][n-1];
        }
    }
}