class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
        for(int i=0;i<m;i++){
            
            if(board[i][0]!='#' && board[i][0]=='O'){
                dfs(board,m,n,i,0,delrow,delcol);
            }
            if(board[i][n-1]!='#' && board[i][n-1]=='O'){
                dfs(board,m,n,i,n-1,delrow,delcol);
            }
        }
        for(int i=0;i<n;i++){
            
            if(board[0][i]!='#' && board[0][i]=='O'){
                dfs(board,m,n,0,i,delrow,delcol);
            }
            if(board[m-1][i]!='#' && board[m-1][i]=='O'){
                dfs(board,m,n,m-1,i,delrow,delcol);
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }
                else{
                    board[i][j]='X';
                }
            }
        }
    }
    void dfs(char[][]board,int m,int n,int i,int j,int []delrow,int []delcol){
        
       
        board[i][j]='#';
        
        for(int k=0;k<4;k++){
           int row=i+delrow[k];
           int col=j+delcol[k];
           if(row>=0 && row<m && col>=0 && col<n && board[row][col]!='#' && board[row][col]=='O' ){
            dfs(board,m,n,row,col,delrow,delcol);
        }
          
        }

    }

}