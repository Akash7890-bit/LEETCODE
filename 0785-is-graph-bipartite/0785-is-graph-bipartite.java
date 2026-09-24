class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
       int []color=new int[n];
       for(int i=0;i<n;i++){
        color[i]=-1;
       } 
       for(int i=0;i<n;i++){
        if(color[i]==-1){
            if(dfs(graph,color,0,i)==false){
                return false;
            }
        }
       }
       return true;
    }
    boolean dfs(int[][] graph,int []color,int currColor,int curr){
        color[curr]=currColor;
        for(int i=0;i<graph[curr].length;i++){
            if(color[curr]==color[graph[curr][i]]){
                return false;
            }
             if(color[graph[curr][i]]==-1){
                if(dfs(graph,color,1-currColor,graph[curr][i])==false){
                    return false;
                }
             }
        }
        return true;
    }

}