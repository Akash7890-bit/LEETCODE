class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int []state=new int[n];
        ArrayList<Integer>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(state[i]!=3){
                if(dfs(i,graph,state)){
                    ans.add(i);
                }
            }
        }
        return ans;

    }
    boolean dfs(int  src,int[][] graph,int[]state){
        if(state[src]!=0){
            return state[src]==2;
        }
        state[src]=1;
        for(int i=0;i<graph[src].length;i++){
            int edge=graph[src][i];
            if(state[edge]==1){
                state[src]=3;
                return false;
            }
            else if(state[edge]==3){
                state[src]=3;
                return false;
            }
            else if(state[edge]==2){
                continue;
            }
            else{
                if(!dfs(edge,graph,state)){
                    state[src]=3;
                    return false;
                }
            }
            
        }
        state[src]=2;
        return true;
    }
}