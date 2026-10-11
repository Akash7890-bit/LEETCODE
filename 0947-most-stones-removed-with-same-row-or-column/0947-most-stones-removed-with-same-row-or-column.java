class Solution {
    int parent[];
    public int removeStones(int[][] stones) {
        int n=stones.length;
        int conComp=n;
        HashMap<Integer,Integer>rowMap=new HashMap<>();
        HashMap<Integer,Integer>colMap=new HashMap<>();
        parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int i=0;i<n;i++){
            int row=stones[i][0];
            int col=stones[i][1];
            if(rowMap.containsKey(row)){
                int prevRowIdx=rowMap.get(row);
                if(DSU(prevRowIdx,i)){
                    conComp--;
                }
                
            }
            else{
                rowMap.put(row,i);
            }
            if(colMap.containsKey(col)){
                int prevColIdx=colMap.get(col);
                if(DSU(prevColIdx,i)){
                    conComp--;
                }
                
            }
            else{
                colMap.put(col,i);
          
            }
        }
        return n-conComp;
        
        

        
    }
    int find(int x){
            if(parent[x]==x){
              return x;  
            }
            return parent[x]=find(parent[x]);
    }
    boolean DSU(int i,int j){
            int root1=find(i);
            int root2=find(j);

            if(root1==root2){
                return false;
            }
            parent[root2]=root1;
            return true;
            
        }
}