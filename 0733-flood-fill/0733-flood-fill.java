class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int key=image[sr][sc];
        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
        int m=image.length;
        int n=image[0].length;
        fill(image,sr,sc,m,n,color,delrow,delcol,key);
        return image;


    }
    void fill(int[][]image,int i,int j,int m,int n,int color,int[] delrow,int []delcol,int key){
        image[i][j]=color;
        for(int k=0;k<4;k++){
            int row=i+delrow[k];
            int col=j+delcol[k];
            if(row>=0 && row<m && col>=0 && col<n && image[row][col]!=color && image[row][col]==key){
                fill(image,row,col,m,n,color,delrow,delcol,key);
            }
        }
    }
}