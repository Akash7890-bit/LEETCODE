class Solution {
    int parent[];
    public int[] findRedundantConnection(int[][] edges) {
      
        int n=edges.length;
        parent=new int[n+1];
      
      for(int i=0;i<n;i++){
        parent[i]=i;
      } 
      for(int i=0;i<n;i++){
        int u=edges[i][0];
        int v=edges[i][1];
        int root1=find(u);
        int root2=find(v);
        if(root1==root2){
            return edges[i];
        }
        else{
            parent[root2]=root1;
        }
      }
      return new int[0]; 
    }
    int find(int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x]=find(parent[x]);
    }
}