
class pair{
    int row;
    int col;

        pair(int row,int col){
            this.row=row;
            this.col=col;
        }
}
class Solution {
    public int snakesAndLadders(int[][] board) {
        int steps=0;
      int n=board.length;
      Queue<Integer>qu=new LinkedList<>();
      boolean vis[][]=new boolean[n][n];
      
      qu.offer(1);
      vis[n-1][0]=true;
      while(!qu.isEmpty()){
        int len=qu.size();

        for(int i=0;i<len;i++){
            int curr=qu.poll();
            if(curr==n*n){
                return steps;
            }
            for(int k=1;k<=6;k++){
                if(curr+k>n*n){
                    break;
                }
                
                
                pair val=getCoord(curr+k,n);
                int row=val.row;
                int col=val.col;
                if( vis[row][col]==true){
                    continue;
                }
                if(board[row][col]==-1){
                    qu.offer(curr+k);
                   
                }
                else{
                   qu.offer(board[row][col]);
                }
                vis[row][col]=true;
               
            }
            
        }
        steps++;
        
      }
      return -1;
    }
       
    
    pair getCoord(int num,int n){
      int Ru=(num-1)/n;
      int Rb=(n-1)-Ru;
      int Lc=(num-1)%n;
      if((n%2==0 && Rb%2==0) ||(n%2==1 && Rb%2==1) ){
        Lc=(n-1)-Lc;
      }
      return new pair(Rb,Lc);

    }
}