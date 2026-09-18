class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>>ans=new ArrayList<>();
       int []delrow={-1,0,1,0};
       int []delcol={0,1,0,-1};
       int m=heights.length;
       int n=heights[0].length; 
       boolean [][] pacificVis=new boolean[m][n];
       boolean [][] atlanticVis=new boolean[m][n];
       for(int b=0;b<m;b++){
        
            dfs1(heights,b,0,m,n,delrow,delcol,pacificVis);
        
      
            dfs2(heights,b,n-1,m,n,delrow,delcol,atlanticVis);
        
        
       }
       for(int c=0;c<n;c++){
        
            dfs1(heights,0,c,m,n,delrow,delcol,pacificVis);
        
       
            dfs2(heights,m-1,c,m,n,delrow,delcol,atlanticVis);
        
        
        
       }
       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(pacificVis[i][j]==true && atlanticVis[i][j]==true){
                ans.add(new ArrayList<>(Arrays.asList(i,j)));
            }
        }
       }

       return ans;

    }
    void dfs1(int heights[][],int i,int j,int m,int n,int []delrow,int []delcol,boolean [][] pacificVis){
        pacificVis[i][j]=true;
        for(int k=0;k<4;k++){
            int row=i+delrow[k];
            int col=j+delcol[k];
            if(row>=0 && row<m && col>=0 && col<n && pacificVis[row][col]!=true && heights[i][j]<=heights[row][col]){
                dfs1(heights,row,col,m,n,delrow,delcol,pacificVis);
            }
        }
    }
    void dfs2(int heights[][],int i,int j,int m,int n,int []delrow,int []delcol,boolean [][] atlanticVis){
        atlanticVis[i][j]=true;
        for(int k=0;k<4;k++){
            int row=i+delrow[k];
            int col=j+delcol[k];
            if(row>=0 && row<m && col>=0 && col<n && atlanticVis[row][col]!=true && heights[i][j]<=heights[row][col]){
                dfs1(heights,row,col,m,n,delrow,delcol,atlanticVis);
            }
        }
    }
    

}