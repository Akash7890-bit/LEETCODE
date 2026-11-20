class Solution {
    int count=0;
    public int totalNQueens(int n) {
        char board[][]=new char[n][n];
        count=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
       

        nQueens(board,0);
        return count;


    }
    void nQueens(char board[][],int row){
       
        if(row==board.length){
            count++;
            return;
        }
        int n=board.length;
        for(int j=0;j<n;j++){
            if(isSafe(board,row,j)){
                board[row][j]='Q';
                nQueens(board,row+1);
                board[row][j]='.';
            }
        }
        

    }
    boolean isSafe(char board[][],int row,int col){
        int n=board.length;
        for(int j=0;j<row;j++){
            if(board[j][col]=='Q'){
                return false;
            }
        }
        for(int i=row-1,j=col+1;i>=0 && j<n;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
}